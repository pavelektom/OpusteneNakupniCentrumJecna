package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Inventory;
import KonzoleVeci.Mistnost;
import KonzoleVeci.Predmet;

public class Vezmi implements Command {

    @Override
    public String vykonat(Hra hra, String s) {
        if (s.trim().equals("")) {
            System.out.println("Co chces vzit? ");
        }
       Inventory inventar = hra.getInventar();
       Predmet p = hra.getNacitani().najdiPredmet(s);
       inventar.pridej(p);
       hra.getAktualniMistnost().odeberPredmet(s);
       return "Predmet byl pridan do inventare ";

    }
}

