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
import exploiter.controller.ResearchByIdController;
import exploiter.controller.SelectController;
import exploiter.controller.UpdateController;
import game.GameController;
import rank.controller.RankDeleteController;
import rank.controller.RankResearchController;
import rank.controller.RankUpdateController;


public class Command {
	public Map<String, List<Controller>> command;
		
	List<Controller> menu = new ArrayList<>();
	List<Controller> user = new ArrayList<>();
	List<Controller> admin = new ArrayList<>();
	
	private static Command instance = new Command();

	private Command() {
		command = new HashMap<>();

		command.put("menu", menu); /* 분기1 : 메인 메뉴 */
		menu.add(null);
		menu.add(new LogInController()); 		// 1. 로그인
		menu.add(new InsertController()); 		// 2. 회원가입
		menu.add(new ExitController()); 		// 3. 프로그램 종료
		
		command.put("user", user); /* 분기2 : 회원 메뉴 */
		user.add(null);
		GameController gameCtrl = GameController.GetInstance();
        user.add(gameCtrl); 					// 1. 게임시작
		user.add(new RankResearchController()); // 2. 랭크확인
		user.add(new Log_outController()); 		// 3. 로그아웃
		user.add(new UpdateController()); 		// 4. 회원수정 
		user.add(new DeleteController()); 		// 5. 회원탈퇴

		command.put("admin", admin); /* 분기2 : 관리자 메뉴 */
		admin.add(null);
		admin.add(new UpdateController());			// 1. 회원수정
		admin.add(new DeleteController()); 			// 2. 회원삭제
		admin.add(new SelectController());			// 3. 회원출력
		admin.add(new ResearchByIdController()); 	// 4. 회원검색
		admin.add(new RankResearchController()); 	// 5. 랭크검색
		admin.add(new RankDeleteController()); 		// 6. 랭크삭제
		admin.add(new RankUpdateController()); 		// 7. 랭크수정
		admin.add(new Log_outController());			// 8. 로그아웃 -> 메인메뉴로 이동
		
	}
	
	public static Command GetInstance()
	{
		if(instance == null)
			instance = new Command();
		
		return instance;
	}

	public static void userCommand() {
		
		userMenu();
		
		Command command = AgameMain.Command.GetInstance();
		String user = "user";
		
		try {
			
		int select = Integer.parseInt(Main.sc.nextLine());
		command.command.get(user).get(select).process();
		
		if(select < 1 || select > 5) {
			throw new Exception();
			
		}
		
		} catch(Exception e){
			System.out.println("1~5 사이의 값을 입력해주세요.");
			System.out.println();
		}
		
		
		
	}
	
	public static void adminCommand() {
		
		adminMenu();
		
		Command command = AgameMain.Command.GetInstance();
		String user = "admin";
		
		
		try {
			
			int select = Integer.parseInt(Main.sc.nextLine());
			command.command.get(user).get(select).process();
			
			if(select < 1 || select > 8) {
				throw new Exception();
				
			}
			
			} catch(Exception e){
				System.out.println("1~8 사이의 값을 입력해주세요.");
				System.out.println();
			}
		
		
	}
	
	public static void menuCommand() {
		menu();
		
		Command command = AgameMain.Command.GetInstance();
		
		
		try {
			
			int select = Integer.parseInt(Main.sc.nextLine());
			command.command.get("menu").get(select).process();
			
			if(select < 1 || select > 3) {
				throw new Exception();
				
			}
			
			} catch(Exception e){
				System.out.println("1~3 사이의 값을 입력해주세요.");
				System.out.println();
			}
		
	}
	

	public static void menu() {
		System.out.println("ByeMedia에 오신 걸 환영합니다.");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 종료");
	}
	
	public static void userMenu() {
		System.out.println("원하시는 메뉴 번호를 입력하세요. .");
		System.out.println("1. 게임시작");
		System.out.println("2. 랭크확인");
		System.out.println("3. 로그아웃");
		System.out.println("4. 회원수정");
		System.out.println("5. 회원탈퇴");
		
	}
	
	public static void adminMenu() {
		System.out.println("원하시는 메뉴 번호를 입력하세요. .");
		System.out.println("1. 회원수정");
		System.out.println("2. 회원삭제");
		System.out.println("3. 회원출력");
		System.out.println("4. 회원검색");
		System.out.println("5. 랭크검색");
		System.out.println("6. 랭크삭제");
		System.out.println("7. 랭크수정");
		System.out.println("8. 로그아웃");

	}

	
	
}
