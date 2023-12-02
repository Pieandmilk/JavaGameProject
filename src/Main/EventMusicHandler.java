package Main;

public class EventMusicHandler {
    GamePanel gp;
    EventRect eventRect[][][];

    int previousEventX,previousEventY;
    boolean canTouchEvent = false;


    public  EventMusicHandler (GamePanel gp){
        this.gp=gp;
        eventRect= new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];

        int map=0;
        int col=0;
        int row=0;

        while (map < gp.maxMap && col< gp.maxWorldCol && row< gp.maxWorldRow){
            eventRect [map][col][row]= new EventRect();
            eventRect[map][col][row].x= 9;
            eventRect[map][col][row].y=9;
            eventRect[map][col][row].width=30;
            eventRect[map][col][row].height=30;
            eventRect[map][col][row].eventRectDefaultX= eventRect[map][col][row].x;
            eventRect[map][col][row].eventRectDefaultY= eventRect[map][col][row].y;

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
    public boolean hit(int map,int col, int row, String reqDirection){
        boolean hit = false;

        if(map==gp.currentMap){
            //Getting current player solid area pos
            gp.player.solidArea.x=gp.player.worldX + gp.player.solidArea.x;
            gp.player.solidArea.y=gp.player.worldY + gp.player.solidArea.y;

            //Getting eventRect solid area position
            eventRect[map][col][row].x= col*gp.tileSize+ eventRect[map][col][row].x;
            eventRect[map][col][row].y= row*gp.tileSize+ eventRect[map][col][row].y;

            if (gp.player.solidArea.intersects(eventRect[map][col][row] )&& eventRect[map][col][row].eventDone==false){
                if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                    hit = true;

                    previousEventX = gp.player.worldX;
                    previousEventY = gp.player.worldY;
                }
            }

            gp.player.solidArea.x = gp.player.solidAreaDefaultX;
            gp.player.solidArea.y = gp.player.solidAreaDefaultY;
            eventRect[map][col][row].x=eventRect[map][col][row].eventRectDefaultX;
            eventRect[map][col][row].y=eventRect[map][col][row].eventRectDefaultY;
        }


        return hit;
    }


    public void enteringLawrenceville(){
        String text= "LAWRENCEVILLE";
        gp.stopMusic();
        gp.playMusic(17);
        gp.ui.addAnnouncement(text);
    }
    public void LawrenceVille(){
        //entering lawrenceville
        if (hit(0,70,54,"left")==true){
            enteringLawrenceville();
        }
        else  if (hit(0,70,55,"left")==true){
            enteringLawrenceville();
        }
        else if (hit(0,70,56,"left")==true){
            enteringLawrenceville();
        }
        else if (hit(0,70,57,"left")==true){
            enteringLawrenceville();
        }
        else if (hit(0,70,58,"left")==true){
            enteringLawrenceville();
        }
        else if (hit(0,70,59,"left")==true){
            enteringLawrenceville();
        }
    }
    public void enteringPlayerLand(){
        String text= "PLAYERLAND";
        gp.stopMusic();
        gp.playMusic(0);
        gp.ui.addAnnouncement(text);

    }
    public void PlayerLand(){
        //EnteringPlayerLand
        if (hit(0,70,54,"right")==true){
            enteringPlayerLand();
        }
        else if (hit(0,70,55,"right")==true){
            enteringPlayerLand();
        }
        else if (hit(0,70,56,"right")==true){
            enteringPlayerLand();
        }
        else if (hit(0,70,57,"right")==true){
            enteringPlayerLand();
        }
        else if (hit(0,70,58,"right")==true) {
            enteringPlayerLand();
        }
        else if (hit(0,70,59,"right")==true){
            enteringPlayerLand();
        }
    }
    public void enteringBeach(){
        String text= "Beach";
        gp.stopMusic();
        gp.playMusic(18);
        gp.ui.addAnnouncement(text);

    }
    public void Beach(){
        //entering beach
        if (hit(0,58,62,"down")==true){
            enteringBeach();
        }
        else if (hit(0,59,62,"down")==true){
            enteringBeach();
        }
        else if (hit(0,58,62,"up")==true){
            enteringLawrenceville();
        }
        else if (hit(0,59,62,"up")==true){
            enteringLawrenceville();
        }
    }

    public void enteringSouthIsland(){
        String text= "SOUTH ISLAND";
        gp.stopMusic();
        gp.playMusic(19);
        gp.ui.addAnnouncement(text);

    }

    public void SouthIsland(){
        //entering south
        if (hit(0,45,53,"left")==true){
            enteringSouthIsland();
        }
        else if (hit(0,45,54,"left")==true){
            enteringSouthIsland();
        }
        else if (hit(0,45,55,"left")==true){
            enteringSouthIsland();
        }
        else if (hit(0,45,56,"left")==true){
            enteringSouthIsland();
        }

        //leaving south
        else if (hit(0,45,53,"right")==true){
            enteringLawrenceville();
        }
        else if (hit(0,45,54,"right")==true){
            enteringLawrenceville();
        }
        else if (hit(0,45,55,"right")==true){
            enteringLawrenceville();
        }
        else if (hit(0,45,56,"right")==true){
            enteringLawrenceville();
        }
    }

    public void enteringNorthIsland(){
        String text= "NORTH ISLAND";
        gp.stopMusic();
        gp.playMusic(20);
        gp.ui.addAnnouncement(text);
    }

    public void NorthIsland(){
        if (hit(0,11,47,"right")==true){
            enteringNorthIsland();
        }
        else if (hit(0,11,48,"right")==true){
            enteringNorthIsland();
        }
        else if (hit(0,11,49,"right")==true){
            enteringNorthIsland();
        }
    }
}
