package huel.controller;

 
import huel.bean.Productinfo;
import huel.bean.ShoppingCart;
import huel.dao.ProductDAO;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ProductDAO gd;
     
    public CartController() {
        gd=new ProductDAO();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("********************a");
		 String command=request.getParameter("action");
		 int com=0;
		 if(command.equals("add")) com=0;//add加入购物车
		 else if(command.equals("changeNum")) com=1;//changeNum 修改购物车中某商品的数量
		 else if(command.equals("removeCart")) com=2;//remove从购物车中移除
		 else if(command.equals("clearCart")) com=3;//晴空购物车
		 switch(com){
		 case 0:add(request,response);break;
		 case 1:changeNum(request,response);break;
		 case 2:removeCart(request,response);break;
		 case 3:clearCart(request,response);break;
		 }
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	public void add(HttpServletRequest request, HttpServletResponse response){
		//根据传入的id,将商品加入购物车，因为涉及商品数量，而goods表中没有，所以特别创建了一个VO类，ShoppingCart.
		Integer id=Integer.parseInt(request.getParameter("id"));
		try{
			Integer Num=0;
			HttpSession session=request.getSession();
			List<ShoppingCart> lsc=(List<ShoppingCart>)session.getAttribute("ShoppingCart");
			if(lsc==null){
				lsc=new LinkedList<ShoppingCart>();
			}
			for(int i=0;i<lsc.size();i++)
			{
				if(lsc.get(i).getId()==id){
					Num=lsc.get(i).getNum();
					lsc.remove(lsc.get(i));
				}
			}
			ShoppingCart sc=new ShoppingCart();
			Productinfo p=gd.findByID(id);
			sc.setName(p.getName());
			sc.setType(p.getType());
			sc.setNum(Num+1);
			sc.setUnitPrice(p.getUnitPrice());
			sc.setId(p.getId());
			sc.setPic(p.getPic());
			lsc.add(sc);//加入购物车
			session.setAttribute("ShoppingCart",lsc);
			System.out.println(id+" "+sc.getNum()+" "+p);
			RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();//打印错误的堆栈跟踪信息
		}
	}
	public void changeNum(HttpServletRequest request, HttpServletResponse response){
		//  修改购物车中ID对应商品的数量
		HttpSession session=request.getSession();
		List<ShoppingCart> lsc=(List<ShoppingCart>)session.getAttribute("ShoppingCart");
		try{
			 String[] number=request.getParameterValues("num");
			for(int i=0;i<lsc.size();i++)
			{
				if(Integer.parseInt(number[i])!=0){
					lsc.get(i).setNum(Integer.parseInt(number[i]));
				}else{
					lsc.remove(i);
				}
			}
			session.setAttribute("ShoppingCart",lsc);
			RequestDispatcher rd=request.getRequestDispatcher("viewShoppingcart.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();//打印错误的堆栈跟踪信息
		}
		System.out.println("*************");
	}
	public void removeCart(HttpServletRequest request, HttpServletResponse response){
		//根据传入的id,将商品加入购物车，因为涉及商品数量，而goods表中没有，所以特别创建了一个VO类，ShoppingCart.
		Integer id=Integer.parseInt(request.getParameter("id"));
		try{
			Integer Num=0;
			HttpSession session=request.getSession();
			List<ShoppingCart> lsc=(List<ShoppingCart>)session.getAttribute("ShoppingCart");
			 
			for(int i=0;i<lsc.size();i++)
			{
				if(lsc.get(i).getId()==id){
					lsc.remove(lsc.get(i));
				}
			}
			session.setAttribute("ShoppingCart",lsc);
			RequestDispatcher rd=request.getRequestDispatcher("viewShoppingcart.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();//打印错误的堆栈跟踪信息
		}
	}
	public void clearCart(HttpServletRequest request, HttpServletResponse response){
		//  清空购物车
		try{
			HttpSession session=request.getSession();
			session.removeAttribute("ShoppingCart");
			RequestDispatcher rd=request.getRequestDispatcher("viewShoppingcart.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();//打印错误的堆栈跟踪信息
		}
	}


}
