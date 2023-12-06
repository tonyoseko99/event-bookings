//package com.tonnyseko.servlet.database;
//
//import java.io.Serializable;
//import java.lang.reflect.Field;
//import java.math.BigDecimal;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//import javax.annotation.PreDestroy;
//import javax.annotation.Resource;
//import javax.inject.Inject;
//import javax.inject.Singleton;
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//import javax.annotation.PostConstruct;
//import javax.ejb.Startup;
//
//import com.tonnyseko.servlet.app.model.entity.Event;
//import com.tonnyseko.servlet.app.model.entity.User;
//import com.tonnyseko.servlet.database.helper.DbColumn;
//import com.tonnyseko.servlet.database.helper.DbTable;
//import com.tonnyseko.servlet.database.helper.DbTableId;
//import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.beanutils.ConvertUtils;
//import org.apache.commons.beanutils.converters.DateConverter;
//import org.apache.commons.lang3.StringUtils;
//
//
////@Singleton
////@Startup
//public class MySqlDB implements Serializable {
//    private static MySqlDB database;
//    private DataSource dataSource;
//
//    private MySqlDB() {
//        try {
//            Context ctx = new InitialContext();
//            dataSource = (DataSource) ctx.lookup("java:/MySqlDS");
//        } catch (NamingException e) {
//            throw new RuntimeException("Error looking up DataSource in JNDI", e);
//        }
//
//    }
//
//    public static MySqlDB getInstance() {
//        if (database == null) {
//            database = new MySqlDB();
//        }
//        return database;
//    }
//
//    public static void updateSchema() {
//        System.out.println("*************** updating schema database *************");
//
//        try {
//            List<Class<?>> entities = new ArrayList<>();
//            entities.add(User.class);
//            entities.add(Event.class);
//
//            for (Class<?> clazz : entities) {
//                if (!clazz.isAnnotationPresent(DbTable.class))
//                    continue;
//
//                DbTable dbTable = clazz.getAnnotation(DbTable.class);
//
//                StringBuilder sqlBuilder = new StringBuilder();
//
//                sqlBuilder.append("create table if not exists ").append(dbTable.tableName()).append("(");
//
//                List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
//                fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
//
//                for (Field field : fields) {
//                    if (!field.isAnnotationPresent(DbColumn.class))
//                        continue;
//
//                    DbColumn dbTableColumn = field.getAnnotation(DbColumn.class);
//
//                    sqlBuilder.append(dbTableColumn.columnName()).append(" ")
//                            .append(dbTableColumn.definition())
//                            .append(field.isAnnotationPresent(DbTableId.class) ? " NOT NULL AUTO_INCREMENT PRIMARY KEY" : "")
//                            .append(",");
//                }
//
//                sqlBuilder.append(")");
//
//                String tableCreationSql = sqlBuilder.toString().replace(",)", ")");
//                System.out.println("Creating table: " + tableCreationSql);
//                connection.prepareStatement(tableCreationSql).executeUpdate();
//
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public void saveOrUpdate(Object entity) {
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
//            PreparedStatement sqlStmt = connection.prepareStatement(query);
//
//            int paramIdx = 1;
//            for (Object param : parameters) {
//                if (param.getClass().isAssignableFrom(BigDecimal.class))
//                    sqlStmt.setBigDecimal(paramIdx++, (BigDecimal) param);
//                else if (param.getClass().isAssignableFrom(Long.class))
//                    sqlStmt.setLong(paramIdx++, (long) param);
//                else if (param.getClass().isAssignableFrom(Date.class))
//                    sqlStmt.setDate(paramIdx++, new java.sql.Date(((Date) param).getTime()));
//                else
//                    sqlStmt.setString(paramIdx++, (String) param);
//            }
//
//            sqlStmt.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @SuppressWarnings("unchecked")
//    public <T> List<T> fetch(T entity) {
//
//        List<T> resultList = new ArrayList<>();
//
//        try {
//            Class<?> clazz = entity.getClass();
//
//            if (!clazz.isAnnotationPresent(DbTable.class))
//                return resultList;
//
//            DbTable dbTable = clazz.getAnnotation(DbTable.class);
//
//            String tableAlias = dbTable.tableName().charAt(0) + "_e_";
//            System.out.println("table alias " + tableAlias);
//
//            List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
//            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
//
//            StringBuilder columnBuilder = new StringBuilder();
//            StringBuilder paramPlaceHolderBuilder = new StringBuilder();
//            List<Object> whereParams = new ArrayList<>();
//
//            DateConverter converter = new DateConverter(null);
//            converter.setPattern("yyyy-mm-dd");
//            ConvertUtils.register(converter, Date.class);
//
//            for (Field field : fields) {
//                if (!field.isAnnotationPresent(DbColumn.class) || field.isAnnotationPresent(DbTableId.class))
//                    continue;
//
//                DbColumn dbTableColumn = field.getAnnotation(DbColumn.class);
//
//                columnBuilder.append(tableAlias).append(".").append(dbTableColumn.columnName()).append(",");
//
//                field.setAccessible(true);
//                if (field.get(entity) != null) {
//                    paramPlaceHolderBuilder
//                            .append(whereParams.isEmpty() ? "" : " and ")
//                            .append(tableAlias).append(".").append(dbTableColumn.columnName()).append("=?");
//                    whereParams.add(field.get(entity));
//                }
//
//            }
//
//            String queryBuilder =
//                    "select " +
//                            columnBuilder +
//                            " from " +
//                            dbTable.tableName() + " " + tableAlias +
//                            (whereParams.isEmpty() && StringUtils.isBlank(paramPlaceHolderBuilder) ? "" : " where " + paramPlaceHolderBuilder);
//
//            String query = queryBuilder.replace(", from", " from");
//            System.out.println("Query: " + query);
//
//            PreparedStatement sqlStmt = connection.prepareStatement(query);
//
//            int paramIdx = 1;
//            for (Object whereParam : whereParams) {
//                if (whereParam.getClass().isAssignableFrom(BigDecimal.class))
//                    sqlStmt.setBigDecimal(paramIdx++, (BigDecimal) whereParam);
//                else if (whereParam.getClass().isAssignableFrom(Long.class))
//                    sqlStmt.setLong(paramIdx++, (long) whereParam);
//                else
//                    sqlStmt.setString(paramIdx++, (String) whereParam);
//            }
//
//            ResultSet resultSet = sqlStmt.executeQuery();
//            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//            int resultSetMetaDataCnt = resultSetMetaData.getColumnCount();
//
//            while (resultSet.next()) {
//                T bean = (T) entity.getClass().getDeclaredConstructor().newInstance();
//
//                for (int idx = 1; idx <= resultSetMetaDataCnt; idx++) {
//                    String colName = resultSetMetaData.getColumnName(idx);
//
//                    for (Field field : fields) {
//                        if (!field.isAnnotationPresent(DbColumn.class) || field.isAnnotationPresent(DbTableId.class))
//                            continue;
//
//                        DbColumn dbTableColumn = field.getAnnotation(DbColumn.class);
//
//                        field.setAccessible(true);
//                        if (dbTableColumn.columnName().equals(colName)) {
//                            BeanUtils.setProperty(bean, field.getName(), resultSet.getObject(idx));
//                            break;
//                        }
//                    }
//
//                }
//
//                resultList.add(bean);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return resultList;
//
//    }
//
//    @PreDestroy
//    public void closeConnection() {
//        try {
//            if (connection != null)
//                connection.close();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//    }
//
////    public static <T> void insert(T entity) {
////        try {
////            Class<?> clazz = entity.getClass();
////            if (!clazz.isAnnotationPresent(DbTable.class))
////                return;
////
////            DbTable dbTable = clazz.getAnnotation(DbTable.class);
////
////            List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
////            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
////
////            StringBuilder columnBuilder = new StringBuilder();
////            StringBuilder paramPlaceHolderBuilder = new StringBuilder();
////            List<Object> parameters = new ArrayList<>();
////
////            for (Field field : fields) {
////                if (!field.isAnnotationPresent(DbColumn.class) || field.isAnnotationPresent(DbTableId.class))
////                    continue;
////
////                field.setAccessible(true);
////                if (field.get(entity) == null)
////                    continue;
////
////                DbColumn dbTableColumn = field.getAnnotation(DbColumn.class);
////
////                columnBuilder.append(dbTableColumn.columnName()).append(",");
////                paramPlaceHolderBuilder.append("?").append(",");
////                parameters.add(field.get(entity));
////            }
////
////            String queryBuilder = "insert into " +
////                    dbTable.tableName() +
////                    "(" +
////                    columnBuilder +
////                    ")" +
////                    " values(" +
////                    paramPlaceHolderBuilder +
////                    ")";
////
////            String query = queryBuilder.replace(",)", ")");
////            System.out.println("Query: " + query);
////
////            try (PreparedStatement sqlStmt = MySqlDB.getInstance().getConnection().prepareStatement(query)) {
////                int paramIdx = 1;
////                for (Object param : parameters) {
////                    if (param instanceof BigDecimal)
////                        sqlStmt.setBigDecimal(paramIdx++, (BigDecimal) param);
////                    else if (param instanceof Long)
////                        sqlStmt.setLong(paramIdx++, (long) param);
////                    else
////                        sqlStmt.setString(paramIdx++, param.toString());
////                }
////
////                sqlStmt.executeUpdate();
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//
//
////    public static List<User> select(Class<?> entity) {
////        return null;
////    }
////
////    public Connection getConnection() throws SQLException {
////        if (dataSource == null) {
////            throw new IllegalStateException("DataSource is null. Initialization error.");
////        }
////
////        return dataSource.getConnection();
////    }
////
////    public void closeConnection(Connection connection) {
////        if (connection != null) {
////            try {
////                connection.close();
////            } catch (SQLException e) {
////                e.printStackTrace();
////            }
////        }
////    }
//
//}
