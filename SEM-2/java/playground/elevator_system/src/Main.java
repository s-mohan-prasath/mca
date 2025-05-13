import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Elevator System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080,720);

        RectangleUI rect = new RectangleUI();
        JButton moveButton = new JButton("Start Elevator");

        moveButton.addActionListener(e->{
            rect.startEscalator(1);
            rect.repaint();
        });

        frame.setLayout(new BorderLayout());
        frame.add(rect, BorderLayout.CENTER);
        frame.add(moveButton, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}