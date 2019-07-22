package com.quiz.QuizSpring;



//change mm mmm


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseUtility {
    /**
    * Connect to a sample database
    */
	
	Connection conn=null;
	
	public  Connection connectToAws() {
		try {
	           // db parameters
	           String url = "jdbc:postgresql://bookstore.co2mg4zkpt30.us-east-2.rds.amazonaws.com"
	           		+ ":5432/awstrainingdb"
	           		+ "?user=dbuser&password=dbpassword";
	           // create a connection to the database
	           conn = DriverManager
	        		   .getConnection(url);
	           
	           System.out.println("Connection to AWR-RDS Postgre has been established.");
	           
	           return conn;
	       } catch (SQLException e) {
	           System.out.println(e.getMessage());
	       } finally {
	           
	       }
	       return null;
		
	}
	//Below Connect
   public  Connection connect() {
       
       try {
           // db parameters
           String url = "jdbc:sqlite:C:\\Users\\marut\\.dbeaver4\\.metadata\\sample-database-sqlite-1\\Chinook.db";
           // create a connection to the database
           conn = DriverManager
        		   .getConnection(url);
           
           System.out.println("Connection to SQLite has been established.");
           
           return conn;
           
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       } finally {
           
       }
       return null;
   }
   
   
  
   
   
public  void insert(String query) {
       

       try {
               Statement stmt = conn.createStatement();
           stmt.executeUpdate(query);
           System.out.println("Insert successful");
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
   }
   
   
public  void delete(String query) {
    

    try {
            Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
        System.out.println("delete successful");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

public  void update(String query) {
    

    try {
            Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
        System.out.println("update successful");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}




   public  ArrayList<String> selectAll(String query){
	   ArrayList<String> finalList= new ArrayList<String>();
       
       try { 
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(query);
           
            List<String> columnNames = new ArrayList<>();
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                columnNames.add(rsmd.getColumnLabel(i));
            }
            
            int rowIndex = 0;
            while (rs.next()) {
                rowIndex++;
                // collect row data as objects in a List
                StringBuffer buff=new StringBuffer();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    buff.append(rs.getObject(i)+ " ");
                }
                
                finalList.add(buff.toString());
                
            }
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
       
       return finalList;
   }
   
   
   public void closeConnection()
   {
	   try {
           if (conn != null) {
               conn.close();
               System.out.println("Connection Closed");
           }
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
   }
   
   
   /**
    * @param args the command line arguments
    */
//   public static void main(String[] args) {
//	   
//	   DataBaseUtility db = new DataBaseUtility();
//	   
//	  // Connection conn= db.connect();
//	   Connection conn= db.connectToAws();
//
//	   db. selectAll("Select * from employee").forEach(e->System.out.println(e));
//	   /*   
//      db.insert("insert into employee values('4','Dan','900','Mike')");
//         
//      db.delete("delete from employee where id='4'");
//      
//      db.update("update employee set name='SanathKamath' where id='2'");
//      
//      System.out.println("**********************");
//	   db. selectAll("Select * from employee order by id").forEach(e->System.out.println(e));
//*/
//       db.closeConnection();
//      
//   }

}

