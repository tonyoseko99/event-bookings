package com.tonnyseko.servlet.database;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.app.model.entity.User;
import com.tonnyseko.servlet.database.helper.DbColumn;
import com.tonnyseko.servlet.database.helper.DbTable;
import com.tonnyseko.servlet.database.helper.DbTableId;

public class MySqlDB implements Serializable {
    private static MySqlDB database;

    private DataSource dataSource;

    private MySqlDB() {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:/MySqlDS");
        } catch (NamingException e) {
            throw new RuntimeException("Error looking up DataSource in JNDI", e);
        }
    }

    public static MySqlDB getInstance() {
        if (database == null) {
            database = new MySqlDB();
        }
        return database;
    }

    public static void updateSchema() {
        System.out.println("*************** updating schema database *************");

        try {
            Connection connection = MySqlDB.getInstance().getConnection();

            List<Class<?>> entities = new ArrayList<>();
            entities.add(User.class);
            entities.add(Event.class);

            for (Class<?> clazz : entities) {
                if (!clazz.isAnnotationPresent(DbTable.class))
                    continue;

                DbTable dbTable = clazz.getAnnotation(DbTable.class);

                StringBuilder sqlBuilder = new StringBuilder();

                sqlBuilder.append("create table if not exists ").append(dbTable.tableName()).append("(");

                List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
                fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

                for (Field field : fields) {
                    if (!field.isAnnotationPresent(DbColumn.class))
                        continue;

                    DbColumn dbTableColumn = field.getAnnotation(DbColumn.class);

                    sqlBuilder.append(dbTableColumn.columnName()).append(" ")
                            .append(dbTableColumn.definition())
                            .append(field.isAnnotationPresent(DbTableId.class) ? " NOT NULL AUTO_INCREMENT PRIMARY KEY"
                                    : "")
                            .append(",");
                }

                sqlBuilder.append(")");

                String tableCreationSql = sqlBuilder.toString().replace(",)", ")");
                System.out.println("Creating table: " + tableCreationSql);
                connection.prepareStatement(tableCreationSql).executeUpdate();

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

//    public static void insert(Object entity) {
//
//        try {
//
//            Class<?> clazz = entity.getClass();
//            if (!clazz.isAnnotationPresent(DbTable.class))
//                return;
//
//            DbTable dbTable = clazz.getAnnotation(DbTable.class);
//
//            List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
//            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
//
//            StringBuilder columnBuilder = new StringBuilder();
//            StringBuilder paramPlaceHolderBuilder = new StringBuilder();
//            List<Object> parameters = new ArrayList<>();
//
//            for (Field field : fields) {
//                if (!field.isAnnotationPresent(DbColumn.class) || field.isAnnotationPresent(DbTableId.class))
//                    continue;
//
//                field.setAccessible(true);
//                if (field.get(entity) == null)
//                    continue;
//
//                DbColumn dbTableColumn = field.getAnnotation(DbColumn.class);
//
//                columnBuilder.append(dbTableColumn.columnName()).append(",");
//                paramPlaceHolderBuilder.append("?").append(",");
//                parameters.add(field.get(entity));
//
//            }
//
//            String queryBuilder = "insert into " +
//                    dbTable.tableName() +
//                    "(" +
//                    columnBuilder +
//                    ")" +
//                    " values(" +
//                    paramPlaceHolderBuilder +
//                    ")";
//
//            String query = queryBuilder.replace(",)", ")");
//            System.out.println("Query: " + query);
//
//            PreparedStatement sqlStmt = MySqlDB.getInstance().getConnection()
//                    .prepareStatement(query);
//
//            int paramIdx = 1;
//            for (Object param : parameters) {
//                if (param instanceof BigDecimal)
//                    sqlStmt.setBigDecimal(paramIdx++, (BigDecimal) param);
//                else if (param instanceof Long)
//                    sqlStmt.setLong(paramIdx++, (long) param);
//                else
//                    sqlStmt.setString(paramIdx++, param.toString());
//            }
//
//            sqlStmt.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static <T> void insert(T entity) {
        try {
            Class<?> clazz = entity.getClass();
            if (!clazz.isAnnotationPresent(DbTable.class))
                return;

            DbTable dbTable = clazz.getAnnotation(DbTable.class);

            List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

            StringBuilder columnBuilder = new StringBuilder();
            StringBuilder paramPlaceHolderBuilder = new StringBuilder();
            List<Object> parameters = new ArrayList<>();

            for (Field field : fields) {
                if (!field.isAnnotationPresent(DbColumn.class) || field.isAnnotationPresent(DbTableId.class))
                    continue;

                field.setAccessible(true);
                if (field.get(entity) == null)
                    continue;

                DbColumn dbTableColumn = field.getAnnotation(DbColumn.class);

                columnBuilder.append(dbTableColumn.columnName()).append(",");
                paramPlaceHolderBuilder.append("?").append(",");
                parameters.add(field.get(entity));
            }

            String queryBuilder = "insert into " +
                    dbTable.tableName() +
                    "(" +
                    columnBuilder +
                    ")" +
                    " values(" +
                    paramPlaceHolderBuilder +
                    ")";

            String query = queryBuilder.replace(",)", ")");
            System.out.println("Query: " + query);

            try (PreparedStatement sqlStmt = MySqlDB.getInstance().getConnection().prepareStatement(query)) {
                int paramIdx = 1;
                for (Object param : parameters) {
                    if (param instanceof BigDecimal)
                        sqlStmt.setBigDecimal(paramIdx++, (BigDecimal) param);
                    else if (param instanceof Long)
                        sqlStmt.setLong(paramIdx++, (long) param);
                    else
                        sqlStmt.setString(paramIdx++, param.toString());
                }

                sqlStmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static List<User> select(Class<User> userClass) {
        return null;
    }

    public Connection getConnection() throws SQLException {
        if (dataSource == null) {
            throw new IllegalStateException("DataSource is null. Initialization error.");
        }

        return dataSource.getConnection();
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
