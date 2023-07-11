public class Wprowadzenie {

    public static void wyswietlWprowadzenieKlienta(){
        System.out.println("\nJesteś klientem sklepu, dostepne operacje: ");
        System.out.println("dodaj do koszyka (KOD produktu)");
        System.out.println("znajdz artykul (nazwa produktu) (?  zastępuje 1 znak, *  zastępuje dowolny ciąg znaków o długości >= 0)");
        System.out.println("wycena zamowienia");
        System.out.println("zrealizuj zamowienie");
        System.out.println("Wpisz operację oraz zatwierdź przyciskiem ENTER. Aby opuścić sklep wpisz: exit\n");
    }

    public static void wyswietlWprowadzenieSprzedawcy(){
        System.out.println("\nJesteś sprzedawcą (magazynierem) sklepu, dostepne operacje: ");
        System.out.println("\ndodaj do magazynu (KOD produktu, nazwa, cena)  - dokladnie w takim formacie");
        System.out.println("Nazwa produktu nie moze zawierac polskich znakow, a cena ma byc w formacie [liczba].[cyfra][cyfra] lub [liczba].[cyfra]");
        System.out.println("Na przyklad (10000, jablko, 1212.12) lub (10000, pomidor, 1.3)");
        System.out.println("\nusun( z magazynu (KOD produktu)");
        System.out.println("\nWpisz operację oraz zatwierdź przyciskiem ENTER. Aby opuścić sklep wpisz: exit\n");
    }
}
