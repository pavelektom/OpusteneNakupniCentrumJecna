package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Predmet;

public class Prozkoumej implements Command {

    @Override
    public String vykonat(Hra hra, String s) {
        String vypis = "";
        boolean dobryDenPaniUcitelko = true;
        boolean neco = false;

        for (Predmet p : hra.getAktualniMistnost().getPredmety()) {
            if (p.isSkryty()) {
                p.setSkryty(false);
                neco = true;
                if (!dobryDenPaniUcitelko) {
                    vypis += "";
                }
                vypis += p.getNazev();
                dobryDenPaniUcitelko = false;
            }
        }
        if (!neco) {
            return "Nic noveho jsi neobjevil.";
        }
        return "Odhalil jsi: " + vypis;

    }
}
