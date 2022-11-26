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
        
        double d = Math.sqrt(Math.pow((box.line.getX2() - box.line.getX1()), 2) +
                Math.pow((box.line.getY2() - box.line.getY1()), 2));
        
        double d1 = 20;
        double d2 = d-d1;
        
        double X1 = box.line.getX2();
        double Y1 = box.line.getY2();
        
        double X2 = ((d1 * box.line.getX1()) + (d2 * box.line.getX2())) / d;
        double Y2 = ((d1 * box.line.getY1()) + (d2 * box.line.getY2())) / d;
        
        double cos = 0.866;
        double sin = 0.5;
        
        double X3 = (cos * (X2-X1)) - (sin * (Y2-Y1)) + X1;
        double Y3 = (sin * (X2-X1)) + (cos * (Y2-Y1)) + Y1;
        double X4 = (cos * (X2-X1)) - (-sin * (Y2-Y1)) + X1;
        double Y4 = (-sin * (X2-X1)) + (cos * (Y2-Y1)) + Y1;
        
        g2d.drawLine((int) X1, (int) Y1, (int) X3, (int) Y3);
        g2d.drawLine((int) X1, (int) Y1, (int) X4, (int) Y4);
    }
}
