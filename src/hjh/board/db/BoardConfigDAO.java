package hjh.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.kr.kr.MakeConnection;

public class BoardConfigDAO {
	

	public int count(int num) { 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "SELECT count(idx) as count from board_config where boardnum = ?";
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

	
	public void insert(BoardConfigDTO dto) {
		//int max=curIdx();
		Connection con = null;
		PreparedStatement pstmt = null;
		System.out.println(dto);
		String sql = "INSERT INTO BOARD_CONFIG ("
				+ "IDX, "
				+ "BOARD_CODE, "
				+ "BOARD_NAME, "
				+ "BAORD_TYPE, "
				+ "URL, "
				+ "EDITER, "
				+ "IS_FILE, "
				+ "FILE_CNT, "
				+ "IS_READONLY, "
				+ "IS_VIEWCNT, "
				+ "IS_LOCK, "
				+ "IS_NOTICE )"
				+" VALUES ( board_config_seq.nextval , ?,?,  ?, ?,? ,? ,? , ?, ?,? , ? )";
		try {
			con= MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,dto.getBoard_code() );
			pstmt.setString(2,dto.getBoard_name() );
			pstmt.setString(3, dto.getBaord_type());
			pstmt.setString(4, dto.getUrl());
			pstmt.setInt(5, dto.getEditer());
			pstmt.setString(6, dto.getIs_file());
			pstmt.setInt(7, dto.getFile_cnt());
			pstmt.setString(8, dto.getIs_readonly());
			pstmt.setString(9, dto.getIs_viewcnt());
			pstmt.setString(10, dto.getIs_lock());
			pstmt.setString(11, dto.getIs_notice());
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
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int max = 0;
		String sql = "SELECT  max(idx) FROM board_config";
		try {
			con= MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				max = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, con);
		}

		return max;
	}

	public ArrayList<BoardConfigDTO> list() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardConfigDTO> list = new ArrayList<BoardConfigDTO>();
		String sql = "SELECT A.IDX,"
				+ "       A.BOARD_NAME,"
				+ "       A.BOARD_CODE,"
				+ "       A.BAORD_TYPE,"
				+ "       A.URL,"
				+ "       A.IS_DELETE,"
				+ "       to_char(A.CREATE_TIME,'yyyy-mm-dd') CREATE_TIME,"
				+ "       to_char(A.UPDATE_TIME,'yyyy-mm-dd') UPDATE_TIME,"
				+ "       A.IS_OPEN,"
				+ "       A.IS_REPLY,"
				+ "       A.IS_COMMENT,"
				+ "       A.EDITER,"
				+ "       A.IS_FILE,"
				+ "       A.FILE_CNT,"
				+ "       A.IS_READONLY,"
				+ "       A.IS_VIEWCNT,"
				+ "       A.IS_LOCK,"
				+ "       A.IS_NOTICE"
				+ "  FROM BOARD_CONFIG A";
		try {
			con= MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int idx = rs.getInt("idx");
				String board_name = rs.getString("board_name");
				String board_code =  rs.getString("board_code");
				String baord_type = rs.getString("baord_type");
				String url =  rs.getString("url");
				String is_delete =  rs.getString("is_delete");
				String create_time =  rs.getString("create_time");
				String update_time = rs.getString("update_time");
				String is_open =  rs.getString("is_open");
				String is_reply =  rs.getString("is_reply");
				String is_comment =  rs.getString("is_comment");
				int editer =  rs.getInt("editer");
				String is_file = rs.getString("is_file");
				int file_cnt = rs.getInt("file_cnt");
				String is_readonly = rs.getString("is_readonly");
				String is_viewcnt =  rs.getString("is_viewcnt");
				String is_lock = rs.getString("is_lock");
				String is_notice = rs.getString("is_notice");
				BoardConfigDTO dto = new BoardConfigDTO(idx, board_name, board_code, baord_type, url, is_delete, create_time, update_time, is_open, is_reply, is_comment, editer, is_file, file_cnt, is_readonly, is_viewcnt, is_lock, is_notice);
				list.add(dto);
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	public BoardConfigDTO getDTO(String board_code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardConfigDTO dto = new BoardConfigDTO();
		String sql = "SELECT A.IDX,"
				+ "       A.BOARD_NAME,"
				+ "       A.BOARD_CODE,"
				+ "       A.BAORD_TYPE,"
				+ "       A.URL,"
				+ "       A.IS_DELETE,"
				+ "       to_char(A.CREATE_TIME,'yyyy-mm-dd') CREATE_TIME,"
				+ "       to_char(A.UPDATE_TIME,'yyyy-mm-dd') UPDATE_TIME,"
				+ "       A.IS_OPEN,"
				+ "       A.IS_REPLY,"
				+ "       A.IS_COMMENT,"
				+ "       A.EDITER,"
				+ "       A.IS_FILE,"
				+ "       A.FILE_CNT,"
				+ "       A.IS_READONLY,"
				+ "       A.IS_VIEWCNT,"
				+ "       A.IS_LOCK,"
				+ "       A.IS_NOTICE"
				+ "  FROM BOARD_CONFIG A where board_code="+board_code ;
		try {
			con= MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int idx = rs.getInt("idx");
				String board_name = rs.getString("board_name");
				String baord_type = rs.getString("baord_type");
				String url =  rs.getString("url");
				String is_delete =  rs.getString("is_delete");
				String create_time =  rs.getString("create_time");
				String update_time = rs.getString("update_time");
				String is_open =  rs.getString("is_open");
				String is_reply =  rs.getString("is_reply");
				String is_comment =  rs.getString("is_comment");
				int editer =  rs.getInt("editer");
				String is_file = rs.getString("is_file");
				int file_cnt = rs.getInt("file_cnt");
				String is_readonly = rs.getString("is_readonly");
				String is_viewcnt =  rs.getString("is_viewcnt");
				String is_lock = rs.getString("is_lock");
				String is_notice = rs.getString("is_notice");
				dto = new BoardConfigDTO(idx, board_name, board_code, baord_type, url, is_delete, create_time, update_time, is_open, is_reply, is_comment, editer, is_file, file_cnt, is_readonly, is_viewcnt, is_lock, is_notice);
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
				+ "from board_config where boardnum=?";

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
