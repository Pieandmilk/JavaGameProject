package Entity;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class NPC_OldMan extends Entity{

    public NPC_OldMan(GamePanel gp){
        super(gp);

        direction = "down";
        speed = 1;
        getNPCImage();
    }

    public void getNPCImage(){

        up1=setup("/npc/oldman_up_1");
        up2=setup("/npc/oldman_up_2");
        down1=setup("/npc/oldman_down_1");
        down2=setup("/npc/oldman_down_2");
        left1=setup("/npc/oldman_left_1");
        left2=setup("/npc/oldman_left_2");
        right1=setup("/npc/oldman_right_1");
        right2=setup("/npc/oldman_right_2");

    }
    public void setAction(){
        actionLockCounter++;

        if (actionLockCounter ==120){
            Random random = new Random();
            int i = random.nextInt(100)+1; //pickup a number from one to one hundred

            if (i <= 25 && direction!="up"){
                direction="up";

            }
            if (i>25 && i<=50 && direction !="down"){
                direction="down";

            }
            if (i>50 && i<=75 && direction !="left"){
                direction="left";
            }
            if (i>=75 && i<=100 && direction!="right"){
                direction="right";
            }
            actionLockCounter=0;
        }
    }
}



