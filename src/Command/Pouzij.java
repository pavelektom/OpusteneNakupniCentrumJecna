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
                hra.getNacitani().najdiMistnost("bezpecnostni_mistnost").setJeZamcena(false);
                hra.getNacitani().najdiMistnost("potraviny").setJeZamcena(false);
                return "Pouzil jsi baterku, uz vidis kolem a muzes jit do mistnosti";
            }
        }
        if (s.equalsIgnoreCase("pojistka")) {
            if (!hra.getAktualniMistnost().getNazev().equalsIgnoreCase("bezpecnostni_mistnost")){
                return "Tady pojistku pouzit je zbytecne.";
            }
            if (hra.getAktualniMistnost().getNazev().equalsIgnoreCase("bezpecnostni_mistnost")){
                hra.setPojistkaVPanelu(true) ;
                hra.zapnutiBezpecnostnihoSystemu();
            }
        }
        if (s.equalsIgnoreCase("naradi")){
            if (!hra.getAktualniMistnost().getNazev().equals("food_court")){
                return "tady je zbytecne pouzit naradi";
            }
            if (hra.getAktualniMistnost().getNazev().equalsIgnoreCase("food_court")){
                hra.setTechnickaSkrinOtevrena(true);
                Predmet pojistka = hra.getNacitani().najdiPredmet("pojistka");
                pojistka.setHledan(true);
                hra.getAktualniMistnost().pridatPredmet(pojistka);
                return "Otevrel jsi technickou skrin, nasel jsi v ni pojistku :D";
            }
        }
        return "";
    }
}
