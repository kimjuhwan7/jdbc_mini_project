package rank.controller;

import java.util.List;

import rank.Rank;
import rank.service.RankResearchService;

public class RankResearchController{
	
	private static RankResearchController instance = new RankResearchController();
	
	RankResearchController GetInstance()
	{
		if(instance == null)
			instance = new RankResearchController();
		
		return instance;
	}

	RankResearchService service = new RankResearchService();
	
	public void function(int select) 
	{
		// TODO Auto-generated method stub
		System.out.println("보고자 하는 랭킹을 선택 해 주세요");
		System.out.println("1.구구단 맞추기 	2.숫자 맞추기 	3.구구단	4.종합 ");
		
		
		if(select == 4)
		{
			List<Rank> rank = service.researchAll();
		
			if(rank != null)
			{
				for(Rank r : rank)
					r.toString();
			}
				else
					System.out.println("No Data");
		}
		else 
			{
			List<Rank> rank = service.researchAll();
		
			if(rank != null)
			{
				for(Rank r : rank)
					r.toString();
			}
			else
				System.out.println("No Data");
			}
		}
		
		
		public void function(String nickname)
		{
			
				List<Rank> rank = service.research(nickname);
			
				if(rank != null)
				{
					for(Rank r : rank)
						r.toString();
				}
					else
						System.out.println("No Data");
		}
}
