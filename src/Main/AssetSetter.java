package Main;

import Enemies.ENEM_Red_Slime;
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
        entitySetter(gp.npc,new NPC_Guy2(gp),0,4,24,57);
        entitySetter(gp.npc,new NPC_Guy3(gp),0,5,14,58);
        entitySetter(gp.npc,new NPC_Guy4(gp),0,6,17,64);
        entitySetter(gp.npc,new NPC_Guy5(gp),0,7,23,64);
        entitySetter(gp.npc,new NPC_Guy6(gp),0,8,30,68);
        entitySetter(gp.npc,new NPC_Guy7(gp),0,9,16,84);
        entitySetter(gp.npc,new NPC_Guy8(gp),0,10,26,82);
        entitySetter(gp.npc,new NPC_GuyGuard(gp),0,11,44,53);
        entitySetter(gp.npc,new NPC_GuyGuard(gp),0,12,57,60);
        entitySetter(gp.npc,new NPC_GuyGuard(gp),0,13,19,69);
        entitySetter(gp.npc,new NPC_OldStatiscian(gp),0,14,66,50);


        entitySetter(gp.npc,new NPC_WeaponSmith(gp),3,1,28,26);
        entitySetter(gp.npc,new NPC_WeaponSmith(gp),12,2,28,26);
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
    public void setEnemyTornament1(){
        entitySetter(gp.enem,new ENEM_Yellow_Slime(gp),10,0, 24, 28);
        entitySetter(gp.enem,new ENEM_Yellow_Slime(gp), 10, 1, 25, 27);
        entitySetter(gp.enem,new ENEM_Yellow_Slime(gp), 10, 2, 31, 27);
        entitySetter(gp.enem,new ENEM_Yellow_Slime(gp), 10, 3, 29, 28);
        entitySetter(gp.enem,new ENEM_Yellow_Slime(gp), 10, 4, 27, 28);
        entitySetter(gp.enem,new ENEM_Rock_Elemental(gp), 10, 5, 25, 31);
        entitySetter(gp.enem,new ENEM_Rock_Elemental(gp), 10, 6, 31, 31);
    }
    public void setEnemyTornament2(){
        entitySetter(gp.enem,new ENEM_Red_Slime(gp),11,0, 24, 28);
        entitySetter(gp.enem,new ENEM_Red_Slime(gp), 11, 1, 25, 27);
        entitySetter(gp.enem,new ENEM_Red_Slime(gp), 11, 2, 31, 27);
        entitySetter(gp.enem,new ENEM_Red_Slime(gp), 11, 3, 29, 28);
        entitySetter(gp.enem,new ENEM_Red_Slime(gp), 11, 4, 27, 28);
        entitySetter(gp.enem,new ENEM_Rock_Elemental(gp), 11, 5, 25, 31);
        entitySetter(gp.enem,new ENEM_Rock_Elemental(gp), 11, 6, 31, 31);
    }


    public void entitySetter(Entity[][] entities, Entity entity,int mapNum, int index, int worldX, int worldY) {
        if (index < entities.length && entity != null) {
            entities[mapNum][index] = entity;
            entities[mapNum][index].worldX = gp.tileSize*worldX;
            entities[mapNum][index].worldY = gp.tileSize*worldY;
        }
    }
}
