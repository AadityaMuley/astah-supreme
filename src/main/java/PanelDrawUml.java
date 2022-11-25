import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    
    
    //dialog box for name of class
    private void dialogBox(MouseEvent me) {
        JDialog dialog = new JDialog();
        dialog.setLayout(new BorderLayout());
        dialog.setPreferredSize(new Dimension(200, 100));
        
        JTextArea textArea = new JTextArea();
        
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        JScrollPane pane = new JScrollPane(textArea);
        pane.setPreferredSize(new Dimension(200, 100));
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        JButton button = new JButton("OK");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = textArea.getText();
                boxes.add(new BoxAttributes(content, new Rectangle(me.getX(), me.getY(), width, height)));
                
                dialog.dispose();
                
                repaint();
            }
        });
        
        dialog.add(pane, BorderLayout.CENTER);
        dialog.add(button, BorderLayout.SOUTH);
        
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);
        dialog.pack();
        dialog.setVisible(true);
    }
    
    
    PanelDrawUml() {

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                
                boolean drawNewRect = true;
                for(BoxAttributes i : boxes) {
                    if((e.getX() >= i.rectangle.x) &&
                            (e.getX() <= i.rectangle.x+i.rectangle.width) &&
                            (e.getY() >= i.rectangle.y) &&
                            (e.getY() <= i.rectangle.y+i.rectangle.height)) {
                        System.out.println("Hit inside rectangle");
                        drawNewRect = false;
                    }
                }
                
                if(drawNewRect == true) {
                    super.mouseClicked(e);
                    dialogBox(e);
                }
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
