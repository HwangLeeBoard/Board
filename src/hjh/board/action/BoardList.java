package hjh.board.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;
import org.apache.tomcat.util.net.SecureNioChannel.ApplicationBufferHandler;

import hjh.board.db.BoardDAO;
import hjh.board.db.BoardDTO;
import hjh.command.controll.Action;
import hjh.command.controll.Forward;

public class BoardList implements Action {

	@Override
	public Forward excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<BoardDTO> list = new ArrayList<>();
		Forward forward = new Forward();
		ArrayList<Integer> sprayPage = new ArrayList<Integer>();
		BoardDAO dao = new BoardDAO();
		ServletContext context = request.getSession().getServletContext();
		int nowPage = 1;
		int board_code=0;
		if(request.getParameter("board_code")==null){
			if(context.getAttribute("board_code")==null){
				response.sendRedirect("index.jsp");
			}else{
				board_code= Integer.parseInt(context.getAttribute("board_code").toString());
			}
			
		}else{
		board_code=Integer.parseInt(request.getParameter("board_code"));	
		}
		context.setAttribute("board_code", board_code);
		int pageCount=dao.pageCount(board_code);
		if (request.getParameter("page") == null) {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(request.getParameter("page"));
		}
		
		list = dao.list2(nowPage,board_code);
		sprayPage = dao.pageSpray(nowPage,board_code);
//		if (null!=request.getParameter("board_code")) {
//			board_code=Integer.parseInt(request.getParameter("board_code"));			
//		}
		
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("sprayPage", sprayPage);
		request.setAttribute("listDTO", list);
		request.setAttribute("page", nowPage);
	
//		 .setAttribute("board_code",board_code );
		forward.setDispacher(true);
		forward.setPath("list.jsp");
		return forward;

	}

}
