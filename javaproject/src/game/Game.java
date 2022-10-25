package game;

public class Game {

	private int serialnum;
	private String gamename;
	private String discription;
	private String genre;
	
	Game()
	{
		
	}
	
	Game(int serialnum, String gamename, String discription, String genre)
	{
		this.serialnum = serialnum;
		this.gamename = gamename;
		this.discription = discription;
		this.genre = genre;
	}
	
	public int getSerialnum() {
		return serialnum;
	}
	
	public void setSerialnum(int serialnum) {
		this.serialnum = serialnum;
	}
	
	public String getGamename() {
		return gamename;
	}
	
	public void setGamename(String gamename) {
		this.gamename = gamename;
	}
	
	public String getDiscription() {
		return discription;
	}
	
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
