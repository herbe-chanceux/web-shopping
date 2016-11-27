package huel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logcheck")
public class Logcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Logcheck() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String usercheckcode=request.getParameter("checkcode");
		String info="";
		HttpSession session=request.getSession();
		String servercheckcode=(String)session.getAttribute("checkCode");
		if(!servercheckcode.equalsIgnoreCase(usercheckcode)){
			info="验证码不正确，请重新输入";
		}else if("张三".equals(username)&&"123".equals(password)){
			info="登陆成功";
		}else{
			info="用户名或密码不正确";
		}
		request.setAttribute("info", info);
		RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

}
