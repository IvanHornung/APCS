//adapted from StackOverflow

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class Sound extends JFrame {
    private Clip clip;
    // Constructor
    public Sound(String n) {
        /**this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Test Sound Clip");
        this.setSize(300, 200);
        this.setVisible(false);*/

        try {
            // Open an audio input stream.
            URL url;
            clip = AudioSystem.getClip();
            if( n == "Classic" ) {
                url = this.getClass().getClassLoader().getResource("classic.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                clip.open(audioIn);
                clip.start();
                clip.loop(5);
            }
            if( n == "PlayerHit" ) {
                url = this.getClass().getClassLoader().getResource("PlayerBoop.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                clip.open(audioIn);
                clip.start();
                clip.loop(0);
            }
            if( n == "WallHit" ) {
                url = this.getClass().getClassLoader().getResource("WallBoop.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                clip.open(audioIn);
                clip.start();
                clip.loop(0);
            }
            if( n == "AIWin" ) {
                url = this.getClass().getClassLoader().getResource("AIWINFINAL.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                clip.open(audioIn);
                clip.start();
                clip.loop(10);
            }
            if( n == "PlayerWin" ) {
                url = this.getClass().getClassLoader().getResource("Low-Rider.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                clip.open(audioIn);
                clip.start();
                clip.loop(10);
            }
            if( n == "Upbeat" ) {
                url = this.getClass().getClassLoader().getResource("Upbeat.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                clip.open(audioIn);
                clip.start();
                clip.loop(10);
            }
            if( n == "Score" ) {
                url = this.getClass().getClassLoader().getResource("Score.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                clip.open(audioIn);
                clip.start();
                clip.loop(0);
            }
            if( n == "Accelerating" ) {
                url = this.getClass().getClassLoader().getResource("Accelerating.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                clip.open(audioIn);
                clip.start();
                clip.loop(0);
            }
            if( n == "Multiball" ) {
                url = this.getClass().getClassLoader().getResource("Multiball.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                clip.open(audioIn);
                clip.start();
                clip.loop(0);
            }
            
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    public void stopSong(){
        clip.stop();
    }
}
