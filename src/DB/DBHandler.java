/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Frederik
 */
public class DBHandler {


private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/examproject";
private static final String USERNAME = "root";
private static final String PASSWORD = "Luger";
private static final String MAX_POOL = "250";
private Connection connection;
private Properties properties;

private Properties getProperties() {
  if(properties == null) {
    properties = new Properties();
    properties.setProperty("user", USERNAME);
    properties.setProperty("password", PASSWORD);
    properties.setProperty("MaxPooledStatements", MAX_POOL);
  }
  return properties;
}

// connect database
public Connection connect() throws SQLException {
    if (connection == null) {
        try {
            Class.forName(DATABASE_DRIVER);
            connection = (Connection) DriverManager.getConnection(DATABASE_URL, getProperties());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    return connection;
}

// disconnect database
public void disconnect() {
  if(connection != null) {
    try {
      connection.close();
      connection = null;
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }
}       
}