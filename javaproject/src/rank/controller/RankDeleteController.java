package rank.controller;

import rank.service.RankDeleteService;

public class RankDeleteController{

	
	private static RankResearchController instance = new RankResearchController();
	
	RankResearchController GetInstance()
	{
		if(instance == null)
			instance = new RankResearchController();
		
		return instance;
	}
	
	RankDeleteService service = new RankDeleteService();
	
	
	public void function() {
		// TODO Auto-generated method stub
		
		System.out.println("제거할 랭킹 데이터를 선택하세요");
		

		int index = Integer.parseInt(Main.sc.nextLine());
		
		int result = service.delete(index);
		
		if(result > 0)
			System.out.println("삭제되었습니다");
		else 
			System.out.println("실패하였습니다");
		
	}

}
