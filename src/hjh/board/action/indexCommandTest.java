package hjh.board.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hjh.board.db.BoardDAO;
import hjh.board.db.BoardDTO;
import hjh.command.controll.Action;
import hjh.command.controll.Forward;

public class indexCommandTest implements Action {
	@Override
	public Forward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<BoardDTO> list = new ArrayList<>();
		Forward forward = new Forward();
		BoardDAO dao = new BoardDAO();
		list = dao.list();
		request.setAttribute("indexlistDTO", list);
		forward.setDispacher(true);
		forward.setPath("list.jsp");
		return forward;

	}

}
