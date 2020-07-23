package sample;
public class outputPrinter implements Runnable{
	public void run() {
		while (true) {
			System.out.println(rpiSystem.allFrames.toString());

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
