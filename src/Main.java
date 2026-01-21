import KonzoleVeci.Mistnost;
import KonzoleVeci.Nacitani;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Nacitani data = Nacitani.loadGameDataFromResources("resources/svet.json");

        System.out.println("OK nacteno mistnosti: " + data.mistnosti.size());
        System.out.println("Prvni mistnost: " + data.mistnosti.get(0).getNazev());
    }
}
