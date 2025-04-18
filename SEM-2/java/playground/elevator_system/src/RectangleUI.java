import javax.swing.*;
import java.awt.*;

public class RectangleUI extends JPanel {
    private int yPosition = 100;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Set color and draw rectangle
        g.setColor(Color.BLACK);
        g.fillRect(100, yPosition, 100, 100);  // x, y, width, height
    }
    public void moveUp(int dist){
        yPosition-=dist;
    }
    public void moveDown(int dist){
        yPosition+=dist;
    }
}
