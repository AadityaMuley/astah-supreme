import javax.swing.*;
import java.awt.*;
<<<<<<< HEAD
import java.util.Observable;
import java.util.Observer;
=======
>>>>>>> ad5fd042fa546b79e960ea8707e0f8104bbdeae2

/**
 * Title: Assignment 4
 * Description:  CSE 564 : Final project
 *
 * @author Aaditya Muley
 * ASUrite : amuley2
 * ASU ID : 1225526185
 * @version 1.0
 */
<<<<<<< HEAD
public class PanelSourceCode extends JPanel implements Observer{

    JTextArea code = new JTextArea();
    
    PanelSourceCode() {
        JPanel codePanel = new JPanel();
        //JScrollPane scrollPane = new JScrollPane(codePanel);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        this.setLayout(new GridLayout());
        code.setText(" ");
        this.add(code);
        //this.add(scrollPane);
        

    }

    // public void printCode(){
    //     //JLabel code = new JLabel();
    //     CodeGeneration c = new CodeGeneration();
    //     //c.update(c);
    //     System.out.println("Print Code called");
    //     String generatedCode = c.getCode();
    //     System.out.println(generatedCode);
    //     code.setText(generatedCode);

    //     this.add(code);
    // }

    @Override
    public void update(Observable o, Object arg1) {
        // TODO Auto-generated method stub
        String generatedCode = ((CodeGeneration)o).getCode();
        //printCode();
        code.setText(generatedCode);
        System.out.println("Update Called");
        
=======
public class PanelSourceCode extends JPanel {
    
    PanelSourceCode() {
        JPanel codePanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(codePanel);

        this.setLayout(new GridLayout());
        this.add(scrollPane);
>>>>>>> ad5fd042fa546b79e960ea8707e0f8104bbdeae2
    }
}
