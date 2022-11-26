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
public class DecoratorAggregation extends Decorator{
    
    @Override
    public void draw(Graphics2D g2d, BoxAttributes box) {
        super.draw(g2d, box);
        
        // logic for aggregation arrow head
    
        double d = Math.sqrt(Math.pow((box.line.getX2() - box.line.getX1()), 2) +
                Math.pow((box.line.getY2() - box.line.getY1()), 2));
    
        double d1 = 10;
        double d2 = d-d1;
    
        double X1 = box.line.getX1();
        double Y1 = box.line.getY1();
    
        double X2 = ((d2 * box.line.getX1()) + (d1 * box.line.getX2())) / d;
        double Y2 = ((d2 * box.line.getY1()) + (d1 * box.line.getY2())) / d;
    
        double cos = 0.707;
        double sin = 0.707;
    
        double X3 = (cos * (X2-X1)) - (sin * (Y2-Y1)) + X1;
        double Y3 = (sin * (X2-X1)) + (cos * (Y2-Y1)) + Y1;
    
        double X4 = (cos * (X2-X1)) - (-sin * (Y2-Y1)) + X1;
        double Y4 = (-sin * (X2-X1)) + (cos * (Y2-Y1)) + Y1;
        
        d1 = 20;
        d2 = d-d1;
        double X5 = ((d2 * box.line.getX1()) + (d1 * box.line.getX2())) / d;
        double Y5 = ((d2 * box.line.getY1()) + (d1 * box.line.getY2())) / d;
    
        int[] X = new int[]{(int) X1, (int) X3, (int) X5, (int) X4};
        int[] Y = new int[]{(int) Y1, (int) Y3, (int) Y5, (int) Y4};
        g2d.fillPolygon(new Polygon(X, Y, 4));
    
        d1 = 20;
        d2 = d-d1;
    
        X1 = box.line.getX2();
        Y1 = box.line.getY2();
    
        X2 = ((d1 * box.line.getX1()) + (d2 * box.line.getX2())) / d;
        Y2 = ((d1 * box.line.getY1()) + (d2 * box.line.getY2())) / d;
    
        cos = 0.866;
        sin = 0.5;
        X3 = (cos * (X2-X1)) - (sin * (Y2-Y1)) + X1;
        Y3 = (sin * (X2-X1)) + (cos * (Y2-Y1)) + Y1;
        X4 = (cos * (X2-X1)) - (-sin * (Y2-Y1)) + X1;
        Y4 = (-sin * (X2-X1)) + (cos * (Y2-Y1)) + Y1;
    
        g2d.drawLine((int) X1, (int) Y1, (int) X3, (int) Y3);
        g2d.drawLine((int) X1, (int) Y1, (int) X4, (int) Y4);
    }
}
