import java.util.ArrayList;
import java.util.List;

public class Klient {

    public List<Produkt> koszyk = new ArrayList<>();

    public List<Produkt> znajdzArtykul(String nazwaArtykulu, List<Produkt> listaProduktow) throws IllegalArgumentException {
            List<Produkt> znalezioneProdukty = new ArrayList<>();
            for (Produkt produkt : listaProduktow) {
                if (produkt.getNazwa().matches(ZamienRegex.zamien(nazwaArtykulu))) {
                    znalezioneProdukty.add(produkt);
                }
            }
            if (znalezioneProdukty.size() < 1){
                System.out.println("Nie znaleziono podanego artykulu");
            }
            return znalezioneProdukty;
    }

    public void dodajDoKoszyka(String kod, List<Produkt> listaProduktow) throws IllegalArgumentException{
        for (Produkt produkt : listaProduktow) {
            if(produkt.getKod().equals(kod)){
                koszyk.add(produkt);
                System.out.println("Dodano produkt do koszyka!");
                return;
                }
            }
            System.out.println("nie znaleziono produktu o kodzie " + kod);
        }

    public float wycenaZamowienia(List<Produkt> koszyk) throws IllegalArgumentException{
        float suma = 0;
        for (Produkt produkt : koszyk) {
            suma += produkt.getCena();
        }
        return (float) (Math.round(suma * 100.0) / 100.0);
    }

    public void zrealizujZamowienie(List<Produkt> koszyk, Sprzedawca sprzedawca) throws IllegalArgumentException{
        sprzedawca.usunArtykulKupionyPrzezSprzedawce(koszyk);
        koszyk.clear();
        System.out.println("Zrealizowano zamowienie!");
    }

    public boolean sprawdzCzyJuzDodano(List <Produkt> koszyk, String kod){
        for (Produkt produkt : koszyk) {
            if(produkt.getKod().equals(kod)){
                System.out.println("Ten produkt znajduje sie juz w koszyku!");
                return false;
            }
        }
        return true;
    }
}


