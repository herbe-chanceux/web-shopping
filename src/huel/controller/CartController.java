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
		 if(command.equals("add")) com=0;//add���빺�ﳵ
		 else if(command.equals("changeNum")) com=1;//changeNum �޸Ĺ��ﳵ��ĳ��Ʒ������
		 else if(command.equals("removeCart")) com=2;//remove�ӹ��ﳵ���Ƴ�
		 else if(command.equals("clearCart")) com=3;//��չ��ﳵ
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
		//���ݴ����id,����Ʒ���빺�ﳵ����Ϊ�漰��Ʒ��������goods����û�У������ر𴴽���һ��VO�࣬ShoppingCart.
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
			lsc.add(sc);//���빺�ﳵ
			session.setAttribute("ShoppingCart",lsc);
			System.out.println(id+" "+sc.getNum()+" "+p);
			RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();//��ӡ����Ķ�ջ������Ϣ
		}
	}
	public void changeNum(HttpServletRequest request, HttpServletResponse response){
		//  �޸Ĺ��ﳵ��ID��Ӧ��Ʒ������
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
			e.printStackTrace();//��ӡ����Ķ�ջ������Ϣ
		}
		System.out.println("*************");
	}
	public void removeCart(HttpServletRequest request, HttpServletResponse response){
		//���ݴ����id,����Ʒ���빺�ﳵ����Ϊ�漰��Ʒ��������goods����û�У������ر𴴽���һ��VO�࣬ShoppingCart.
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
			e.printStackTrace();//��ӡ����Ķ�ջ������Ϣ
		}
	}
	public void clearCart(HttpServletRequest request, HttpServletResponse response){
		//  ��չ��ﳵ
		try{
			HttpSession session=request.getSession();
			session.removeAttribute("ShoppingCart");
			RequestDispatcher rd=request.getRequestDispatcher("viewShoppingcart.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();//��ӡ����Ķ�ջ������Ϣ
		}
	}


}
