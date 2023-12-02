package Objects;

import Entity.Entity;
import Entity.Projectile;
import Main.GamePanel;

public class OBJ_Rock extends Projectile {
    GamePanel gp;
    public OBJ_Rock(GamePanel gp) {
        super(gp);
        this.gp=gp;
        name="Rock";
        speed=6;
        maxLifePoints=80;
        lifePoints=maxLifePoints;
        attack=2;
        useCost=1;
        alive=false;
        getImage();
    }
    public void getImage(){
        up1=setup("/projectiles/rock",gp.tileSize,gp.tileSize);
        up2=setup("/projectiles/rock",gp.tileSize,gp.tileSize);
        up3=setup("/projectiles/rock",gp.tileSize,gp.tileSize);
        down1=setup("/projectiles/rock",gp.tileSize,gp.tileSize);
        down2=setup("/projectiles/rock",gp.tileSize,gp.tileSize);
        down3=setup("/projectiles/rock",gp.tileSize,gp.tileSize);
        left1=setup("/projectiles/rock",gp.tileSize,gp.tileSize);
        left2=setup("/projectiles/rock",gp.tileSize,gp.tileSize);
        left3=setup("/projectiles/rock",gp.tileSize,gp.tileSize);
        right1=setup("/projectiles/rock",gp.tileSize,gp.tileSize);
        right2=setup("/projectiles/rock",gp.tileSize,gp.tileSize);
        right3=setup("/projectiles/rock",gp.tileSize,gp.tileSize);

    }
    public boolean hasResource(Entity user){
        boolean haveResource=false;
        if (user.ammo>=useCost){
            haveResource=true;
        }
        return haveResource;
    }

    public void subtractResource(Entity user){
        user.ammo-=useCost;
    }
}
