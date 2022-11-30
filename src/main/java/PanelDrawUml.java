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
    private String movedBoxName; // temporary string to record moved box's name
    private String startBoxName;
    private String endBoxName;
    
    PanelDrawUml() {

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("mouse clicked");
                
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
                                    startBoxName = i.name;
                                    
                                    X1 = i.rectangle.x + (i.rectangle.width/2);
                                    Y1 = i.rectangle.y + (i.rectangle.height/2);
                                    
                                    break;
                                }
                                if(secondRectangle == 1) {
                                    drawNewRect = false;
                                    secondRectangle = 0;
                                    endBoxName = i.name;
                                    
                                    relationship = relationSelector.getRelation();
                                    X2 = i.rectangle.x + (i.rectangle.width/2);
                                    Y2 = i.rectangle.y + (i.rectangle.height/2);

                                    boxes.add(new BoxAttributes(0,
                                                                relationship,
                                                                startBoxName,
                                                                endBoxName,
                                                                new Line2D.Double(X1, Y1, X2, Y2)));
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

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                // reset moved box's name
                movedBoxName = "";

                for(BoxAttributes i: boxes) {
                    if(i.isBox == 1) {
                        if((e.getX() >= i.rectangle.x) &&
                                (e.getX() <= i.rectangle.x + i.rectangle.width) &&
                                (e.getY() >= i.rectangle.y) &&
                                (e.getY() <= i.rectangle.y + i.rectangle.height)) {

                            movedBoxName = i.name;
                            break;
                        }
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                boolean movable = true;

                for(BoxAttributes i: boxes) {
                    if(i.isBox == 1) {
                        if((e.getX() >= i.rectangle.x) &&
                                (e.getX() <= i.rectangle.x + i.rectangle.width) &&
                                (e.getY() >= i.rectangle.y) &&
                                (e.getY() <= i.rectangle.y + i.rectangle.height)) {

                            movable = false;
                            break;
                        }
                    }
                }

                if(movable == true) {
                    for(BoxAttributes i: boxes) {
                        if(i.isBox == 1 && i.name == movedBoxName) {
                            i.rectangle.x = e.getX();
                            i.rectangle.y = e.getY();
                        }

                        if(i.isBox == 0 && movedBoxName == i.start) {
                            double newX1 = e.getX() + (width/2);
                            double newY1 = e.getY() + (height/2);
                            i.line = new Line2D.Double(newX1, newY1, i.line.getX2(), i.line.getY2());
                        }

                        if(i.isBox == 0 && movedBoxName == i.end) {
                            double newX1 = e.getX() + (width/2);
                            double newY1 = e.getY() + (height/2);
                            i.line = new Line2D.Double(i.line.getX1(), i.line.getY1(), newX1, newY1);
                        }
                    }
                }

                repaint();
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
                DrawBox drawBox = new DrawBox();
                drawBox.draw(g2d, box);
            }
            
            // if isBox = 0 then it's a relationship line so drawing that
            if(box.isBox == 0) {
                DrawRelationLine drawRelationLine = new DrawRelationLine();
                // relationship = 1 is Association
                if(box.relationship == 1) {
                    drawRelationLine.draw(g2d, box);
        
                    // decorator for association arrow head
                    DecoratorAssociation association = new DecoratorAssociation();
                    association.setDrawable(drawRelationLine);
                    association.draw(g2d, box);
                }
    
                // relationship = 2 is Aggregation
                else if(box.relationship == 2) {
                    drawRelationLine.draw(g2d, box);
        
                    // decorator for aggregation arrow head
                    DecoratorAggregation aggregation = new DecoratorAggregation();
                    aggregation.setDrawable(drawRelationLine);
                    aggregation.draw(g2d, box);
                }
    
                // relationship = 3 is Inheritance
                else {
                    drawRelationLine.draw(g2d, box);
        
                    // decorator for inheritance arrow head
                    DecoratorInheritance inheritance = new DecoratorInheritance();
                    inheritance.setDrawable(drawRelationLine);
                    inheritance.draw(g2d, box);
                }
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
