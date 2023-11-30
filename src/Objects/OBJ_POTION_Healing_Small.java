package Objects;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_POTION_Healing_Small extends Entity {
    GamePanel gp;
    int value= 4;
    public OBJ_POTION_Healing_Small(GamePanel gp) {
        super(gp);
        this.gp=gp;
        type= type_Consumable;
        down1=setup("/objects/Health_Potion_Small",gp.tileSize,gp.tileSize);
        name="Small Healing Potion";
        description="["+name+"]\nA potion that can heal you fairly.\nHeals for ["+value+"]";

    }
    public void use(Entity entity){
        gp.gameState=gp.dialogState;
        gp.ui.currentDialoguesText="You drinked the "+ name + " and \nhealed up "+ value+ " Health Points!!";
        entity.lifePoints+=value;
        if(gp.player.lifePoints>gp.player.maxLifePoints){
            gp.player.lifePoints=gp.player.maxLifePoints;
        }
        gp.playSE(14);
    }
}
