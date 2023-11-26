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

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font minimalPixel2;
    BufferedImage keyImage,heart_full,heart_half,heart_empty;
    public boolean messageOn=false;
    public String message;
    public int messageCounter= 0;
    public boolean gameFinished=false;
    double playTime;
    public String currentDialoguesText ="";
    public int commandNum=0;
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
    public void showMessage(String text){
        message=text;
        messageOn=true;
    }

    public void draw(Graphics2D g2){
        this.g2=g2;
        g2.setFont(minimalPixel2);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if (gameFinished==true){
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN,40F));
            g2.setColor(Color.white);
            String text;
            int textLength;
            int x;
            int y;

            text="YOU FOUND THE TREASURE!!";
            textLength= (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();

            x = gp.screenWidth/2-(textLength/2);
            y = gp.screenHeight/2-(gp.tileSize*3);

            g2.drawString(text,x,y);

            text="Your time is: "+ df.format(playTime);
            textLength= (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();

            x = gp.screenWidth/2-(textLength/2);
            y = gp.screenHeight/2+(gp.tileSize*4);
            g2.drawString(text,x,y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD,80F));
            g2.setColor(Color.yellow);

            text="CONGRATULATIONS!!";
            textLength= (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();

            x = gp.screenWidth/2-(textLength/2);
            y = gp.screenHeight/2+(gp.tileSize*2);

            g2.drawString(text,x,y);
            /*gp.gameThread=null;*/
        }
        else {
            //Title State
            if (gp.gameState== gp.titleState){
                drawTitleScreen();
            }

            //Play State
            else if (gp.gameState==gp.playState){
                g2.setFont(g2.getFont().deriveFont(Font.PLAIN,40F));
                g2.setColor(Color.white);

                g2.drawImage(keyImage,gp.tileSize/2,gp.tileSize*2,gp.tileSize,gp.tileSize,null);
                g2.drawString("x "+gp.player.hasKey,74,gp.tileSize*3);

                //TIME
                playTime+=(double) 1/60;
                g2.drawString("Time: "+df.format(playTime),gp.tileSize*17,65);

                drawHeart();


            }
            //Pause State
            else if (gp.gameState==gp.pauseState){
                drawPause();
            }

            //Dialog State
            else if (gp.gameState==gp.dialogState){

                drawDialogScreen();
            }

            //Messages
            if (messageOn==true){
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message,gp.tileSize/2,gp.tileSize*5);
                messageCounter++;
                //Makes message disappear for a while
                if (messageCounter>120){
                    messageCounter=0;
                    messageOn=false;
                }
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
        int y= gp.tileSize/2;
        int width= gp.screenWidth -(gp.tileSize*4);
        int height= gp.tileSize *4;

        drawSubWindow(x,y,width,height);
        x+=gp.tileSize;
        y+=gp.tileSize;
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,25F));
        for(String line:currentDialoguesText.split("\n")){
            g2.drawString(line,x,y);
            y+=40;
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
