package Command;
import KonzoleVeci.Hra;
import KonzoleVeci.Inventory;
import KonzoleVeci.PinFrame;
import KonzoleVeci.Predmet;

//Tato trida je pro pouziti predmetu
public class Pouzij implements Command {

    @Override
    public String vykonat(Hra hra, String s) {
        if (s ==null){
            return "Co chces pouzit?"; // Pokud hrac nic nenapise vratime, "Co chces pouzit?"
        }
        Inventory inventar = hra.getInventar();
        Predmet p = inventar.najdi(s);

        if (p==null){ // Pokud nema predmet, vratime mu "Tento predmet nemas."
            return "Tento predmet nemas.";
        }
        if (s.equalsIgnoreCase("baterka")){     //Pokud predmet je baterka, nastavime v temne
            if (hra.getAktualniMistnost().isTemna()){       //Pokud je misntost temna, rozsviti se
                hra.getAktualniMistnost().setTemna(false);
                hra.getNacitani().najdiMistnost("bezpecnostni_mistnost").setJeZamcena(false);
                hra.getNacitani().najdiMistnost("potraviny").setJeZamcena(false); //odemknou se potraviny a bezpecnostni mistnost, protoze hrac uz vidi
                return "Pouzil jsi baterku, uz vidis kolem a muzes jit do mistnosti";
            } else{
                return "Tady ti je baterka k nicemu...";
            }
        }
//        if (s.equalsIgnoreCase("pojistka")) {                               // Pokud je predmet pojistka overime si, ze hrac je v bezpecnostni mistnosti
//            if (!hra.getAktualniMistnost().getNazev().equalsIgnoreCase("bezpecnostni_mistnost")){
//                return "Tady pojistku pouzit je zbytecne.";
//            }
//            if (hra.getAktualniMistnost().getNazev().equalsIgnoreCase("bezpecnostni_mistnost")){
//                hra.setPojistkaVPanelu(true) ;                                          // pote nastavime boolean pro tuto metodu
//                hra.zapnutiBezpecnostnihoSystemu();                                     // -> a pomoci metody ve Hre pouzijeme pouziti panelu
//            }
//        }

        if (s.equalsIgnoreCase("pojistka")) {
            if (!hra.getAktualniMistnost().getNazev().equalsIgnoreCase("bezpecnostni_mistnost")) {
                return "Tady pojistku pouzit je zbytecne.";
            }
            hra.setPojistkaVPanelu(true);
            new PinFrame(hra);
            return "Zapínám bezpečnostní panel...";
        }
        if (s.equalsIgnoreCase("naradi")){                                  // Pokud je predmet narad overime si, ze hrac je ve food courtu
            if (!hra.getAktualniMistnost().getNazev().equals("food_court")){
                return "tady je zbytecne pouzit naradi";
            }
            if (hra.getAktualniMistnost().getNazev().equalsIgnoreCase("food_court")){
                hra.setTechnickaSkrinOtevrena(true);                                    //Pokud je, nastavime ze skrinka je otevrena
                Predmet pojistka = hra.getNacitani().najdiPredmet("pojistka");
                pojistka.setHledan(true);                                               // Nastavime ze pojistka byla hledana, aby hrac nemusel davat prikaz hledat
                hra.getAktualniMistnost().pridatPredmet(pojistka);                      // a pridame pojistku do mistnosti
                return "Otevrel jsi technickou skrin, nasel jsi v ni pojistku :D";
            }
        }
        return "";
    }
}
