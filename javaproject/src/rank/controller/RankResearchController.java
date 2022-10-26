package rank.controller;

import java.util.List;

import AgameMain.Main;
import rank.Rank;
import rank.service.RankResearchService;

public class RankResearchController implements exploiter.controller.Controller{
	
	private static RankResearchController instance = null;
	
	public static RankResearchController GetInstance()
	{
		if(instance == null)
			instance = new RankResearchController();
		
		return instance;
	}

	RankResearchService service = new RankResearchService();
	
	@Override
	public void process() 
	{
		// TODO Auto-generated method stub		

		System.out.println("보고자 하는 랭킹을 선택 해 주세요");
		System.out.println("1.숫자 맞추기\t2.구구단 맞추기\t3.틱택토\t4.종합 ");
		int select = Integer.parseInt(Main.sc.nextLine());
		if(select == 4)
		{
			List<Rank> rank = service.researchAll();
		
			if(rank != null && rank.size() != 0)
			{
				for(Rank r : rank)
					System.out.println(r.toString());
			}
				else
					System.out.println("No Data");
		}
		else 
			{
				List<Rank> rank = service.research(select);
				if(rank != null && rank.size() != 0)
				{
					for(Rank r : rank)
						System.out.println(r.toString());
				}
				else
					System.out.println("No Data");
			}
		}
	public void function(int num) 
	{
		// TODO Auto-generated method stub		

			List<Rank> rank = service.research(num);
		
			if(rank != null && rank.size() != 0)
			{
				for(Rank r : rank)
					System.out.println(r.toString());
			}
				else
					System.out.println("No Data");
		}
	}

