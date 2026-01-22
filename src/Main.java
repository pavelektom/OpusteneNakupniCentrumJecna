import KonzoleVeci.Mistnost;
import KonzoleVeci.Nacitani;
import KonzoleVeci.PousteniPrikazu;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Nacitani data = Nacitani.loadGameDataFromResources("resources/svet.json");

        System.out.println("mistnosti: " + data.mistnosti.size());
        PousteniPrikazu pust = new PousteniPrikazu();
        pust.spusteni();
    }
}
