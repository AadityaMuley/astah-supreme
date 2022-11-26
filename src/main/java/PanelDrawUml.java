import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Title: Assignment 4
 * Description:  CSE 564 : Final project
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
    
    RelationSelector relationSelector = new RelationSelector();
    private int relationship; // 1-Association, 2-Aggregation, 3-Inheritance
    private int secondRectangle = 0; // checks if 2nd click is also inside an existing rectangle
    private double X1, Y1, X2, Y2; // temporary coordinates for line between 2 rectangles
    
    DrawBox drawBox = new DrawBox();
    DrawRelationLine drawRelationLine = new DrawRelationLine();
    
    
    PanelDrawUml() {

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                
                // draw rectangle box with class name on Left click
                if(SwingUtilities.isLeftMouseButton(e)) {
                    boolean drawNewRect = true;
    
                    // check if mouse clicked inside an existing box twice to create a relationship line
                    for(BoxAttributes i : boxes) {
                        if(i.isBox == 1) {
                            if((e.getX() >= i.rectangle.x) &&
                                    (e.getX() <= i.rectangle.x + i.rectangle.width) &&
                                    (e.getY() >= i.rectangle.y) &&
                                    (e.getY() <= i.rectangle.y + i.rectangle.height)) {
        
                                if(secondRectangle == 0) {
                                    drawNewRect = false;
                                    secondRectangle = 1;
                                    
                                    X1 = i.rectangle.x + (i.rectangle.width/2);
                                    Y1 = i.rectangle.y + (i.rectangle.height/2);
                                    
                                    break;
                                }
                                if(secondRectangle == 1) {
                                    drawNewRect = false;
                                    secondRectangle = 0;
                                    
                                    relationship = relationSelector.getRelation();
                                    X2 = i.rectangle.x + (i.rectangle.width/2);
                                    Y2 = i.rectangle.y + (i.rectangle.height/2);
                                    boxes.add(new BoxAttributes(0, relationship, new Line2D.Double(X1, Y1, X2, Y2)));
                                }
                            }
                        }
                    }
    
                    // draw new rectangle
                    if(drawNewRect == true) {
                        super.mouseClicked(e);
                        dialogBox(e);
                    }
                }
                
                // pop up dialog to select relation arrow head between association, aggregation, inheritance
                if(SwingUtilities.isRightMouseButton(e)) {
                    relationSelector.setRelation();
                }
            }
        });
    }


    // draw boxes
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for(BoxAttributes box: boxes) {
            
            // if isBox = 1 then it's a rectangle so drawing that
            if(box.isBox == 1) {
                drawBox.draw(g2d, box);
            }
            
            // if isBox = 0 then it's a relationship line so drawing that
            if(box.isBox == 0) {
                drawRelationLine.draw(g2d, box);
            }
        }
        
        repaint();
    }
    
    
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
                boxes.add(new BoxAttributes(1, content, new Rectangle(me.getX(), me.getY(), width, height)));
                
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
}
