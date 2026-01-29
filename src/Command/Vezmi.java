package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Inventory;
import KonzoleVeci.Mistnost;
import KonzoleVeci.Predmet;

public class Vezmi implements Command {



    @Override
    public String vykonat(Hra hra, String s) {
        if (s.trim().equals("")) {
            return "Co chces vzit? ";
        }
        String nazev = s.trim();
        Predmet p = hra.getAktualniMistnost().odeberPredmet(nazev);

        if (p == null) {
            return "Takovy predmet tu neni..";
        }
        if (p.isSkryty()) {
            hra.getAktualniMistnost().pridatPredmet(p);
            return "Tenhle predmet tu mozna je, kdo vi...";
        }
        if (!p.isHledan()) {
            hra.getAktualniMistnost().pridatPredmet(p);
            return "Tenhle predmet tu mooooznaaaa je, zkus treba jeste neco...";
        }

        Inventory inventar = hra.getInventar();
        if (!inventar.pridej(p)) {
            hra.getAktualniMistnost().pridatPredmet(p);
            return "Inventar je plny neco musis polozit jestli chces toto zvednout :(";
        }
        return "Vzal jsi: " + p.getNazev();
    }
}

