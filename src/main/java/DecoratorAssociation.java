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
public class DecoratorAssociation extends Decorator{
    
    @Override
    public void draw(Graphics2D g2d, BoxAttributes box) {
        super.draw(g2d, box);
        
        // logic for association arrow head
    
        g2d.setColor(Color.RED);
        g2d.fill(box.line);
        g2d.draw(box.line);
    }
}
