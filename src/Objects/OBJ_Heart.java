package Objects;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Heart extends Entity {
    GamePanel gp;

    public OBJ_Heart (GamePanel gp){
        super(gp);
        this.gp=gp;
        type=type_PickUpOnly;

        name = "Heart";
        value=2;
        down1=setup("/objects/Heart_Full",gp.tileSize,gp.tileSize);
        image=setup("/objects/Heart_Full",gp.tileSize,gp.tileSize);
        image2=setup("/objects/Heart_Half",gp.tileSize,gp.tileSize);
        image3=setup("/objects/Heart_Empty",gp.tileSize,gp.tileSize);
    }
    public void use(Entity entity){
        gp.playSE(8);
        gp.ui.addMessage("Health +" + value);
        entity.lifePoints+=value;
        if(entity.lifePoints>entity.maxLifePoints){
            entity.lifePoints=entity.maxLifePoints;
        }
    }
}
