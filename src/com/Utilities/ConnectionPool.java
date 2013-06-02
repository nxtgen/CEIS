/*
 * Connection Pool implementation based on Apache-dbcp
 * 
 */
package Utilities;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author j1008791
 */
public class ConnectionPool {
    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;
    
    private ConnectionPool() throws NamingException
    {
        try 
        {            
            Context envCtx = (Context) new InitialContext().lookup("java:comp/env");
            dataSource = (DataSource) envCtx.lookup("jdbc/ceismgr");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    public static ConnectionPool getInstance()
    {
        try 
        {
            if (pool == null)
                pool = new ConnectionPool();            
        } catch (NamingException ex)
        {
           ex.printStackTrace();
        }       
        return pool;
    }
    
    public Connection getConnection()
    {
        try 
        {
            return dataSource.getConnection();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    
    public void freeConnection(Connection c)
    {
        try     
        {
            c.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
