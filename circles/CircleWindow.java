import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class CircleWindow {

    private JFrame frame;
    private Circle circle;
    private CirclePanel circlePanel;
    private BigCirclePanel bigCircle;
    private JSlider[] speedSliders;
    private CircleThread[] threads;

    public CircleWindow(int n) {
        frame = new JFrame("Kółka");
        frame.setSize(900, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ColorListGenerator colorList = new ColorListGenerator(n);

        circle = new Circle(n, colorList);
        circlePanel = new CirclePanel(circle);
        bigCircle = new BigCirclePanel();

        circlePanel.setOpaque(false);
        bigCircle.setOpaque(false);

        JPanel panel = new JPanel();

        panel.setLayout(new OverlayLayout(panel));
        panel.add(circlePanel);
        panel.add(bigCircle);
        frame.add(panel);

        JPanel sliderPanel = new JPanel(new GridLayout(n, 1));
        speedSliders = new JSlider[n];
        ChangeListener sliderListener = e -> {
            JSlider slider = (JSlider) e.getSource();
            int index = -1;
            for (int i = 0; i < n; i++) {
                if (slider == speedSliders[i]) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                threads[index].setAngularVelocity(slider.getValue());
            }
        };

        for (int i = 0; i < n; i++) {
            speedSliders[i] = new JSlider(0, 100, (int) (Math.random() * (100 + 1)));
            speedSliders[i].setBackground(colorList.getColor(i));

            speedSliders[i].addChangeListener(sliderListener);
            sliderPanel.add(speedSliders[i]);
        }

        frame.add(sliderPanel, BorderLayout.EAST);

        threads = new CircleThread[n];
        for (int i = 0; i < n; i++) {
            circle.setJSlider(speedSliders);
            threads[i] = new CircleThread(circle, i, circlePanel, speedSliders[i].getValue());
            threads[i].start();
        }
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        try{
            checkCircleCount(n);
            SwingUtilities.invokeLater(() -> new CircleWindow(n));
        } catch (Exception e){
            System.out.println("Wystąpił błąd: " + e);
        }
    }

    static void checkCircleCount(int n)throws CircleCountException{
        if(n > 30){
            throw new CircleCountException("\n" + "Wprowadzono za dużo kółek");
        }
    }
}
