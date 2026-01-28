package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Inventory;
import KonzoleVeci.Mistnost;
import KonzoleVeci.Predmet;

public class Vezmi implements Command {

    @Override
    public void vykonat(Hra hra, String s) {
        if (s.trim().equals("")){
            System.out.println("Co chces vzit? ");
        } else {
           Inventory inventar = hra.getInventar();
           Predmet p = hra.getNacitani().najdiPredmet(s);
           inventar.pridej(p);
           hra.getAktualniMistnost().odeberPredmet(s);
           System.out.println("Predmet byl pridan do inventare ");
        }




    }
}

