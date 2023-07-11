import java.awt.*;
import java.util.ArrayList;

public class ColorListGenerator {
    private ArrayList<Color> colors;

    public ColorListGenerator(int n){
        colors = new ArrayList<>(n);

        for(int i = 0; i < n; i++){
            Color generatedColor = null;
            boolean shouldRun = true;
            boolean checker;

            while (shouldRun) {
                checker = true;
                generatedColor = new Color((int) (Math.random() * 0x1000000));

                for (Color color : colors) {
                    if (color.equals(generatedColor)) {
                        checker = false;
                        break;
                    }
                }
                if (checker) {
                    shouldRun = false;
                }
            }
            colors.add(generatedColor);
        }
    }

    public Color getColor(int index){
        return colors.get(index);
    }
}
