package huel.dao;

import huel.bean.Account;
import huel.bean.AccountProducts;
import huel.util.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
	public boolean save(Account a){
		String saveSql="insert into account(userid,address,postcode,accountcode,accountdate,execute) values(?,?,?,?,?,?)";
	    PreparedStatement ps;
	    Connection con;
	    try{
	    	con=DbConnect.getDBconnection();
	    	ps=con.prepareStatement(saveSql);
	    	ps.setInt(1,a.getUserid());
	    	ps.setString(2, new String(a.getAddress().getBytes("iso-8859-1"),"UTF-8"));
	    	ps.setString(3,a.getPostcode());
	    	ps.setString(4,a.getAccountcode());
	    	ps.setString(5,a.getAccountdate());
	    	ps.setInt(6,a.getExecute());
	    	//System.out.println("11111111");
	    	int n=ps.executeUpdate();
	    	DbConnect.closeDB(con, ps, null);
	    	System.out.println("订单信息插入订单表：n="+n);
	    	
	    }catch(Exception e){
	    	System.out.println("订单信息插入订单表失败！");
	    	return false;
	    }
	    return true;
}
	public List<Account> getAccount1(int uid){
		String saveSql="select * from account where userid=?";
		PreparedStatement ps;
	    Connection con;
	    ResultSet rs;
	    List<Account> la=new ArrayList<Account>();
	    try{
	    	con=DbConnect.getDBconnection();
	    	ps=con.prepareStatement(saveSql);
	    	ps.setInt(1,uid);
	    	rs=ps.executeQuery();
	    	
	    	while(rs.next()){
	    		Account a=new Account();
	    		a.setId(rs.getInt("id"));
	    		a.setUserid(rs.getInt("userid"));
	    		a.setAccountcode(rs.getString("accountcode"));
	    		a.setAccountdate(rs.getString("accountdate"));
	    		a.setAddress(rs.getString("address"));
	    		a.setPostcode(rs.getString("postcode"));
	    		a.setExecute(rs.getInt("execute"));
	    		la.add(a);
	    		System.out.println("订单信息lala"+la.size());
	    		
	    	}
	    	DbConnect.closeDB(con, ps, rs);  
	    	
	    }catch(Exception e){
	    	//System.out.println("订单信息插入订单表失败！");
	    	return null;
	    }
	    return la;
}
	
	
	}
