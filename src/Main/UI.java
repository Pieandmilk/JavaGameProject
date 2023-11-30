package Main;

import Entity.Entity;
import Objects.OBJ_Heart;
import Objects.OBJ_Key;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font minimalPixel2;
    BufferedImage keyImage,heart_full,heart_half,heart_empty;
    public boolean messageOn=false;
    ArrayList<String> message = new ArrayList<>();
    ArrayList<Integer> messageCounter = new ArrayList<>();
    public boolean gameFinished=false;
    public String currentDialoguesText ="";
    public int commandNum=0;
    public int slotCol=0;
    public int slotRow=0;
    DecimalFormat df = new DecimalFormat("#0.00");


    public UI(GamePanel gp){
        this.gp=gp;

        try {
            InputStream is =getClass().getResourceAsStream("/font/MinimalPixel v2.ttf");
            minimalPixel2=Font.createFont(Font.TRUETYPE_FONT,is);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        OBJ_Key key= new OBJ_Key(gp);
        keyImage=key.image;

        //Create Hud object
        Entity heart = new OBJ_Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_empty = heart.image3;

    }

    public void addMessage(String text){
        message.add(text);
        messageCounter.add(0);
    }

    public void draw(Graphics2D g2){
        this.g2=g2;
        g2.setFont(minimalPixel2);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if (gameFinished==true){
            //finishing game
        }
        else {
            //Title State
            if (gp.gameState== gp.titleState){
                drawTitleScreen();
            }

            //Play State
            else if (gp.gameState==gp.playState){
                drawHeart();
                drawMessage();
            }
            //Pause State
            else if (gp.gameState==gp.pauseState){
                drawPause();
            }

            //Dialog State
            else if (gp.gameState==gp.dialogState){

                drawDialogScreen();
            }

            //Character State
            else if (gp.gameState==gp.characterState) {
                drawCharacterScreen();
                drawInventoryScreen();
            }

        }

    }
    public void drawTitleScreen(){

        //BackGround
        try {
            BufferedImage bg = ImageIO.read(getClass().getResourceAsStream("/background/title.png"));
            g2.drawImage(bg,0,0,gp.screenWidth, gp.screenHeight, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Title Name
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,80F));

        String text= "CASINO CHRONICLES";
        int x = getXforCenterOfScreen(text);
        int y = gp.screenHeight/2-(gp.tileSize*4);

        //Shadow
        g2.setColor(Color.black);
        g2.drawString(text,x+5,y+5);
        //main color
        g2.setColor(Color.white);
        g2.drawString(text,x,y);

        //MENU
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,30F));
        text="NEW GAME";
        x = getXforCenterOfScreen(text);
        y = gp.screenHeight/2-gp.tileSize;
        g2.setColor(Color.black);
        g2.drawString(text,x+5,y+5);
        g2.setColor(Color.white);
        g2.drawString(text,x,y);

        if(commandNum==0){
            g2.drawString(">",x-(gp.tileSize/2),y);
        }

        text="LOAD GAME";
        x = getXforCenterOfScreen(text);
        y += gp.tileSize;
        g2.setColor(Color.black);
        g2.drawString(text,x+5,y+5);
        g2.setColor(Color.white);
        g2.drawString(text,x,y);

        if(commandNum==1){
            g2.drawString(">",x-(gp.tileSize/2),y);
        }

        text="QUIT";
        x = getXforCenterOfScreen(text);
        y += gp.tileSize;
        g2.setColor(Color.black);
        g2.drawString(text,x+5,y+5);
        g2.setColor(Color.white);
        g2.drawString(text,x,y);

        if(commandNum==2){
            g2.drawString(">",x-(gp.tileSize/2),y);
        }
    }

    public void drawPause(){

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        g2.setColor(Color.white);

        String text="PAUSED";

        int x = getXforCenterOfScreen(text);
        int y = gp.screenHeight/2;

        g2.drawString(text,x,y);
    }

    public void drawDialogScreen(){
        //Window
        int x= gp.tileSize*2;
        int y= (gp.screenHeight/2)+90;
        int width= gp.screenWidth -(gp.tileSize*4);
        int height= gp.tileSize *3;

        drawSubWindow(x,y,width,height);
        x+=gp.tileSize;
        y+=gp.tileSize;
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,25F));
        for(String line:currentDialoguesText.split("\n")){
            g2.drawString(line,x,y);
            y+=40;
        }

    }

    public void drawCharacterScreen(){
        //Draw Frame
        final int frameX = gp.tileSize;
        final int frameY = gp.tileSize;
        final int frameWidth= gp.tileSize * 5;
        final int frameHeight= gp.tileSize *10;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);

        //Text
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,22F));

        int textX=frameX+20;
        int textY=frameY+gp.tileSize;
        final int lineHeight=35;

        //Names

        g2.drawString("Level",textX,textY);
        textY+=lineHeight;
        g2.drawString("Life", textX,textY);
        textY+=lineHeight;
        g2.drawString("Strength",textX,textY);
        textY+=lineHeight;
        g2.drawString("Dexterity", textX,textY);
        textY+=lineHeight;
        g2.drawString("Attack",textX,textY);
        textY+=lineHeight;
        g2.drawString("Defense", textX,textY);
        textY+=lineHeight;
        g2.drawString("EXP",textX,textY);
        textY+=lineHeight;
        g2.drawString("Next Level", textX,textY);
        textY+=lineHeight;
        g2.drawString("Coin",textX,textY);
        textY+=lineHeight+20;
        g2.drawString("Weapon", textX,textY);
        textY+=lineHeight+20;
        g2.drawString("Shield", textX,textY);

        //Values
        int tailX=(frameX+frameWidth)-30;
        //Reset textY
        textY=frameY+gp.tileSize;
        String value;

        value=String.valueOf(gp.player.level);
        textX=getXforAlignRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value=String.valueOf(gp.player.lifePoints+"/"+gp.player.maxLifePoints);
        textX=getXforAlignRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value=String.valueOf(gp.player.strength);
        textX=getXforAlignRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value=String.valueOf(gp.player.dexterity);
        textX=getXforAlignRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value=String.valueOf(gp.player.attack);
        textX=getXforAlignRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value=String.valueOf(gp.player.defense);
        textX=getXforAlignRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value=String.valueOf(gp.player.exp);
        textX=getXforAlignRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value=String.valueOf(gp.player.nextLevelExp);
        textX=getXforAlignRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value=String.valueOf(gp.player.coin);
        textX=getXforAlignRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        g2.drawImage(gp.player.currentWeapon.down1,tailX-gp.tileSize,textY-15,null);
        textY+=48;
        g2.drawImage(gp.player.currentShield.down1,tailX-gp.tileSize,textY-10,null);
    }

    public void drawInventoryScreen(){

        //Frame
        int frameX=gp.tileSize*10;
        int frameY=gp.tileSize;
        int frameWidth=gp.tileSize*11;
        int frameHeight=gp.tileSize*6;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);
        //Slot
        final int slotXstart= frameX+20;
        final int slotYstart= frameY+20;
        int slotX=slotXstart;
        int slotY=slotYstart;
        int slotSize=gp.tileSize+2;

        //Draws player's item
        for (int i=0;i< gp.player.inventory.size();i++){
            //Draw Equip Cursor
            if(gp.player.inventory.get(i)==(gp.player.currentWeapon) || gp.player.inventory.get(i)==(gp.player.currentShield)){

                g2.setColor(new Color(240,190,90));
                g2.fillRoundRect(slotX,slotY,gp.tileSize,gp.tileSize,10,10);
            }
            g2.drawImage(gp.player.inventory.get(i).down1,slotX,slotY,null);
            slotX+=slotSize;

            if (i == 9 || i ==19 || i==29 || i ==39 || i==49){
                slotX=slotXstart;
                slotY+=slotSize;
            }
        }


        //Cursor
        int cursorX= slotXstart + (slotSize*slotCol);
        int cursorY= slotYstart + (slotSize*slotRow);
        int cursorWidth=gp.tileSize;
        int cursorHeight=gp.tileSize;

        //Draw Cursor
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorX,cursorY,cursorWidth,cursorHeight,10,10);

        //Description Frame
        int dFrameX=frameX;
        int dFrameY=frameY+frameHeight;
        int dFrameWidth=frameWidth;
        int dFrameHeight=gp.tileSize*4;


        //Draw Description text;
        int textX=dFrameX+20;
        int textY=dFrameY+gp.tileSize;
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,22F));

        int itemIndex= getItemIndexOnSlot();

        if (itemIndex < gp.player.inventory.size()){
            drawSubWindow(dFrameX,dFrameY,dFrameWidth,dFrameHeight);
            for(String line: gp.player.inventory.get(itemIndex).description.split("\n")){
                g2.drawString(line,textX,textY);
                textY +=32;
            }
        }
    }
    public int getItemIndexOnSlot(){
        int itemIndex=slotCol+(slotRow*10);
        return itemIndex;
    }

    public void drawMessage(){
        int messageX =gp.tileSize;
        int messageY =gp.tileSize*4;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,22F));
        for(int i=0; i<message.size();i++){
            if (message.get(i) !=null){
                g2.setColor(Color.black);
                g2.drawString(message.get(i),messageX+5,messageY+5);
                g2.setColor(Color.white);
                g2.drawString(message.get(i),messageX,messageY);

                int counter = messageCounter.get(i) + 1;//messageCounter++
                messageCounter.set(i,counter); //set the counter to the array
                messageY+=50;

                if (messageCounter.get(i)>120){
                    message.remove(i);
                    messageCounter.remove(i);
                }
            }
        }
    }



    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color(0, 0, 0,200);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35,35);

        c =new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5,y+5,width-10,height-10,25,25);
    }

    public int getXforCenterOfScreen(String text){
        int textLength= (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();

        int x = gp.screenWidth/2-(textLength/2);
        return x;
    }
    public int getXforAlignRightText(String text,int tailX){
        int textLength= (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();

        int x = tailX-textLength;
        return x;
    }


    public void drawHeart(){
        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i=0;
        //DRAWS MAX HEARTS
        while(i<gp.player.maxLifePoints/2){
            g2.drawImage(heart_empty,x,y,null);
            i++;
            x+=gp.tileSize;
        }

        x = gp.tileSize/2;
        y = gp.tileSize/2;
        i=0;
        //DRAW CURRENT HEARTS
        while(i<gp.player.lifePoints){
            g2.drawImage(heart_half,x,y,null);
            i++;
            if(i <gp.player.lifePoints){
                g2.drawImage(heart_full,x,y,null);
            }
            i++;
            x += gp.tileSize;
        }

    }
}
