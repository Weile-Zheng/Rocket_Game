package game;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class makeSound {

	public static void main(String[] args) throws LineUnavailableException, UnsupportedAudioFileException, IOException {

		String songpath = "src/game/music.wav";
		File file = new File(songpath);
		AudioInputStream audioInput = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioInput);
		clip.start();
	    clip.loop(Clip.LOOP_CONTINUOUSLY);

		Scanner s = new Scanner(System.in);
		s.nextInt();

	}
}