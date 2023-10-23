package Main;

import Entity.Player;
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


    TileManager tileM= new TileManager(this);
    KeyHandler keyH= new KeyHandler();

    Thread gameThread;

    Player player= new Player(this,keyH);
    //FPS
    int FPS =60;



    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
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
                System.out.println("FPS: " + drawCount);
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
        tileM.draw(g2);
        player.draw(g2);


        g2.dispose();
    }
}