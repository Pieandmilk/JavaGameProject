package Entity;

import Main.GamePanel;
import Main.KeyHandler;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public int hasKey=0;


    //Player_One Constructor
    public Player(GamePanel gp, KeyHandler keyH){
        super(gp);//Calling the constructor of class

        this.keyH= keyH;

        // PLACING CHARACTER AT THE CENTER OF THE SCREEN
        screenX= gp.screenWidth/2- (gp.tileSize/2);
        screenY= gp.screenHeight/2- (gp.tileSize/2);

        solidArea = new Rectangle();

        solidArea.x= 14;
        solidArea.y= 16;

        solidArea.width= 20;
        solidArea.height= 32;
        //recording default values
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;

        attackArea.width= 36;
        attackArea.height= 36;

        setDefaultValues();
        getPlayerImage();
        getPlayerAttackImage();
    }
    public void setDefaultValues(){
        worldX=gp.tileSize * 77;
        worldY=gp.tileSize * 44;
        speed= 4;
        direction= "down";

        //Player Status
        maxLifePoints=10;
        lifePoints=maxLifePoints;
    }
    public void getPlayerImage(){

        up1=setup("/player/player_up1",gp.tileSize,gp.tileSize);
        up2=setup("/player/player_up2",gp.tileSize,gp.tileSize);
        up3=setup("/player/player_up3",gp.tileSize,gp.tileSize);
        down1=setup("/player/player_down1",gp.tileSize,gp.tileSize);
        down2=setup("/player/player_down2",gp.tileSize,gp.tileSize);
        down3=setup("/player/player_down3",gp.tileSize,gp.tileSize);
        left1=setup("/player/player_left1",gp.tileSize,gp.tileSize);
        left2=setup("/player/player_left2",gp.tileSize,gp.tileSize);
        left3=setup("/player/player_left3",gp.tileSize,gp.tileSize);
        right1=setup("/player/player_right1",gp.tileSize,gp.tileSize);
        right2=setup("/player/player_right2",gp.tileSize,gp.tileSize);
        right3=setup("/player/player_right3",gp.tileSize,gp.tileSize);

    }

    public void getPlayerAttackImage(){
        attackUp1=setup("/player/player_attack_up_1",gp.tileSize,gp.tileSize*2);
        attackUp2=setup("/player/player_attack_up_2",gp.tileSize,gp.tileSize*2);
        attackUp3=setup("/player/player_attack_up_1",gp.tileSize,gp.tileSize*2);
        attackDown1=setup("/player/player_attack_down_1",gp.tileSize,gp.tileSize*2);
        attackDown2=setup("/player/player_attack_down_2",gp.tileSize,gp.tileSize*2);
        attackDown3=setup("/player/player_attack_down_2",gp.tileSize,gp.tileSize*2);
        attackLeft1=setup("/player/player_attack_left_1",gp.tileSize*2,gp.tileSize);
        attackLeft2=setup("/player/player_attack_left_2",gp.tileSize*2,gp.tileSize);
        attackLeft3=setup("/player/player_attack_left_1",gp.tileSize*2,gp.tileSize);
        attackRight1=setup("/player/player_attack_right_1",gp.tileSize*2,gp.tileSize);
        attackRigth2=setup("/player/player_attack_right_2",gp.tileSize*2,gp.tileSize);
        attackRight3=setup("/player/player_attack_right_3",gp.tileSize*2,gp.tileSize);

    }

    public void update(){
        if (attacking== true){
            attacking();
        }

        else if (keyH.upPressed== true || keyH.downPressed==true || keyH.leftPressed==true || keyH.rightPressed==true || keyH.enterPressed==true ||keyH.ePressed==true){

            if (keyH.upPressed==true){
                direction="up";

            }
            else if (keyH.downPressed == true){
                direction="down";

            }
            else if (keyH.leftPressed==true){
                direction="left";

            }
            else if (keyH.rightPressed==true) {
                direction="right";

            }
            // Check tile collision
            collisionOn=false;
            gp.cChecker.checkTile(this);


            //Check object collision
            int objIndex=gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            //Check npc collision
            int npcIndex=gp.cChecker.checkEntity(this, gp.npc);
            InteractNPC(npcIndex);

            //Check enemy collision
            int enemyIndex=gp.cChecker.checkEntity(this,gp.enem);
            contactEnemy(enemyIndex);

            //Check eventRect collision
            gp.eHandler.checkEvent();


            //IF collision is false, player can move
            if (collisionOn == false && keyH.enterPressed==false){
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
            }
            gp.keyH.enterPressed=false;
            gp.keyH.ePressed=false;

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

        if (invincibleFrames==true){
            invincibleCounter++;
            if(invincibleCounter>60){
                invincibleFrames=false;
                invincibleCounter=0;
            }
        }
    }
    public void attacking(){
        spriteCounter++;
        if (spriteCounter<=5){
            spriteNum=1;
        }
        if (spriteCounter >5 && spriteCounter<=25){
            spriteNum=2;
            //Save current Wolrd X and Y, Solidarea
            int currentWorldX= worldX;
            int currentWorldY= worldY;

            //Attack Area becomes solid
            int solidAreaWidth= solidArea.width;
            int solidAreaHeight= solidArea.height;


            //Adjust player's world xy for attacks
            switch (direction){
                case "up":
                    worldY-= attackArea.height;
                    break;
                case "down":
                    worldY+= attackArea.height;
                    break;
                case "left":
                    worldX-=attackArea.width;
                    break;
                case "right":
                    worldX+=attackArea.width;
                    break;
            }

            solidArea.width=attackArea.width;
            solidArea.height=attackArea.height;

            //Checks enemy collision with the updated worldX worldY and solidArea
            int enemyIndex = gp.cChecker.checkEntity(this,gp.enem);
            damageEnemy(enemyIndex);

            //After Checking collision, restore the original data
            worldX= currentWorldX;
            worldY= currentWorldY;
            solidArea.width= solidAreaWidth;
            solidArea.height= solidAreaHeight;

        }
        if (spriteCounter>25 && spriteCounter<=30){
            spriteNum=3;
        }
        if (spriteCounter>30){
            spriteNum=1;
            spriteCounter=0;
            attacking=false;
        }

    }

    public void pickUpObject(int i){
        //indicating that it touch an object
        if (i != 999){
            String objectName = gp.obj[i].name;
            switch (objectName){
                case "Key":
                    gp.playSE(1);
                    hasKey++;
                    gp.obj[i]= null;//object will disappear when touch
                    gp.ui.showMessage("You got a key!");
                    break;
                case "Door":
                    if(hasKey>0){
                        gp.playSE(3);
                        gp.obj[i]= null;//object will disappear when touch
                        System.out.println("Speed:" + speed);
                        hasKey--;
                        gp.ui.showMessage("You opened a door!");

                    }else{
                        gp.ui.showMessage("You need a key!");
                    }break;
                case "Boots":
                    gp.playSE(2);
                    speed +=2;
                    System.out.println("Speed:" + speed);
                    gp.obj[i]= null;
                    gp.ui.showMessage("You pick up magic boots!");
                    break;
                case "Chest":
                    gp.ui.gameFinished=true;
                    gp.stopMusic();
                    gp.playSE(4);
                    break;
            }
        }
    }

    public void InteractNPC(int i){
        if (gp.keyH.enterPressed==true){
            if (i != 999){
                gp.gameState=gp.dialogState;
                gp.npc[i].speak();
            }
            else{
                gp.playSE(7);
                attacking = true;
            }
        }
    }

    public void contactEnemy(int i){
        if (i!=999){
            if(invincibleFrames==false){
                gp.playSE(6);
                lifePoints-=1;
                invincibleFrames=true;

            }
        }
    }

    public void damageEnemy(int i){
        if (i!=999){
            if(gp.enem[i].invincibleFrames == false){
                gp.enem[i].damageReaction();
                gp.playSE(5);
                gp.enem[i].lifePoints -=1;
                gp.enem[i].invincibleFrames = true;

                if (gp.enem[i].lifePoints<=0){
                    gp.enem[i].dying=true;
                }
            }
        }
    }
    public void draw(Graphics2D g2){

        BufferedImage image = null;
        int tempScreenX=screenX;
        int tempScreenY=screenY;

        switch (direction){
            case "up":
                if (attacking== false){

                    if(spriteNum==1){
                        image= up1;
                    }
                    if(spriteNum==2) {
                        image = up2;
                    }
                    if(spriteNum==3) {
                        image = up3;
                    }
                }
                if (attacking== true){
                    tempScreenY=screenY-gp.tileSize;
                    if(spriteNum==1){
                        image= attackUp1;
                    }
                    if(spriteNum==2) {
                        image = attackUp2;
                    }
                    if(spriteNum==3) {
                        image = attackUp3;
                    }
                }
                break;
            case "down":
                if (attacking==false){
                    if(spriteNum==1){
                        image= down1;
                    }
                    if(spriteNum==2){
                        image=down2;
                    }
                    if(spriteNum==3){
                        image= down3;
                    }
                }
                if (attacking== true){
                    if(spriteNum==1){
                        image= attackDown1;
                    }
                    if(spriteNum==2) {
                        image = attackDown2;
                    }
                    if(spriteNum==3) {
                        image = attackDown3;
                    }
                }

                break;

            case "left":
                if (attacking==false){
                    if(spriteNum==1){
                        image= left1;
                    }
                    if(spriteNum==2){
                        image= left2;
                    }
                    if(spriteNum==3){
                        image= left3;
                    }
                }
                if (attacking== true){
                    tempScreenX= screenX-gp.tileSize;
                    if(spriteNum==1){
                        image= attackLeft1;
                    }
                    if(spriteNum==2) {
                        image = attackLeft2;
                    }
                    if(spriteNum==3) {
                        image = attackLeft3;
                    }
                }

                break;

            case "right":
                if (attacking==false){
                    if(spriteNum==1){
                        image=right1;
                    }
                    if(spriteNum==2){
                        image=right2;
                    }
                    if(spriteNum==3){
                        image=right3;
                    }
                }
                if (attacking== true){
                    if(spriteNum==1){
                        image= attackRight1;
                    }
                    if(spriteNum==2) {
                        image = attackRigth2;
                    }
                    if(spriteNum==3) {
                        image = attackRight3;
                    }
                }

                break;
        }
        if (invincibleFrames==true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }
        g2.drawImage(image,tempScreenX,tempScreenY,null);

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }


}
