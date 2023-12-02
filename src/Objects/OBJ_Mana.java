package Objects;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_Mana extends Entity {
    GamePanel gp;
    public OBJ_Mana(GamePanel gp) {
        super(gp);
        this.gp=gp;
        type=type_PickUpOnly;
        value=1;
        name="Mana";
        down1=setup("/objects/Mana",gp.tileSize,gp.tileSize);
        image=setup("/objects/Mana",gp.tileSize,gp.tileSize);
        image2=setup("/objects/Mana_Empty",gp.tileSize,gp.tileSize);
    }
    public void use(Entity entity){
        gp.playSE(16);
        gp.ui.addMessage("Mana +" + value);
        entity.mana+=value;
    }
}
