package hjh.board.db;

public class BoardConfigDTO {
	private int idx;	
	private String board_name;
	private String board_code;
	private String baord_type;
	private String url;
	private String is_delete;
	private String create_time;
	private String update_time;
	private String is_open;
	private String is_reply;
	private String is_comment;
	private int editer;
	private String is_file;
	private int file_cnt;
	private String is_readonly;
	private String is_viewcnt;
	private String is_lock;
	private String is_notice;
	public BoardConfigDTO() {
		// TODO Auto-generated constructor stub
	}
	public BoardConfigDTO(int idx, String board_name, String board_code, String baord_type, String url,
			String is_delete, String create_time, String update_time, String is_open, String is_reply,
			String is_comment, int editer, String is_file, int file_cnt, String is_readonly, String is_viewcnt,
			String is_lock, String is_notice) {
		super();
		this.idx = idx;
		this.board_name = board_name;
		this.board_code = board_code;
		this.baord_type = baord_type;
		this.url = url;
		this.is_delete = is_delete;
		this.create_time = create_time;
		this.update_time = update_time;
		this.is_open = is_open;
		this.is_reply = is_reply;
		this.is_comment = is_comment;
		this.editer = editer;
		this.is_file = is_file;
		this.file_cnt = file_cnt;
		this.is_readonly = is_readonly;
		this.is_viewcnt = is_viewcnt;
		this.is_lock = is_lock;
		this.is_notice = is_notice;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_code() {
		return board_code;
	}
	public void setBoard_code(String board_code) {
		this.board_code = board_code;
	}
	public String getBaord_type() {
		return baord_type;
	}
	public void setBaord_type(String baord_type) {
		this.baord_type = baord_type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(String is_delete) {
		this.is_delete = is_delete;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public String getIs_open() {
		return is_open;
	}
	public void setIs_open(String is_open) {
		this.is_open = is_open;
	}
	public String getIs_reply() {
		return is_reply;
	}
	public void setIs_reply(String is_reply) {
		this.is_reply = is_reply;
	}
	public String getIs_comment() {
		return is_comment;
	}
	public void setIs_comment(String is_comment) {
		this.is_comment = is_comment;
	}
	public int getEditer() {
		return editer;
	}
	public void setEditer(int editer) {
		this.editer = editer;
	}
	public String getIs_file() {
		return is_file;
	}
	public void setIs_file(String is_file) {
		this.is_file = is_file;
	}
	public int getFile_cnt() {
		return file_cnt;
	}
	public void setFile_cnt(int file_cnt) {
		this.file_cnt = file_cnt;
	}
	public String getIs_readonly() {
		return is_readonly;
	}
	public void setIs_readonly(String is_readonly) {
		this.is_readonly = is_readonly;
	}
	public String getIs_viewcnt() {
		return is_viewcnt;
	}
	public void setIs_viewcnt(String is_viewcnt) {
		this.is_viewcnt = is_viewcnt;
	}
	public String getIs_lock() {
		return is_lock;
	}
	public void setIs_lock(String is_lock) {
		this.is_lock = is_lock;
	}
	public String getIs_notice() {
		return is_notice;
	}
	public void setIs_notice(String is_notice) {
		this.is_notice = is_notice;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idx;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardConfigDTO other = (BoardConfigDTO) obj;
		if (idx != other.idx)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BoardConfigDTO [idx=" + idx + ", board_name=" + board_name + ", board_code=" + board_code
				+ ", baord_type=" + baord_type + ", url=" + url + ", is_delete=" + is_delete + ", create_time="
				+ create_time + ", update_time=" + update_time + ", is_open=" + is_open + ", is_reply=" + is_reply
				+ ", is_comment=" + is_comment + ", editer=" + editer + ", is_file=" + is_file + ", file_cnt="
				+ file_cnt + ", is_readonly=" + is_readonly + ", is_viewcnt=" + is_viewcnt + ", is_lock=" + is_lock
				+ ", is_notice=" + is_notice + "]";
	}
	
	

}
