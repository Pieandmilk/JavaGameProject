package Objects;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_SHIELD extends Entity {
    public OBJ_SHIELD(GamePanel gp) {
        super(gp);
        type=type_Shield;
        name="Kite Shield ";
        down1=setup("/objects/Shield", gp.tileSize, gp.tileSize);

        defenseValue=2;
        description="["+name+"]\nA shield that can block certain attacks.";
    }
}
