package huel.tool;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;


@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        String  requestip=request.getRemoteAddr();
		
		String saveDirectory="d:\\tools\\upload";
		
		File savedir=new File(saveDirectory);
		if(!savedir.exists()){
			savedir.mkdirs();
		}
		int maxPostSize=10*1024*1024;
	
		FileRenamePolicy policy=(FileRenamePolicy)new DefaultFileRenamePolicy();
		MultipartRequest multi;
		multi=new MultipartRequest(request,saveDirectory,maxPostSize,"utf-8",policy);
		
		Enumeration<String> files=multi.getFileNames();
		String name=files.nextElement();
		File f=multi.getFile(name);
		
		if(f!=null){
			String fileName=f.getName();
		
			File sServerFile=new File(saveDirectory+"\\"+requestip+"-"+fileName);
			
			if(sServerFile.exists()){//先将先前上传的文件删掉
				sServerFile.delete();
			}
			f.renameTo(sServerFile);
			String message="文件上传成功！文件名为："+requestip+"-"+fileName;
			request.setAttribute("message", message);
			
			
			
		}
		request.getRequestDispatcher("/F_s.jsp").forward(request, response);
		
	}

}
