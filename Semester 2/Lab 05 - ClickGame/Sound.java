//Adopted from StackOverflow

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
        try {
            // Open an audio input stream.
            URL url;
            clip = AudioSystem.getClip();
            if( n == "Hit" ) {
                url = this.getClass().getClassLoader().getResource("birdhit.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                clip.open(audioIn);
                clip.start();
                clip.loop(0);
            }
            else if( n == "Miss" ) {
                url = this.getClass().getClassLoader().getResource("Miss.wav");
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
