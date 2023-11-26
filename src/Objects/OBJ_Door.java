package Objects;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Door extends Entity {

    public OBJ_Door (GamePanel gp){
        super(gp);
        name = "Door";
        down1=setup("/objects/door",gp.tileSize,gp.tileSize);
        collision=true;
    }
}
