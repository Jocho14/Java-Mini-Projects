import javax.swing.*;
import java.awt.*;

public class LeafPanel extends JPanel {
    private LeafColor leafColor;
    private final int width;
    private final int height;

    public LeafPanel(int width, int height) {
        leafColor = new LeafColor();
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width * SnailLife.CELL_SIZE, height * SnailLife.CELL_SIZE));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                g.setColor(leafColor.colorArray[SnailLife.leaf[i][j]]);
                g.fillRect(i * SnailLife.CELL_SIZE, j * SnailLife.CELL_SIZE, SnailLife.CELL_SIZE, SnailLife.CELL_SIZE);
                if (Snail.occupied[i][j]) {
                    g.setColor(Color.RED);
                    g.fillOval(i * SnailLife.CELL_SIZE + (SnailLife.CELL_SIZE / 4), j * SnailLife.CELL_SIZE + (SnailLife.CELL_SIZE / 4),
                            SnailLife.CELL_SIZE / 2, SnailLife.CELL_SIZE / 2);
                }
            }
        }
    }
}

