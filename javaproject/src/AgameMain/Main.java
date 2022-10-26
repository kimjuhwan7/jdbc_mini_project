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

}
