package Objects;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Heart extends Entity {

    public OBJ_Heart (GamePanel gp){
        super(gp);
        name = "Heart";
        image=setup("/objects/Heart_Full",gp.tileSize,gp.tileSize);
        image2=setup("/objects/Heart_Half",gp.tileSize,gp.tileSize);
        image3=setup("/objects/Heart_Empty",gp.tileSize,gp.tileSize);
    }
}
