import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Title: Assingment 3
 * Description:  CSE 564 : Singleton, Decorator, Observer Pattern
 *
 * @author Aaditya Muley
 * ASUrite : amuley2
 * ASU ID : 1225526185
 * @version 1.0
 */
public class PanelDrawUml extends JPanel {

    private ArrayList<BoxAttributes> boxes = new ArrayList<BoxAttributes>();
    private final int width = 100;
    private final int height = 50;

    PanelDrawUml() {

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

        // mouse event in the UML panel
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                Dialog dialog = new Dialog();
                dialog.setTitle("Type Name Here: ");
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setLocationRelativeTo(null);
                dialog.pack();
                dialog.setVisible(true);

                String name = dialog.getName();
                boxes.add(new BoxAttributes(name, new Rectangle(e.getX(), e.getY(), width, height)));

                repaint();
            }
        });
    }


    // draw boxes
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for(BoxAttributes box: boxes) {
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fill(box.rectangle);
            g2d.draw(box.rectangle);

            g2d.setColor(Color.BLACK);
            g2d.drawString(box.name, (int)box.rectangle.getX(), (int)box.rectangle.getY()+15);
        }
    }
}
