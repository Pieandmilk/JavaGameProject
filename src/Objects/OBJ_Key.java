package Objects;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Key extends Entity {

    public OBJ_Key (GamePanel gp){
        super(gp);
        name = "Key";
        image= setup("/objects/key",gp.tileSize,gp.tileSize);
        down1=setup("/objects/key",gp.tileSize,gp.tileSize);
        description="["+name+"]\nIt might open something.";
    }
}
