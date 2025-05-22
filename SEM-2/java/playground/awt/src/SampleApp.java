import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SampleApp extends Frame {
    public SampleApp() {
        setTitle("Sample App");
        setSize(500,500);
        setLayout(new GridLayout(2,1));

        Panel panel1 = new Panel();
        Panel panel2 = new Panel();
        panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel2.setLayout(new FlowLayout(FlowLayout.TRAILING));

        Button b1 = new Button("Button 1");
        Button b2 = new Button("Button 1");
        Button b3 = new Button("Button 1");
        Button b4 = new Button("Button 1");

        panel1.add(b1);
        panel1.add(b2);
        panel1.add(b3);
        panel2.add(b4);

        add(panel1);
        add(panel2);

        setVisible(true);
    }
}
