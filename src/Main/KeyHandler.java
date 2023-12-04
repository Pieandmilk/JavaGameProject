package Main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;
    public boolean upPressed,downPressed,leftPressed,rightPressed,enterPressed,ePressed,shootKeyPressed;
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

        } else if (gp.gameState==gp.inGameSettingsState) {
            inGameSettingsState(code);
        }
        //Dialogue State
        else if(gp.gameState== gp.dialogState){
            dialogueState(code);
        }
        //Character State
        else if (gp.gameState==gp.characterState) {
            characterState(code);

        }
        //Transaction State
        else if(gp.gameState==gp.transactionState){
           transactionState(code);
        }

        else if (gp.gameState == gp.gameOverState){
            gameOverState(code);
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

            }
            if(gp.ui.commandNum==2){
                System.exit(0);
            }
        }
    }
    public void playState(int code){
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            upPressed=true;
        }
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            downPressed=true;
        }
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            leftPressed=true;
        }
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
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
        if (code == KeyEvent.VK_ESCAPE){
            gp.gameState=gp.pauseState;
        }
        if (code == KeyEvent.VK_ENTER){
            enterPressed=true;
        }
        if (code == KeyEvent.VK_E){
            ePressed=true;
        }
        if (code == KeyEvent.VK_F){
            shootKeyPressed=true;
        }
        if (code == KeyEvent.VK_C){
            gp.gameState=gp.characterState;
        }
    }
    public void pauseState(int code){
        if (gp.gameState == gp.pauseState) {
            if (code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.playState;
            }
            if (code == KeyEvent.VK_UP) {
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 3;
                }
            }
            if (code == KeyEvent.VK_DOWN) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 3) {
                    gp.ui.commandNum = 0;
                }
            }
        }

        //edit actions **************
        if (code == KeyEvent.VK_ENTER) {
            //CheckWallet
            if (gp.ui.commandNum == 0) {

            }
            //save
            if (gp.ui.commandNum == 1) {

            }
            //option settings
            if (gp.ui.commandNum == 2) {
                gp.gameState = gp.inGameSettingsState; //go from paused to settings
                gp.ui.commandNum = 0;
            }
            //MainMenu
            if (gp.ui.commandNum == 3) {
                gp.gameState = gp.titleState; // Change game state to title state
                gp.ui.commandNum = 0;
                gp.stopMusic();
            }


            if (code == KeyEvent.VK_UP) {
                gp.ui.commandNum--;

                if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 2;
                }
            }
            if (code == KeyEvent.VK_DOWN) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 2) {
                    gp.ui.commandNum = 0;
                }
            }
        }
    }
    public void inGameSettingsState(int code){
        //Game settings State
        if (gp.gameState == gp.inGameSettingsState) {
            if(code == KeyEvent.VK_ESCAPE){
                gp.gameState = gp.pauseState;
            }

            if (code == KeyEvent.VK_UP) {
                gp.ui.commandNum--;

                if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 1;
                }
            }
            if (code == KeyEvent.VK_DOWN) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 1) {
                    gp.ui.commandNum = 0;
                }
            }
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
    //TRANSACTIONS
    public void transactionState(int code){
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
    }

    public void gameOverState(int code){
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            gp.ui.commandNum--;
            if (gp.ui.commandNum < 0){
                gp.ui.commandNum = 1;
            }
        }
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            gp.ui.commandNum++;
            if (gp.ui.commandNum > 1){
                gp.ui.commandNum = 0;
            }
        }
        if (code == KeyEvent.VK_ENTER){
            if (gp.ui.commandNum == 0){
                gp.stopMusic();
                gp.gameState = gp.playState;
                gp.TryAgain();
            }
            else if (gp.ui.commandNum == 1){
                gp.gameState = gp.titleState;
                gp.stopMusic();
                gp.setupGame();
                gp.Restart();
            }
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            upPressed=false;
        }
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            downPressed=false;
        }
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            leftPressed=false;
        }
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            rightPressed=false;
        }
        if (code == KeyEvent.VK_F){
            shootKeyPressed=false;
        }

    }
}
