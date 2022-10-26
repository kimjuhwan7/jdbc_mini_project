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
		System.out.println("변경할 데이터의 번호를 입력하세요");
		int index = Main.sc.nextInt();
		System.out.println("변경할 데이터의 번호를 입력하세요");
		int index = Main.sc.nextInt();
		System.out.println("변경할 데이터의 번호를 입력하세요");
		int index = Main.sc.nextInt();
		
		
		service.update(new Rank(serialnum, usernum, score, cleardate.toString()));
	}
}
