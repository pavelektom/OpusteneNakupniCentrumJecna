package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Predmet;
//Prozkoumej je pro predmety, ktere jsou HODNE schovane
public class Prozkoumej implements Command {

    @Override
    public String vykonat(Hra hra, String s) {
        String vypis = "";
        boolean neco = false;
        for (Predmet p : hra.getAktualniMistnost().getPredmety()) { //projdeme vsechny predmety v aktualni mistnosti
            if (p.isSkryty()) {// pokud je skryty
                neco = true;
                p.setSkryty(false); // odkryjeme ho
                p.setHledan(true); // dame i aby hrac nemusel dat prikaz hledat
                vypis += p.getNazev(); //nastavime predmet ktery odhalil
            }
        }
        if (!neco) {
            return "Nic noveho jsi neobjevil.";
        }
        return "Odhalil jsi: " + vypis; //vratime co odhalil

    }
}
