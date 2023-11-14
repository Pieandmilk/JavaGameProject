package Main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UtilityTool {
    public BufferedImage scaledImage (BufferedImage original, int width, int height){
        BufferedImage scaledImage = new BufferedImage(width,height,original.getType());
        Graphics2D g2 = scaledImage.createGraphics(); //Creates a Graphics2D, which can be used to draw into this buffered image
        g2.drawImage(original,0,0,width,height,null);
        g2.dispose();

        return scaledImage;
    }
}
