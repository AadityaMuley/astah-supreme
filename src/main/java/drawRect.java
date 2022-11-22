import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class drawRect extends JPanel {

    int x = 0;
    int y = 0;

    public drawRect(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 20);
        System.out.println(x + " " + y);
    }
}
