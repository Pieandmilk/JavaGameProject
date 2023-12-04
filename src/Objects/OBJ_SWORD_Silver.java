package Objects;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_SWORD_Silver extends Entity {
    public OBJ_SWORD_Silver(GamePanel gp) {
        super(gp);
        type=type_Sword;
        name= "Silver Sword";
        down1= setup("/objects/Silver_Sword",gp.tileSize,gp.tileSize);
        attackValue=4;
        attackArea.width=36;
        attackArea.height=36;
        description="["+name+"]\nAn sword made from a shiny metal.";
    }
}
