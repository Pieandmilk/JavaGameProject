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

        solidArea.x= 8;
        solidArea.y= 16;

        //recording default values
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;

        solidArea.width= 32;
        solidArea.height= 32;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX=gp.tileSize * 23;
        worldY=gp.tileSize * 21;
        speed= 4;
        direction= "down";
    }
    public void getPlayerImage(){

        up1=setup("/player/boy_up_1");
        up2=setup("/player/boy_up_2");
        down1=setup("/player/boy_down_1");
        down2=setup("/player/boy_down_2");
        left1=setup("/player/boy_left_1");
        left2=setup("/player/boy_left_2");
        right1=setup("/player/boy_right_1");
        right2=setup("/player/boy_right_2");

    }

    public void update(){
        if (keyH.upPressed== true || keyH.downPressed==true || keyH.leftPressed==true || keyH.rightPressed==true){

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

            //IF collision is false, player can move
            if (collisionOn == false){
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

            spriteCounter++;
            if(spriteCounter>12){
                if(spriteNum==1){
                    spriteNum=2;
                }
                else if (spriteNum==2){
                    spriteNum=1;
                }
                spriteCounter=0;
            }
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
        if (i != 999){
            if (gp.keyH.enterPressed==true){
                gp.gameState=gp.dialogState;
                gp.npc[i].speak();
            }
        }
        gp.keyH.enterPressed=false;
    }
    public void draw(Graphics2D g2){

        BufferedImage image = null;

        switch (direction){
            case "up":
                if(spriteNum==1){
                    image= up1;
                }
                if(spriteNum==2) {
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum==1){
                    image= down1;
                }
                if(spriteNum==2){
                    image=down2;
                }
                break;

            case "left":
                if(spriteNum==1){
                    image= left1;
                }
                if(spriteNum==2){
                    image= left2;
                }


                break;

            case "right":
                if(spriteNum==1){
                    image=right1;
                }
                if(spriteNum==2){
                    image=right2;
                }

                break;
        }
        g2.drawImage(image,screenX,screenY,null);


    }
}
