import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Snail {
    private static int width;
    private static int height;

    private int t;
    private int v;

    private int x;
    private int y;
    public static boolean[][] occupied; //true - jest ślimak, false - nie ma ślimaka

    private boolean checker;

    public Snail(int width, int height) {
        if (occupied == null) {
            Snail.width = width;
            Snail.height = height;
            occupied = new boolean[width][height];
        }

        Random random = new Random();

        boolean shouldRun = true;
        checker = true;
        while (shouldRun) {
            checker = true;
            x = random.nextInt(width);
            y = random.nextInt(height);

            if (occupied[x][y]) {
                checker = false;
            }

            if (checker) {
                shouldRun = false;
            }
        }
        occupied[x][y] = true;
    }

    public void move() {
        List<int[]> moveOptions = new ArrayList<>();
        List<Integer> leafValues = new ArrayList<>();

        Random random = new Random();
        int newX, newY;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) {
                    continue;
                }
                newX = x + dx;
                newY = y + dy;

                if (newX >= 0 && newX < width && newY >= 0 && newY < height) {
                    if (SnailLife.leaf[x][y] < SnailLife.leaf[newX][newY]
                            && SnailLife.leaf[newX][newY] > 0 && !occupied[newX][newY]) {
                        moveOptions.add(new int[]{newX, newY});
                        leafValues.add(SnailLife.leaf[newX][newY]);
                    }
                }
            }
        }

        if (moveOptions.size() > 0) {
            int maximum = Collections.max(leafValues);

            for (int i = 0; i < moveOptions.size(); i++) {
                int[] move = moveOptions.get(i);
                if (SnailLife.leaf[move[0]][move[1]] < maximum) {
                    moveOptions.remove(i);
                }
            }

            if (moveOptions.size() > 0){
                int[] chosenMove = moveOptions.get(random.nextInt(moveOptions.size()));
                occupied[x][y] = false;

                x = chosenMove[0];
                y = chosenMove[1];
                occupied[x][y] = true;
            }
        }

        else {
            try {
                Thread.sleep(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void eat() {
        if (SnailLife.leaf[x][y] > 0) {
            SnailLife.leaf[x][y]--;
        }
        try {
            Thread.sleep(v);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setT(int t) {
        this.t = t;
    }

    public void setV(int v) {
        this.v = v;
    }
}



