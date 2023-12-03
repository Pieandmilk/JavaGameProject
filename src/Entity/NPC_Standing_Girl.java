package Entity;

import Main.GamePanel;

public class NPC_Standing_Girl extends Entity{
    public NPC_Standing_Girl(GamePanel gp) {
        super(gp);
        direction = "left";
        speed =0;

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
        up1=setup("/npc/white_hair_left2",gp.tileSize,gp.tileSize);
        up2=setup("/npc/white_hair_left2",gp.tileSize,gp.tileSize);
        up3=setup("/npc/white_hair_left2",gp.tileSize,gp.tileSize);
        down1=setup("/npc/white_hair_down1",gp.tileSize,gp.tileSize);
        down2=setup("/npc/white_hair_down2",gp.tileSize,gp.tileSize);
        down3=setup("/npc/white_hair_down3",gp.tileSize,gp.tileSize);
        left1=setup("/npc/white_hair_left2",gp.tileSize,gp.tileSize);
        left2=setup("/npc/white_hair_left2",gp.tileSize,gp.tileSize);
        left3=setup("/npc/white_hair_left2",gp.tileSize,gp.tileSize);
        right1=setup("/npc/white_hair_right1",gp.tileSize,gp.tileSize);
        right2=setup("/npc/white_hair_right2",gp.tileSize,gp.tileSize);
        right3=setup("/npc/white_hair_right3",gp.tileSize,gp.tileSize);
    }
    public void setDialogue(){
        dialogues[0]="Hi Son!";
        dialogues[1]="Going out for an adventure?";
        dialogues[2]="Be careful there are a whole lot of baddies out there.";
        dialogues[3]="May your quests be filled with wonder!";
    }
}
