package rank;

import java.time.LocalDate;

public class Rank {
	private int serialnum;
	private int exploiternum;
	private int score;
	private LocalDate cleartime;
	private String nickname = null;
	private String gamename = null;
	
	public Rank(int serialnum, int exploiternum, int score, LocalDate cleartime)
	{
		this.serialnum = serialnum;
		this.exploiternum = exploiternum;
		this.score = score;
		this.cleartime = cleartime;
	}
	
	public Rank() 
	{
		
	}
	
	public int getSerialNum() {
		return serialnum;
	}
	
	public void setSerialNum(int serialnum) {
		this.serialnum = serialnum;
	}
	
	public int getExploiterNum() {
		return exploiternum;
	}
	
	public void setExploiterNum(int exploiternum) {
		this.exploiternum = exploiternum;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public LocalDate getCleartime() {
		return cleartime;
	}
	
	public void setCleartime(LocalDate cleartime) {
		this.cleartime = cleartime;
	}
	
	public void setGamename(String gamename) {
		this.gamename = gamename;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(nickname != null)
			return "이름: "+ this.nickname +  "클리어 점수 : " + this.score + "클리어 일 : " + this.cleartime;
		
		else if (gamename != null)
			return "게임 명 : "+ this.nickname +  "클리어 점수 : " + this.score + "클리어 일 : " + this.cleartime;
		
		else
			return "클리어 점수 : " + this.score + "클리어 일 : " + this.cleartime;
	}

	
}
