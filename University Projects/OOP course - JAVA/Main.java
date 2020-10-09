/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JAVADB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author alienware
 */
public class Main {
    
    public static String url = "";
    public static String username = "";
    public static String password = "";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter url: ");
        url = reader.nextLine();
        System.out.println("Enter username: ");
        username = reader.nextLine();
        System.out.println("Enter password: ");
        password = reader.nextLine();
        
        reader.close();
        getConnection();
        createTable();
        
    }
    
    public static void createTable() throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS tablename (id int NOT NULL AUTO_INCREMENT , first carchar(255) , last varchar(255), PRIMARY KEY(id)");
            create.executeUpdate();
        }catch(Exception e){System.out.println(e);}
        finally{
            System.out.println("Function Complete.");
        };
    }
    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            url = "jdbc:mysql://192.168.1.255:3306/test.db";
            username = "ancompcn@gmail.com";
            password = "aA8252nanu";
            Class.forName(driver);
            
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected");
            return conn;
        } catch (Exception e){System.out.println(e);}
        return null;
    }
    
}
