/*
 * User bean class
 * 
 */
package com.ceis;

import java.io.Serializable;

public class User implements Serializable
{
    private String id;
    private String passwd;
    
    public User()
    {
        id = "";
        passwd = "";
    }
            
    public User (String id, String passwd)
    {
        this.id = id;
        this.passwd = passwd;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    { 
        return id; 
    }
    
    public void setPassWd(String passwd)
    {
        this.passwd = passwd;
    }

    public String getPassWd()
    { 
        return passwd; 
    }
}
