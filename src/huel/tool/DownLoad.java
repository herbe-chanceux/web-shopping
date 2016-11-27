package huel.tool;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.ServletUtils;


@WebServlet("/downLoad")
public class DownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String filepath="d:/";    //下载路径
		//String filename="1.png";  
		String filepath=this.getServletContext().getRealPath("/")+"source/";
		
		String filename=request.getParameter("filename");//获取下载的文件名
		filename=new String(filename.getBytes("ISO8859-1"),"UTF-8");
		String guessCharset="gbk";
		try { //使用iso8559_1编码方式
		    String isofilename = new String(filename.getBytes(guessCharset),"iso-8859-1");
		    response.setContentType("application/octet-stream");
		    response.setHeader("Content-Disposition","attachment; filename=" + isofilename);
		    ServletOutputStream out = null;
		    out = response.getOutputStream();
		    ServletUtils.returnFile(filepath+filename,out);   //下载文件
		}catch (UnsupportedEncodingException ex) {    //iso8559_1编码异常
		      ex.printStackTrace();
		}catch(IOException e){      //getOutputStream()异常
		     e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
