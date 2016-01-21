package hjh.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.kr.kr.MakeConnection;

public class CommentDAO {
	

	public int count(int num) { 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "SELECT count(idx) as count from board_comment where boardnum = ?";
		try {
			con= MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, con);
		}
		return count;
	}

	
	public void insert(CommentDTO dto) {
		int max=curIdx();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board_comment ("
				+ "NUM ,"
				+ "WRITER, "
				+ "CONTENT, "				
				+ "BOARDNUM, "
				+ "IP)";
		sql += " values( board_comment_seq.nextval , ?, ?, ?,?)";

		try {
			con= MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getBoardnum());
			pstmt.setString(4, dto.getIp());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, con);
		}

	}
	


	public int curIdx() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int max = 0;
		String sql = "SELECT  max(idx) FROM board";
		try {
			con= MakeConnection.GetConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				max = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(rs, ps, con);
		}

		return max;
	}

	public ArrayList<BoardDTO> list() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardDTO> dto = new ArrayList<BoardDTO>();
		String sql = "SELECT A.IDX, " + "A.BOARD_CODE," + "    A.CATEGORYS," + "       A.TITLE," + "       A.WRITER,"
				+ "       A.PASSWD," + "       A.EMAIL," + "       A.CONTENT," + "       A.REMOTE_ADDR,"
				+ "       to_char(A.DATE_TIME,'yyyy-mm-dd') DATE_TIME, " + "       A.IS_NOTICE,"
				+ "       A.likecnt,A.badcnt," + "       A.IS_COMMENT," + "       A.IS_REPLY," + "       A.IS_PRIVATE,"
				+ "       A.SEQ," + "       A.LEVELS," + "       A.STEP," + "       A.FILECNT," + "       A.HITS,"
				+ "       A.MEMBER_SEQ  FROM BOARD A order by A.seq desc, A.step asc";
		try {
			con= MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int idx = rs.getInt("idx");
				int board_code = rs.getInt("board_code");
				int categorys = rs.getInt("categorys");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String passwd = rs.getString("passwd");
				String email = rs.getString("email");
				String content = rs.getString("content");
				String remote_addr = rs.getString("remote_addr");
				String dateTime = rs.getString("date_Time");
				String is_notice = rs.getString("is_notice");
				int likecnt = rs.getInt("likecnt");
				int badcnt = rs.getInt("badcnt");
				String is_comment = rs.getString("is_comment");
				String is_reply = rs.getString("is_reply");
				String is_private = rs.getString("is_private");
				int seq = rs.getInt("seq");
				int levels = rs.getInt("levels");
				int step = rs.getInt("step");
				int fileCnt = rs.getInt("fileCnt");
				int hits = rs.getInt("hits");
				int member_seq = rs.getInt("member_seq");
				dto.add(new BoardDTO(idx, board_code, categorys, title, writer, passwd, email, content, remote_addr,
						dateTime, is_notice, likecnt, badcnt, is_comment, is_reply, is_private, seq, levels, step,
						fileCnt, hits, member_seq));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, con);
		}
		return dto;
	}

	

	public PreparedStatement getCon(Connection con, PreparedStatement ps, String sql) throws SQLException {
		con = MakeConnection.GetConnection();
		ps = con.prepareStatement(sql);
		return ps;
	}

	public void delete(int selectNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete board where idx = " + selectNum;
		try {
			con= MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		
		closeAll(null, pstmt, con);
	}}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	

	public ArrayList<CommentDTO> getCommentList(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommentDTO> cList = new ArrayList<>();
		String sql = "SELECT NUM, "
				+ "WRITER, "
				+ "CONTENT, "
				+ "to_char(WRITEDATE,'yyyy-MM-DD') WRITEDATE, "
				+ "to_char(UPDATEDATE,'yyyy-MM-DD') UPDATEDATE,  "
				+ "IS_DELETE, "
				+ "REPROOT, "
				+ "REPSTEP,"
				+ "REPINDENT, "
				+ "BOARDNUM, "
				+ "IP "				
				+ "from board_comment where boardnum=?";

		try {
			con= MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String writer=rs.getString("writer");
				String content=rs.getString("content");
				String writedate=rs.getString("writedate");
				String updatedate=rs.getString("updatedate");
				String is_delete=rs.getString("is_delete");
				int reproot=rs.getInt("reproot");
				int repstep=rs.getInt("repstep");
				int repindent=rs.getInt("REPINDENT");
				int boardnum=rs.getInt("boardnum");
				String ip = rs.getString("ip");
				CommentDTO cDto = new CommentDTO(idx, writer, content, writedate, updatedate, is_delete, reproot, repstep, repindent, boardnum, ip);
				cList.add(cDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, con);
		}
		return cList;
	}
}
