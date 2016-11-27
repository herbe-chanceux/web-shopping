package huel.controller;

import huel.bean.Account;
import huel.bean.AccountProducts;
import huel.bean.Productinfo;
import huel.bean.ShoppingCart;
import huel.bean.Userinfo;
import huel.dao.AccountDAO;
import huel.dao.AccountproductsDAO;
import huel.dao.ProductDAO;
import huel.util.CodeCreator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AccountDAO  ad;
    private AccountproductsDAO apd;
    private ProductDAO pd;
    
    public AccountController() {
       ad=new AccountDAO();
       apd=new AccountproductsDAO();
       pd=new ProductDAO();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command=request.getParameter("action");
		int com=0;
		if(command.equals("getAccountCode")) com=0;
		else if(command.equals("saveAccount")) com=1;
		else if(command.equals("showAccount")) com=2;
		else if(command.equals("showAccount2")) com=3;
		switch(com){
		case 0:getAccountCode(request,response);break;
		case 1:saveAccount(request,response);break;
		case 2:showAccount(request,response);break;
		case 3:showAccount2(request,response);break;
		}
	}
	

	


	private void showAccount2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	try{
	    HttpSession session=request.getSession();
		request.setCharacterEncoding("UTF-8");
		System.out.println("fhhhhhhhhhhhhhhhhhhhhhhhhhh");
		String accountcode=request.getParameter("accountcode");
		System.out.println("++++++++"+accountcode);
		session.setAttribute("ordertable2", apd.getAccount2(accountcode));
		System.out.println("%%%%%%%%%%%%****************");
		
	
		List<AccountProducts> lap=new ArrayList<AccountProducts>();
		lap=(List<AccountProducts>)session.getAttribute("ordertable2");
		AccountProducts ap=new AccountProducts();
		if(ap!=null){
			for(int i=0;i<lap.size();i++){
				ap=lap.get(i);
		   
		
		System.out.println("lllllllllllllllllllllllllllllllllllllllllllllllll");
		int Id=ap.getProductid();
		System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF*"+Id);
		session.setAttribute("findByID", pd.findByID(Id));}}
		System.out.println("bBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
	    request.getRequestDispatcher("showAccount2.jsp").forward(request, response); 
	}catch(Exception e){
		e.printStackTrace();
		}
		
	}


	public void getAccountCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Userinfo u=(Userinfo)request.getSession().getAttribute("Userinfo");
		
		System.out.println("controll  userid="+u.getId()+",name="+u.getUsername());
		request.setAttribute("accountCode",new CodeCreator().createAccountcode(u.getId()));
		request.getRequestDispatcher("account.jsp").forward(request, response);
	}
	public void saveAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("enter save Account ACCOUNTcontrolll.java");
		request.setCharacterEncoding("UTF-8");
		Userinfo u=(Userinfo)request.getSession().getAttribute("Userinfo");
		Productinfo p=(Productinfo)request.getSession().getAttribute("Productinfo");
		String accountcode=request.getParameter("accountCode");
		String address=request.getParameter("address");
		String postcode=request.getParameter("postcode");
		Account a=new Account();
		a.setUserid(u.getId());
		a.setAccountcode(accountcode);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String d=sdf.format(new Date()).toString();//获取当前日期转化为字符
		a.setAccountdate(d);
		a.setAddress(address);
		a.setExecute(0);
		a.setPostcode(postcode);
		System.out.println("accountcode="+accountcode+"address="+address+"postcode"+postcode);
		if(ad.save(a))
		{
			@SuppressWarnings("unchecked")
			List<ShoppingCart> lsc=(List<ShoppingCart>)request.getSession().getAttribute("ShoppingCart");
			for(ShoppingCart sc:lsc){
				AccountProducts ap=new AccountProducts();
				ap.setUserid(u.getId());
				ap.setProductid(sc.getId());
				ap.setNum(sc.getNum());
				ap.setAccountcode(a.getAccountcode());
				ap.setAccountdate(a.getAccountdate());
				 System.out.println(ap.getUserid());
		    	 System.out.println(ap.getProductid());
		    	 System.out.println(ap.getAccountcode());
		    	 System.out.println(ap.getAccountdate());
		    	 System.out.println(ap.getNum());
				if(!apd.save(ap))
				{
					System.out.println("--------------------accountgoods出错：--------------------"+sc.getId());
					request.setAttribute("errors","对商品，"+sc.getName()+"结账出错!");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}
		request.getSession().setAttribute("ShoppingCart", new ArrayList<ShoppingCart>());
		request.getRequestDispatcher("accountover.jsp").forward(request, response);
	}else{
		request.setAttribute("errors","结账出错!");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
}
	
public void showAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
		HttpSession session=request.getSession();
	request.setCharacterEncoding("UTF-8");
	Userinfo u=(Userinfo)request.getSession().getAttribute("Userinfo");
	int userid=u.getId();
	System.out.println("++++++++"+userid);

	
	session.setAttribute("ordertable", ad.getAccount1(userid));
	
    request.getRequestDispatcher("showAccount.jsp").forward(request, response); 
}catch(Exception e){
	e.printStackTrace();
	}
}


}

