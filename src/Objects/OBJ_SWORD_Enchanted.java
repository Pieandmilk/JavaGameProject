package Objects;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_SWORD_Enchanted extends Entity {
    public OBJ_SWORD_Enchanted(GamePanel gp) {
        super(gp);
        type=type_Sword;
        name= "Enchanted Sword";
        down1= setup("/objects/Enchanted_Sword",gp.tileSize,gp.tileSize);
        attackValue=6;
        attackArea.width=36;
        attackArea.height=36;
        description="["+name+"]\nAn sword made from a enchanted materials.";
    }
}
