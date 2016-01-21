package hjh.command.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hjh.board.db.BoardConfigDAO;
import hjh.board.db.BoardConfigDTO;

public class BoardConfigInsert implements Action {

	@Override
	public Forward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Forward forward = new Forward();
		BoardConfigDTO bcDTO = new BoardConfigDTO();
		BoardConfigDAO bcDAO = new BoardConfigDAO();
		int idx =0;	
		String board_name = request.getParameter("board_name");
		String board_code =  null;
		String baord_type = null;
		String url =  null;
		String is_delete =  null;
		String create_time =  null;
		String update_time =  null;
		String is_open =  null;
		String is_reply =  request.getParameter("is_reply");
		String is_comment =  null;
		int editer =  0;
		String is_file =  request.getParameter("is_file");
		int file_cnt = Integer.parseInt(request.getParameter("file_cnt"));
		String is_readonly =  request.getParameter("is_readonly");
		String is_viewcnt =  request.getParameter("is_viewcnt");
		String is_lock =  request.getParameter("is_lock");
		String is_notice = request.getParameter("is_notice");
		bcDTO = new BoardConfigDTO(idx, board_name, board_code, baord_type, url, is_delete, create_time, update_time, is_open, is_reply, is_comment, editer, is_file, file_cnt, is_readonly, is_viewcnt, is_lock, is_notice);

		bcDAO.insert(bcDTO);
		forward.setDispacher(false);
		forward.setPath("./admin/index.jsp");
		
		return forward;
	}

}
