package game;

import java.util.Random;

import AgameMain.Main;
import rank.controller.RankInsertController;
import rank.controller.RankResearchController;

public class Hi99 {
	int x; // 랜덤으로 생성 할 숫자_1
	int y; // 랜덤으로 생성 할 숫자_2
	int z; // 사람이 적을 답
	int answer; // 계산된 답
	int i; // 문제반복
	static int score; // 점수
	static int serial_num = 2;
	Random random = new Random(); // 랜덤숫자 생성

	public void game_Start() {
		System.out.println("구구단 게임을 시작합니다. (횟수제한 10회)");
		makeMul();
	}

	public void makeMul() {
		score = 0;
		i = 0;
		while (i < 10) {
			i++;
			x = random.nextInt(9) + 1;
			y = random.nextInt(9) + 1;
			answer = x * y;
			System.out.print(x + " X " + y + " = ");
			z = Main.sc.nextInt();
			if (z == answer) {
				System.out.println("정답입니다!");
				score += 10;// 총점 추가
			} else {
				System.out.println("오답입니다!");
			}
		}
		if (score == 100) {
			System.out.println("만점입니다! 대단합니다!");
			System.out.println();
			reGame();
		} else if (score >= 60) {
			System.out.println("최종점수는 100점 만점 중 " + score + " 점입니다.");
			System.out.println("아쉽게만점을 받지 못했습니다.");
			System.out.println();
			reGame();
		} else {
			System.out.println("최종점수는 100점 만점 중 " + score + " 점입니다.");
			System.out.println("분발하셔야 합니다.");
			System.out.println();
			reGame();
		}
	}

	private void reGame() {
		System.out.println("한번 더 플레이 하시겠습니까? (네 | 아니오) ");
		while (true) {
			String sys = Main.sc.nextLine();

			if (sys.equals("네") == true) {
				game_Start();
				break;
			} else if (sys.equals("아니오") == true) {
				exitGame();
				break;
			} else {
				System.out.println("네/아니오 로만 작성해 주십시오");
				continue;
			}
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

	public int getSerialnum() {
		return Hi99.serial_num;
	}
}
