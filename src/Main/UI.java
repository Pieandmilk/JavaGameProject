package Main;

import Objects.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;
    Font minimalPixel2_40,minimalPixel2_80B;
    BufferedImage keyImage;
    public boolean messageOn=false;
    public String message;
    public int messageCounter= 0;
    public boolean gameFinished=false;
    double playTime;
    DecimalFormat df = new DecimalFormat("#0.00");


    public UI(GamePanel gp){
        this.gp=gp;

        minimalPixel2_40=new Font("MinimalPixel2",Font.PLAIN,40);
        minimalPixel2_80B= new Font("MinimalPixel2",Font.BOLD,80);
        OBJ_Key key= new OBJ_Key(gp);
        keyImage=key.image;

    }
    public void showMessage(String text){
        message=text;
        messageOn=true;
    }

    public void draw(Graphics2D g2){

        if (gameFinished==true){
            g2.setFont(minimalPixel2_40);
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

            g2.setFont(minimalPixel2_80B);
            g2.setColor(Color.yellow);

            text="CONGRATULATIONS!!";
            textLength= (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();

            x = gp.screenWidth/2-(textLength/2);
            y = gp.screenHeight/2+(gp.tileSize*2);

            g2.drawString(text,x,y);
            /*gp.gameThread=null;*/
        }
        else {
            if (gp.gameState==1){

            g2.setFont(minimalPixel2_40);
            g2.setColor(Color.white);

            g2.drawImage(keyImage,gp.tileSize/2,gp.tileSize/2,gp.tileSize,gp.tileSize,null);
            g2.drawString("x "+gp.player.hasKey,74,65);

            //TIME
            playTime+=(double) 1/60;
            g2.drawString("Time: "+df.format(playTime),gp.tileSize*17,65);

            }
            else if (gp.gameState==2){
                g2.setFont(minimalPixel2_80B);
                g2.setColor(Color.white);

                String text="PAUSED";
                int textLength= (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();

                int x = gp.screenWidth/2-(textLength/2);
                int y = gp.screenHeight/2+(gp.tileSize*2);

                g2.drawString(text,x,y);
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
}
