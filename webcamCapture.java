package sample;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;

public class webcamCapture implements Runnable{

	public void run() {
		Webcam webcam = Webcam.getDefault();
		//webcam.open();
		while (true) {
			try {
				frame theFrame = new frame(webcam.getImage()); // makes frame with the image
				bufferSetObject pic = new bufferSetObject(rpiSystem.allFrames, theFrame); // creates object and adds it to buffer
				Thread.sleep(30); // wait 30 milliseconds before next pic (33 fps)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}


}