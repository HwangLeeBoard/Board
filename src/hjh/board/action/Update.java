package hjh.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import hjh.board.db.BoardDAO;
import hjh.board.db.BoardDTO;
import hjh.command.controll.Action;
import hjh.command.controll.Forward;

public class Update implements Action {

	@Override
	public Forward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Forward forward = new Forward();
		BoardDAO bDao = new BoardDAO();
		BoardDTO bDto = new BoardDTO();
		String path = request.getRealPath("file1");
		int size = 1024 * 1024 * 10;

		MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy()

		);
		int idx=Integer.parseInt(multi.getParameter("idx"));
		int board_code = 0;
		int categorys = 0;
		String writer = multi.getParameter("writer");
		String passwd = "";
		String email = "";
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String remote_addr = request.getRemoteAddr();
		String is_comment = "";
		String dateTime = "";
		String is_notice = "N";
		int likecnt = 0;
		int badcnt = 0;
		String is_reply = "";
		String is_private = "";
		int fileCnt = 0;
		int hits = 0;
		int step = 0;
		int levels = 0;
		int seq = 0;
		int member_seq = 0;

		bDto = new BoardDTO(idx, 0, 0, title, writer, passwd, email, content, remote_addr, dateTime, is_notice,
				likecnt, badcnt, is_comment, is_reply, is_private, seq, levels, step, fileCnt, hits, member_seq);
		System.out.println(bDto);
		bDao.update(bDto);
		
		forward.setDispacher(false);
		forward.setPath("View.do?num="+idx);

		return forward;
	}

}
