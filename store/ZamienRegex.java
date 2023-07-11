public class ZamienRegex {

    String dane[] = new String[3];
    public static String zamien(String wyraz){
        if (wyraz.contains("?")){
            return wyraz.replace("?",".");
        }
        else if (wyraz.contains("*")){
            return wyraz.substring(0, wyraz.indexOf("*"))+ ".*";
        }
        return wyraz;
    }

    public static String wyciagnijNazwe(String slowo){
        return slowo.substring(slowo.indexOf("(") + 1, slowo.indexOf(")"));
    }

    public void wyciagnijDaneProduktu(String slowo){
        dane[0] = slowo.substring(slowo.indexOf("(") + 1, slowo.indexOf(","));
        dane[1] = slowo.substring(slowo.indexOf(",") + 1, slowo.lastIndexOf(","));
        dane[2] = slowo.substring(slowo.lastIndexOf(",") + 1, slowo.indexOf(")"));
    }
}
