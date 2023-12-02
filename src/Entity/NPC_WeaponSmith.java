package Entity;

import Main.GamePanel;

public class NPC_WeaponSmith extends Entity{

    public NPC_WeaponSmith(GamePanel gp) {
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
    }
    public void getNPCImage(){

        down1=setup("/npc/weaponsmith_down2",gp.tileSize,gp.tileSize);
        down2=setup("/npc/weaponsmith_down2",gp.tileSize,gp.tileSize);
        down3=setup("/npc/weaponsmith_down2",gp.tileSize,gp.tileSize);

    }
}
