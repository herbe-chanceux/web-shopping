package huel.controller;

import huel.bean.Userinfo;
import huel.dao.UserinfoDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/userinfoController")
public class UserinfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserinfoDAO ud;
 
    public UserinfoController() {
       UserinfoDAO ud=new UserinfoDAO();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command=request.getParameter("action");
		int com=0;
		if(command.equals("regist")) com=0;
		else if(command.equals("login")) com=1;
		else if(command.equals("logout")) com=2;
		
		switch(com)
		{
		case 0:regist(request,response);break;
		case 1:login(request,response);break;
		case 2:logout(request,response);break;
		}
	}
	
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
		request.setCharacterEncoding("UTF-8");	
		String username=request.getParameter("username");	
		String password=request.getParameter("password");
		String repassword=request.getParameter("repassword");
		String sex=request.getParameter("sex");	
		String tel=request.getParameter("tel");	
		String email=request.getParameter("email");	
		
		Userinfo u=new Userinfo();
		u.setUsername(username);
		u.setPassword(password);
		u.setSex(sex);
		u.setTel(tel);
		u.setEmail(email);
		
		UserinfoDAO ud=new UserinfoDAO();
		if(password.equals(repassword)){
		if(ud.save(u)){
			//PrintWriter Out=response.getWriter();
	    	//Out.println("<scripe type='text/javascript'> window.alert('注册成功，去登录');window.location.href='Userlogin.jsp';</script>");

			request.getRequestDispatcher("registsuccess.jsp").forward(request, response);
		}
		}else{
			request.setAttribute("error", "用户注册失败！");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}catch(Exception e){
		
	}
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	try{request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String  checkcode=request.getParameter("checkcode");
		 Userinfo u=new Userinfo();
		    
			u.setUsername(username);
			u.setPassword(password);
		 HttpSession session=request.getSession();
		 String servercheckcode=(String)session.getAttribute("checkCode");
		  UserinfoDAO ud=new UserinfoDAO();
		  u=ud.query(username,password);
		 if(!servercheckcode.equalsIgnoreCase( checkcode)){
			 request.setAttribute("error","验证码不正确，请重新输入！！！");
			 request.getRequestDispatcher("error.jsp").forward(request, response);
		 }else if(u!=null ){
			System.out.println("loing ------userid"+u.getId());
			 request.getSession().setAttribute("Userinfo", u);
			 request.getRequestDispatcher("index.jsp").forward(request, response);
		 }
		 else{
			    request.setAttribute("error","用户名或密码不存在！！！");
				request.getRequestDispatcher("error.jsp").forward(request, response);
		 }
		 }
    	catch(Exception e){
			 
	}

	}
	    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	    }

}
