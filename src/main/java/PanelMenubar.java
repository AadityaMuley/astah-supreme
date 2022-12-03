import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.beans.EventHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Title: Assignment 4
 * Description:  CSE 564 : Final project
 *
 * @author Aaditya Muley
 * ASUrite : amuley2
 * ASU ID : 1225526185
 * @version 1.0
 */
public class PanelMenubar extends JPanel {

    PanelDrawUml drawUml = new PanelDrawUml();
    JButton loadButton;
    JButton saveButton;
    private ArrayList<BoxAttributes> boxes = new ArrayList<>();


    PanelMenubar() {

        loadButton = new JButton("Load");
        saveButton = new JButton("Save");


        ActionListener saveListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = "";
                boxes = drawUml.getBoxes();

                for(BoxAttributes box: boxes) {
                    if(box.isBox == 1) {
                        result += box.isBox + ","
                                + box.name + ","
                                + box.rectangle.x + ","
                                + box.rectangle.y + ","
                                + box.rectangle.width + ","
                                + box.rectangle.height + "\n";
                    }
                    else {
                        result += box.isBox + ","
                                + box.relationship + ","
                                + box.start + ","
                                + box.end + ","
                                + box.line.getX1() + ","
                                + box.line.getY1() + ","
                                + box.line.getX2() + ","
                                + box.line.getY2() + "\n";
                    }
                }

                saveFile(result);
            }
        };

        ActionListener loadListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                loadFile();
                drawUml.setBoxes(boxes);

            }
        };

        loadButton.addActionListener(loadListener);
        saveButton.addActionListener(saveListener);
        add(loadButton);
        add(saveButton);
    }


    public ArrayList<BoxAttributes> getBoxes() {
        return this.boxes;
    }



    public void saveFile(String result) {
        JFileChooser fileChooser1 = new JFileChooser();
        int retrival = fileChooser1.showSaveDialog(null);
        if(retrival == JFileChooser.APPROVE_OPTION) {
            try {
                System.out.println(result);     /////////////////////////////////////////////
                FileWriter fw = new FileWriter(fileChooser1.getSelectedFile() + ".txt");
                fw.write(result);
                fw.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    public void loadFile() {
        JFileChooser fileChooser2 = new JFileChooser();
        String scanValue = "";

        if(fileChooser2.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = fileChooser2.getSelectedFile();
                Scanner scanner = new Scanner(selectedFile);
                BoxAttributes box;

                while(scanner.hasNext()) {
                    scanValue = scanner.nextLine();
                    String[] strings = scanValue.split(",", 0);

                    if(Integer.parseInt(strings[0]) == 1) {
                        box = new BoxAttributes();
                        Data d = Data.getInstance();
                        box.isBox = Integer.parseInt(strings[0]);
                        box.name = strings[1];
                        box.rectangle = new Rectangle(Integer.parseInt(strings[2]),
                                                      Integer.parseInt(strings[3]),
                                                      Integer.parseInt(strings[4]),
                                                      Integer.parseInt(strings[5]));
                        box.status[0] = strings[0];
                        box.status[1] = strings[1];
                        boxes.add(box);
                        d.addClass(strings[1]);
                        box.loadCode();
                        
                    }
                    else if(Integer.parseInt(strings[0]) == 0) {
                        box = new BoxAttributes();
                        Data d = Data.getInstance();
                        box.isBox = Integer.parseInt(strings[0]);
                        box.relationship = Integer.parseInt(strings[1]);
                        box.start = strings[2];
                        box.end = strings[3];
                        box.line = new Line2D.Double(Double.parseDouble(strings[4]),
                                                     Double.parseDouble(strings[5]),
                                                     Double.parseDouble(strings[6]),
                                                     Double.parseDouble(strings[7]));
                        box.status[0] = strings[0];
                        box.status[1] = strings[1];
                        boxes.add(box);
                        int rel = Integer.parseInt(strings[1]);
                        d.updateClass(strings[2], rel ,strings[3]);
                        box.loadCode();
                        
                    }
                }

            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }





}
