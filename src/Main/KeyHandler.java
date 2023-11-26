package Main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;
    public boolean upPressed,downPressed,leftPressed,rightPressed,enterPressed,ePressed;
    boolean checkDrawTime=false;

    public KeyHandler (GamePanel gp){
        this.gp=gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        //Title state
        if (gp.gameState== gp.titleState) {

            if (code == KeyEvent.VK_UP) {
                gp.ui.commandNum--;
                if (gp.ui.commandNum<0){
                    gp.ui.commandNum=2;
                }
            }
            if (code == KeyEvent.VK_DOWN) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum>2){
                    gp.ui.commandNum=0;
                }
            }
            if (code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum==0){
                    gp.gameState= gp.playState;
                    gp.stopMusic();
                    gp.playMusic(0);
                }
                else if(gp.ui.commandNum==1){
                    //ADD LOADING FEATURE

                }
                if(gp.ui.commandNum==2){
                    System.exit(0);
                }
            }
        }

        //Play state
        else if (gp.gameState== gp.playState){
            if (code == KeyEvent.VK_W){
                upPressed=true;
            }
            if (code == KeyEvent.VK_S){
                downPressed=true;
            }
            if (code == KeyEvent.VK_A){
                leftPressed=true;
            }
            if (code == KeyEvent.VK_D){
                rightPressed=true;
            }

            //Debug
            if (code == KeyEvent.VK_T){
                if(checkDrawTime==false){
                    checkDrawTime=true;
                } else if (checkDrawTime==true) {
                    checkDrawTime=false;
                }
            }
            if (code == KeyEvent.VK_P){
                gp.gameState=gp.pauseState;
            }
            if (code == KeyEvent.VK_ENTER){
                enterPressed=true;
            }
            if (code == KeyEvent.VK_E){
                ePressed=true;
            }
        }
        //Pause State
        else if(gp.gameState== gp.pauseState){
            if (code == KeyEvent.VK_P){
                gp.gameState= gp.playState;
            }

        }
        //Dialogue State
        else if(gp.gameState== gp.dialogState){
            if (code == KeyEvent.VK_ENTER){
                gp.gameState= gp.playState;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W){
            upPressed=false;
        }
        if (code == KeyEvent.VK_S){
            downPressed=false;
        }
        if (code == KeyEvent.VK_A){
            leftPressed=false;
        }
        if (code == KeyEvent.VK_D){
            rightPressed=false;
        }

    }
}
