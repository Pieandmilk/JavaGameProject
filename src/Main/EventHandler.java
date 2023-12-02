package Main;

public class EventHandler {
    GamePanel gp;
    EventRect eventRect[][];

    int previousEventX,previousEventY;
    boolean canTouchEvent = false;


    public  EventHandler (GamePanel gp){
        this.gp=gp;
        eventRect= new EventRect[gp.maxWorldCol][gp.maxWorldRow];

        int col=0;
        int row=0;

        while (col< gp.maxWorldCol && row< gp.maxWorldRow){
            eventRect [col][row]= new EventRect();
            eventRect[col][row].x= 23;
            eventRect[col][row].y=23;
            eventRect[col][row].width=2;
            eventRect[col][row].height=2;
            eventRect[col][row].eventRectDefaultX= eventRect[col][row].x;
            eventRect[col][row].eventRectDefaultY= eventRect[col][row].y;

            col++;
            if (col== gp.maxWorldCol){
                col=0;
                row++;
            }
        }



    }

    public void checkEvent(){
        // Check if the player character is more than 1 tile away from the last event
        int xDistance= Math.abs(gp.player.worldX- previousEventX);
        int yDistance= Math.abs(gp.player.worldY- previousEventY);
        int distance= Math.max(xDistance,yDistance);
        if (distance> gp.tileSize){
            canTouchEvent = true;
        }
        if (canTouchEvent==true){
            if (hit(27,16,"right")==true){
                damagePit(27,16,gp.dialogState);
            }
            if (hit(64,55,"any")==true){
                rejuvenatingWaters(64,55,gp.dialogState);
            }
            //SAILING
            if (hit(7,46,"any")==true){
                sailBoatSouth(7,46,gp.dialogState);
            }
            if (hit(61,79,"any")==true){
                sailBoatNorth(61,79,gp.dialogState);
            }

        }

    }
    public boolean hit(int col, int row, String reqDirection){
        boolean hit = false;
        //Getting current player solid area pos
        gp.player.solidArea.x=gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y=gp.player.worldY + gp.player.solidArea.y;

        //Getting eventRect solid area position
        eventRect[col][row].x= col*gp.tileSize+ eventRect[col][row].x;
        eventRect[col][row].y= row*gp.tileSize+ eventRect[col][row].y;

        if (gp.player.solidArea.intersects(eventRect[col][row] )&& eventRect[col][row].eventDone==false){
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;

                previousEventX = gp.player.worldX;
                previousEventY = gp.player.worldY;
            }
        }

        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect[col][row].x=eventRect[col][row].eventRectDefaultX;
        eventRect[col][row].y=eventRect[col][row].eventRectDefaultY;

        return hit;
    }

    public void damagePit(int col,int row,int gameState){
        gp.gameState=gameState;
        gp.ui.currentDialoguesText= "You fell in a pit";
        gp.player.lifePoints-=1;
        canTouchEvent=false;
        /*eventRect[col][row].eventDone=true;*/
    }
    public void rejuvenatingWaters(int col, int row, int gameState){
        if (gp.keyH.ePressed == true){
            gp.gameState=gameState;
            gp.playSE(8);
            gp.ui.currentDialoguesText= "You drink water from the well\nYou feel refreshed";
            gp.player.lifePoints=gp.player.maxLifePoints;
            gp.player.mana=gp.player.maxMana;

        }
    }

    public void sailBoatNorth(int col,int row,int gameState){
        if (gp.keyH.ePressed == true){
            gp.gameState=gameState;
            gp.playSE(10);
            gp.ui.currentDialoguesText= "Sailed to North part of the island!";
            gp.player.worldX=gp.tileSize*7;
            gp.player.worldY=gp.tileSize*47;


        }
    }
    public void sailBoatSouth(int col,int row,int gameState){
        if (gp.keyH.ePressed == true){
            gp.gameState=gameState;
            gp.playSE(10);
            gp.ui.currentDialoguesText= "Sailed to South part of the island!";
            gp.player.worldX=gp.tileSize*61;
            gp.player.worldY=gp.tileSize*80;
            gp.stopMusic();
            gp.playMusic(18);
        }
    }

}
