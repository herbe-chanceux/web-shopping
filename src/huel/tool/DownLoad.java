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
		//String filepath="d:/";    //����·��
		//String filename="1.png";  
		String filepath=this.getServletContext().getRealPath("/")+"source/";
		
		String filename=request.getParameter("filename");//��ȡ���ص��ļ���
		filename=new String(filename.getBytes("ISO8859-1"),"UTF-8");
		String guessCharset="gbk";
		try { //ʹ��iso8559_1���뷽ʽ
		    String isofilename = new String(filename.getBytes(guessCharset),"iso-8859-1");
		    response.setContentType("application/octet-stream");
		    response.setHeader("Content-Disposition","attachment; filename=" + isofilename);
		    ServletOutputStream out = null;
		    out = response.getOutputStream();
		    ServletUtils.returnFile(filepath+filename,out);   //�����ļ�
		}catch (UnsupportedEncodingException ex) {    //iso8559_1�����쳣
		      ex.printStackTrace();
		}catch(IOException e){      //getOutputStream()�쳣
		     e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
