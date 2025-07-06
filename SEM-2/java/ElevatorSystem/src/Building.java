import javax.swing.*;
import java.awt.*;


public class Building extends JLayeredPane {
    Floor[] floors;
    public Building(Floor[] floors) {
        this.floors = floors;
        setOpaque(true);
        setPreferredSize(new Dimension(ESystem.FLOOR_WIDTH,ESystem.TOTAL_FLOORS*ESystem.FLOOR_HEIGHT));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        for (int i = 0; i < ESystem.TOTAL_FLOORS; i++) {
            floors[i] = new Floor(i);
            add(floors[i],JLayeredPane.DEFAULT_LAYER);
            System.out.println(floors[i].toString()+" is rendered");
        }
    }
}
