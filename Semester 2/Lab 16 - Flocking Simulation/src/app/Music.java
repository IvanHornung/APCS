package app;

//Adopted from StackOverflow

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class Music extends JFrame {
    private static final long serialVersionUID = 1L;
    private Clip clip;

    public Music() {
        try {
            // Open an audio input stream.
            URL url;
            clip = AudioSystem.getClip();
            url = this.getClass().getClassLoader().getResource("ambience.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip.open(audioIn);
            clip.start();
            clip.loop(5);
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