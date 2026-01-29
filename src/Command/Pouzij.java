package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Inventory;
import KonzoleVeci.Predmet;

public class Pouzij implements Command {

    @Override
    public String vykonat(Hra hra, String s) {
        if (s ==null){
            return "Co chces pouzit?";
        }
        Inventory inventar = hra.getInventar();
        Predmet p = inventar.najdi(s);

        if (p==null){
            return "Tento predmet nemas.";
        }
        if (s.equalsIgnoreCase("baterka")){
            if (hra.getAktualniMistnost().isTemna()){
                hra.getAktualniMistnost().setTemna(false);
            }
        }
        if (s.equalsIgnoreCase("naradi")){
            if (!hra.getAktualniMistnost().getNazev().equals("food_court")){
                return "tady je zbytecne pouzit naradi";
            }
            if (hra.getAktualniMistnost().getNazev().equalsIgnoreCase("food_court")){
                hra.setTechnickaSkrinOtevrena(true);
                Predmet pojistka = hra.getNacitani().najdiPredmet("pojistka");
                hra.getAktualniMistnost().pridatPredmet(pojistka);
                return "Otevrel jsi technickou skrin, nasel jsi v ni pojistku :D";
            }
        }
        if (s.equalsIgnoreCase("pristupova_karta")){
            if (hra.getAktualniMistnost().getNazev().equals("elektronika")){
                hra.getNacitani().najdiMistnost("sklad").setJeZamcena(false);
                return "Otevrel jsi sklad. ";
            }
        }
        return "";
    }
}
