import java.awt.*;
import java.awt.geom.Line2D;

public class BoxAttributes {
    public int isBox = 1; // used in both constructors and determines if current object stores data for a rectangle or a relationship line
                          // 0-relationship line, 1-rectangle
    public String name;
    public Rectangle rectangle;
    public int relationship;
    public Line2D line;

    public BoxAttributes(int isBox, String name, Rectangle rectangle) {
        this.isBox = isBox;
        this.name = name;
        this.rectangle = rectangle;
    }
    
    public BoxAttributes(int isBox, int relationship, Line2D line) {
        this.isBox = isBox;
        this.relationship = relationship;
        this.line = line;
    }
}
