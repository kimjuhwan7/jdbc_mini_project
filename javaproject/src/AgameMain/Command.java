package AgameMain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exploiter.controller.Controller;
import exploiter.controller.DeleteController;
import exploiter.controller.ExitController;
import exploiter.controller.InsertController;
import exploiter.controller.LogInController;
import exploiter.controller.Log_outController;
import exploiter.controller.UpdateController;
import rank.controller.RankDeleteController;
import rank.controller.RankInsertController;
import rank.controller.RankResearchController;

//Main.Command
//메인.커멘드
public class Command {
	public Map<String, List<Controller>> command;
		




	public Command() {
		command = new HashMap<>();
		List<Controller> menu = new ArrayList<>();
		List<Controller> user = new ArrayList<>();
		List<Controller> admin = new ArrayList<>();

		command.put("menu", menu); // 분기1 : 메인 메뉴
		menu.add(null);
		menu.add(new LogInController()); // // 로그인
		menu.add(new InsertController()); // 회원가입
		menu.add(new ExitController()); // 프로그램 종료
		
//		command.put("user", user); // 분기2 : 회원 메뉴
//		user.add(null);
//		// user.add(new GameController()); // 게임시작
//		user.add((Controller) new RankResearchController()); // 랭크확인
//		user.add((Controller) new Log_outController()); // 로그아웃 -> 메인메뉴로 이동
//		user.add((Controller) new UpdateController()); // 회원수정
//		user.add((Controller) new DeleteController()); // 회원탈퇴
		
//		command.put("admin", admin); // 분기2 : 관리자 메뉴
//		admin.add(null);
//		admin.add((Controller) new UpdateController()); // 회원관리
//		admin.add((Controller) new RankResearchController()); // 랭크검색
//		admin.add((Controller) new RankDeleteController()); // 랭크삭제
//		admin.add((Controller) new RankInsertController()); // 랭크수정
//		admin.add((Controller) new Log_outController()); // 로그아웃 -> 메인메뉴로 이동 
		
		
	}

	
	
	
	
	
}
