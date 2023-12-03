package Entity;

import Main.GamePanel;

public class Projectile extends Entity{
    GamePanel gp;
    Entity user;
    public Projectile(GamePanel gp) {
        super(gp);
        this.gp=gp;
    }

    public void set(int currentMap,int worldX, int worldY, String direction, boolean alive, Entity user){
        gp.currentMap=currentMap;
        this.worldX=worldX;
        this.worldY=worldY;
        this.direction=direction;
        this.alive=alive;
        this.user=user;
        this.lifePoints=this.maxLifePoints;
    }
    public void update(){

        if (user == gp.player){
            int enemyIndex= gp.cChecker.checkEntity(this , gp.enem);
            if (enemyIndex!=999){
                gp.player.damageEnemy(enemyIndex,attack);
                alive=false;
            }
        }
        if(user != gp.player){
            boolean contactPlayer= gp.cChecker.checkPlayer(this);
            if(gp.player.invincibleFrames==false && contactPlayer==true ){
                damagePlayer(attack);
                alive=false;
            }
        }

        switch (direction){
            case "up":
                worldY -= speed;
                break;
            case "down":
                worldY += speed;
                break;
            case "left":
                worldX-= speed;
                break;
            case "right":
                worldX+= speed;
                break;
        }
        lifePoints--;
        if (lifePoints<=0){
            alive=false;
        }
        spriteCounter++;
        if(spriteCounter>12){
            if(spriteNum==1){
                spriteNum=2;
            }
            else if (spriteNum==2){
                spriteNum=3;
            }
            else if (spriteNum==3){
                spriteNum=1;
            }
            spriteCounter=0;
        }
    }
    public boolean hasResource(Entity user){
        boolean haveResource=false;
        return haveResource;
    }
    public void subtractResource(Entity user){
    }
}
