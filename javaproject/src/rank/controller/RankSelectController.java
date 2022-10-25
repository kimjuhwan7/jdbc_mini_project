package rank.controller;

import java.util.List;

import rank.Rank;
import rank.RankDaoOracle;
import rank.service.RankSelectService;

public class RankSelectController{
	
	private static RankSelectController instance = new RankSelectController();
	
	RankSelectController GetInstance()
	{
		if(instance == null)
			instance = new RankSelectController();
		
		return instance;
	}
	
	RankSelectService service = new RankSelectService(new RankDaoOracle());

	public void function() {
		// TODO Auto-generated method stub
		List<Rank> rank = service.select();
		
		if(rank != null)
		{
			for(Rank r : rank)
			{
				r.toString();
			}
		}
		else
			System.out.println("No Data");
	}

}
