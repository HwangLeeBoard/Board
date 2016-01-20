package hjh.board.action;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import hjh.board.db.BoardDAO;
import hjh.board.db.BoardDTO;
import hjh.board.db.CommentDAO;
import hjh.board.db.CommentDTO;
import hjh.board.db.FIleDTO;
import hjh.board.db.FileDAO;
import hjh.command.controll.Action;
import hjh.command.controll.Forward;


public class CommentInsert implements Action {

	@Override
	public Forward excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int num=0;
		String writer=request.getParameter("cWriter");
		String content=request.getParameter("cContent");
		String writedate="";
		String updatedate="";
		String is_delete="";
		int reproot=0;
		int repstep=0;
		int repindent=0;
		int boardnum=Integer.parseInt(request.getParameter("num"));
		String ip = request.getRemoteAddr();
		CommentDTO cDto = new CommentDTO(num, writer, content, writedate, updatedate, is_delete, reproot, repstep, repindent, boardnum, ip);
		CommentDAO cDao = new CommentDAO();
		Forward forward = new Forward();
		cDao.insert(cDto);
		forward.setDispacher(false);
		forward.setPath("View.do?num="+boardnum);
		return forward;

	}

}
