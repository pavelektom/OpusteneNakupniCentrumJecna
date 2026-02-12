package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Inventory;
import KonzoleVeci.Mistnost;
import KonzoleVeci.Predmet;
//Tato trida slouzi pro brani predmetu z mistnosti
public class Vezmi implements Command {



    @Override
    public String vykonat(Hra hra, String s) {
        if (s.trim().equals("")) { // Pokud hrac nic nenapise vratime mu ->
            return "Co chces vzit? ";
        }
        String nazev = s.trim();
        Predmet p = hra.getAktualniMistnost().odeberPredmet(nazev); //Nastavime, ze predmet je ten, ktery byl v mistnosti

        if (p == null) {
            return "Takovy predmet tu neni.."; //Pokud tu predmet, ktery hrac chtel neni, vratime mu toto
        }
        if (p.isSkryty()) {
            hra.getAktualniMistnost().pridatPredmet(p); //Pokud je predmet skryty, vratime predmet do mistnosti a toto vypiseme
            return "Tenhle predmet tu mozna je, kdo vi...";
        }
        if (!p.isHledan()) {
            hra.getAktualniMistnost().pridatPredmet(p);// Pokud jeste nebyla trida prohledana tak ->
            return "Tenhle predmet tu mooooznaaaa je, zkus treba jeste neco...";
        }
        if (p.getNazev().equals("pristupova_karta")) { //Pokud bere pristupovou kartu, nastavime boolean pro prikaz odemkni
            hra.setMaPristupovoukartu(true);
        }
        if (p.getNazev().equals("baterka")) { //Pokud bere baterku, nastavime ukol jako hotovy
            hra.getNacitani().ukoly.get(0).setSplneny(true);
        }
        if (p.getNazev().equals("pojistka")) { //Stejne jak u baterky
            hra.getNacitani().ukoly.get(2).setSplneny(true);
        }
        Inventory inventar = hra.getInventar();
        if (!inventar.pridej(p)) { //Nakonec overime, ze hrac ma misto v inventari
            hra.getAktualniMistnost().pridatPredmet(p);
            return "Inventar je plny neco musis polozit jestli chces toto zvednout :(";
        }
        return "Vzal jsi: " + p.getNazev() + " - "+ p.getPopis(); //Vypiseme co hrac vzal
    }
}

