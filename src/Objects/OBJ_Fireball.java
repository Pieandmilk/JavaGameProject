package Objects;

import Entity.Entity;
import Entity.Projectile;
import Main.GamePanel;

public class OBJ_Fireball extends Projectile {
    GamePanel gp;
    public OBJ_Fireball(GamePanel gp) {
        super(gp);
        this.gp=gp;
        name="Fireball";
        speed=8;
        maxLifePoints=80;
        lifePoints=maxLifePoints;
        attack=8;
        useCost=1;
        alive=false;
        getImage();
    }
    public void getImage(){
        up1=setup("/projectiles/fireball_up_1",gp.tileSize,gp.tileSize);
        up2=setup("/projectiles/fireball_up_2",gp.tileSize,gp.tileSize);
        up3=setup("/projectiles/fireball_up_3",gp.tileSize,gp.tileSize);
        down1=setup("/projectiles/fireball_down_1",gp.tileSize,gp.tileSize);
        down2=setup("/projectiles/fireball_down_2",gp.tileSize,gp.tileSize);
        down3=setup("/projectiles/fireball_down_3",gp.tileSize,gp.tileSize);
        left1=setup("/projectiles/fireball_left_1",gp.tileSize,gp.tileSize);
        left2=setup("/projectiles/fireball_left_2",gp.tileSize,gp.tileSize);
        left3=setup("/projectiles/fireball_left_3",gp.tileSize,gp.tileSize);
        right1=setup("/projectiles/fireball_right_1",gp.tileSize,gp.tileSize);
        right2=setup("/projectiles/fireball_right_2",gp.tileSize,gp.tileSize);
        right3=setup("/projectiles/fireball_right_3",gp.tileSize,gp.tileSize);

    }

    public boolean hasResource(Entity user){
        boolean haveResource=false;
        if (user.mana>=useCost){
            haveResource=true;
        }
        return haveResource;
    }

    public void subtractResource(Entity user){
        user.mana-=useCost;
    }
}
