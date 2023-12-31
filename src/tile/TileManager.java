package tile;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int[][][] mapTileNum;

    ArrayList<String> fileNames= new ArrayList<>();
    ArrayList<String> collisionStatus= new ArrayList<>();

    public TileManager(GamePanel gp){

        this.gp = gp;

        // READ TITLE DATA FILE
        InputStream is = getClass().getResourceAsStream("/maps/TILEDATA_FINAL.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        // GETTING TILE NAMES AND COLLISION INFO FROM THE FILE
        String line;
        try {
            while ((line= br.readLine())!=null){
                fileNames.add(line);
                collisionStatus.add(br.readLine());
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        //INITIALIZE THE TITLE ARRAY BASED ON THE fileNAMES size
        tile = new Tile[fileNames.size()];
        getTileImage();


        //GET THE maxWorldCol & ROW
        is = getClass().getResourceAsStream("/maps/MAP_FINAL.txt");
        br = new BufferedReader(new InputStreamReader(is));

        try {
            String line2= br.readLine();
            String maxTile[]=line2.split(" ");
            gp.maxWorldCol=maxTile.length;
            gp.maxWorldRow=maxTile.length;
            mapTileNum= new int[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];

            br.close();
        }catch (IOException e){
            System.out.println("EXCEPTION!");
        }

        loadMap("/maps/MAP_FINAL.txt",0);
        loadMap("/maps/Player_House_Interior.txt",1);
        loadMap("/maps/Player_House_Interior_2nd_Floor.txt",2);
        loadMap("/maps/WEAPON_SHOP.txt",3);
        loadMap("/maps/NPC_Big_House.txt",4);
        loadMap("/maps/NPC_Big_House.txt",5);
        loadMap("/maps/NPC_Normal_House.txt",6);
        loadMap("/maps/NPC_Normal_House.txt",7);
        loadMap("/maps/NPC_Normal_House.txt",8);
        loadMap("/maps/NPC_Normal_House.txt",9);
        loadMap("/maps/TOURNAMENT_MAP.txt",10);
        loadMap("/maps/TOURNAMENT_MAP.txt",11);
        loadMap("/maps/WEAPON_SHOP.txt",12);
        loadMap("/maps/NPC_Normal_House.txt",13);
        loadMap("/maps/NPC_Normal_House.txt",14);
        loadMap("/maps/NPC_Normal_House.txt",15);
        loadMap("/maps/NPC_Normal_House.txt",16);
        loadMap("/maps/NPC_Normal_House.txt",17);
        loadMap("/maps/NPC_Big_House.txt",18);
        loadMap("/maps/NPC_Big_House.txt",19);
    }
    public void getTileImage(){
        for (int i=0; i < fileNames.size();i++){
            String fileName;
            boolean collision;
            //GET FILE NAME
            fileName=fileNames.get(i);
            if (collisionStatus.get(i).equals("true")){
                collision=true;
            }else {
                collision=false;
            }
            setUp(i,fileName,collision);
        }

    }
    public void setUp(int index, String imageName, boolean collision){
        UtilityTool uTool = new UtilityTool();
        try{
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/"+imageName));
            tile[index].image=uTool.scaledImage(tile[index].image,gp.tileSize, gp.tileSize);
            tile[index].collision=collision;
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    public void loadMap(String filePathMap, int map){
        try{
            InputStream is = getClass().getResourceAsStream(filePathMap);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col=0;
            int row=0;

            while(col< gp.maxWorldCol && row< gp.maxWorldRow){
                String line = br.readLine();
                while(col< gp.maxWorldCol){
                    String numbers[]= line.split(" ");
                    int num = Integer.parseInt(numbers[col]); // String converts to integer
                    mapTileNum[map][col][row] =num;
                    col++;
                }
                if (col== gp.maxWorldCol){
                    col=0;
                    row++;
                }
            }
            br.close();
        }catch (Exception e){

        }
    }
    public void draw(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;


        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){
            int tileNum = mapTileNum[gp.currentMap][worldCol][worldRow];

            //Checking world coordinates
            int worldX= worldCol * gp.tileSize;
            int worldY = worldRow* gp.tileSize;

            //Checking where to draw the screen
            int screenX= worldX- gp.player.worldX + gp.player.screenX;
            int screenY= worldY- gp.player.worldY + gp.player.screenY;

            //Rendering only the screen is showing
            if (worldX + gp.tileSize> gp.player.worldX - gp.player.screenX &&
                    worldX- gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY+ gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY- gp.tileSize < gp.player.worldY + gp.player.screenY){
                g2.drawImage(tile[tileNum].image, screenX , screenY, null);
            }


            worldCol++;


            if (worldCol == gp.maxWorldCol){
                worldCol = 0;

                worldRow++;

            }
        }
    }
}
