package Test;

import Command.Odemkni;
import KonzoleVeci.Mistnost;
import KonzoleVeci.Hra;
import KonzoleVeci.Predmet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OdemkniTest {
    Hra hra = new Hra();
    Odemkni odemkni = new Odemkni();

    void priprava(){
        hra.getNacitani().mistnosti.clear();
        Mistnost a = new Mistnost("elektronika","b",false,false,true);
        Mistnost b = new Mistnost("sklad","c",true,false,true);
        hra.getNacitani().mistnosti.add(a);
        hra.getNacitani().mistnosti.add(b);
        Predmet p =new Predmet("pristupova_karta", "e",false );
        a.getSousedi().add("sklad");
        b.getSousedi().add("elektronika");
        hra.getNacitani().mistnosti.get(0).getSousedi().add(hra.getNacitani().mistnosti.get(1).getNazev());
        hra.getNacitani().mistnosti.get(1).getSousedi().add(hra.getNacitani().mistnosti.get(0).getNazev());
        hra.getInventar().pridej(p);
        hra.setMaPristupovoukartu(true);
        hra.setAktualniMistnost(a);
    }

    @Test
    void vykonat() {
        priprava();
        assertEquals("Odemkl jsi sklad. ", odemkni.vykonat(hra, "sklad"));
    }
}