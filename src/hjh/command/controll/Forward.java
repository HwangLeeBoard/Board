package hjh.command.controll;

public class Forward {
	private boolean isDispacher=false;
	private String path=null;
	private int board_code=0;
	
	public int getBoard_code() {
		return board_code;
	}
	public void setBoard_code(int board_code) {
		this.board_code = board_code;
	}
	public boolean isDispacher() {
		return isDispacher;
	}
	public void setDispacher(boolean isDispacher) {
		this.isDispacher = isDispacher;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
