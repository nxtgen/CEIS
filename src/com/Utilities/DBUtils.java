/*
 * Generic Jdbc functionality
 * 
 */
package Utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DBUtils {
    public static Connection getConnection()
    {
        ConnectionPool pool;
  Connection connect;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            pool = ConnectionPool.getInstance();
            connect = pool.getConnection();
        }
        catch(Exception e) {
            connect = null;
            e.printStackTrace();
        }
        return connect;
    }
    
    public static void freeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }    
    
    public static ResultSet execute(Connection connect, String query, String userId, String passWd) {       
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;
        
        try {
            preparedStatement = connect.prepareStatement(query);            
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, passWd);            
            resultSet = preparedStatement.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return resultSet;
    }
}
