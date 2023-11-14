package Main;

import Entity.Player;
import Objects.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

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


    //FPS
    int FPS =60;

    //SYSTEM
    public TileManager tileM= new TileManager(this);
    KeyHandler keyH= new KeyHandler();
    Sound music= new Sound();
    Sound se= new Sound();
    public CollisionChecker cChecker= new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    Thread gameThread;

    //PLAYER AND OBJECT
    public Player player= new Player(this,keyH);
    public SuperObject obj[] = new SuperObject[10];//initiates how many objects are present in the screen




    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){
        aSetter.setObject();
        playMusic(0);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
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
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //Debug

        long drawStart=0;
        if (keyH.checkDrawTime==true){
            drawStart=System.nanoTime();
        }


        //Tile
        tileM.draw(g2);

        //Object
        for (int i = 0; i<obj.length;i++){
            if (obj[i] != null){
                obj[i].draw(g2, this);
            }
        }

        //Player
        player.draw(g2);

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
