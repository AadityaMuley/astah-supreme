import javax.swing.*;
import java.awt.*;

import java.util.Observable;
import java.util.Observer;


/**
 * Title: Assignment 4
 * Description:  CSE 564 : Final project
 *
 * @author Aaditya Muley
 * ASUrite : amuley2
 * ASU ID : 1225526185
 * @version 1.0
 */
public class PanelSourceCode extends JPanel implements Observer {
    
    JTextArea code = new JTextArea();
    
    PanelSourceCode() {
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        this.setLayout(new GridLayout());
        code.setText(" ");
        this.add(code);
    }
    
    @Override
    public void update(Observable o, Object arg1) {
        // TODO Auto-generated method stub
        String generatedCode = ((CodeGeneration) o).getCode();
        code.setText(generatedCode);
    }
}
