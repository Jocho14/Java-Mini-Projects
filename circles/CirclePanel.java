import javax.swing.*;
import java.awt.*;

public class CirclePanel extends JPanel {
    private Circle circle;

    public CirclePanel(Circle circle) {
        this.circle = circle;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Point[] points = circle.getPoints();
        Color[] colors = circle.getColors();
        for (int i = 0; i < points.length; i++) {
            g.setColor(colors[i]);
            g.fillOval(points[i].x - Circle.RADIUS, points[i].y - Circle.RADIUS, Circle.DIAMETER, Circle.DIAMETER);
        }
    }
}





