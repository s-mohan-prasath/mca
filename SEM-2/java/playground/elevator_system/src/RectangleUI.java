import javax.swing.*;
import java.awt.*;

public class RectangleUI extends JPanel {
    private int yPosition = 100, width = 100, height = 100;
    private char direction = 'u';

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(100, yPosition, width, height);
    }

    public void moveUp(int dist) {
        yPosition -= dist;
    }

    public void moveDown(int dist) {
        yPosition += dist;
    }

    public void startEscalator(int moveDist) {
        Timer timer = new Timer(25, e -> {
            // Check if moving up and has reached the top
            if (direction == 'u') {
                if (yPosition <= 0) {
                    direction = 'd'; // switch to down
                } else {
                    moveUp(moveDist);
                }
            } else { // moving down
                if (yPosition + height >= getHeight()) {
                    direction = 'u'; // switch to up
                } else {
                    moveDown(moveDist);
                }
            }
            repaint(); // redraw the rectangle
        });
        timer.start();
    }
}
