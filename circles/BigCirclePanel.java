import javax.swing.*;
import java.awt.*;

public class BigCirclePanel extends JPanel {
    public static final int LARGE_RADIUS = 280;
    public static final int LARGE_DIAMETER = LARGE_RADIUS * 2;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(350 - LARGE_RADIUS, 350 - LARGE_RADIUS, LARGE_DIAMETER, LARGE_DIAMETER);
    }
}