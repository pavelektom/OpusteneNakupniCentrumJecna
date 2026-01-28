package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Inventory;
import KonzoleVeci.Mistnost;
import KonzoleVeci.Predmet;

public class Poloz implements Command {

    @Override
    public String vykonat(Hra hra, String s) {
        String ahoj = s.trim().toLowerCase();
        if (ahoj.equals("") || s.trim().isEmpty() == true) {
            return "Vyberte jaky predmet chcete odebrat z inventare..";
        }
        Inventory inventar = hra.getInventar();
        Predmet p = inventar.odeber(ahoj);
        hra.getAktualniMistnost().pridatPredmet(p);

        if (p == null){
            return "Takovy predmet nemas";
        }

        return "Predmet " + s + " byl polozen.";
    }
}
