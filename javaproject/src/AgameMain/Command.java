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
import rank.controller.RankInsertController;
import rank.controller.RankResearchController;

//Main.Command
//메인.커멘드
public class Command {
	public Map<String, List<Controller>> command;
		
	List<Controller> menu = new ArrayList<>();
	List<Controller> user = new ArrayList<>();
	List<Controller> admin = new ArrayList<>();
	
	private static Command instance = new Command();

	private Command() {
		command = new HashMap<>();

		command.put("menu", menu); // 분기1 : 메인 메뉴
		menu.add(null);
		menu.add(new LogInController()); // // 로그인
		menu.add(new InsertController()); // 회원가입
		menu.add(new ExitController()); // 프로그램 종료
		
		command.put("user", user); // 분기2 : 회원 메뉴
		user.add(null);
//        user.add(new GameController()); // 게임시작
		user.add(new RankResearchController()); // 랭크확인
		user.add(new Log_outController()); // 로그아웃
		user.add(new UpdateController()); // 회원수정 
		user.add(new DeleteController()); // 회원22탈퇴

		command.put("admin", admin); // 분기2 : 관리자 메뉴
		admin.add(null);
		admin.add(new UpdateController()); // 회원수정
		admin.add(new DeleteController()); //회원삭제
		admin.add(new SelectController()); // 회원출력
		admin.add(new ResearchByIdController()); // 회원검색
//		admin.add(new RankResearchController()); // 랭크검색
		admin.add(new RankDeleteController()); // 랭크삭제
//		admin.add(new RankInsertController()); // 랭크수정
		admin.add(new Log_outController());// 로그아웃 -> 메인메뉴로 이동
		
	}
	
	public static Command GetInstance()
	{
		if(instance == null)
			instance = new Command();
		
		return instance;
	}
	
	public List<Controller> GetUserContainer()
	{
		return user;
	}
	public List<Controller> GetAdminContainer()
	{
		return admin;
	}
	public List<Controller> GetMenuContainer()
	{
		return menu;
	}

	public static void userCommand() {
		
		Main.userMenu();
		
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
		
		Main.adminMenu();
		
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
		Main.menu();
		
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
	
	
	
	
}
