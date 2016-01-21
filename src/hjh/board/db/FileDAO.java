package hjh.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.kr.kr.MakeConnection;

public class FileDAO {
	

	public int insert(FIleDTO fDto) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "insert into fileattach(idx, board_idx,filename,filesize )"
		+ "values(file_seq.nextval, ? ,?,?  )";
		int result = 0;
		try {
			con = MakeConnection.GetConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, fDto.getBoard_idx());
			ps.setString(2, fDto.getFilename());
			ps.setInt(3, fDto.getFilesize());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, ps, con);
		}

		return result;

	}
	
	public ArrayList<FIleDTO> getFile(int num) {
		ArrayList<FIleDTO> list = new ArrayList<>();



		String sql = " select * from fileattach where board_idx=?";

		Connection con = null;
		PreparedStatement ps = null;
		
		ResultSet rs = null;

		
		try {
			con = MakeConnection.GetConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int board_idx = rs.getInt("board_idx");
				String filename = rs.getString("filename");
				int filesize = rs.getInt("filesize");
			
				FIleDTO fDto = new FIleDTO(num, board_idx, filename, filesize);
				
				list.add(fDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, con);
		}
		return list;
	}
	
	

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
}
