package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Mistnost;

public class Jdi implements Command {




    @Override
    public void vykonat(Hra hra, String s) {
        String cil = s;
        Mistnost aktualni = hra.getAktualniMistnost();

        if (aktualni == null) {
            System.out.println("neni nastavena aktualni mistnost");
            return;                             // Tady se zkontroluje jestli je nastavena aktualni mistnost, neboli jestli se spravne nacetly soubory.
        }
        if (aktualni.getSousedi() == null || !aktualni.getSousedi().contains(cil)) {
            System.out.println("Tam odtud jit nemuzes");
            return;                             // Kdyz hrac zada mistnost, ktera neni soused, vypise se mu "Tam odtud jit nemuzes".
        }
        Mistnost cilova = null;
        for (Mistnost m : hra.getNacitani().mistnosti) {
            if (m != null && cil.equals(m.getNazev())) {
                cilova = m;
                break;
            }
        }
        if (cilova.isJeZamcena()) {
            System.out.println("Mistnost je zamcena");
            return;                             // Pokud je mistnost zamcena, tak se mu vypise toto a hrac nemuze vstoupit.
        }
        hra.setAktualniMistnost(cilova);        // Nastavim akutalni mistnost na tu, kterou hrac zadal.
        System.out.println(cilova.getNazev());  // Vypise se nazev mistnosti
        System.out.println(cilova.getPopis());  // Tady se vypise popis mistnosti. (pisou se mi podtrzitka nevim co s tim)
        if (cilova.isTemna()) {                 // Pokud je v mistnosti tma, hrac nemuze hledat predmety v mistnosti. proto mu oznamime jestli je tma.
            System.out.println("Je tu tma");
        }
    }
}