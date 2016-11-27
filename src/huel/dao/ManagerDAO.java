package huel.dao;

import huel.bean.Managerinfo;
import huel.util.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManagerDAO {
	
	/*public boolean save(Managerinfo u1){
		String saveSql="insert into manager(Staff_Name,Staff_Password) values(?,?)";
	    PreparedStatement ps;
	    Connection con;
	    try{
	    	con=DbConnect.getDBconnection();
	    	ps=con.prepareStatement(saveSql);
	    	ps.setString(1, new String(u1.getStaff_Name().getBytes("iso8859-1"),"UTF-8"));
	    	ps.setString(2,u1.getStaff_Password());
	    
	    }catch(Exception e){
	    	System.out.println("登录失败！");
	    	return false;
	    }
	    return true;
	}*/
	    
	    
	public Managerinfo query(String Staff_Name,String Staff_Password){
		String saveSql="select * from manager where Staff_Name=? and Staff_Password=?"; 
		PreparedStatement ps;
		Connection con;
		System.out.println("name="+Staff_Name+",passwd="+Staff_Password);
		Managerinfo u1=new Managerinfo();
		try{
			con=DbConnect.getDBconnection();
			ps=con.prepareStatement(saveSql);
			ps.setString(1, Staff_Name);
			ps.setString(2,Staff_Password);
			//System.out.println("query1==================");
			ResultSet rs=ps.executeQuery();//返回查询的结果集
			//System.out.println("2==================");
			if(rs.next()){
			u1.setId(rs.getInt("id"));
			u1.setStaff_Name(rs.getString("Staff_Name"));
			u1.setStaff_Password(rs.getString("Staff_Password"));
			}
		}catch(Exception e)
		{  System.out.println("用户登录失败！");
		return null;
		}
		return u1;
	}
}

