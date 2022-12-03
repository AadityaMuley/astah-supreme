import javax.swing.*;
import java.awt.*;

public class help {

    JDialog helpDialog;
    JLabel label1, label2, label3, label4;

    public help() {
        helpDialog = new JDialog();
        helpDialog.setTitle("Group Members: ");
        helpDialog.setLayout(new GridLayout(4,1));
        label1 = new JLabel("Aaditya Mulay");
        label2 = new JLabel("Yichen Wang");
        label3 = new JLabel("Jash Pramod Kahar");
        label4 = new JLabel("Manasi Jayant Anantpurkar");

        helpDialog.add(label1);
        helpDialog.add(label2);
        helpDialog.add(label3);
        helpDialog.add(label4);
        helpDialog.setSize(250, 250);
        helpDialog.setLocationRelativeTo(null);
        helpDialog.setVisible(true);
    }
}
