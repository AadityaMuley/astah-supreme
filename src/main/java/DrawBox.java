import java.awt.*;

/**
 * Title: Assignment 4
 * Description:  CSE 564 : Final project
 *
 * @author Aaditya Muley
 * ASUrite : amuley2
 * ASU ID : 1225526185
 * @version 1.0
 */
public class DrawBox extends Drawable{
    
    @Override
    public void draw(Graphics2D g2d, BoxAttributes box) {
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fill(box.rectangle);
        g2d.draw(box.rectangle);
    
        g2d.setColor(Color.BLACK);
        g2d.drawString(box.name, (int) box.rectangle.getX(), (int) box.rectangle.getY() + 15);
    }
}
