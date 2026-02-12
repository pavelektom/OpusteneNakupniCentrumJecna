package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Ukoly;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    Hra hra = new Hra();
    List list = new List();

    @Test
    void nemasUkoly() {
        hra.getUkoly().clear();
        assertEquals("Nemas zadne ukoly", list.vykonat(hra, ""));
    }

    @Test
    void nesplnenyUkol() {
        hra.getUkoly().clear();
        hra.getUkoly().add(new Ukoly("a","b",false));
        assertEquals("Tvoje ukoly  " +"\n" + " - " + "a" + "\n" +  "      -> " + "b"+  "\n" + "      -> nesplneny" + "\n", list.vykonat(hra, ""));

    }
    @Test
    void splnenyUkol() {
        hra.getUkoly().clear();
        hra.getUkoly().add(new Ukoly("a","b",true));
        assertEquals("Tvoje ukoly  " +"\n" + " - " + "a" + "\n" +  "      -> " + "b"+  "\n" + "      -> splneny" + "\n", list.vykonat(hra, ""));

    }

}