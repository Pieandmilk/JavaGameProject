package Main;

import GUI.GUI;

public class EventHandler {
    GamePanel gp;
    EventRect eventRect[][][];

    int previousEventX,previousEventY;
    boolean canTouchEvent = false;


    public  EventHandler (GamePanel gp){
        this.gp=gp;
        eventRect= new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];

        int map=0;
        int col=0;
        int row=0;

        while (map<gp.maxMap && col< gp.maxWorldCol && row< gp.maxWorldRow){
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
                if (row==gp.maxWorldRow){
                    row=0;
                    map++;
                }
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
            if (hit(0,27,16,"right")==true){
                damagePit(gp.dialogState);
            }
            if (hit(0,64,55,"any")==true){
                rejuvenatingWaters(gp.dialogState);
            }
            //Signs
            if (hit(0,42,53,"any")==true){
                sign1(0,42,53,gp.dialogState);
            }

            if (hit(0,77,57,"any")==true){
                sign2(0,77,56,gp.dialogState);
            }

            //SAILING
            if (hit(0,7,46,"any")==true){
                sailBoatSouth(gp.dialogState);
            }
            if (hit(0,61,79,"any")==true){
                sailBoatNorth(gp.dialogState);
            }


            //In and Out of Player's house
            if (hit(1,20,26,"left")==true){
                gettingUpPlayerHouse();
            }
            if (hit(2,31,26,"right")==true){
                gettingDownPlayerHouse();
            }

            if (hit(1,30,32,"down")==true){
                outsidePlayerHouseFront();
            }
            if (hit(1,29,16,"up")==true){
                outsidePlayerHouseBack();
            }
            if (hit(1,30,16,"up")==true){
                outsidePlayerHouseBack();
            }
            if (hit(0,77,43,"up")==true){
                gettingInPlayerHouseFront();
            }
            if (hit(0,77,38,"down")==true){
                gettingInPlayerHouseBack();
            }

            //getting in weapon shop
            if (hit(0,56,50,"up")==true){
                gettingInWeaponShop();
            }
            if (hit(3,28,31,"down")==true){
                gettingOutWeaponShop();
            }
            //weaponshop2
            if (hit(0,21,69,"up")==true){
                gettingInWeaponShop2();
            }
            if (hit(0,22,69,"up")==true){
                gettingInWeaponShop2();
            }
            if (hit(12,28,31,"down")==true){
                gettingOutWeaponShop2();
            }

            //getting in npc big house1
            if (hit(0,56,42,"up")==true){
                gettingInNPCBigHouse1();
            }
            if (hit(4,30,32,"down")==true){
                gettingOutNPCBigHouse1();
            }
            //getting in npc big house2
            if (hit(0,50,31,"up")==true){
                gettingInNPCBigHouse2();
            }
            if (hit(5,30,32,"down")==true){
                gettingOutNPCBigHouse2();
            }

            if (hit(0,25,63,"up")==true){
                gettingInNPCBigHouse3();
            }
            if (hit(0,26,63,"up")==true){
                gettingInNPCBigHouse3();
            }
            if (hit(18,30,32,"down")==true){
                gettingOutNPCBigHouse3();
            }

            if (hit(0,15,63,"up")==true){
                gettingInNPCBigHouse4();
            }
            if (hit(0,14,63,"up")==true){
                gettingInNPCBigHouse4();
            }
            if (hit(19,30,32,"down")==true){
                gettingOutNPCBigHouse4();
            }



            //getting in npc normal house1
            if (hit(0,79,57,"up")==true){
                gettingInNPCNormalHouse1();
            }
            if (hit(6,28,31,"down")==true){
                gettingOutNPCNormalHouse1();
            }

            //getting in npc normal house2
            if (hit(0,49,54,"up")==true){
                gettingInNPCNormalHouse2();
            }
            if (hit(7,28,31,"down")==true){
                gettingOutNPCNormalHouse2();
            }

            //getting in npc normal house3
            if (hit(0,48,48,"up")==true){
                gettingInNPCNormalHouse3();
            }
            if (hit(8,28,31,"down")==true){
                gettingOutNPCNormalHouse3();
            }
            //getting in npc normal house4
            if (hit(0,59,32,"up")==true){
                gettingInNPCNormalHouse4();
            }
            if (hit(9,28,31,"down")==true){
                gettingOutNPCNormalHouse4();
            }
            //getting in npc normal house5
            if (hit(0,32,60,"up")==true){
                gettingInNPCNormalHouse5();
            }
            if (hit(13,28,31,"down")==true){
                gettingOutNPCNormalHouse5();
            }

            //getting in npc normal house6
            if (hit(0,25,57,"up")==true){
                gettingInNPCNormalHouse6();
            }
            if (hit(14,28,31,"down")==true){
                gettingOutNPCNormalHouse6();
            }
            //getting in npc normal house7
            if (hit(0,13,57,"up")==true){
                gettingInNPCNormalHouse7();
            }
            if (hit(15,28,31,"down")==true){
                gettingOutNPCNormalHouse7();
            }


            //getting in tournament
            if (hit(0,53,13,"up")==true){
                gettingInTournamentBuilding1();
            }
            if (hit(10,27,33,"down")==true){
                gettingOutTournamentBuilding1();
            }
            if (hit(10,28,33,"down")==true){
                gettingOutTournamentBuilding1();
            }
            if (hit(10,29,33,"down")==true){
                gettingOutTournamentBuilding1();
            }

            //getting in tournament2
            if (hit(0,20,63,"up")==true){
                gettingInTournamentBuilding2();
            }
            if (hit(11,27,33,"down")==true){
                gettingOutTournamentBuilding2();
            }
            if (hit(11,28,33,"down")==true){
                gettingOutTournamentBuilding2();
            }
            if (hit(11,29,33,"down")==true){
                gettingOutTournamentBuilding2();
            }


            //Buying in shop
            if (hit(3,28,28,"any")==true){
                shopGUI();
            }
            if (hit(12,28,28,"any")==true){
                shopGUI2();
            }

        }
    }
    public boolean hit(int map,int col, int row, String reqDirection){
        boolean hit = false;
        //Getting current player solid area pos

        if (map==gp.currentMap){
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

    public void damagePit(int gameState){
        gp.gameState=gameState;
        gp.ui.currentDialoguesText= "You fell in a pit";
        gp.player.lifePoints-=1;
        canTouchEvent=false;
        /*eventRect[col][row].eventDone=true;*/
    }
    public void rejuvenatingWaters( int gameState){
        if (gp.keyH.ePressed == true){
            gp.gameState=gameState;
            gp.playSE(8);
            gp.ui.currentDialoguesText= "You drink water from the well\nYou feel refreshed";
            gp.player.lifePoints=gp.player.maxLifePoints;
            gp.player.mana=gp.player.maxMana;

        }
    }

    public void sailBoatNorth(int gameState){
        if (gp.keyH.ePressed == true){
            gp.gameState=gameState;
            gp.playSE(10);
            gp.ui.currentDialoguesText= "Sailed to North Part of the Island.";
            gp.player.worldX=gp.tileSize*7;
            gp.player.worldY=gp.tileSize*47;
        }
    }
    public void sailBoatSouth(int gameState){
        if (gp.keyH.ePressed == true){
            gp.gameState=gameState;
            gp.playSE(10);
            gp.ui.currentDialoguesText= "Sailed to Derby Beach!";
            gp.player.worldX=gp.tileSize*61;
            gp.player.worldY=gp.tileSize*80;
            gp.stopMusic();
            gp.playMusic(18);
        }
    }

    public void outsidePlayerHouseFront(){
            gp.currentMap=0;
            gp.playSE(21);
            gp.player.worldX=gp.tileSize*77;
            gp.player.worldY=gp.tileSize*43;
    }
    public void outsidePlayerHouseBack(){
        gp.currentMap=0;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*77;
        gp.player.worldY=gp.tileSize*38;
    }
    public void gettingInPlayerHouseFront(){
        gp.currentMap=1;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*30;
        gp.player.worldY=gp.tileSize*31;
    }
    public void gettingInPlayerHouseBack(){
        gp.currentMap=1;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*29;
        gp.player.worldY=gp.tileSize*16;
    }

    public void gettingUpPlayerHouse(){
        gp.currentMap=2;
        gp.playSE(22);
        gp.player.worldX=gp.tileSize*31;
        gp.player.worldY=gp.tileSize*26;
    }
    public void gettingDownPlayerHouse(){
        gp.currentMap=1;
        gp.playSE(22);
        gp.player.worldX=gp.tileSize*20;
        gp.player.worldY=gp.tileSize*26;
    }
    public void gettingInWeaponShop(){
        gp.currentMap=3;
        gp.playSE(21);
        gp.ui.addAnnouncement("WEAPON BLACKSMITH SHOP");
        gp.player.worldX=gp.tileSize*28;
        gp.player.worldY=gp.tileSize*31;
    }
    public void gettingOutWeaponShop(){
        gp.currentMap=0;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*56;
        gp.player.worldY=gp.tileSize*50;
    }
    public void gettingInNPCBigHouse1(){
        gp.currentMap=4;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*30;
        gp.player.worldY=gp.tileSize*32;
    }
    public void gettingInNPCBigHouse2(){
        gp.currentMap=5;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*30;
        gp.player.worldY=gp.tileSize*32;
    }
    public void gettingOutNPCBigHouse1(){
        gp.currentMap=0;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*56;
        gp.player.worldY=gp.tileSize*42;
    }

    public void gettingOutNPCBigHouse2(){
        gp.currentMap=0;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*50;
        gp.player.worldY=gp.tileSize*31;
    }

    public void gettingInNPCBigHouse3(){
        gp.currentMap=18;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*30;
        gp.player.worldY=gp.tileSize*32;
    }
    public void gettingOutNPCBigHouse3(){
        gp.currentMap=0;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*26;
        gp.player.worldY=gp.tileSize*63;
    }

    public void gettingInNPCBigHouse4(){
        gp.currentMap=19;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*30;
        gp.player.worldY=gp.tileSize*32;
    }
    public void gettingOutNPCBigHouse4(){
        gp.currentMap=0;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*15;
        gp.player.worldY=gp.tileSize*63;
    }


    public void gettingInNPCNormalHouse1(){
        gp.currentMap=6;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*28;
        gp.player.worldY=gp.tileSize*31;
    }
    public void gettingOutNPCNormalHouse1(){
        gp.currentMap=0;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*79;
        gp.player.worldY=gp.tileSize*57;
    }

    public void gettingInNPCNormalHouse2(){
        gp.currentMap=7;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*28;
        gp.player.worldY=gp.tileSize*31;
    }
    public void gettingOutNPCNormalHouse2(){
        gp.currentMap=0;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*49;
        gp.player.worldY=gp.tileSize*54;
    }

    public void gettingInNPCNormalHouse3(){
        gp.currentMap=8;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*28;
        gp.player.worldY=gp.tileSize*31;
    }
    public void gettingOutNPCNormalHouse3(){
        gp.currentMap=0;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*48;
        gp.player.worldY=gp.tileSize*48;
    }
    public void gettingInNPCNormalHouse4(){
        gp.currentMap=9;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*28;
        gp.player.worldY=gp.tileSize*31;
    }
    public void gettingOutNPCNormalHouse4(){
        gp.currentMap=0;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*59;
        gp.player.worldY=gp.tileSize*32;
    }


    public void gettingInNPCNormalHouse5(){
        gp.currentMap=13;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*28;
        gp.player.worldY=gp.tileSize*31;
    }
    public void gettingOutNPCNormalHouse5(){
        gp.currentMap=0;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*32;
        gp.player.worldY=gp.tileSize*60;
    }

    public void gettingInNPCNormalHouse6(){
        gp.currentMap=14;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*28;
        gp.player.worldY=gp.tileSize*31;
    }
    public void gettingOutNPCNormalHouse6(){
        gp.currentMap=0;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*25;
        gp.player.worldY=gp.tileSize*57;
    }

    public void gettingInNPCNormalHouse7(){
        gp.currentMap=15;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*28;
        gp.player.worldY=gp.tileSize*31;
    }
    public void gettingOutNPCNormalHouse7(){
        gp.currentMap=0;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*13;
        gp.player.worldY=gp.tileSize*57;
    }

    public void sign1(int map,int col,int row,int gamestate){
        gp.gameState=gamestate;
        gp.ui.currentDialoguesText="Welcome to lawrence town!!";
        canTouchEvent=false;
    }

    public void sign2(int map,int col,int row,int gamestate) {
        gp.gameState = gamestate;
        gp.ui.currentDialoguesText = "Kerby's House!!";
        canTouchEvent = false;
    }

    public void gettingInTournamentBuilding1(){
        gp.currentMap=10;
        gp.aSetter.setEnemyTornament1();
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*28;
        gp.player.worldY=gp.tileSize*32;
    }
    public void gettingOutTournamentBuilding1(){
        gp.currentMap=0;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*53;
        gp.player.worldY=gp.tileSize*13;
    }

    public void gettingInTournamentBuilding2(){
        gp.currentMap=11;
        gp.aSetter.setEnemyTornament2();
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*28;
        gp.player.worldY=gp.tileSize*32;
    }
    public void gettingOutTournamentBuilding2(){
        gp.currentMap=0;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*20;
        gp.player.worldY=gp.tileSize*63;
    }

    public void gettingInWeaponShop2(){
        gp.currentMap=12;
        gp.playSE(21);
        gp.ui.addAnnouncement("WEAPON BLACKSMITH SHOP");
        gp.player.worldX=gp.tileSize*28;
        gp.player.worldY=gp.tileSize*31;
    }

    public void gettingOutWeaponShop2(){
        gp.currentMap=0;
        gp.playSE(21);
        gp.player.worldX=gp.tileSize*21;
        gp.player.worldY=gp.tileSize*69;
    }
    public void shopGUI(){
        if (gp.keyH.ePressed==true){
            gp.gui.pack();
            gp.gui.setVisible(true);

        }

    }
    public void shopGUI2(){
        if (gp.keyH.ePressed==true){
            gp.gui.pack();
            gp.gui.setVisible(true);

        }

    }

}
