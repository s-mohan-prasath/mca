import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class awt_18_05_2025 extends Frame {
    public awt_18_05_2025(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setSize(1000,500);
        setTitle("awt_18_05_2025");

        Button b1 = new Button("Start of the Course");
        Button b2 = new Button("First year ends");
        Button b3 = new Button("Second year ends");
        Button b4 = new Button("Graduation on");
        TextArea area = new TextArea(2,20);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setText("August 2024");
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setText("June 2025");
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setText("May 2026");
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setText("On June 2026");
            }
        });
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(area);
        setVisible(true);
    }
    public static void main(String[] args) {
        new awt_18_05_2025();
    }
}