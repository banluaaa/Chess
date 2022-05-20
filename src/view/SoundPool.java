package view;

import javax.sound.sampled.AudioFileFormat;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class SoundPool extends Thread{
    public static final String BG_MUSIC = "Hoaprox - Ngẫu Hứng (即兴创作).wav";
    //public static final String SHOOT = "";
    AudioClip ac;
    public SoundPool(String path){
        URL url = this.getClass().getResource("/sound/"+path);
        ac = Applet.newAudioClip(url);
    }
    public void play(){
        ac.play();
    }
    public void stopAC(){
        ac.stop();
    }
    public void loop(){
        ac.loop();
    }
    @Override
    public void run(){
        play();
    }
}
