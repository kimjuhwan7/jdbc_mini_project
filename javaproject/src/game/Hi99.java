package game;

import java.util.Random;
import java.util.Scanner;

public class Hi99 extends Thread {

	static int x;// 앞자리
	static int y;// 뒷자리
	static int z;// 사용자입력값
	static int answer;// 앞*뒤=결과값
	static int count_down = 0;// 카운트 다운
	static int score;// 총점
	static int plus = 10;// 추가점수
	static boolean situation = true;
	static int start_count = 10;// 잔여시간

	@Override
	public void run() {

		System.out.println("run() 들어옴");
		for (; start_count > count_down - 1; start_count--) {
			try {
				Thread.sleep(1000);

				if (count_down == start_count) {

					situation = false;
				}
			} catch (InterruptedException e) {

			}
		}

	}

	public static void main(String[] args) {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		Hi99 thread = new Hi99();

		thread.start();
		System.out.println("구구단 게임을 시작합니다." + start_count + "초 동안 문제를 빠르게 풀어주세요");

		while (true) {

			x = random.nextInt(2) + 1;
			y = random.nextInt(2) + 1;
			answer = x * y;

			System.out.print(x + " x " + y + " => ");

//----------------------------------------------------
//첫번째 실행 후 사용자가 입력하면 첫번째 스레드를 멈추고    결과 출력 후 2번째 스레드 시작해야함
// ----------------------------------------------------
			z = sc.nextInt();// 사용자 입력

			if (z == answer) {
				score += 10;
				System.out.println("정답입니다! " + plus + "점 추가 " + " 총점 =>" + score);

			} else if (z != answer) {
				System.out.println("오답입니다! 정답은 : " + answer + "입니다");

			}
			if (situation == false) {
				System.out.println("시간이 종료 되었습니다.");
				System.out.println("총 스코어 " + score + "입니다. 축하합니다");
				break;
			}

		}
	}

}
