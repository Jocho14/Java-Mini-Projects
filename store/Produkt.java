public class Produkt {
    private final String kod;
    private final String nazwa;
    private final Float cena;

    public Produkt(String kod, String nazwa, Float cena) {
        this.kod = kod;
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public String getKod() {
        return kod;
    }

    public String getNazwa() {
        return nazwa;
    }

    public Float getCena() {
        return cena;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "kod='" + kod + '\'' +
                ", nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                '}';
    }
}
