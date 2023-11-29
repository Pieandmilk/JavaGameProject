package Objects;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_AXE_Bronze extends Entity {
    public OBJ_AXE_Bronze(GamePanel gp) {
        super(gp);
        type=type_Axe;
        name="Bronze Axe";
        down1=setup("/objects/Bronze_Axe",gp.tileSize,gp.tileSize);
        attackArea.width=30;
        attackArea.height=30;
        attackValue=4;
        description="["+name+"]\nAn woodcutter's axe.";
    }
}
