package Objects;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_SWORD_Steel extends Entity {
    public OBJ_SWORD_Steel(GamePanel gp) {
        super(gp);
        type=type_Sword;
        name= "Steel Sword";
        down1= setup("/objects/Steel_Sword",gp.tileSize,gp.tileSize);
        attackValue=3;
        attackArea.width=36;
        attackArea.height=36;
        description="["+name+"]\nAn sword made from steel.";
    }
}
