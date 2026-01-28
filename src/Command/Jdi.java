package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Mistnost;

public class Jdi implements Command {




    @Override
    public String vykonat(Hra hra, String s) {
        String cil = s;
        Mistnost aktualni = hra.getAktualniMistnost();

        if (aktualni == null) {
            return "neni nastavena aktualni mistnost";                             // Tady se zkontroluje jestli je nastavena aktualni mistnost, neboli jestli se spravne nacetly soubory.
        }
        if (aktualni.getSousedi() == null || !aktualni.getSousedi().contains(cil)) {
            return "Tam odtud jit nemuzes";                             // Kdyz hrac zada mistnost, ktera neni soused, vypise se mu "Tam odtud jit nemuzes".
        }
        Mistnost cilova = null;
        for (Mistnost m : hra.getNacitani().mistnosti) {
            if (m != null && cil.equals(m.getNazev())) {
                cilova = m;
                break;
            }
        }
        if (cilova.isJeZamcena()) {
            return "Mistnost je zamcena";                             // Pokud je mistnost zamcena, tak se mu vypise toto a hrac nemuze vstoupit.
        }
        hra.setAktualniMistnost(cilova);        // Nastavim akutalni mistnost na tu, kterou hrac zadal.
        System.out.println(cilova.getNazev());  // Vypise se nazev mistnosti
        if (cilova.isTemna()) {                 // Pokud je v mistnosti tma, hrac nemuze hledat predmety v mistnosti. proto mu oznamime jestli je tma.
            System.out.println("Je tu tma");
        }
        return cilova.getPopis();
    }
}