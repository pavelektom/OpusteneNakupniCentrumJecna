package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Predmet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventarTest {
    Hra hra = new Hra();
    Inventar inventar = new Inventar();
    @Test
    void prazdnyInventar() {
        assertEquals(">> Inventar je prazdny.", inventar.vykonat(hra, ""));
    }
    @Test
    void necoVInventariJe() {
        Predmet p = new Predmet("a","b", false);
        hra.getInventar().pridej(p);
        assertEquals(hra.getInventar().vypis(), inventar.vykonat(hra, ""));
    }

}