package game;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music extends Thread {
		String songpath = "src/game/music.wav";
	
	public void run() {
		try {
		File file = new File(songpath);
		AudioInputStream audioInput = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioInput);
		clip.start();
	    clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch(Exception e) {
			System.out.println("Audio Playing Error");
		}

	}
}
