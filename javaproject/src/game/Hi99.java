package game;

import java.util.Random;

import AgameMain.Main;
import rank.controller.RankInsertController;
import rank.controller.RankResearchController;

public class Hi99 {
	int x; // 랜덤으로 생성 할 숫자
	int y;
	int z; // 사람이 적을 답
	int answer; // 계산된 답
	int i; // 문제반복
	static int score; // 점수
	static int serial_num = 2;
	Random random = new Random(); // 랜덤숫자 생성

	public void game_Start() {
		System.out.println("구구단 게임을 시작합니다.");
		makeMul();
	}

	public void makeMul() {
		score = 0;
		i = 0;
		while (i < 10) {
			i++;
			x = random.nextInt(9) + 1;
			y = random.nextInt(9) + 1;
			answer = x * y; // 시스템 정답 저장
			System.out.print(x + " X " + y + " = ");
			z = Main.sc.nextInt(); // 사람이 적은 정답 저장
			if (z == answer) {
				System.out.println("정답입니다!");
				score += 10;
			} else {
				System.out.println("오답입니다!");
			}
		}
		if (score == 100) {
			System.out.println("만점입니다! 대단합니다!");
		} else {
			System.out.println("최종점수는 100점 만점 중 " + score + " 점입니다." + "\n아쉽게만점을 받지 못했습니다.\n");
			reGame();
		}
	}

	private void reGame() {
		System.out.println("한번 더 플레이 하시겠습니까? (네 | 아니오) ");
		String yes = "네";
		String no = "아니요";

		String sys = Main.sc.nextLine();
		if (sys.equals(yes)) {
			game_Start();
		} else if (sys.equals(no)) {
			exitGame();
		} else {
			System.out.println("네/아니오 로만 작성해 주십시오");
			reGame();
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

	public int getSerialnum() {
		return Hi99.serial_num;
	}
}
