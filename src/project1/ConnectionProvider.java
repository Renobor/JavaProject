/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

/**
 *
 * @author 태건
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.StatementEvent;




public class ConnectionProvider {

 
 
 
 
 public static Connection getConnection()//드라이버 메모리로 로드하고, 서버에 연결하는 반복된 동작을 묶음.
 {
  try{
   //1. jdbc 드라이버를 메모리로 로드한다.
   Class.forName("oracle.jdbc.driver.OracleDriver");
   
   //2. db Server에 연결한다.
   Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2", "board", "board");
   

   return conn;
   
  }catch(Exception e)
  {
   System.out.println(e);
   return null;
  }
 }
 
 
 
 public static void coles(ResultSet rs, Statement stmt, Connection conn)//닫는 동작도 반복되어 묶음 
 {
  
  try {
 
   if(rs!=null)
    rs.close();
   if(stmt!=null)   
    stmt.close();   
   if(conn!=null)   
    conn.close();  
  }catch(Exception e){}
  
  
 }
 
 

 
 
}
