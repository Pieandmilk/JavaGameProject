package Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;
    URL soundURL[]= new URL[30];
    public Sound(){
        soundURL[0]= setup("BlueBoyAdventure");
        soundURL[1]= setup("coin");
        soundURL[2]= setup("powerup");
        soundURL[3]= setup("unlock");
        soundURL[4]= setup("fanfare");
        soundURL[5]= setup("hitmonster");
        soundURL[6]= setup("receivedamage");
        soundURL[7]= setup("weapon_swing");
        soundURL[8]= setup("heal_up");
        soundURL[9]= setup("INTRO_TITLE_SONG");
        soundURL[10]= setup("splash");
        soundURL[11]=setup("level_up");
        soundURL[12]=setup("click");
        soundURL[13]=setup("axe_swing");
        soundURL[14]= setup("Open_Bottle");
        soundURL[15]=setup("fireball");
        soundURL[16]=setup("mana");
        soundURL[17]=setup("LAWRENCE_TOWN");
        soundURL[18]=setup("beach");
        soundURL[19]=setup("SOUTH_ISLAND");
        soundURL[20]=setup("NORTH_ISLAND");
    }

    public URL setup(String filepath){
        URL sound = null;
        sound=getClass().getResource("/sound/"+filepath+".wav");
        return sound;
    }

    //Opening a audio file
    public void setFile(int i) {
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }
        catch (Exception e){

        }
    }
    public void play() {
        clip.start();
    }
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
        clip.stop();
    }
}
