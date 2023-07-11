import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class AktualizujPlik {

    public static void aktualizacja(List<Produkt> listaProduktow){
        try {
            File file = new File("src//lista.txt");
            PrintWriter printWriter = new PrintWriter(file);

            for(Produkt produkt : listaProduktow){
                printWriter.println(produkt.getKod() + ", " + produkt.getNazwa() + ", " + produkt.getCena());
            }
            printWriter.close();
        } catch
        (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
