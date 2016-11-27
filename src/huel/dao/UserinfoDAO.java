package huel.dao;

import huel.bean.Userinfo;
import huel.util.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UserinfoDAO {
  
	
	public boolean save(Userinfo u){
		String saveSql="insert into userinfo(username,password,sex,tel,email) values(?,?,?,?,?)";
	    PreparedStatement ps;
	    Connection con;
	    try{
	    	con=DbConnect.getDBconnection();
	    	ps=con.prepareStatement(saveSql);
	    	ps.setString(1, new String(u.getUsername().getBytes("iso-8859-1"),"UTF-8"));
	    	ps.setString(2,u.getPassword());
	    	ps.setString(3, new String(u.getSex().getBytes("iso-8859-1"),"UTF-8"));
	    	ps.setString(4,u.getTel());
	    	ps.setString(5,u.getEmail());
	    	System.out.println("11111111");
	    	int n=ps.executeUpdate();
	    	System.out.println("注册：n="+n);
	    	
	    }catch(Exception e){
	    	System.out.println("注册失败！");
	    	return false;
	    }
	    return true;
	}

	public Userinfo query(String username,String password){
		String saveSql="select * from userinfo where username=? and password=?"; 
		PreparedStatement ps;
		Connection con;
		System.out.println("name="+username+",passwd="+password);
		Userinfo u=new Userinfo();
		try{
			con=DbConnect.getDBconnection();
			ps=con.prepareStatement(saveSql);
			ps.setString(1, username);
			ps.setString(2,password);
			//System.out.println("query1==================");
			ResultSet rs=ps.executeQuery();//返回查询的结果集
			//System.out.println("2==================");
			if(rs.next()){
			u.setId(rs.getInt("id"));
			u.setUsername(rs.getString("username"));
			u.setPassword(rs.getString("password"));
			u.setSex(rs.getString("sex"));
			u.setTel(rs.getString("tel"));
			u.setEmail(rs.getString("email"));
			}
		}catch(Exception e)
		{  System.out.println("用户登录失败！");
		return null;
		}
		return u;
	}
	public int getPagecount() throws Exception{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int recordcount=0,t1=0,t2=0;
		try{
			conn=DbConnect.getDBconnection();
			String sql="select count(*) from userinfo";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.next();
			recordcount=rs.getInt(1);
			t1=recordcount%3;
			t2=recordcount/3;
		}finally{
			DbConnect.closeDB(conn, ps, rs);
		}
		return t1==0?t2:t2+1;
	}
	public List<Userinfo> listUserinfo(int pageno) throws Exception{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int pagesize=3;
		int startRecno=(pageno-1)*pagesize;
		ArrayList<Userinfo> userList=new ArrayList<Userinfo>();
		try{
			conn=DbConnect.getDBconnection();
			String sql="select * from userinfo order by userid limit ?,?";
			ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, startRecno);
			ps.setInt(2, pagesize);
			rs=ps.executeQuery();
			while(rs.next()){
				Userinfo user=new Userinfo();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setSex(rs.getString(3));
				userList.add(user);
			}
		}finally{
			DbConnect.closeDB(conn, ps, rs);
		}
		return userList;
	}
	
}
