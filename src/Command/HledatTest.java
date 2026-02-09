package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Mistnost;
import KonzoleVeci.Predmet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HledatTest {


    @Test
    void testHledatNajdePredmet() {
        Hra hra = new Hra();
        Hledat hledat = new Hledat();
        hra.getNacitani().mistnosti.clear();
        Mistnost m = new Mistnost("hala", "velká hala", false, false, false);
        Predmet p1 = new Predmet("em", "ahoj", false);
        m.getPredmety().add(p1);
        hra.getNacitani().mistnosti.add(m);
        hra.setAktualniMistnost(m);
        String vysledek = hledat.vykonat(hra, "");
        assertEquals("Nasel jsi: em", vysledek);
        assertTrue(p1.isHledan());
    }
}