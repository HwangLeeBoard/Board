package hjh.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import hjh.board.db.BoardConfigDTO;
import kr.kr.kr.MakeConnection;

public class MemberDAO {

	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection con) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
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

	
	
	public PreparedStatement getSql(Connection con, PreparedStatement ps, String sql) throws SQLException {

		return MakeConnection.GetConnection().prepareStatement(sql);
	}
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public void join(MemberDTO mDto) {
		Connection con = null;
		PreparedStatement ps = null;
		MemberDTO dto = new MemberDTO();
		String sql = "INSERT INTO MEMBER ( IDX,EMAIL,PASSWD,NAME,GENDER,PNUM,IP )"
				+ "VALUES ( MEMBER_SEQ.nextval, ?, ?, ?,? , ?, ?)";
		try {
			con= MakeConnection.GetConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, mDto.getEmail());
			ps.setString(2, mDto.getPasswd());
			ps.setString(3, mDto.getName());
			ps.setString(4, mDto.getGender());
			ps.setString(5, mDto.getPnum());
			ps.setString(6, mDto.getIp());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, ps, con);
		}
	}

	public MemberDTO selById(String email) {
		MemberDTO memberDTO = new MemberDTO();
		String sql = "SELECT A.IDX," + "       A.EMAIL," + "       A.PASSWD," + "       A.NAME," + "       A.GENDER,"
				+ "       A.PNUM," + "       TO_CHAR(A.joindate,'yyyy-mm-dd') joindate,"
				+ "       TO_CHAR(A.LOGINTIME,'yyyy-mm-dd') LOGINTIME," + "       A.IP"
				+ "  FROM MEMBER A where email = ?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con= MakeConnection.GetConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();

			if (rs.next()) {
				int idx = rs.getInt("idx");
				String passwd = rs.getString("passwd");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String pnum = rs.getString("pnum");
				String joindate = rs.getString("joindate");
				String logintime = rs.getString("logintime");
				String ip = rs.getString("ip");
				memberDTO = new MemberDTO(idx, email, passwd, name, gender, pnum, joindate, logintime, ip);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, con);
		}
		return memberDTO;
	}

	public int loginChk(String email, String passwd) {
		int result = 0;
		MemberDTO chkDto = selById(email);
		

		if (chkDto.getEmail() != null) {

			if (chkDto.getEmail().equals(email) && chkDto.getPasswd().equals(passwd)) {
				result = 1; // �α��� ����
			} else if (chkDto.getEmail().equals(email) && !chkDto.getPasswd().equals(passwd)) {
				result = 2; // �н����尡 Ʋ���ϴ�.
			} else if (!chkDto.getEmail().equals(email)) {
				result = 0; // ȸ�������� ����ϴ�.
			}
		}
		return result;

	}

	public int idChk(String email) {
		
		int result = 0;
		MemberDTO chkDto = selById(email);
		

		if (chkDto.getEmail() != null) {
			if (chkDto.getEmail().equals(email)) {
				result = 1; // �ߺ����̵�
			}
		}
		return result;

	}
	
	public ArrayList<MemberDTO> list() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql = "SELECT A.IDX,"
				+ "       A.EMAIL,"
				+ "       A.PASSWD,"
				+ "       A.NAME,"
				+ "       A.GENDER,"
				+ "       A.PNUM,"
				+ "       to_char(A.JOINDATE,'yyyy-mm-dd') JOINDATE,"
				+ "       to_char(A.LOGINTIME,'yyyy-mm-dd') LOGINTIME,"
				+ "       A.IP"
				+ "  FROM MEMBER A";
		try {
			con= MakeConnection.GetConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int idx = rs.getInt("idx");
				String email = rs.getString("email");
				String passwd = rs.getString("passwd");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String pnum = rs.getString("pnum");
				String joindate = rs.getString("joindate");
				String logintime = rs.getString("logintime");
				String ip = rs.getString("ip");
				MemberDTO mDto = new MemberDTO(idx, email, passwd, name, gender, pnum, joindate, logintime, ip);
				list.add(mDto);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
}
