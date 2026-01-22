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
            return;
        }
        if (aktualni.getSousedi() == null || !aktualni.getSousedi().contains(cil)) {
            System.out.println("Tam odtud jit nemuzes");
            return;
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
            return;
        }
        hra.setAktualniMistnost(cilova);
        System.out.println(cilova.getNazev());
        System.out.println(cilova.getPopis());
        if (cilova.isTemna()) {
            System.out.println("Je tu tma");
        }
    }

}