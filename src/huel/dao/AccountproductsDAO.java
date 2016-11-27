package huel.dao;

import huel.bean.Account;
import huel.bean.AccountProducts;
import huel.util.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountproductsDAO {
	public boolean save(AccountProducts ap){
		 PreparedStatement ps;
	     Connection con;
	   
	    try{
	    	 System.out.println("SDLKFJL;SKDJFL;KSJDFLKJSDLKFJLKDSJFDFGDFGDFGDFGDFGDAO");
	    	 System.out.println(ap.getUserid());
	    	 System.out.println(ap.getProductid());
	    	 System.out.println(ap.getAccountcode());
	    	 System.out.println(ap.getNum());
	    	 System.out.println(ap.getAccountdate());
	    	String saveSql="insert into accountproducts(userid,productid,accountcode,num,accountdate) values(?,?,?,?,?)";
	    	con=DbConnect.getDBconnection();
	    	ps=con.prepareStatement(saveSql);
	    	ps.setInt(1, ap.getUserid());
	    	ps.setInt(2,ap.getProductid());
	    	ps.setString(3,ap.getAccountcode());
	    	ps.setInt(4,ap.getNum());
	    	ps.setString(5,ap.getAccountdate());
	    	
	    	int n=ps.executeUpdate();
	    	System.out.println("inser into Accountproducts：n="+n);
	    	DbConnect.closeDB(con, ps, null);
	    }catch(Exception e){
	    	System.out.println("插入订单商品明细表失败！");
	    	return false;
	    }
	    return true;

}
	public List<AccountProducts> getAccount2(String accountcode){
		String saveSql="select * from accountproducts where accountcode=?";
		PreparedStatement ps;
	    Connection con;
	    ResultSet rs;
	    List<AccountProducts> ll=new ArrayList<AccountProducts>();
	    try{
	    	con=DbConnect.getDBconnection();
	    	ps=con.prepareStatement(saveSql);
	    	ps.setString(1,accountcode);
	    	rs=ps.executeQuery();
	    	if(rs==null)System.out.println("订单信息kong");
	    	
	    	while(rs.next()){
	    		AccountProducts p=new AccountProducts();
	    		System.out.println("dddddddddddddddddddddd");
	    		p.setId(rs.getInt("id"));
	    		p.setUserid(rs.getInt("userid"));
	     		System.out.println("eeeeeeeeeeeeeeeeeeeeeeee");
	    		p.setProductid(rs.getInt("productid"));
	    		p.setAccountcode(rs.getString("accountcode"));
	    		p.setAccountdate(rs.getString("accountdate"));
	    		p.setNum(rs.getInt("num"));
	    		ll.add(p);
	    		System.out.println("订单信息lala"+ll.size());
	    	}
	    	DbConnect.closeDB(con, ps, rs);  
	    	
	    }catch(Exception e){
	    	//System.out.println("订单信息插入订单表失败！");
	    	return null;
	    }
	    return ll;
}

}
