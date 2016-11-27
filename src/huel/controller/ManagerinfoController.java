package huel.controller;

import huel.bean.Managerinfo;
import huel.dao.ManagerDAO;

import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ManagerinfoController")
public class ManagerinfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ManagerDAO um;
    
    public ManagerinfoController() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String command=request.getParameter("action");
		int com=0;
		if(command.equals("login")) com=0;
		else if(command.equals("logout")) com=1;
		switch(com)
		{
		case 0:login(request,response);break;
		case 1:logout(request,response);break;
		
		}
	}


	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		String username=new String(request.getParameter("Staff_Name").getBytes("ISO-8859-1"),"UTF-8");
		String password=request.getParameter("Staff_Password");
		//String info="";
		try{
			HttpSession session=request.getSession();
		  Managerinfo m;					 
		  ManagerDAO md=new ManagerDAO();
		  m=md.query(username,password);
	if(m!=null ){
		for(int i=0;i<m.getStaff_Name().length();i++){
		    if(m.getStaff_Name().equals(username)&&m.getStaff_Password().equals(password)){
			    response.setContentType("text/html;charset=utf-8");
				session.setAttribute("Staff_Name",username);
				session.setAttribute("Staff_Password",password);
				PrintWriter out=response.getWriter();
				out.println("<html>");
				out.println("<body>");
				out.println("<script type='text/javascript'> alert('登陆成功！');window.location.href='mainH.jsp';</script>");
				out.println("</body>");
				out.println("</html>");
				out.close();
				//info="登陆成功";
				}	
		     else {
		    	    response.setContentType("text/html;charset=utf-8");
					session.setAttribute("Staff_Name",username);
					session.setAttribute("Staff_Password",password);
					PrintWriter out=response.getWriter();
					out.println("<html>");
					out.println("<body>");
					out.println("<script type='text/javascript'> alert('登陆失败！');window.location.href='Managerlogin.jsp';</script>");
					out.println("</body>");
					out.println("</html>");
					out.close();}
		 } 
		
	     }        
	           // request.setAttribute("error","用户名或密码不存在！！！");
	            //request.getRequestDispatcher("error.jsp").forward(request, response);
		}catch(Exception e){
		     
     }
}
	    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    	request.getRequestDispatcher("login.jsp").forward(request, response);
	    }


		public ManagerDAO getUm() {
			return um;
		}


		public void setUm(ManagerDAO um) {
			this.um = um;
		}

}
