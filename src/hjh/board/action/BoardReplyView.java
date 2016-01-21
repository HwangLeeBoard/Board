package hjh.board.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hjh.board.db.BoardDAO;
import hjh.board.db.BoardDTO;
import hjh.board.db.CommentDAO;
import hjh.board.db.CommentDTO;
import hjh.board.db.FIleDTO;
import hjh.board.db.FileDAO;
import hjh.command.controll.Action;
import hjh.command.controll.Forward;

public class BoardReplyView implements Action {

	@Override
	public Forward excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardDAO bDao = new BoardDAO();
		BoardDTO bDto = new BoardDTO();
		Forward forward = new Forward();
		ArrayList<FIleDTO> list = new ArrayList<FIleDTO>();
		FileDAO fDao = new FileDAO();
		CommentDAO cDao = new CommentDAO();
		int num = Integer.parseInt(request.getParameter("idx"));
		ArrayList<CommentDTO> clist= cDao.getCommentList(num);
		System.out.println(clist);
		bDto = bDao.getDto(num);
		list = fDao.getFile(num);
		request.setAttribute("BoardDto", bDto);
		request.setAttribute("Filelist", list);
		request.setAttribute("clist", clist);
		forward.setDispacher(true);
		forward.setPath("reply.jsp");
		return forward;

	}

}
