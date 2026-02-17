package Test;

import Command.Hledat;
import Command.Vezmi;
import KonzoleVeci.Hra;
import KonzoleVeci.Mistnost;
import KonzoleVeci.Predmet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VezmiTest {
    Hra hra = new Hra();
    Vezmi vezmi = new Vezmi();
    @Test
    void neprohledanaMistnostTest() {
        hra.getNacitani().mistnosti.clear();
        Mistnost m = new Mistnost("hala", "popis", false, false, false);
        hra.getNacitani().mistnosti.add(m);
        hra.setAktualniMistnost(m);
        Predmet p = new Predmet("em", "popis", false);
        hra.getAktualniMistnost().pridatPredmet(p);
        assertEquals("Tenhle predmet tu mooooznaaaa je, zkus treba jeste neco...",vezmi.vykonat(hra, "em"));
    }

    @Test
    void vezmiNic() {
        hra.getNacitani().mistnosti.clear();
        assertEquals("Co chces vzit? ", vezmi.vykonat(hra, ""));
    }

    @Test
    void normalneProhledanaMistnostTest() {
        hra.getNacitani().mistnosti.clear();
        Mistnost m = new Mistnost("hala", "popis", false, false, false);
        hra.getNacitani().mistnosti.add(m);
        hra.setAktualniMistnost(m);
        Predmet p = new Predmet("em", "popis", false);
        hra.getAktualniMistnost().pridatPredmet(p);
        Hledat hledat = new Hledat();
        hledat.vykonat(hra, "");
        assertEquals("Vzal jsi: em - popis",vezmi.vykonat(hra, "em"));
    }

    @Test
    void predmetTuNeni() {
        hra.getNacitani().mistnosti.clear();
        assertEquals("Takovy predmet tu neni..", vezmi.vykonat(hra, "ahoj"));
    }
}