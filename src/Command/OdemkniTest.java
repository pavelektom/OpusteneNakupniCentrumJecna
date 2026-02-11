package Command;

import KonzoleVeci.Mistnost;
import KonzoleVeci.Hra;
import KonzoleVeci.Predmet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OdemkniTest {
    Hra hra = new Hra();
    Predmet p = hra.getNacitani().najdiPredmet("pristupova_karta");


    Odemkni odemkni = new Odemkni();
    @Test
    void vykonat() {
        hra.setAktualniMistnost(hra.getNacitani().najdiMistnost("elektronika"));
        hra.getInventar().pridej(p);
        odemkni.vykonat(hra, "sklad");
    }
}