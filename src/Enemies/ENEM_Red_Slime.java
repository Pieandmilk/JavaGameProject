package Enemies;

import Entity.Entity;
import Main.GamePanel;
import Objects.*;

import java.util.Random;

public class ENEM_Red_Slime extends Entity {
    GamePanel gp;

    public ENEM_Red_Slime(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type= type_Enemy;
        name="Red Slime";
        speed= 1;
        maxLifePoints = 30;
        lifePoints=maxLifePoints;
        attack=5;
        defense=0;
        exp=2;
        projectile = new OBJ_Rock(gp);


        solidArea.x=3;
        solidArea.y=18;
        solidArea.width=42;
        solidArea.height=30;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;

        getImage();


    }
    public void getImage(){
        up1=setup("/enemies/greenslime_down_1",gp.tileSize,gp.tileSize);
        up2=setup("/enemies/greenslime_down_2",gp.tileSize,gp.tileSize);
        up3=setup("/enemies/greenslime_down_1",gp.tileSize,gp.tileSize);
        down1=setup("/enemies/greenslime_down_1",gp.tileSize,gp.tileSize);
        down2=setup("/enemies/greenslime_down_2",gp.tileSize,gp.tileSize);
        down3=setup("/enemies/greenslime_down_1",gp.tileSize,gp.tileSize);
        left1=setup("/enemies/greenslime_down_1",gp.tileSize,gp.tileSize);
        left2=setup("/enemies/greenslime_down_2",gp.tileSize,gp.tileSize);
        left3=setup("/enemies/greenslime_down_1",gp.tileSize,gp.tileSize);
        right1=setup("/enemies/greenslime_down_1",gp.tileSize,gp.tileSize);
        right2=setup("/enemies/greenslime_down_2",gp.tileSize,gp.tileSize);
        right3=setup("/enemies/greenslime_down_1",gp.tileSize,gp.tileSize);

    }
    public void setAction(){
        actionLockCounter++;

        if (actionLockCounter ==120){
            Random random = new Random();
            int i = random.nextInt(100)+1; //pickup a number from one to one hundred

            if (i <= 25 ){
                direction="up";

            }
            if (i>25 && i<=50 ){
                direction="down";

            }
            if (i>50 && i<=75 ){
                direction="left";
            }
            if (i>=75 && i<=100 ){
                direction="right";
            }
            actionLockCounter=0;

        }
    }
    public void damageReaction(){
        actionLockCounter=0;
        direction=gp.player.direction;
    }
    public void checkDrop(){
        int i = new Random().nextInt(100)+1;
        if(i>1 && i <5){
            dropItem(new OBJ_Coin_Gold(gp));
        }
        if (i>=5&&i<15){
            dropItem(new OBJ_Coin_Silver(gp));
        }
        if (i>=15&&i<50){
            dropItem(new OBJ_Coin_Copper(gp));
        }
        if (i>=50 && i<75){
            dropItem(new OBJ_Heart(gp));
        }
        if (i>=75 && i<100){
            dropItem(new OBJ_Mana(gp));
        }
    }
}
