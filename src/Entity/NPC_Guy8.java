package Entity;

import Main.GamePanel;

import java.util.Random;

public class NPC_Guy8 extends Entity{
    public NPC_Guy8(GamePanel gp) {
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
        up1=setup("/npc/guy8_up1",gp.tileSize,gp.tileSize);
        up2=setup("/npc/guy8_up2",gp.tileSize,gp.tileSize);
        up3=setup("/npc/guy8_up3",gp.tileSize,gp.tileSize);
        down1=setup("/npc/guy8_down1",gp.tileSize,gp.tileSize);
        down2=setup("/npc/guy8_down2",gp.tileSize,gp.tileSize);
        down3=setup("/npc/guy8_down3",gp.tileSize,gp.tileSize);
        left1=setup("/npc/guy8_left1",gp.tileSize,gp.tileSize);
        left2=setup("/npc/guy8_left2",gp.tileSize,gp.tileSize);
        left3=setup("/npc/guy8_left3",gp.tileSize,gp.tileSize);
        right1=setup("/npc/guy8_right1",gp.tileSize,gp.tileSize);
        right2=setup("/npc/guy8_right2",gp.tileSize,gp.tileSize);
        right3=setup("/npc/guy8_right3",gp.tileSize,gp.tileSize);
    }
    public void setDialogue(){
        dialogues[0]="Halt, traveler!";
        dialogues[1]="Beware! Fierce creatures lurk beyond.";
        dialogues[2]="Vicious beasts roam these parts, hungry for unwary souls.";
        dialogues[3]="Take heed and prepare well before venturing further!";
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
