import java.awt.*;

/**
 * Title: Assignment 4
 * Description:  CSE 564 : Final project
 *
 * @author Aaditya Muley
 * ASUrite : amuley2
 * ASU ID : 1225526185
 * @version 1.0
 */
public class Decorator extends Drawable{
    protected Drawable drawable;
    
    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
    
    @Override
    public void draw(Graphics2D g2d, BoxAttributes box) {
        if(this.drawable != null) {
        this.drawable.draw(g2d, box);
        }
    }
}
