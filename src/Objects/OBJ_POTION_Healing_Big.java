package Objects;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_POTION_Healing_Big extends Entity {
    GamePanel gp;

    public OBJ_POTION_Healing_Big(GamePanel gp) {
        super(gp);
        this.gp=gp;
        type= type_Consumable;
        value= 8;
        down1=setup("/objects/Health_Potion_Big",gp.tileSize,gp.tileSize);
        name="Big Healing Potion";
        description="["+name+"]\nA potion that can heal you greatly.\nHeals for ["+value+"]";

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
