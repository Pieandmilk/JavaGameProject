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
            titleState(code);
        }

        //Play state
        else if (gp.gameState== gp.playState){
            playState(code);
        }
        //Pause State
        else if(gp.gameState== gp.pauseState){
            pauseState(code);

        }
        //Dialogue State
        else if(gp.gameState== gp.dialogState){
            dialogueState(code);
        }
        //Character State
        else if (gp.gameState==gp.characterState) {
            characterState(code);

        }
    }

    public void titleState(int code){

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
    public void playState(int code){
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
        if (code == KeyEvent.VK_C){
            gp.gameState=gp.characterState;
        }
    }
    public void pauseState(int code){
        if (code == KeyEvent.VK_P){
            gp.gameState= gp.playState;
        }
    }
    public void dialogueState(int code){
        if (code == KeyEvent.VK_ENTER){
            gp.gameState= gp.playState;
        }
    }
    public void characterState(int code){
        if (code== KeyEvent.VK_C){
            gp.gameState= gp.playState;
        }
        if (code== KeyEvent.VK_UP){
            gp.playSE(12);
            gp.ui.slotRow--;
            if (gp.ui.slotRow<0){
                gp.ui.slotRow=4;
            }

        }
        if (code== KeyEvent.VK_DOWN){
            gp.playSE(12);
            gp.ui.slotRow++;
            if (gp.ui.slotRow>4){
                gp.ui.slotRow=0;
            }
        }
        if (code== KeyEvent.VK_LEFT){
            gp.playSE(12);
            gp.ui.slotCol--;
            if (gp.ui.slotCol<0){
                gp.ui.slotCol=9;
            }
        }
        if (code== KeyEvent.VK_RIGHT){
            gp.playSE(12);
            gp.ui.slotCol++;
            if (gp.ui.slotCol>9){
                gp.ui.slotCol=0;
            }
        }
        if (code == KeyEvent.VK_ENTER){
            gp.player.selectItem();
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
