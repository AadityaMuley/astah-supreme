import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Observable;

public class BoxAttributes extends Observable {
    public int isBox = 1; // used in both constructors and determines if current object stores data for a rectangle or a relationship line
                          // 0-relationship line, 1-rectangle
    public String name;
    public Rectangle rectangle;
    public int relationship;
    public String start;
    public String end;
    public Line2D line;
    public String[] status = new String[2];

//    public BoxAttributes(int isBox, String name, Rectangle rectangle) {
//        this.isBox = isBox;
//        this.name = name;
//        this.rectangle = rectangle;
//    }
//
//    public BoxAttributes(int isBox, int relationship, String start, String end, Line2D line) {
//        this.isBox = isBox;
//        this.relationship = relationship;
//        this.start = start;
//        this.end = end;
//        this.line = line;
//    }
    
    public void setBoxAttributes(int isBox, String name, Rectangle rectangle) {
        this.isBox = isBox;
        this.name = name;
        this.rectangle = rectangle;
        status[0] = String.valueOf(isBox);
        status[1] = name;
        
        setChanged();
        notifyObservers();
    }
    
    public void setLineAttributes(int isBox, int relationship, String start, String end, Line2D line) {
        this.isBox = isBox;
        this.relationship = relationship;
        this.start = start;
        this.end = end;
        this.line = line;
        status[0] = String.valueOf(isBox);
        status[1] = String.valueOf(relationship);
        
        setChanged();
        notifyObservers();
    }
    
    public String[] getStatus() {
        return(status);
    }
}
