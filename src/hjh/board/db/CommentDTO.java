package hjh.board.db;

public class CommentDTO {
	private int num;
	private String writer;
	private String content;
	private String writedate;
	private String updatedate;
	private String is_delete;
	private int reproot;
	private int repstep;
	private int repindent;
	private int boardnum;
	private String ip;
	
	public CommentDTO() {
		// TODO Auto-generated constructor stub
	}

	public CommentDTO(int num, String writer, String content, String writedate, String updatedate, String is_delete,
			int reproot, int repstep, int repindent, int boardnum, String ip) {
		super();
		this.num = num;
		this.writer = writer;
		this.content = content;
		this.writedate = writedate;
		this.updatedate = updatedate;
		this.is_delete = is_delete;
		this.reproot = reproot;
		this.repstep = repstep;
		this.repindent = repindent;
		this.boardnum = boardnum;
		this.ip = ip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
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
		CommentDTO other = (CommentDTO) obj;
		if (num != other.num)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommentDTO [num=" + num + ", writer=" + writer + ", content=" + content + ", writedate=" + writedate
				+ ", updatedate=" + updatedate + ", is_delete=" + is_delete + ", reproot=" + reproot + ", repstep="
				+ repstep + ", repindent=" + repindent + ", boardnum=" + boardnum + ", ip=" + ip + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public String getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(String is_delete) {
		this.is_delete = is_delete;
	}

	public int getReproot() {
		return reproot;
	}

	public void setReproot(int reproot) {
		this.reproot = reproot;
	}

	public int getRepstep() {
		return repstep;
	}

	public void setRepstep(int repstep) {
		this.repstep = repstep;
	}

	public int getRepindent() {
		return repindent;
	}

	public void setRepindent(int repindent) {
		this.repindent = repindent;
	}

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	

}
