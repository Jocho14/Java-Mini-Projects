public class CircleThread extends Thread {
    private Circle circle;
    private int index;
    private double angularVelocity;
    private CirclePanel circlePanel;

    public CircleThread(Circle circle, int index, CirclePanel circlePanel, double angularVelocity) {
        this.circle = circle;
        this.index = index;
        this.circlePanel = circlePanel;
        this.angularVelocity = angularVelocity;
    }

    public void setAngularVelocity(double angularVelocity) {
        this.angularVelocity = angularVelocity;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (CircleThread.class) {
                circle.move(index, angularVelocity);
                circlePanel.repaint();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }

            if (angularVelocity == 0) {
                this.interrupt();
            }

           if (angularVelocity > 0 && this.isInterrupted()) {
                this.interrupt();
            }
        }
    }
}
