import java.util.ArrayList;
import java.util.List;

public class Sprzedawca {
    private List<Produkt> listaProduktow = new ArrayList<>();

    public void dodajArtykul(String kod, String nazwa, Float cena){
        for (Produkt produkt : listaProduktow) {
            if(produkt.getKod().equals(kod)){
                System.out.println("Produkt o danym kodzie znajduje sie juz w magazynie!");
                return;
            }
        }
        listaProduktow.add(new Produkt(kod, nazwa, cena));
        AktualizujPlik.aktualizacja(listaProduktow);
        System.out.println("Dodano nowy produkt do magazynu!");

    }

    public void usunArtykulKupionyPrzezSprzedawce(List<Produkt> koszyk){
        listaProduktow.removeAll(koszyk);
        AktualizujPlik.aktualizacja(listaProduktow);
    }

    public void pobierzArtykul(String kod){
        for (Produkt produkt : listaProduktow) {
            if(produkt.getKod().equals(kod)){
                listaProduktow.remove(produkt);
                AktualizujPlik.aktualizacja(listaProduktow);
                System.out.println("Usunieto produkt z magazynu!");
                return;
            }
        }
        System.out.println("Produkt o podanym kodzie nie znajduje sie w magazynie!");
    }

    public List<Produkt> getListaProduktow() {
        return listaProduktow;
    }

    public void wyswietlArtykuly(List<Produkt> listaProduktow){
        for(Produkt produkt : listaProduktow){
            System.out.println(produkt);
        }
    }

    @Override
    public String toString() {
        return "Sprzedawca{" +
                "listaProduktow=" + listaProduktow +
                '}';
    }
}
