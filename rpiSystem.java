package sample;
public class rpiSystem {
	public static bufferSet allFrames = new bufferSet();
	public static void runThreads() {
		
		/*
		 * TODO: Whenever threshold is crossed logic, GUI, resetting each time, test all this on a RPI
		 * 
		 */
		Thread listen = new Thread(new soundMonitor());
		Thread webcams = new Thread(new webcamCapture());
		Thread printer = new Thread(new outputPrinter());
		
		//listen.start(); // Mic is on and listening
		webcams.start(); // webcams are watching
		printer.start();
		
	}

}
