package hjh.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;

import hjh.board.db.BoardDAO;
import hjh.command.controll.Action;
import hjh.command.controll.Forward;

public class IsLike implements Action {

	@Override
	public Forward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Forward forward= new Forward();
		BoardDAO bDAO = new BoardDAO();
		
		String like=request.getParameter("like");
		int idx = Integer.parseInt(request.getParameter("idx"));
		bDAO.isLike(idx,like);
		System.out.println(like);
		forward.setDispacher(false);
		forward.setPath("View.do?num="+idx);
		return forward;
	}

}
