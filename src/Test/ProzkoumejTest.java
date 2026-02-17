package Test;

import Command.Prozkoumej;
import KonzoleVeci.Hra;
import KonzoleVeci.Mistnost;
import KonzoleVeci.Predmet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProzkoumejTest {
    Hra hra = new Hra();
    Prozkoumej prozkoumej = new Prozkoumej();

    @Test
    void odhalenoJupi() {
        hra.getNacitani().mistnosti.clear();
        hra.getNacitani().mistnosti.add(new Mistnost("hala", "velká hala", false, false, true));
        hra.getNacitani().mistnosti.getFirst().getPredmety().add(new Predmet("em", "ahoj", true));
        hra.setAktualniMistnost(hra.getNacitani().mistnosti.getFirst());
        assertEquals("Odhalil jsi: em", prozkoumej.vykonat(hra, ""));
    }
    @Test
    void prazdnaMistnost() {
        hra.getNacitani().mistnosti.clear();
        hra.getNacitani().mistnosti.add(new Mistnost("hala", "velká hala", false, false, true));
        hra.setAktualniMistnost(hra.getNacitani().mistnosti.getFirst());
        assertEquals("Nic noveho jsi neobjevil.", prozkoumej.vykonat(hra, ""));
    }

}