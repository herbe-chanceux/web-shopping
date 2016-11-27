package huel.util;
import java.sql.*;
public class DbConnect {	
	  PreparedStatement pstmt=null;
	  ResultSet  rs=null;
	  public static Connection getDBconnection(){
	  try{	 	  
	  
	    try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			System.out.println("数据库驱动加载");
		}//加载驱动
	    Connection  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping?"
		+     "user=root&password=123456&"+
	         "useUnicode=true&characterEncoding=UTF-8");//获得数据库连接
	    return conn;
	  }catch(SQLException e)
	     {
		  System.out.println("数据库连接失败");
		 }
	  return null;
	  }
	  
	  public static void closeDB(Connection con,PreparedStatement pstm,ResultSet rs){
		  try {
			if(rs!=null) rs.close();
			  if(pstm!=null) pstm.close();
			  if(con!=null) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
}
