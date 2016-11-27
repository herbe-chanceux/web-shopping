package huel.dao;

import huel.bean.Account;
import huel.bean.Productinfo;
 
import huel.util.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class ProductDAO {
    public ArrayList<Productinfo> findAllProduct(){  //查询所有的商品
    	String sql="select * from product";
    	PreparedStatement ps;
		Connection con;	
		ResultSet rs;
		ArrayList<Productinfo> ll=new ArrayList<Productinfo>();
		
		try{
			con=DbConnect.getDBconnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				Productinfo p=new Productinfo();
				p.setId(rs.getInt("Id"));
				p.setType(rs.getString("Type"));
				p.setName(rs.getString("Name"));
				p.setUnitPrice(rs.getFloat("UnitPrice"));
				p.setPromotionPrice(rs.getFloat("PromotionPrice"));
				p.setLanguage(rs.getString("Language"));
				p.setDirector(rs.getString("Director"));
				p.setActor(rs.getString("Actor"));
				p.setInstruction(rs.getString("Instruction"));
				p.setDate(rs.getString("Date"));
				p.setNumber(rs.getInt("Number"));
				p.setPic(rs.getString("Pic"));
				
				ll.add(p);
			}
			DbConnect.closeDB(con, ps, rs);
		}catch(SQLException e){
			System.out.println("按类别获取所有商品操作失败ProductDAO");
			return null;
		}
		return ll; 
    }
    public ArrayList<Productinfo> findByType(String Type){//按类型查询商品
    	String sql="select * from product where Type=?";
    	System.out.println("DAO:type="+Type);
    	PreparedStatement ps;
		Connection con;	
		ResultSet rs;
		ArrayList<Productinfo> ll=new ArrayList<Productinfo>();
		
		try{
			con=DbConnect.getDBconnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, Type);
			rs=ps.executeQuery();
			while(rs.next()){
				Productinfo p=new Productinfo();
				p.setId(rs.getInt("Id"));
				p.setType(rs.getString("Type"));
				p.setName(rs.getString("Name"));
				p.setUnitPrice(rs.getFloat("UnitPrice"));
				p.setPromotionPrice(rs.getFloat("PromotionPrice"));
				p.setLanguage(rs.getString("Language"));
				p.setDirector(rs.getString("Director"));
				p.setActor(rs.getString("Actor"));
				p.setInstruction(rs.getString("Instruction"));
				p.setDate(rs.getString("Date"));
				p.setNumber(rs.getInt("Number"));
				p.setPic(rs.getString("Pic"));
				System.out.println(rs.getString("Name"));
				ll.add(p);
			}
			DbConnect.closeDB(con, ps, rs);
			
		}catch(SQLException e){
			System.out.println("按类别获取所有商品操作失败ProductDAO");
			return null;
		} 
		return ll;
    }
    public Productinfo findByID(int Id){
		String sql="select * from product where Id=?";
		Connection conn;
		PreparedStatement pstmt;
		conn=DbConnect.getDBconnection();
		try{
			pstmt=((Connection) conn).prepareStatement(sql);
			pstmt.setInt(1,Id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				Productinfo p=new Productinfo();
				p.setId(rs.getInt("Id"));
				p.setType(rs.getString("Type"));
				p.setName(rs.getString("Name"));
				p.setUnitPrice(rs.getFloat("UnitPrice"));
				p.setPromotionPrice(rs.getFloat("PromotionPrice"));
				p.setLanguage(rs.getString("Language"));
				p.setDirector(rs.getString("Director"));
				p.setActor(rs.getString("Actor"));
				p.setInstruction(rs.getString("Instruction"));
				p.setDate(rs.getString("Date"));
				p.setNumber(rs.getInt("Number"));
				p.setPic(rs.getString("Pic"));
				System.out.println(rs.getString("Name"));
				return p;
			}else{
				return null;
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;	
			}
		}
    public boolean deleteProduct(int id){
    	
		String Sql="delete from product where Id=?";
		PreparedStatement ps;
	    Connection con;
	    try{
	    	
	    	con=DbConnect.getDBconnection();
	    	ps=con.prepareStatement(Sql);
	    	ps.setInt(1,id);
	    	System.out.println("dele1--------------------");
	    	int n=ps.executeUpdate();
	    	System.out.println("dele2--------------------");
	    	DbConnect.closeDB(con, ps, null);
	    	System.out.println("商品信息删除product表：n="+n);
	    }catch(Exception e){
	    	System.out.println("商品删除product表失败！");
		return false;
		}
	    return true;
	}

	public boolean updateGoods(String Id,Productinfo p){
		return false;
	}
	public boolean addProduct(Productinfo p){
		String Sql="insert into product(Type,Name,UnitPrice,PromotionPrice) values(?,?,?,?)";
		PreparedStatement ps;
	    Connection con;
	    try{
	    	con=DbConnect.getDBconnection();
	    	ps=con.prepareStatement(Sql);
	    	ps.setString(1,p.getType());
	    	ps.setString(2,p.getName());
	    	ps.setFloat(3,p.getUnitPrice());
	    	ps.setFloat(4,p.getPromotionPrice());
	    	int n=ps.executeUpdate();
	    	DbConnect.closeDB(con, ps, null);
	    	System.out.println("商品信息插入product表：n="+n);
	    }catch(Exception e){
	    	System.out.println("商品插入product表失败！");
	    	return false;
	    }
		return true;
	}

	public static void main(String[] args){
		
	}


	public Object findAllPage(String type) {
		// TODO Auto-generated method stub
		return null;
	}
	 //TYPE ，分页的LIST  product
    public List<Productinfo> ListPro(String Type,int pageNo) throws Exception{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int pageSize=3;
		int startRecno=(pageNo-1)*pageSize;
		ArrayList<Productinfo> proList=new ArrayList<Productinfo>();
		try{			
			conn=DbConnect.getDBconnection();
			String sql="select * from product where Type=? order by Id limit ?,? ";
			ps=conn.prepareStatement(sql);			
			ps.setString(1, Type);
			ps.setInt(2, startRecno);
			ps.setInt(3, pageSize);			
			rs=ps.executeQuery();			
			while(rs.next()){				
				Productinfo pro=new Productinfo();
				pro.setId(rs.getInt(1));
				pro.setType(rs.getString(2));
				pro.setName(rs.getString(3));
				pro.setUnitPrice(rs.getFloat(4));
				pro.setPromotionPrice(rs.getFloat(5));
				pro.setLanguage(rs.getString(6));
				pro.setDirector(rs.getString(7));
				pro.setActor(rs.getString(8));
				pro.setInstruction(rs.getString(9));
				pro.setDate(rs.getString(10));
				pro.setNumber(rs.getInt(11));
				pro.setPic(rs.getString(12));
				proList.add(pro);
			}
		}finally{
			DbConnect.closeDB(conn, ps, rs);
		}
		return proList;
	}
	//type 得出总页数 product
    public int getPagecount( String Type) throws Exception{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int recordCount=0,t1=0,t2=0;
		try{
			conn=DbConnect.getDBconnection();
			String sql="select count(*) from product where Type=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, Type);
			rs=ps.executeQuery();
			rs.next();
			recordCount=rs.getInt(1);
			t1=recordCount%3;
			t2=recordCount/3;
		}finally{
			DbConnect.closeDB(conn, ps, rs);
		}
		return t1==0?t2:t2+1;
	}
    
	
	
}
