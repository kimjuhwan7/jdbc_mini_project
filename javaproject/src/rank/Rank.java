package rank;

public class Rank {
	private int serialnum;
	private int usernum;
	private int score;
	private String cleartime;
	
	public Rank(int serialnum, int usernum, int score, String cleartime)
	{
		this.serialnum = serialnum;
		this.usernum = usernum;
		this.score = score;
		this.cleartime = cleartime;
	}
	
	public Rank() 
	{
		
	}
	
	public int getSerialnum() {
		return serialnum;
	}
	
	public void setSerialnum(int serialnum) {
		this.serialnum = serialnum;
	}
	
	public int getUsernum() {
		return usernum;
	}
	
	public void setUsernum(int usernum) {
		this.usernum = usernum;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getCleartime() {
		return cleartime;
	}
	
	public void setCleartime(String cleartime) {
		this.cleartime = cleartime;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " : " + this.score + " : " + this.cleartime;
	}

	
}
