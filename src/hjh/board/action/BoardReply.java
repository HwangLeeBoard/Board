package hjh.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hjh.board.db.BoardDAO;
import hjh.board.db.BoardDTO;
import hjh.command.controll.Action;
import hjh.command.controll.Forward;

public class BoardReply implements Action {

	@Override
	public Forward excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		BoardDAO bDao = new BoardDAO();
		BoardDTO bDto = new BoardDTO();
		Forward forward = new Forward();
		int num= Integer.parseInt(request.getParameter("num"));
		bDto = bDao.getDto(num);
		request.setAttribute("BoardDto", bDto);
		
		forward.setDispacher(true);
		forward.setPath("reply.jsp");
		RequestDispatcher dis= request.getRequestDispatcher("reply.jsp");
		dis.forward(request, response);
		return forward;
	}

}
