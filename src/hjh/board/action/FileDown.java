package hjh.board.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import hjh.command.controll.Action;
import hjh.command.controll.Forward;

public class FileDown implements Action {

	@Override
	public Forward excute(HttpServletRequest request, HttpServletResponse response) throws IOException{

	
	String filename = request.getParameter("filename");
	//filename="Chrysanthemum.jpg";
	String origin = request.getParameter("origin");
	//PrintWriter out = response.getWriter();
	
	String upload = "file1";
	String path = request.getServletContext().getRealPath(upload);
	String filepath = path+"\\"+filename;
	
	File file = new File(filepath);
	System.out.println(filepath);
	System.out.println(file);
	byte[] b = new byte[1024*4];
	String mType=request.getServletContext().getMimeType(filepath);
	System.out.println(mType);
	if (mType==null) {
		mType="application/cotet-stream";
	}
	
	response.setContentType(mType);
	String Encoding= new String(filename.getBytes("UTF-8"),"8859_1");
	response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
	
	ServletOutputStream outputStream = null;
	FileInputStream fileIn = null;
	
	try {
		outputStream=response.getOutputStream();
		fileIn= new FileInputStream(file);
		int numRead =-1;
		
		while (true) {
			numRead=fileIn.read(b,0,b.length);
			if (numRead==-1) {
				break;
			}
			outputStream.write(b,0,numRead);
		}
		System.out.println(numRead);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		if (outputStream!=null) {
			outputStream.flush();
			outputStream.close();
		}
		if (fileIn!=null) {
			fileIn.close();
		}
	}
		return null;
	}
	

}
