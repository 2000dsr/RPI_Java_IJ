package sample;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class soundMonitor implements Runnable{
	public static int bytesRead;
	public static byte [] buffer;
	public static boolean micTripped = false;
	static TargetDataLine targetDataLine;
	public void run() {
		AudioFormat audioFormat = getAudioFormat();

		try {
			targetDataLine = (TargetDataLine) AudioSystem.getTargetDataLine(audioFormat);
			targetDataLine.open();
			targetDataLine.start();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			targetDataLine = null;
		}
		buffer = new byte[2000];
		short max = 0;
		int threshold = 80;
		boolean newMax;
		
		while (true) {
			int bytesRead = targetDataLine.read(buffer,0,buffer.length);
			// checks for max below
			
			newMax = false;
			if (bytesRead >=0) {
				//max = (short) (buffer[0] + (buffer[1] << 8));
				
				for (int p=2;p<bytesRead-1;p+=2) {
					short thisValue = (short) (buffer[p] + (buffer[p+1] << 8));
					thisValue = (short) (Math.log(thisValue)*10);
					if (thisValue>threshold) {
						max=thisValue;
						newMax = true;
						micTripped = true;
					}
				}
				if (newMax) System.out.println("Value is "+max); // if the max was updated then print it
			}

		}

		
	}
	
	public static void closeAudio() {
		if (targetDataLine != null) {
		targetDataLine.close();
		}
	}


	public static AudioFormat getAudioFormat(){
		float sampleRate = 8000.0F;
		int sampleSizeInBits = 16;
		int channels = 1;
		boolean signed = true;
		boolean bigEndian = false;
		return new AudioFormat(sampleRate,sampleSizeInBits,channels,signed,bigEndian);
		//PCM_SIGNED unknown sample rate, 16 bit, mono, 2 bytes/frame, little-endian
	}



}
