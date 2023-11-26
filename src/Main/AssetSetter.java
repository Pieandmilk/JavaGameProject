package Main;

import Enemies.ENEM_Slime;
import Entity.NPC_OldMan;
import Objects.*;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){
        gp.obj[0] = new OBJ_Key(gp);
        gp.obj[0].worldX = 23 *gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;

        gp.obj[1] = new OBJ_Key(gp);
        gp.obj[1].worldX = 23 *gp.tileSize;
        gp.obj[1].worldY = 40 * gp.tileSize;

        gp.obj[2] = new OBJ_Key(gp);
        gp.obj[2].worldX = 38 *gp.tileSize;
        gp.obj[2].worldY = 8 * gp.tileSize;

        gp.obj[3] = new OBJ_Door(gp);
        gp.obj[3].worldX = 13 *gp.tileSize;
        gp.obj[3].worldY = 23 * gp.tileSize;

        gp.obj[4] = new OBJ_Door(gp);
        gp.obj[4].worldX = 10 *gp.tileSize;
        gp.obj[4].worldY = 28 * gp.tileSize;

        gp.obj[5] = new OBJ_Door(gp);
        gp.obj[5].worldX = 12 *gp.tileSize;
        gp.obj[5].worldY = 12 * gp.tileSize;

        gp.obj[6] = new OBJ_Chest(gp);
        gp.obj[6].worldX = 12 *gp.tileSize;
        gp.obj[6].worldY = 8 * gp.tileSize;

        gp.obj[7] = new OBJ_Boots(gp);
        gp.obj[7].worldX = 37 *gp.tileSize;
        gp.obj[7].worldY = 42 * gp.tileSize;
    }
    public void setNPC(){
        gp.npc[0]= new NPC_OldMan(gp);
        gp.npc[0].worldX=gp.tileSize*77;
        gp.npc[0].worldY=gp.tileSize*45;
    }

    public void setEnemy(){
        gp.enem[0]= new ENEM_Slime(gp);
        gp.enem[0].worldX=gp.tileSize*75;
        gp.enem[0].worldY=gp.tileSize*50;

        gp.enem[1]= new ENEM_Slime(gp);
        gp.enem[1].worldX=gp.tileSize*70;
        gp.enem[1].worldY=gp.tileSize*55;
    }
}
