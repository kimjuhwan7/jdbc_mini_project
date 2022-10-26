package rank.controller;

import java.time.LocalDate;

import AgameMain.Main;
import rank.Rank;
import rank.service.RankInsertService;

public class RankInsertController{
	
	private static RankInsertController instance = new RankInsertController();
	
	RankInsertController GetInstance()
	{
		if(instance == null)
			instance = new RankInsertController();
		
		return instance;
	}
	
	RankInsertService service = new RankInsertService();

	public void function(int serialnum,int score, LocalDate cleardate) {
		// TODO Auto-generated method stub
		
		service.Insert(new Rank(Main.user.getUsernum(), serialnum, score, cleardate.toString()));
		
	}

}
