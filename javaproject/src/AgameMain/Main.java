package AgameMain;

import java.time.LocalDate;
import java.util.Scanner;

import exploiter.Exploiter;
//Main
//메인

//패키지 위로 보내려고 앞에 A붙임(수정가능)
public class Main {
	public static Scanner sc = new Scanner(System.in);// 다회용 스케너
	public static Exploiter user; // 로그인 정보 저장용
	public static LocalDate now = LocalDate.now();

	
	
	public static void main(String[] args) {

		while (true) {
			
			if(Main.user==null) {
				Command.menuCommand();
			} else if(Main.user.getAdmin() == 0) {
				Command.userCommand();
			} else if(Main.user.getAdmin() == 1) {
				Command.adminCommand();
			}
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
		System.out.println("1. 회원관리");
		System.out.println("2. 랭크검색");
		System.out.println("3. 랭크삭제");
		System.out.println("4. 랭크수정");

	}

}
