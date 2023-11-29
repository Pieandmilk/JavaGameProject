package Entity;

//This stores variables that will be used in player, monster and NPC classes.
// Also, This is the Parent Class

import Main.AssetSetter;
import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Entity {
    GamePanel gp;
    public boolean collision = false;



    public BufferedImage up1, up2,up3, down1, down2,down3, left1, left2,left3, right1, right2,right3;
    public BufferedImage attackUp1, attackUp2, attackUp3, attackDown1, attackDown2,attackDown3, attackLeft1, attackLeft2,attackLeft3, attackRight1,attackRigth2,attackRight3;
    public BufferedImage image, image2,image3;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public Rectangle attackArea= new Rectangle(0,0,0,0);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public String dialogues[] = new String[20];


    //STATE
    public int worldX,worldY;
    public String direction="down";
    public int dialogueIndex=0;
    public int spriteNum=1;
    public boolean collisionOn = false;
    public boolean invincibleFrames= false;
    public boolean attacking = false;
    public boolean alive=true;
    public boolean dying=false;
    public boolean hpBarOn=false;


    //Counters
    public int spriteCounter = 0;
    public int actionLockCounter=0;
    public int invincibleCounter=0;
    public int dyingCounter=0;
    public int hpBarCounter=0;
    public int respawnCounter=0;

    //Attributes
    public int type;
    public String name;
    public int speed;
    public int level;
    public int strength;
    public int attack;
    public int dexterity;
    public int defense;
    public int exp;
    public int nextLevelExp;
    public int coin;
    public Entity currentWeapon;
    public Entity currentShield;
    public int maxLifePoints;
    public int lifePoints;

    //ITEM ATTRIBUTES
    public int attackValue;
    public int defenseValue;
    public String description="";


    public Entity(GamePanel gp){
        this.gp=gp;

    }
    public void setAction(){}
    public void damageReaction(){}


    public void speak(){
        if (dialogues[dialogueIndex]== null){
            dialogueIndex=0;
        }
        gp.ui.currentDialoguesText= dialogues[dialogueIndex];
        dialogueIndex++;

        switch (gp.player.direction){
            case "up":
                direction="down";
                break;
            case "down":
                direction= "up";
                break;
            case "left":
                direction= "right";
                break;
            case "right":
                direction="left";
                break;
        }
    };
    public void update(){
        setAction();
        collisionOn=false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkEntity(this, gp.npc);
        gp.cChecker.checkEntity(this, gp.enem);
        boolean contactPlayer =gp.cChecker.checkPlayer(this);

        if (this.type==2 && contactPlayer==true){
            if (gp.player.invincibleFrames==false){
                gp.playSE(6);
                int damage=attack-gp.player.defense;
                if (damage<0){
                    damage=0;
                }
                gp.player.lifePoints-=damage;
                gp.player.invincibleFrames=true;
            }
        }


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
                spriteNum=3;
            }
            else if (spriteNum==3){
                spriteNum=1;
            }
            spriteCounter=0;
        }

        if (invincibleFrames==true){
            invincibleCounter++;
            respawnCounter=0;

            if(invincibleCounter>40){
                invincibleFrames=false;
                invincibleCounter=0;
            }

        }


    }

    public void draw(Graphics2D g2){
        BufferedImage image = null;
        int screenX= worldX- gp.player.worldX + gp.player.screenX;
        int screenY= worldY- gp.player.worldY + gp.player.screenY;

        //Rendering only the screen is showing
        if (worldX + gp.tileSize> gp.player.worldX - gp.player.screenX &&
                worldX- gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY+ gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY- gp.tileSize < gp.player.worldY + gp.player.screenY){
            switch (direction){
                case "up":
                    if(spriteNum==1){
                        image= up1;
                    }
                    if(spriteNum==2) {
                        image = up2;
                    }
                    if(spriteNum==3) {
                        image = up3;
                    }
                    break;
                case "down":
                    if(spriteNum==1){
                        image= down1;
                    }
                    if(spriteNum==2){
                        image=down2;
                    }
                    if(spriteNum==3){
                        image=down3;
                    }
                    break;

                case "left":
                    if(spriteNum==1){
                        image= left1;
                    }
                    if(spriteNum==2){
                        image= left2;
                    }
                    if(spriteNum==3){
                        image= left3;
                    }


                    break;

                case "right":
                    if(spriteNum==1){
                        image=right1;
                    }
                    if(spriteNum==2){
                        image=right2;
                    }
                    if(spriteNum==3){
                        image=right3;
                    }

                    break;
            }

            //Enemy Health Bar
            if (type==2 && hpBarOn == true){
                double oneScale =(double)gp.tileSize/maxLifePoints;//Finds the length of the bar
                double hpBarValue=oneScale*lifePoints;

                g2.setColor(new Color(35, 35, 35));
                g2.fillRect(screenX-2,screenY-17,gp.tileSize+3,13);
                g2.setColor(new Color(255,0,30));
                g2.fillRect(screenX,screenY-15,(int)hpBarValue,10);

                hpBarCounter++;
                if (hpBarCounter>600){
                    hpBarCounter=0;
                    hpBarOn=false;
                }
            }



            if (invincibleFrames==true){
                hpBarOn=true;
                hpBarCounter=0;

                changeAlpha(g2,0.4F);
            }
            if (dying== true){
                dyingAnimation(g2);

            }
            g2.drawImage(image, screenX , screenY, gp.tileSize, gp.tileSize, null);
            changeAlpha(g2,1F);
        }
    }
    public void dyingAnimation(Graphics2D g2){
        dyingCounter++;
        int i = 5;

        if (dyingCounter<=i){

            changeAlpha(g2,0F);
        }
        if (dyingCounter>i && dyingCounter<=i*2){

            changeAlpha(g2,1F);
        }
        if (dyingCounter>i*2 && dyingCounter<=i*3){

            changeAlpha(g2,0F);
        }
        if (dyingCounter>i*3 && dyingCounter<=i*4){

            changeAlpha(g2,1F);
        }
        if (dyingCounter>i*4 && dyingCounter<=i*5){

            changeAlpha(g2,0F);
        }
        if (dyingCounter>i*5 && dyingCounter<=i*6){

            changeAlpha(g2,1F);
        }
        if (dyingCounter>i*6 && dyingCounter<=i*7){

            changeAlpha(g2,0F);
        }
        if (dyingCounter>i*7 && dyingCounter<=i*8){

            changeAlpha(g2,1F);
        }
        if (dyingCounter>i*8){
            dying=false;
            alive=false;
        }

    }

    public void changeAlpha(Graphics2D g2, float alphaValue){
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
    }

    public BufferedImage setup(String imagePath,int width, int height){
        UtilityTool uTool = new UtilityTool();
        BufferedImage image= null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image= uTool.scaledImage(image,width,height);
        }catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }
}
