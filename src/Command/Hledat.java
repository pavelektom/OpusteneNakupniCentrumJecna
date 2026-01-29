package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Mistnost;
import KonzoleVeci.Predmet;

public class Hledat implements Command {

    @Override
    public String vykonat(Hra hra, String s) {
        Mistnost m =hra.getAktualniMistnost();
        String vypis = "";
        boolean ahoj = true;
        boolean neco = false;

        for (Predmet p : m.getPredmety()) {
            if (!p.isSkryty() && !p.isHledan()) {
                p.setHledan(true);
                neco = true;
                if (!ahoj) {
                    vypis += "";
                }
                vypis += p.getNazev();
                ahoj = false;
            }
        }

        if (!neco) {
            return "Nic dalsiho jsi nenasel.";
        }

        return "Nasel jsi: " + vypis;

    }
}
