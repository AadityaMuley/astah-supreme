import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Title: Assingment 4
 * Description:  CSE 564 : Final project
 *
 * @author Aaditya Muley
 * ASUrite : amuley2
 * ASU ID : 1225526185
 * @version 1.0
 */
public class RelationSelector {
    
    static int relation = 1;
    
    public int getRelation() {
        JDialog dialog = new JDialog();
        dialog.setLayout(new GridLayout(3,1));
        dialog.setPreferredSize(new Dimension(200, 100));
    
        JButton association = new JButton("Association");
        association.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                relation = 1;
                dialog.dispose();
            }
        });
    
        JButton aggregation = new JButton("Aggregation");
        aggregation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                relation = 2;
                dialog.dispose();
            }
        });
    
        JButton inheritance = new JButton("Inheritance");
        inheritance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                relation = 3;
                dialog.dispose();
            }
        });
    
        dialog.add(association);
        dialog.add(aggregation);
        dialog.add(inheritance);
    
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);
        dialog.pack();
        dialog.setVisible(true);
        
        return relation;
    }
}
