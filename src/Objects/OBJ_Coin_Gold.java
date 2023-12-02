package Objects;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_Coin_Gold extends Entity {
    GamePanel gp;
    public OBJ_Coin_Gold(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type= type_PickUpOnly;
        name="Gold Coin";
        value=10;
        down1 =setup("/objects/Coin_Gold",gp.tileSize,gp.tileSize);

    }
    public void use(Entity entity){
        gp.playSE(1);
        gp.ui.addMessage("Coin +" + value);
        gp.player.coin+=value;
    }
}
