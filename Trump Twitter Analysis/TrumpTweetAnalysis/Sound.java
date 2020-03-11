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
            if( n == "Rap" ) {
                url = this.getClass().getClassLoader().getResource("TRUMPSONG.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                clip.open(audioIn);
                clip.start();
                clip.loop(0);
            }
            
            if( n == "Intro" ) {
                url = this.getClass().getClassLoader().getResource("Intro.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                clip.open(audioIn);
                clip.start();
                clip.loop(0);
            }
            
            if( n == "Loading" ) {
                url = this.getClass().getClassLoader().getResource("Loading.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                clip.open(audioIn);
                clip.start();
                clip.loop(10);
            }
            
            if( n == "Final" ) {
                url = this.getClass().getClassLoader().getResource("Final.wav");
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
