package hjh.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hjh.board.db.BoardConfigDAO;
import hjh.board.db.BoardConfigDTO;
import hjh.command.controll.Action;
import hjh.command.controll.Forward;

public class BoardWrite implements Action {

	@Override
	public Forward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Forward forward = new Forward();
		BoardConfigDAO bConfigDAO = new BoardConfigDAO();
		BoardConfigDTO bConfigDTO = new BoardConfigDTO();
		String board_code = request.getParameter("board_code");
		bConfigDTO=bConfigDAO.getDTO(board_code);
		
		request.setAttribute("bConfigDTO", bConfigDTO);
		
		forward.setPath("write.jsp");
		forward.setDispacher(true);
		return forward;
	}

}
