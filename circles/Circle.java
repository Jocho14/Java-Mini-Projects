import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Circle {

    public static final int RADIUS = 20;
    public static final int DIAMETER = RADIUS * 2;
    private final double MAX_RADIANS = 6.28318530718;

    private Point[] points;
    private Color[] colors;
    private double[] angles;
    boolean checker;
    private ArrayList<Point> pointList;
    private ArrayList<Double> angleList;
    private JSlider[] slider;

    public void setJSlider(JSlider[] slider){
        this.slider = slider;
    }

    public Circle(int n, ColorListGenerator colorList) {
        pointList = new ArrayList<>();
        points = new Point[n];
        colors = new Color[n];
        angles = new double[n];
        angleList = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int centerX = 0;
            int centerY = 0;
            double angle = 0;
            boolean shouldRun = true;
            checker = true;

            while (shouldRun) {
                checker = true;
                angle = random.nextDouble() * 360;

                angle = Math.toRadians(angle);
                centerX = (int) (17.5 * RADIUS + 14 * RADIUS * Math.cos(angle));
                centerY = (int) (17.5 * RADIUS + 14 * RADIUS * Math.sin(angle));

                for (Point point : pointList) {
                    double distance = Math.sqrt((centerX - point.x) * (centerX - point.x)
                            + (centerY - point.y) * (centerY - point.y));
                    if (distance < DIAMETER) {
                        checker = false;
                        break;
                    }
                }
                if (checker) {
                    shouldRun = false;
                }
            }
            angleList.add(angle);
            pointList.add(new Point(centerX, centerY));
            points[i] = new Point(centerX, centerY);
            colors[i] = colorList.getColor(i);
        }
    }

    public void move(int index, double angularVelocity) {
        angles[index] += Math.toRadians(angularVelocity / 20);
        angles[index] %= MAX_RADIANS;

        double angle = angles[index];
        angle += angleList.get(index);

        points[index].x = (int) (17.5 * RADIUS + 14 * RADIUS * Math.cos(angle));
        points[index].y = (int) (17.5 * RADIUS + 14 * RADIUS * Math.sin(angle));

        for (int i = 0; i < points.length; i++) {
            if (i == index) continue;

            double iAngleValue = (angles[i] + angleList.get(i)) % MAX_RADIANS;
            double indexAngleValue = (angles[index] + angleList.get(index)) % MAX_RADIANS;

            if((iAngleValue - indexAngleValue) > 0 && (iAngleValue - indexAngleValue) < 0.1){
                slider[index].setValue(slider[i].getValue());
                angles[index] = (angles[index] - 0.05);
                i++;
            }
        }
    }
    public Point[] getPoints() {
        return points;
    }

    public Color[] getColors() {
        return colors;
    }
}

