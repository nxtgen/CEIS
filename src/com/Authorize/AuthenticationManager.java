/*
 * Authentication Manager business class.
 * 
 */
package Authorize;

import Utilities.DBUtils;
import ceis.User;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author j1008791
 */
public class AuthenticationManager {
    private static AuthenticationManager anInstance = null;
    
    private AuthenticationManager() 
    {    
    }
    
    public static AuthenticationManager Instance() 
    {
        if (anInstance == null)
            anInstance = new AuthenticationManager();
        
        return anInstance;
    }
    
    public boolean Authorize(User anUser) 
    {      
        ResultSet resultSet;   
        int number = 0;
        boolean isValid = false;
        String query = "select count(*) from user where UserID=? and PassWord=?";
        
        Connection connection = DBUtils.getConnection();
        try {
            resultSet = DBUtils.execute(connection, query, anUser.getId(), anUser.getPassWd());
            while (resultSet.next()) {
                number = resultSet.getInt(1);
            }   
            isValid = number==1?true:false;
        }
        catch (Exception e) {
            e.printStackTrace();
        }        
        
        DBUtils.freeConnection(connection);
        return isValid;
    }
}
