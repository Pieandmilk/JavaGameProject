package Main;

import Enemies.ENEM_Rock_Elemental;
import Enemies.ENEM_Slime;
import Entity.*;
import Objects.*;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){
        entitySetter(gp.obj,new OBJ_Coin_Gold(gp),0,0,75,50);
        entitySetter(gp.obj,new OBJ_POTION_Healing_Small(gp),0,3,75,52);
        entitySetter(gp.obj,new OBJ_Heart(gp),0,4,75,53);
        entitySetter(gp.obj,new OBJ_Mana(gp),0,5,75,54);
        entitySetter(gp.obj,new OBJ_AXE_Bronze(gp), 0,6,79,36);
        entitySetter(gp.obj, new OBJ_SHIELD(gp),2,7,26,26);
    }
    public void setNPC(){
        entitySetter(gp.npc,new NPC_OldMan(gp),0,0,77,45);
        entitySetter(gp.npc,new NPC_PinkHair(gp),0,1,50,50);
        entitySetter(gp.npc,new NPC_WhiteHair(gp),0,2,64,50);
        entitySetter(gp.npc,new NPC_Guy1(gp),0,3,60,42);
        entitySetter(gp.npc,new NPC_WeaponSmith(gp),3,1,28,26);
    }

    public void setEnemy(){
        entitySetter(gp.enem,new ENEM_Slime(gp),0,0,75,50);
        entitySetter(gp.enem,new ENEM_Slime(gp),0,1,70,55);
        entitySetter(gp.enem,new ENEM_Slime(gp),0,2,71,55);
        entitySetter(gp.enem,new ENEM_Slime(gp),0,3,72,55);
        entitySetter(gp.enem,new ENEM_Rock_Elemental(gp),0,4,73,55);
    }


    public void entitySetter(Entity[][] entities, Entity entity,int mapNum, int index, int worldX, int worldY) {
        if (index < entities.length && entity != null) {
            entities[mapNum][index] = entity;
            entities[mapNum][index].worldX = gp.tileSize*worldX;
            entities[mapNum][index].worldY = gp.tileSize*worldY;
        }
    }
}
