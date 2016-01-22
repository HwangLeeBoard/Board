package hjh.board.action;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import hjh.board.db.BoardDAO;
import hjh.board.db.BoardDTO;
import hjh.board.db.FIleDTO;
import hjh.board.db.FileDAO;
import hjh.command.controll.Action;
import hjh.command.controll.Forward;

public class BoardReply implements Action {

	@Override
	public Forward excute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		BoardDAO bDao = new BoardDAO();
		Forward forward = new Forward();
		int num = Integer.parseInt(request.getParameter("num"));

		// int page = Integer.parseInt(multi.getParameter("page"));
		int board_code = Integer.parseInt(request.getParameter("board_code"));
		// int categorys = Integer.parseInt(multi.getParameter("categorys"));
		String writer = request.getParameter("writer");
		String passwd = request.getParameter("passwd");
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String remote_addr = request.getRemoteAddr();
		String is_comment = "";
		String dateTime = "";
		String is_notice = "";
		int likecnt = 0;
		int badcnt = 0;
		String is_reply = "";
		String is_private = "";
		int fileCnt = 0;
		int hits = 0;
		int step = 0;
		int levels = 0;
		int seq = Integer.parseInt(request.getParameter("repRoot"));
		int member_seq = 0;
		int page = Integer.parseInt(request.getParameter("page"));
		BoardDTO bDto = new BoardDTO(0, board_code, 0, title, writer, passwd, email, content, remote_addr, dateTime,
				is_notice, likecnt, badcnt, is_comment, is_reply, is_private, seq, levels, step, fileCnt, hits,
				member_seq);
		bDao.insert(bDto);
		//request.setAttribute("BoardDto", bDto);
		forward.setPath("ReplyView.do?board_code=" + board_code + "&page=" + page + "&seq=" + seq);
		forward.setDispacher(false);
		return forward;
	}

}
