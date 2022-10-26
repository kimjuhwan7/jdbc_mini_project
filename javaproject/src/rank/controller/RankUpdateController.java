package rank.controller;

import java.time.LocalDate;

import AgameMain.Main;
import rank.Rank;
import rank.service.RankUpdateService;

public class RankUpdateController  implements exploiter.controller.Controller{

	RankUpdateService service = new RankUpdateService();
	private static RankUpdateController instance = null;

	RankUpdateController GetInstance()
	{
		if(instance == null)
			instance = new RankUpdateController();
		
		return instance;
	}
	@Override
	public void process() {
		// TODO Auto-generated method stub
		
		System.out.println("변경할 데이터의 번호를 입력하세요");
		int index = Main.sc.nextInt();
		System.out.println("변경할 데이터의 점수를 입력하세요");
		int score = Main.sc.nextInt();
		System.out.println("변경할 데이터의 클리어 일을 입력하세요");
		String cleardate = Main.sc.next();
		
		
		service.update(index, score, cleardate.toString());
	}
}
