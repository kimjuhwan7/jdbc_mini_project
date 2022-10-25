package game;

import java.util.Random;
import java.util.Scanner;

//Hi99 hi = new Hi99();
//hi.hi_start();

public class Hi99 extends Thread {

	public static void main(String[] args) {
		Hi99 hi99 = new Hi99();
		hi99.hi_start();
	}

	static int x;// 앞자리
	static int y;// 뒷자리
	static int z;// 사용자입력값
	static int answer;// 앞*뒤=결과값
	static int score;// 총점
	static int plus = 10;// 추가점수
	static int count_down = 0;// 카운트 다운
	static int start_count = 30;// 잔여시간
	static int serial_num = 2;// 게임 시리얼넘버

	@Override
	public void run() {// 스레드
		while (start_count > count_down) {
			start_count--;
			try {
				Thread.sleep(1000);// 1초
			} catch (InterruptedException e) {

			}
		}
		// start_count 끝나면 실행
		System.out.println("시간이 종료 되었습니다.");
		System.out.println("총 스코어 " + score + "입니다. 축하합니다");
	}

	public void hi_start() {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
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

			z = sc.nextInt();// 사용자 입력

			if (z == answer) {
				score += 10;
				System.out.println("정답입니다! " + plus + "점 추가 " + " 총점 =>" + score);

			} else if (z != answer) {
				System.out.println("오답입니다! 정답은 : " + answer + " 입니다");

			}
		}
	}
}
