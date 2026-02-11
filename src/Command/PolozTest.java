package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Mistnost;
import KonzoleVeci.Predmet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolozTest {

    @Test
    void polozTestik() {
        Hra hra = new Hra();
        hra.getNacitani().mistnosti.clear();
        Mistnost m = new Mistnost("hala", "popis", false, false, false);
        hra.getNacitani().mistnosti.add(m);
        hra.setAktualniMistnost(m);
        Predmet p = new Predmet("em", "popis", false);
        hra.getInventar().pridej(p);
        Poloz poloz = new Poloz();
        assertEquals("Predmet em byl polozen.", poloz.vykonat(hra, "em"));
    }

    @Test
    void polozNic() {
        Hra hra = new Hra();
        Poloz poloz = new Poloz();
        assertEquals("Vyberte jaky predmet chcete odebrat z inventare..", poloz.vykonat(hra, ""));
    }

    @Test
    void polozNemamTentoPredmetAchJoToJeSkoda() {
        Hra hra = new Hra();
        hra.getNacitani().mistnosti.clear();
        Mistnost m = new Mistnost("hala", "popis", false, false, false);
        hra.getNacitani().mistnosti.add(m);
        hra.setAktualniMistnost(m);
        Poloz poloz = new Poloz();
        assertEquals("Takovy predmet nemas", poloz.vykonat(hra, "em"));
    }
}