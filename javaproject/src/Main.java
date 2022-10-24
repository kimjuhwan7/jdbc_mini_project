import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);// 다회용 스케너

	public static void main(String[] args) {

		Commend commend = new Commend();

		while (true) {
			menu();
			System.out.println("메뉴를 입력하세요. >>");
			int select = Integer.parseInt(sc.nextLine());

		}
	}

	public static void menu() {
		System.out.println("ByeMedia에 오신 걸 환영합니다.");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 종료");
	}

}
