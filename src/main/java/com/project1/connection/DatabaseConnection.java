package com.project1.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    //instantiating connection object
    private static Connection con = null;

    /*instantiating properties object to retrieve variables*/
    private static final Properties prop = new Properties();

    static {
        try {
            //import the jar file into jva
            Class.forName("org.postgresql.Driver");
            prop.load(new FileReader("src/main/resources/db.properties"));

            // actually getting this connection
            con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    // getter for connection
    public static Connection getCon() {
        return con;
    }

}
