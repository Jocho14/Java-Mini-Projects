import java.util.Random;
import javax.swing.*;

public class SnailLife {
    public static final int CELL_SIZE = 40; // rozmiar komórki
    private static final int REFRESH_RATE = 20000; // częstotliwość odświeżania wartości komórek liścia (w milisekundach)
    private static final int SLEEP_T_DURATION = 1000;
    private static final int SPEED_V_CONSUMPTION = 10;

    public static int[][] leaf;
    private Random random = new Random();
    private JFrame frame;

    private LeafPanel leafPanel;

    public SnailLife(int width, int height, int snailCount) {
        frame = new JFrame("Życie ślimaków");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        leafPanel = new LeafPanel(width, height);

        leaf = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                leaf[i][j] = random.nextInt(11);
            }
        }

        startAndRefreshLeafThread(width, height);

        for (int i = 0; i < snailCount; i++) {
            Snail snail = new Snail(width, height);
            SnailThread snailThread = new SnailThread(snail, leafPanel, SLEEP_T_DURATION, SPEED_V_CONSUMPTION);
            snailThread.start();
        }

        frame.add(leafPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        int snailCount = Integer.parseInt(args[2]);

        try{
            checkRatio(width, height, snailCount);
            SwingUtilities.invokeLater(() -> new SnailLife(width, height, snailCount));
        } catch (Exception e){
            System.out.println("Wystąpił błąd: " + e);
        }
    }

    static void checkRatio(int width, int height, int snailCount)throws IncorrectRatioException{
        if(width * height < snailCount){
            throw new IncorrectRatioException("\n" + "Liczba ślimaków jest niepoprawna w stosunku do liczby komórek liścia!");
        }
    }

    private void startAndRefreshLeafThread(int width, int height) {
        Thread refreshThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(REFRESH_RATE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (leaf) {
                    for (int i = 0; i < width; i++) {
                        for (int j = 0; j < height; j++) {
                            if (leaf[i][j] < 10) {
                                leaf[i][j] += 1;
                            }
                        }
                    }
                }
                leafPanel.repaint();
            }
        });
        refreshThread.start();
    }
}



