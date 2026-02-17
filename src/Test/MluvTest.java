package Test;

import Command.Mluv;
import KonzoleVeci.Hra;
import KonzoleVeci.Mistnost;
import Postavy.Postava;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MluvTest {
    Postava p= new Postava("ahoj", "ok", "dobry den");
    Hra hra = new Hra();
    Mluv mluv = new Mluv();
    @Test
    void nikdoTuNeni() {
        Mistnost m = new Mistnost("a","b",false, false, true);
        hra.getNacitani().mistnosti.clear();
        hra.getNacitani().mistnosti.add(m);
        hra.setAktualniMistnost(m);
        assertEquals("V teto mistnosti nikdo neni..", mluv.vykonat(hra, ""));
    }
    @Test
    void prazdnyVstup(){
        hra.setAktualniMistnost(hra.getNacitani().najdiMistnost("kancelar"));
        assertEquals("S kym chces mluvit? ", mluv.vykonat(hra, ""));
    }
    @Test
    void spravnyVstup(){
        hra.setAktualniMistnost(hra.getNacitani().najdiMistnost("kancelar"));
        assertEquals("Alena | Hele, neco ti reknu, musis to tady prohledat, nekde se tu bude nachazet servisni kod. pomoci neho budes moci odemknout bezpecnostni panel, ja ho dlouho zpet ztratila a nemam tuseni kde je.", mluv.vykonat(hra, "Alena"));
    }
}