package hjh.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.kr.kr.MakeConnection;

public class BoardDAO {

	public ArrayList<Integer> pageSpray(int nowPage, int board_code) {
		int endPage = endPage(nowPage, board_code);
		int startPage = startPage(nowPage);
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i = startPage; i <= endPage; i++) {
			array.add(i);
		}
		return array;
	}

	public ArrayList<BoardDTO> list2(int nowPage, int board_code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		int endIdx = nowPage * 10;
		int startIdx = endIdx - 9;

		ArrayList<BoardDTO> dto = new ArrayList<BoardDTO>();
		String sql = "SELECT A.IDX, " + "A.BOARD_CODE," + "    A.CATEGORYS," + "       A.TITLE," + "       A.WRITER,"
				+ "       A.PASSWD," + "       A.EMAIL," + "       A.CONTENT," + "       A.REMOTE_ADDR,"
				+ "       to_char(A.DATE_TIME,'yyyy-mm-dd') DATE_TIME, " + "       A.IS_NOTICE,"
				+ "       A.likecnt,A.badcnt," + "       A.IS_COMMENT," + "       A.IS_REPLY," + "       A.IS_PRIVATE,"
				+ "       A.SEQ," + "       A.LEVELS," + "       A.STEP," + "       A.FILECNT," + "       A.HITS,"
				+ "       A.MEMBER_SEQ  FROM BOARD A where A.board_code = ? order by A.seq desc, A.step asc ";
		System.out.println(sql);
		try {
			con = MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_code);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count++;
				if (count >= startIdx && count <= endIdx) {
					int idx = rs.getInt("idx");
					board_code = rs.getInt("board_code");
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
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, con);
		}
		return dto;
	}

	public int endPage(int nowPage, int board_code) { // return:������
														// ������������
														// input:����������
		final int BLOCK = 10; // �ؿ� ������ ǥ���
		int endPage = 0;
		if (pageCount(board_code) / BLOCK > (nowPage - 1) / BLOCK) {
			endPage = startPage(nowPage) - 1 + BLOCK;
		} else {
			endPage = (startPage(nowPage) + (pageCount(board_code) % BLOCK)) - 1;
		}
		return endPage;
	}

	public int startPage(int nowPage) { // return:���������� input:����������
										// ;;;board_code
		final int BLOCK = 10; // �ؿ� ������ ǥ���
		int startPage = 0;
		startPage = ((nowPage - 1) / BLOCK) * BLOCK + 1;
		return startPage;
	}

	public int pageCount(int board_code) { // ���� board_code�������� ���ð�����
											// �Ǵ��Ͽ� ��ȯ
		int count = 0;
		int i = 0;
		count = count(board_code);
		final int PAGE_NUM = 10; // ���������� ǥ�õǴ� ���� ��
		if (count % PAGE_NUM != 0) {
			i++;
		}
		count /= PAGE_NUM;
		count += i;

		return count;
	}

	public int count(int board_code) { // ��ȯ�� :board_code �� ���� ���� ��
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "SELECT count(idx) as count from board where board_code = ?";
		try {
			con = MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_code);
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

	public void reply(BoardDTO dto) {
		// TODO Auto-generated method stub
		increaseReplyStep(dto.getSeq(), dto.getStep());
		String sql = "insert into board (idx, title, writer, content, seq, step, levels, board_code, ";
		sql += "categorys, passwd, email, remote_addr )";
		sql += "values (idx_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getSeq());
			pstmt.setInt(5, dto.getStep() + 1);
			pstmt.setInt(6, dto.getLevels() + 1);
			pstmt.setInt(7, dto.getBoard_code());
			pstmt.setInt(8, dto.getCategorys());
			pstmt.setString(9, dto.getPasswd());
			pstmt.setString(10, dto.getEmail());
			pstmt.setString(11, dto.getRemote_addr());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, con);
		}
	}

	public void insert(BoardDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board (idx, board_code, categorys, writer, ";
		sql += "passwd, email, title, content, remote_addr, seq)";
		sql += " values( idx_seq.nextval , ?, ?, ?, ?, ?, ?, ?, ?,  idx_seq.currval)";
		try {
			con = MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBoard_code());
			pstmt.setInt(2, dto.getCategorys());
			pstmt.setString(3, dto.getWriter());
			pstmt.setString(4, dto.getPasswd());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getTitle());
			pstmt.setString(7, dto.getContent());
			pstmt.setString(8, dto.getRemote_addr());
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
			con = MakeConnection.GetConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				max = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, con);
		}

		return max;
	}

	public ArrayList<BoardDTO> list() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		ArrayList<BoardDTO> dto = new ArrayList<BoardDTO>();
		String sql = "SELECT A.IDX, " + "A.BOARD_CODE," + " A.CATEGORYS," + " A.TITLE," + " A.WRITER," + " A.PASSWD,"
				+ " A.EMAIL," + " A.CONTENT," + " A.REMOTE_ADDR," + " to_char(A.DATE_TIME,'yyyy-mm-dd') DATE_TIME, "
				+ " A.IS_NOTICE," + " A.likecnt,A.badcnt," + " A.IS_COMMENT," + " A.IS_REPLY," + " A.IS_PRIVATE,"
				+ " A.SEQ," + " A.LEVELS," + " A.STEP," + " A.FILECNT," + " A.HITS,"
				+ " A.MEMBER_SEQ  FROM BOARD A order by A.seq desc, A.step asc";
		try {
			con = MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (count >= 10) {
					break;
				}
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
				count++;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, con);
		}
		return dto;
	}

	public ArrayList<BoardDTO> list3() {
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
			con = MakeConnection.GetConnection();
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
				String dateTime = rs.getString("to_char(date_time,'yyyy-mm-dd')");
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
			con = MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			closeAll(null, pstmt, con);
		}
	}
	
	public void isLike(int idx, String like) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql="";
		if (like.equals("Y")) {
			sql = "update board set likecnt = likecnt+1 where idx = " + idx;
		}else if (like.equals("N")) {
			sql = "update board set badcnt = badcnt+1 where idx = " + idx;
		}
		
		try {
			con = MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			closeAll(null, pstmt, con);
		}
	}
	

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

	public void increaseReplyStep(int seq, int step) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update board set step = step + 1 where seq = ? and step > ? ";
		try {
			con = MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.setInt(2, step);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, con);
		}

	}

	public void increaseReadCnt(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update board set hits = hits + 1 where idx = ?";
		try {
			con = MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, con);
		}

	}

	public BoardDTO getDto(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO dto = new BoardDTO();
		String sql = "SELECT A.IDX, " + "A.BOARD_CODE," + "    A.CATEGORYS," + "       A.TITLE," + "       A.WRITER,"
				+ "       A.PASSWD," + "       A.EMAIL," + "       A.CONTENT," + "       A.REMOTE_ADDR,"
				+ "       to_char(A.DATE_TIME,'yyyy-mm-dd') DATE_TIME, " + "       A.IS_NOTICE,"
				+ "       A.likecnt,A.badcnt," + "       A.IS_COMMENT," + "       A.IS_REPLY," + "       A.IS_PRIVATE,"
				+ "       A.SEQ," + "       A.LEVELS," + "       A.STEP," + "       A.FILECNT," + "       A.HITS,"
				+ "       A.MEMBER_SEQ  FROM BOARD A " + "where idx= ? " + " order by A.seq desc, A.step asc";
		try {
			con = MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			while (rs.next()) {
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
				dto = new BoardDTO(idx, board_code, categorys, title, writer, passwd, email, content, remote_addr,
						dateTime, is_notice, likecnt, badcnt, is_comment, is_reply, is_private, seq, levels, step,
						fileCnt, hits, member_seq);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, con);
		}
		return dto;
	}

	public void update(BoardDTO bDto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD set "
				+ "TITLE = ?, "
				+ "WRITER = ?, "
				+ "CONTENT = ?, "
				+ "REMOTE_ADDR = ?, "
				+ "IS_NOTICE = ? "
				+ "WHERE idx=?";
		
		try {
			con = MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getWriter());
			pstmt.setString(3, bDto.getContent());
			pstmt.setString(4, bDto.getRemote_addr());
			pstmt.setString(5, bDto.getIs_notice());
			pstmt.setInt(6, bDto.getIdx());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, con);
		}
		
	}

}