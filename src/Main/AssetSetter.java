package Main;

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

    }
    public void setNPC(){
        entitySetter(gp.npc,new NPC_OldMan(gp),0,gp.tileSize*77,gp.tileSize*45);
    }

    public void setEnemy(){
        entitySetter(gp.enem,new ENEM_Slime(gp),0,gp.tileSize*75,gp.tileSize*50);
        entitySetter(gp.enem,new ENEM_Slime(gp),1,gp.tileSize*70,gp.tileSize*55);
        entitySetter(gp.enem,new ENEM_Slime(gp),2,gp.tileSize*71,gp.tileSize*55);
        entitySetter(gp.enem,new ENEM_Slime(gp),3,gp.tileSize*72,gp.tileSize*55);
        entitySetter(gp.enem,new ENEM_Slime(gp),4,gp.tileSize*73,gp.tileSize*55);
    }


    public void entitySetter(Entity[] entities, Entity entity, int index, int worldX, int worldY) {
        if (index < entities.length && entity != null) {
            entities[index] = entity;
            entities[index].worldX = worldX;
            entities[index].worldY = worldY;
        }
    }
}
