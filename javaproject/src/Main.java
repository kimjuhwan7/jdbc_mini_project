import java.util.Scanner;

import exploiter.Exploiter;
//Main
//메인
public class Main {
	public static Scanner sc = new Scanner(System.in);// 다회용 스케너
	public static Exploiter user; // 로그인 정보 저장용

	public static void main(String[] args) {

		Command command = new Command();

		while (true) {
			menu();
			System.out.println("메뉴를 입력하세요. >>");
			int select = Integer.parseInt(sc.nextLine());

			command.command.get(select).process();

		}
	}

	public static void menu() {
		System.out.println("ByeMedia에 오신 걸 환영합니다.");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 종료");
	}

}
