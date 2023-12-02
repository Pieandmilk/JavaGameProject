package Objects;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_Coin_Copper extends Entity {
    GamePanel gp;
    public OBJ_Coin_Copper(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type= type_PickUpOnly;
        name="Copper Coin";
        value=1;
        down1 =setup("/objects/Coin_Copper",gp.tileSize,gp.tileSize);

    }
    public void use(Entity entity){
        gp.playSE(1);
        gp.ui.addMessage("Coin +" + value);
        gp.player.coin+=value;
    }
}
