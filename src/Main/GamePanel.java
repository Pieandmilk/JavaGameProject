package Main;

import DiscreteStructures.StatisticsCalculatorUII;
import Entity.Entity;
import Entity.Player;
import GUI.GUI;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class GamePanel extends JPanel implements Runnable{

    //SCREEN SETTINGS
    final int originalTileSize= 16; //32*32??
    final int scale = 3;
    public final int tileSize= originalTileSize*scale; //Tile size will be 42*42
    public final int maxScreenCol= 22;
    public final int maxScreenRow=12;
    public final int screenWidth = tileSize*maxScreenCol;
    public final int screenHeight = tileSize*maxScreenRow;

    //WORLD SETTING

    public int maxWorldCol;
    public int maxWorldRow;
    public int maxMap=20;
    public int currentMap=2;


    //FPS
    int FPS =60;

    //SYSTEM
    public TileManager tileM= new TileManager(this);
    public KeyHandler keyH= new KeyHandler(this);
    Sound music= new Sound();
    Sound se= new Sound();
    public CollisionChecker cChecker= new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    public EventMusicHandler eMusicHandler = new EventMusicHandler(this);
    public GUI gui = new GUI(this);
    public StatisticsCalculatorUII guii = new StatisticsCalculatorUII();
    Thread gameThread;

    //PLAYER AND OBJECT
    public Player player= new Player(this,keyH);
    public Entity obj[][] = new Entity[maxMap][20];//initiates how many objects are present in the screen
    public  Entity npc[][]= new Entity[maxMap][20];
    public Entity enem[][]= new Entity[maxMap][20];
    private int aliveEnemies = 0;
    private int respawnCounter=0;

    public ArrayList <Entity> projectileList = new ArrayList<>();

    /*We sort the order of the array. The entity that has the lowest worldY comes in index 0.
    We draw entities in order of their worldY value.(The fewer, the earlier)*/
    ArrayList<Entity> entityList = new ArrayList<>();

    //GAME STATE - involves pausing and continuing the game
    public int gameState;
    public final int titleState=0;
    public final int playState=1;
    public final int pauseState=2;
    public final int dialogState=3;
    public final int characterState=4;
    public final int inGameSettingsState=5;
    //****PJA
    public final int transactionState=6;
    public final int gameOverState = 7;






    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){
        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setEnemy();
        playMusic(9);
        gameState=titleState;
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void TryAgain(){
        currentMap=2;
        player.setDefaultPositions();
        player.restoreLife();
        aSetter.setNPC();
        aSetter.setEnemy();
        ui.gp.playMusic(0);
    }
    public void Restart(){
        currentMap=2;
        player.setDefaultValues();
        player.setDefaultPositions();
        player.restoreLife();
        player.setItems();
        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setEnemy();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer=0;
        int drawCount=0;

        while (gameThread != null){
            currentTime=System.nanoTime();
            delta += (currentTime-lastTime)/ drawInterval;
            timer += (currentTime-lastTime);
            lastTime= currentTime;

            if (delta>=1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer>=1000000000){
                drawCount=0;
                timer=0;
            }
        }
    }

    public void update(){
        if (gameState==1){
            aliveEnemies = 0;
            //PLAYER
            player.update();

            //NPC
            for(int i = 0; i< npc[1].length;i++){
                if (npc[currentMap][i] != null){
                    npc[currentMap][i].update();
                }
            }
            for(int i = 0; i< enem[1].length;i++){

                if (enem[currentMap][i] != null){
                    if (enem[currentMap][i].alive==true && enem[currentMap][i].dying==false){
                        aliveEnemies++;
                        enem[currentMap][i].update();
                    }
                    if (enem[currentMap][i].alive==false){
                        enem[currentMap][i].checkDrop();
                        enem[currentMap][i] = null;

                    }
                }
            }
            for(int i = 0; i< projectileList.size();i++){
                if (projectileList.get(i) != null){
                    if (projectileList.get(i).alive==true){
                        projectileList.get(i).update();
                    }
                    if (projectileList.get(i).alive==false){
                        projectileList.remove(i);

                    }
                }
            }
            if (aliveEnemies==0){
                respawnCounter++;
                if (respawnCounter>2000){
                    aSetter.setEnemy();
                    respawnCounter=0;
                }
            }

        }
        if (gameState==2){

        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //Debug

        long drawStart=0;
        if (keyH.checkDrawTime==true){
            drawStart=System.nanoTime();
        }

        if(gameState==titleState){
            ui.draw(g2);
        }
        else {
            //Tile
            tileM.draw(g2);

            //ADD ENTITIES TO LISt

            //Player
            entityList.add(player);

            //NPC
            for (int i = 0;i < npc[1].length; i++){
                if (npc[currentMap][i]!=null){
                    entityList.add(npc[currentMap][i]);
                }
            }
            //Objects
            for (int i= 0; i<obj[1].length; i++){
                if(obj[currentMap][i]!=null){
                    entityList.add(obj[currentMap][i]);
                }
            }
            for(int i = 0; i< enem[1].length;i++){
                if (enem[currentMap][i] != null){
                    entityList.add(enem[currentMap][i]);
                }
            }
            for(int i = 0; i< projectileList.size();i++){
                if (projectileList.get(i) != null){
                    entityList.add(projectileList.get(i));
                }
            }

            //Sort
            Collections.sort(entityList, new Comparator<Entity>() {
                @Override
                public int compare(Entity e1, Entity e2) {
                    int result= Integer.compare(e1.worldY,e2.worldY);
                    return result;
                }
            });

            //Drawing Entities
            for (int i= 0; i<entityList.size(); i++){
                entityList.get(i).draw(g2);
            }
            //Empty List (Otherwise the list gets larger and larger for every loop)
            entityList.clear();

            //UI

            ui.draw(g2);



            //Debug
            if (keyH.checkDrawTime==true){
                long drawEnd=System.nanoTime();
                long passed= drawEnd-drawStart;
                g2.setColor(Color.white);
                g2.drawString("Draw time: "+ passed,10,400);
                System.out.println("Draw time: "+ passed);
            }

            g2.dispose();
        }

    }

    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic(){
        music.stop();
    }
    public void playSE(int i){
        se.setFile(i);
        se.play();
    }


}
