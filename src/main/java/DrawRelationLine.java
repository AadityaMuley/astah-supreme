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
public class DrawRelationLine extends Drawable{
    
    @Override
    public void draw(Graphics2D g2d, BoxAttributes box) {
        // relationship = 1 is Association
        if(box.relationship == 1) {
            g2d.setColor(Color.RED);
            g2d.fill(box.line);
            g2d.draw(box.line);
        }
        // relationship = 2 is Aggregation
        else if(box.relationship == 2) {
            g2d.setColor(Color.GREEN);
            g2d.fill(box.line);
            g2d.draw(box.line);
        }
        // relationship = 3 is Inheritance
        else {
            g2d.setColor(Color.BLUE);
            g2d.fill(box.line);
            g2d.draw(box.line);
        }
    }
}
