package Main;

import Enemies.ENEM_Rock_Elemental;
import Enemies.ENEM_Slime;
import Entity.Entity;
import Entity.NPC_OldMan;
import Objects.*;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){
        entitySetter(gp.obj,new OBJ_Key(gp),0,75,50);
        entitySetter(gp.obj,new OBJ_AXE_Bronze(gp),1,77,50);
        entitySetter(gp.obj,new OBJ_SHIELD(gp),2,75,51);
        entitySetter(gp.obj,new OBJ_POTION_Healing_Small(gp),3,75,52);
    }
    public void setNPC(){
        entitySetter(gp.npc,new NPC_OldMan(gp),0,77,45);
    }

    public void setEnemy(){
        entitySetter(gp.enem,new ENEM_Slime(gp),0,75,50);
        entitySetter(gp.enem,new ENEM_Slime(gp),1,70,55);
        entitySetter(gp.enem,new ENEM_Slime(gp),2,71,55);
        entitySetter(gp.enem,new ENEM_Slime(gp),3,72,55);
        entitySetter(gp.enem,new ENEM_Rock_Elemental(gp),4,73,55);
    }


    public void entitySetter(Entity[] entities, Entity entity, int index, int worldX, int worldY) {
        if (index < entities.length && entity != null) {
            entities[index] = entity;
            entities[index].worldX = gp.tileSize*worldX;
            entities[index].worldY = gp.tileSize*worldY;
        }
    }
}
