package Command;

import static org.junit.jupiter.api.Assertions.*;


import KonzoleVeci.Hra;
import KonzoleVeci.Mistnost;
import KonzoleVeci.Nacitani;
import Postavy.Hrac;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class JdiTest {
    public ArrayList<Mistnost> mistnosti = new ArrayList<>();
    Hra hra = new Hra();
    Nacitani nacitani = new Nacitani();
    Jdi jdi = new Jdi();



    void pridat(){
        hra.getNacitani().mistnosti.clear();
        hra.getNacitani().mistnosti.add(new Mistnost("a","c",false,false,false));
        hra.getNacitani().mistnosti.add(new Mistnost("b","d",false,false,false));
        hra.getNacitani().mistnosti.get(0).getSousedi().add(hra.getNacitani().mistnosti.get(1).getNazev());
        hra.getNacitani().mistnosti.get(0).getSousedi().add(hra.getNacitani().mistnosti.get(0).getNazev());

    }

    @org.junit.jupiter.api.Test
    void vykonat() {
        pridat();
        hra.setAktualniMistnost(hra.getNacitani().mistnosti.get(0));
        jdi.vykonat(hra, "b");
        Assert.assertEquals(hra.getNacitani().mistnosti.get(1), hra.getAktualniMistnost());
    }
}