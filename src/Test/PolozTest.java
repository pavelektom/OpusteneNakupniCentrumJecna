package Test;

import Command.Poloz;
import KonzoleVeci.Hra;
import KonzoleVeci.Mistnost;
import KonzoleVeci.Predmet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolozTest {
    Hra hra = new Hra();
    Poloz poloz = new Poloz();

    @Test
    void polozTestik() {
        hra.getNacitani().mistnosti.clear();
        Mistnost m = new Mistnost("hala", "popis", false, false, false);
        hra.getNacitani().mistnosti.add(m);
        hra.setAktualniMistnost(m);
        Predmet p = new Predmet("em", "popis", false);
        hra.getInventar().pridej(p);
        poloz.vykonat(hra, "em");
        assertEquals(">> Inventar je prazdny.", hra.getInventar().vypis());
    }

    @Test
    void polozNic() {
        assertEquals("Vyberte jaky predmet chcete odebrat z inventare..", poloz.vykonat(hra, ""));
    }

    @Test
    void polozNemamTentoPredmetAchJoToJeSkoda() {
        hra.getNacitani().mistnosti.clear();
        Mistnost m = new Mistnost("hala", "popis", false, false, false);
        hra.getNacitani().mistnosti.add(m);
        hra.setAktualniMistnost(m);
        assertEquals("Takovy predmet nemas",poloz.vykonat(hra, "em"));
    }
}