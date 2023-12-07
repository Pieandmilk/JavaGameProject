package Entity;

import Main.GamePanel;

import java.util.Random;

public class NPC_OldStatiscian extends Entity{

    public NPC_OldStatiscian(GamePanel gp){
        super(gp);

        direction = "down";
        speed = 1;

        solidArea.x=0;
        solidArea.y=16;
        solidArea.width=48;
        solidArea.height=32;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        getNPCImage();
        setDialogue();
    }

    public void getNPCImage(){

        up1=setup("/npc/oldman_up_1",gp.tileSize,gp.tileSize);
        up2=setup("/npc/oldman_up_2",gp.tileSize,gp.tileSize);
        up3=setup("/npc/oldman_up_1",gp.tileSize,gp.tileSize);
        down1=setup("/npc/oldman_down_1",gp.tileSize,gp.tileSize);
        down2=setup("/npc/oldman_down_2",gp.tileSize,gp.tileSize);
        down3=setup("/npc/oldman_down_1",gp.tileSize,gp.tileSize);
        left1=setup("/npc/oldman_left_1",gp.tileSize,gp.tileSize);
        left2=setup("/npc/oldman_left_2",gp.tileSize,gp.tileSize);
        left3=setup("/npc/oldman_left_1",gp.tileSize,gp.tileSize);
        right1=setup("/npc/oldman_right_1",gp.tileSize,gp.tileSize);
        right2=setup("/npc/oldman_right_2",gp.tileSize,gp.tileSize);
        right3=setup("/npc/oldman_right_1",gp.tileSize,gp.tileSize);
    }
    public void setDialogue(){
        dialogues[0]="Hello travel, do you want see my work?";
        dialogues[1]="I have an calculator that solve Statistics";
        dialogues[2]="I have been working this for months";
        dialogues[3]="Behold!!";
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
    public void speak(){
        super.speak();
    }
}



