package Objects;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_SWORD_Wooden extends Entity {
    public OBJ_SWORD_Wooden(GamePanel gp){
        super(gp);
        type=type_Sword;
        name= "Wooden Sword";
        down1= setup("/objects/Wooden_Sword",gp.tileSize,gp.tileSize);
        attackValue=2;
        attackArea.width=36;
        attackArea.height=36;
        description="["+name+"]\nAn sword made from a rotting tree.";


    }
}
