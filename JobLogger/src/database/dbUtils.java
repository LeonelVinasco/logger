/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import java.sql.DriverManager;
import java.util.*;

/**
 *
 * @author leo
 */
public class dbUtils {
    private static Connection db=null;
    
    public static void connectDB (Map dbParams){
        Properties connectionProps=new Properties();
        connectionProps.put("user",dbParams.get("password"));
        String conn = "jdbc:"+dbParams.get("dbms")+"://"
                      +dbParams.get("serverName")+":"+dbParams.get("ServerName")+":"
                      +dbParams.get("portNumber")+"/";
        try{
            db=DriverManager.getConnection(conn, connectionProps);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void closeDB(){
        try{
            db.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void update(String message, int t){
        String query="insert into Log_Values('"+message+"',"+ String.valueOf(t)+")";
        try(Statement state= db.createStatement()){
            state.executeUpdate(query);    
        }catch(SQLException e){
            e.printStackTrace(); 
        }
    }
}
