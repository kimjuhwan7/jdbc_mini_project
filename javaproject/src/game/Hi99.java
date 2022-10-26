package game;

import java.util.Random;
import java.util.regex.Pattern;

import AgameMain.Main;
import rank.controller.RankInsertController;
import rank.controller.RankResearchController;

public class Hi99 extends Thread {
	Random random = new Random();
	String pattern = "^[0-9]*$";// 숫자만
	String val = "123456789"; // 대상문자열

	int x;// 앞자리
	int y;// 뒷자리
	String z;// 사용자입력값
	int answer;// 앞*뒤=결과값
	static int score;// 총점
	int plus = 10;// 추가점수
	int count_down = 0;// 카운트 다운
	int start_count = 30;// 잔여시간
	static int serial_num = 2;// 게임 시리얼넘버

	@Override
	public void run() {// 스레드
		try {
			while (start_count > count_down) {
				start_count--;
				Thread.sleep(1000);// 1초
			}
		} catch (InterruptedException e) {
		} finally {
			System.out.println("시간이 종료 되었습니다.");
			System.out.println("총 스코어 " + score + "입니다. 축하합니다");

		}
		// start_count 끝나면 실행
		System.out.println("시간이 종료 되었습니다.");
		System.out.println("총 스코어 " + score + "입니다. 축하합니다");
		reGame();

	}

	public void game_Start() {
		String pattern = "^[0-9]*$";// 숫자만
		Hi99 thread = new Hi99();

		System.out.println("구구단 게임을 시작합니다.");
		System.out.println(start_count + "초 동안 문제를 빠르게 풀어주세요");
		System.out.println("시작!");

		thread.start();// 스레드 실행 (run)

		while (true) {
			x = random.nextInt(9) + 1;
			y = random.nextInt(9) + 1;
			answer = x * y;// 곱셈 결과 값
			System.out.print(x + " x " + y + " => ");
			while (true) {
				z = Main.sc.nextLine();// 사용자 입력
				Boolean regex = Pattern.matches(pattern, z);
				if (!regex) {
					System.out.println("정수만 입력해주세요");
					continue;
				}
				break;
			}
			if (answer == Integer.valueOf(z)) {
				score += 10;
				System.out.println("정답입니다! " + plus + "점 추가 " + "총점 =>" + score);

			} else {
				System.out.println("오답입니다! 정답-> " + answer + " 총점 =>" + score + " 다음문제");

			}
		}
	}

	private void reGame() {
		System.out.println("한번 더 플레이 하시겠습니까? (네 | 아니오) ");
		String sc = Main.sc.nextLine();
		if (sc.equals("네")) {
			game_Start();
		} else if (sc.equals("아니오")) {
			exitGame();
		}
	}

	private static void exitGame() {
		RankInsertController insertctl = new RankInsertController();
		insertctl.function(serial_num, score, Main.now);
		RankResearchController showRanking = new RankResearchController();
		showRanking.function(serial_num);
		System.out.println("\nGAME OVER");
		System.out.println("메뉴로 돌아갑니다.");
		System.out.println();

	}

	public static void main(String[] args) {
		Hi99 hi99 = new Hi99();
		hi99.game_Start();
	}

	public int getSerialNum() {
		return Hi99.serial_num;
	}
}
