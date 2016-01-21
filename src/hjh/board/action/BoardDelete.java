package hjh.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hjh.board.db.BoardDAO;
import hjh.command.controll.Action;
import hjh.command.controll.Forward;

public class BoardDelete implements Action {

	@Override
	public Forward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Forward forward = new Forward();
		BoardDAO bDao = new BoardDAO();
		int idx= Integer.parseInt(request.getParameter("idx"));
		int board_code= Integer.parseInt(request.getParameter("board_code"));
		bDao.delete(idx);
		forward.setDispacher(false);
		forward.setPath("List.do?board_code="+board_code);
		return forward;
	}

}
