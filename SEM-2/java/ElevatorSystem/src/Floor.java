import javax.swing.*;
import java.awt.*;

public class Floor extends JPanel {
    private final int NUMBER;
    public Floor(int n) {
        this.NUMBER = n;
        setLayout(new BorderLayout());
        setOpaque(true);
        setBounds(0, ( ESystem.TOTAL_FLOORS-NUMBER-1) * ESystem.FLOOR_HEIGHT, ESystem.FLOOR_WIDTH, ESystem.FLOOR_HEIGHT);
        setBackground(new Color(240, 240, 240));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createTitledBorder("Floor " + n)
        ));
    }
    public void addPerson(Person person) {
        add(person);
        revalidate();
        repaint();
    }

    public void removePerson(Person person) {
        remove(person);
        revalidate();
        repaint();
    }

    @Override
    public String toString() {
        return "[FLOOR : " + NUMBER+"]";
    }
}
