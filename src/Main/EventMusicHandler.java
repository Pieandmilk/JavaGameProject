package Main;

public class EventMusicHandler {
    GamePanel gp;
    EventRect eventRect[][];

    int previousEventX,previousEventY;
    boolean canTouchEvent = false;


    public  EventMusicHandler (GamePanel gp){
        this.gp=gp;
        eventRect= new EventRect[gp.maxWorldCol][gp.maxWorldRow];

        int col=0;
        int row=0;

        while (col< gp.maxWorldCol && row< gp.maxWorldRow){
            eventRect [col][row]= new EventRect();
            eventRect[col][row].x= 9;
            eventRect[col][row].y=9;
            eventRect[col][row].width=30;
            eventRect[col][row].height=30;
            eventRect[col][row].eventRectDefaultX= eventRect[col][row].x;
            eventRect[col][row].eventRectDefaultY= eventRect[col][row].y;

            col++;
            if (col== gp.maxWorldCol){
                col=0;
                row++;
            }
        }



    }

    public void checkEventMusic(){
        // Check if the player character is more than 1 tile away from the last event
        int xDistance= Math.abs(gp.player.worldX- previousEventX);
        int yDistance= Math.abs(gp.player.worldY- previousEventY);
        int distance= Math.max(xDistance,yDistance);
        if (distance> gp.tileSize){
            canTouchEvent = true;
        }
        if (canTouchEvent==true){
            LawrenceVille();

            PlayerLand();

            Beach();

            NorthIsland();

            SouthIsland();

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


    public void enteringLawrenceville(int col, int row){
        String text= "LAWRENCEVILLE";
        gp.stopMusic();
        gp.playMusic(17);
        gp.ui.addAnnouncement(text);
    }
    public void LawrenceVille(){
        //entering lawrenceville
        if (hit(70,54,"left")==true){
            enteringLawrenceville(70,54);
        }
        else  if (hit(70,55,"left")==true){
            enteringLawrenceville(70,55);
        }
        else if (hit(70,56,"left")==true){
            enteringLawrenceville(70,56);
        }
        else if (hit(70,57,"left")==true){
            enteringLawrenceville(70,57);
        }
        else if (hit(70,58,"left")==true){
            enteringLawrenceville(70,58);
        }
        else if (hit(70,59,"left")==true){
            enteringLawrenceville(70,59);
        }
    }
    public void enteringPlayerLand(int col, int row){
        String text= "PLAYERLAND";
        gp.stopMusic();
        gp.playMusic(0);
        gp.ui.addAnnouncement(text);

    }
    public void PlayerLand(){
        //EnteringPlayerLand
        if (hit(70,54,"right")==true){
            enteringPlayerLand(70,54);
        }
        else if (hit(70,55,"right")==true){
            enteringPlayerLand(70,55);
        }
        else if (hit(70,56,"right")==true){
            enteringPlayerLand(70,56);
        }
        else if (hit(70,57,"right")==true){
            enteringPlayerLand(70,57);
        }
        else if (hit(70,58,"right")==true){
            enteringPlayerLand(70,58);
        }
        else if (hit(70,59,"right")==true){
            enteringPlayerLand(70,59);
        }
    }
    public void enteringBeach(int col, int row){
        String text= "Beach";
        gp.stopMusic();
        gp.playMusic(18);
        gp.ui.addAnnouncement(text);

    }
    public void Beach(){
        //entering beach
        if (hit(58,62,"down")==true){
            enteringBeach(58,62);
        }
        else if (hit(59,62,"down")==true){
            enteringBeach(59,62);
        }
        else if (hit(58,62,"up")==true){
            enteringLawrenceville(58,62);
        }
        else if (hit(59,62,"up")==true){
            enteringLawrenceville(59,562);
        }
    }

    public void enteringSouthIsland(int col, int row){
        String text= "SOUTH ISLAND";
        gp.stopMusic();
        gp.playMusic(19);
        gp.ui.addAnnouncement(text);

    }

    public void SouthIsland(){
        //entering south
        if (hit(45,53,"left")==true){
            enteringSouthIsland(45,53);
        }
        else if (hit(45,54,"left")==true){
            enteringSouthIsland(45,54);
        }
        else if (hit(45,55,"left")==true){
            enteringSouthIsland(45,55);
        }
        else if (hit(45,56,"left")==true){
            enteringSouthIsland(45,56);
        }

        //leaving south
        else if (hit(45,53,"right")==true){
            enteringLawrenceville(45,53);
        }
        else if (hit(45,54,"right")==true){
            enteringLawrenceville(45,54);
        }
        else if (hit(45,55,"right")==true){
            enteringLawrenceville(45,55);
        }
        else if (hit(45,56,"right")==true){
            enteringLawrenceville(45,56);
        }
    }

    public void enteringNorthIsland(int col, int row){
        String text= "NORTH ISLAND";
        gp.stopMusic();
        gp.playMusic(20);
        gp.ui.addAnnouncement(text);
    }

    public void NorthIsland(){
        if (hit(11,47,"right")==true){
            enteringNorthIsland(11,47);
        }
        else if (hit(11,48,"right")==true){
            enteringNorthIsland(11,48);
        }
        else if (hit(11,49,"right")==true){
            enteringNorthIsland(11,49);
        }
    }
}
