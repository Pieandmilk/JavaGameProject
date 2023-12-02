package Objects;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_Coin_Silver extends Entity {
    GamePanel gp;
    public OBJ_Coin_Silver(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type= type_PickUpOnly;
        name="Silver Coin";
        value=5;
        down1 =setup("/objects/Coin_Silver",gp.tileSize,gp.tileSize);

    }
    public void use(Entity entity){
        gp.playSE(1);
        gp.ui.addMessage("Coin +" + value);
        gp.player.coin+=value;
    }
}
