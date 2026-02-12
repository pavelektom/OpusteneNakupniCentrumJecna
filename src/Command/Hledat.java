package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Mistnost;
import KonzoleVeci.Predmet;
 //Tato trida je pro hledani predmetu, ktere jsou v kazde mistnosti
//Je to pro predmety, ktere nepotrebuji prikaz prozkoumej
public class Hledat implements Command {

    @Override
    public String vykonat(Hra hra, String s) {
        Mistnost m =hra.getAktualniMistnost();
        String vypis = "";
        boolean ahoj = true;
        boolean neco = false;

        for (Predmet p : m.getPredmety()) {
            if (!p.isSkryty() && !p.isHledan()) {  //pokud predmet je prozkoumany a neni hledany, nastavime ze byl prohledany
                p.setHledan(true);
                neco = true;
                vypis += p.getNazev(); //vypiseme :D
            }
        }

        if (!neco) {
            return "Nic jsi nenasel.";
        }

        return "Nasel jsi: " + vypis;

    }
}
