package Main;

import Enemies.ENEM_Rock_Elemental;
import Enemies.ENEM_Slime;
import Enemies.ENEM_Yellow_Slime;
import Entity.*;
import Objects.*;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){
        entitySetter(gp.obj,new OBJ_POTION_Healing_Small(gp),0,3,26,31);
        entitySetter(gp.obj,new OBJ_Heart(gp),0,4,61,29);
        entitySetter(gp.obj,new OBJ_Mana(gp),0,5,49,22);
        entitySetter(gp.obj,new OBJ_AXE_Bronze(gp), 0,6,79,36);
        entitySetter(gp.obj, new OBJ_SHIELD(gp),0,7,65,40);
    }
    public void setNPC(){
        entitySetter(gp.npc,new NPC_OldMan(gp),0,0,77,45);
        entitySetter(gp.npc,new NPC_PinkHair(gp),0,1,50,50);
        entitySetter(gp.npc,new NPC_WhiteHair(gp),0,2,64,50);
        entitySetter(gp.npc,new NPC_Guy1(gp),0,3,60,42);
        entitySetter(gp.npc,new NPC_WeaponSmith(gp),3,1,28,26);
        entitySetter(gp.npc,new NPC_Standing_Girl(gp),1,0,24,29);
    }

    public void setEnemy(){
        //BEACH
        entitySetter(gp.enem,new ENEM_Slime(gp), 0, 0, 53, 66);
        entitySetter(gp.enem,new ENEM_Slime(gp), 0, 1, 63, 67);
        entitySetter(gp.enem,new ENEM_Slime(gp), 0, 2, 61, 69);
        entitySetter(gp.enem,new ENEM_Slime(gp), 0, 3, 57, 71);
        entitySetter(gp.enem,new ENEM_Slime(gp), 0, 4, 64, 72);
        entitySetter(gp.enem,new ENEM_Rock_Elemental(gp), 0, 5, 59, 76);
        //SOUTH ISLAND
        entitySetter(gp.enem,new ENEM_Yellow_Slime(gp),0,6, 29, 63);
        entitySetter(gp.enem,new ENEM_Yellow_Slime(gp), 0, 7, 23, 63);
        entitySetter(gp.enem,new ENEM_Yellow_Slime(gp), 0, 8, 26, 70);
        entitySetter(gp.enem,new ENEM_Yellow_Slime(gp), 0, 9, 30, 75);
        entitySetter(gp.enem,new ENEM_Yellow_Slime(gp), 0, 10, 30, 81);
        entitySetter(gp.enem,new ENEM_Yellow_Slime(gp), 0, 11, 20, 84);
    }


    public void entitySetter(Entity[][] entities, Entity entity,int mapNum, int index, int worldX, int worldY) {
        if (index < entities.length && entity != null) {
            entities[mapNum][index] = entity;
            entities[mapNum][index].worldX = gp.tileSize*worldX;
            entities[mapNum][index].worldY = gp.tileSize*worldY;
        }
    }
}
