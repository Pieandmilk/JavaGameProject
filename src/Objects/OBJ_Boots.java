package Objects;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Boots extends Entity {
    GamePanel gp;
    public OBJ_Boots (GamePanel gp){
        super(gp);
        name = "Boots";
        down1= setup("/objects/boots",gp.tileSize,gp.tileSize);

    }
}
