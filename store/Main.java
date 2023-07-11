import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    /**
     * Aby uruchomić program w trybie sprzedawcy lub klienta należy podać argument:
     * K - Klient
     * S - Sprzedawca
     */
    public static void main(String[] args) {
        Sprzedawca sprzedawca = new Sprzedawca();
        Klient klient = new Klient();
        try {
            File file = new File("src//lista.txt"); //plik lista.txt musi znaleźć się w folderze \src
            Scanner scr = new Scanner(file);

            while (scr.hasNextLine()) {
                String str = scr.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(str, ", ");
                sprzedawca.getListaProduktow().add(new Produkt(tokenizer.nextToken(), tokenizer.nextToken(), Float.parseFloat(tokenizer.nextToken())));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku!" + e);
        }
        if (args[0].equals("K")) {
            System.out.println("Lista dostępnych produktów: ");
            sprzedawca.wyswietlArtykuly(sprzedawca.getListaProduktow());

            Wprowadzenie.wyswietlWprowadzenieKlienta();

            while (true) {
                Scanner scanner = new Scanner(System.in);
                String operacja = scanner.nextLine();

                if (operacja.matches("^dodaj do koszyka \\(\\d+\\)")) {
                    if (klient.sprawdzCzyJuzDodano(klient.koszyk, ZamienRegex.wyciagnijNazwe(operacja))) {
                        klient.dodajDoKoszyka(ZamienRegex.wyciagnijNazwe(operacja), sprzedawca.getListaProduktow());
                    }
                } else if (operacja.matches("^znajdz artykul \\(.*\\)$")) {
                    System.out.println(klient.znajdzArtykul(ZamienRegex.wyciagnijNazwe(operacja), sprzedawca.getListaProduktow()));

                } else if (operacja.equals("wycena zamowienia")) {
                    System.out.println("Należność za zakupy: " + klient.wycenaZamowienia(klient.koszyk) + "zł");

                } else if (operacja.equals("zrealizuj zamowienie")) {
                    klient.zrealizujZamowienie(klient.koszyk, sprzedawca);

                } else if (operacja.equals("exit")) {
                    System.exit(1);

                } else {
                    System.out.println("błędna operacja");
                }

            }
        }

        if (args[0].equals("S")) {
            System.out.println("Lista dostępnych produktów: ");
            sprzedawca.wyswietlArtykuly(sprzedawca.getListaProduktow());
            Wprowadzenie.wyswietlWprowadzenieSprzedawcy();

            while (true) {
                Scanner scanner = new Scanner(System.in);
                String operacja = scanner.nextLine();

                if (operacja.matches("^dodaj do magazynu \\(([0-1]+), ([a-zA-Z]+), ([0-9]+\\.[0-9]{1,2})\\)$")) {
                    ZamienRegex zamienRegex = new ZamienRegex();
                    zamienRegex.wyciagnijDaneProduktu(operacja);
                    sprzedawca.dodajArtykul(zamienRegex.dane[0], zamienRegex.dane[1], Float.parseFloat(zamienRegex.dane[2]));


                } else if (operacja.matches("^usun z magazynu \\(\\d+\\)$")) {
                    sprzedawca.pobierzArtykul(ZamienRegex.wyciagnijNazwe(operacja));
                } else if (operacja.equals("exit")) {
                    System.exit(1);
                } else {
                    System.out.println("Nieprawidlowa operacja lub nieprawidlowy format danych!");
                }
            }
        } else {
            System.out.println("Niepoprawny argument linii wywołania programu");
            return;
        }
    }
}