package rank.controller;

import java.util.List;

import generic.GenericCommand;
import rank.Rank;
import rank.RankDaoOracle;
import rank.service.RankSelectService;

public class RankSelectController implements GenericCommand{
	
	RankSelectService service = new RankSelectService(new RankDaoOracle());

	@Override
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
