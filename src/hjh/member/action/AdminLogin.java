package hjh.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hjh.command.controll.Action;
import hjh.command.controll.Forward;
import hjh.member.db.MemberDTO;

public class AdminLogin implements Action {

	@Override
	public Forward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Forward forward = new Forward();
		HttpSession sess = request.getSession();
		PrintWriter out = response.getWriter();
		
		
		
		if (sess.getAttribute("mem") == null) {
			out.println("<script>alert('나가라');location.href='index.jsp';</script>");
			return null;
		} else {
			MemberDTO mDto = (MemberDTO) sess.getAttribute("mem");
			if (mDto.getEmail().equals("123")) {
				forward = new Forward();
				forward.setDispacher(true);
				forward.setPath("/admin/index.jsp");
			}
			
		}
		return forward;

	}

}
