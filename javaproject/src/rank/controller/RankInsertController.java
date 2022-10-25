package rank.controller;

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

	public void function(int serialnum,int score, String cleardate) {
		// TODO Auto-generated method stub
		
		int result = service.Insert(new Rank(serialnum, Main.user.getUsernum(),score,cleardate));
		
	}

}