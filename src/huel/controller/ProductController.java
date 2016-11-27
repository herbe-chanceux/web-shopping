package huel.controller;

//import huel.bean.*;
import huel.bean.Account;
import huel.bean.AccountProducts;
import huel.bean.Productinfo;
import huel.bean.ShoppingCart;
import huel.bean.Userinfo;
import huel.dao.AccountDAO;
import huel.dao.ProductDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.DataLine.Info;

 
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private ProductDAO  pd; 
    
    public ProductController() {
    	 pd=new ProductDAO ();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String command=request.getParameter("action");
		 int com=0;
		 if(command.equals("findByType")) com=0;//将一页商品作为属性
		 else if(command.equals("findByKeyWord")) com=1;//将由id得到的商品作为属性
		 else if(command.equals("addProduct")) com=2;//管理员添加商品
		 else if(command.equals("deleteProduct")) com=3;
		 switch(com){
		 case 0:findByType(request,response);
		 break;
		 case 1:findByKeyWord(request,response);
		 break;
		 case 2:addProduct(request,response);
		 break;
		 case 3:deleteProduct(request,response);
		 break; 
		 } 
	}
	 
	private void addProduct(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException  {
		System.out.println("enter save Account ACCOUNTcontrolll.java");
		request.setCharacterEncoding("UTF-8");
	    String Type=request.getParameter("Type");
	    String Name=request.getParameter("Name");
	    Float UnitPrice=Float.parseFloat(request.getParameter("UnitPrice"));
	    Float PromotionPrice=Float.parseFloat(request.getParameter("PromotionPrice"));
	    Productinfo p=new Productinfo();
	    p.setType(Type);
	    p.setName(Name);
	    p.setUnitPrice(UnitPrice);
	    p.setPromotionPrice(PromotionPrice);
	    if(pd.addProduct(p)){
	    	request.setAttribute("info", "添加成功 ");
			request.getRequestDispatcher("addOver.jsp").forward(request, response);
	    }
	    else{
	    	request.setAttribute("errors","添加出错!");
			request.getRequestDispatcher("error.jsp").forward(request, response);
	    } 
}
	private void deleteProduct(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException  {
		System.out.println("enter save Account ACCOUNTcontrolll.java");
		request.setCharacterEncoding("UTF-8");
	    int id=Integer.parseInt(request.getParameter("id"));
	   
	    if(pd.deleteProduct(id)){
	    	//request.setAttribute("info", "删除成功 ");
			request.getRequestDispatcher("deleteOver.jsp").forward(request, response);
	    }
	    else{
	    	request.setAttribute("error","添加出错!");
			request.getRequestDispatcher("error.jsp").forward(request, response);
	    } 
}
	
	
	
	
		protected List<Productinfo>  findByType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//request.setCharacterEncoding("UTF-8");
			String Type=request.getParameter("Type");
			// Type=new String(Type.getBytes("ISO-8859-1"),"UTF-8");
		
			 Integer start=0;//显示第几页（请求参数）
			    //Integer pagesize=3;
			 List<Productinfo> ll ;
			if(request.getParameter("start")==null){
				start=1;
			}else{
				start=Integer.parseInt(request.getParameter("start"));
			}
			 try{
				 
				 ProductDAO p=new ProductDAO();	
				 Type=new String(Type.getBytes("iso-8859-1"),"UTF-8");				
				  ll=p.ListPro(Type, start);
				 request.setAttribute("pageCount", p.getPagecount(Type));
				 request.setAttribute("start", start);
				 request.setAttribute("findByType",ll);
			   request.getRequestDispatcher("Fenye.jsp").forward(request, response); 	
			   }catch(Exception e)
			   {
				   System.out.println("list error");
				   return null;				   
			   }
			 return ll;				
		}		
		protected void  findByKeyWord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 
		}
}
