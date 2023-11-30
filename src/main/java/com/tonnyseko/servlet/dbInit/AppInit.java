package com.tonnyseko.servlet.dbInit;

import com.tonnyseko.servlet.database.MySqlDB;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class AppInit implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Database instance created");

        MySqlDB.updateSchema();

        System.out.println("Database connection established");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try{
            MySqlDB database = MySqlDB.getInstance();
            if (database.getConnection() != null){
                database.getConnection().close();
                System.out.println("Database connection closed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
