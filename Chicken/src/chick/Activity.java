package chick;

import java.util.Timer;
import java.util.TimerTask;

public class Activity {

	static int count = 5;

	public static void main(String[] args) {
		System.out.println("타이머사용해 실시간 카운트다운 및 자동종료");

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				if (count >= 0) {
					System.out.println("카운트 업" + count);
					--count;
				} else {
					timer.cancel();
					System.out.println("카운트 업 종료");
				}
			}
		};timer.schedule(task, 1000,1000);
	}
}
