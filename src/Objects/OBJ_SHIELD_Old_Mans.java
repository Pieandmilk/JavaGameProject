package Objects;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_SHIELD_Old_Mans extends Entity {
    public OBJ_SHIELD_Old_Mans(GamePanel gp) {
        super(gp);

        name="Old man's shield";
        down1=setup("/objects/Old_Man's_Shield", gp.tileSize, gp.tileSize);

        defenseValue=1;
        description="["+name+"]\nA shield that came from an old man.";
    }
}
