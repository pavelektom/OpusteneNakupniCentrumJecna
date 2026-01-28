package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Inventory;
import KonzoleVeci.Mistnost;
import KonzoleVeci.Predmet;

public class Poloz implements Command {

    @Override
    public void vykonat(Hra hra, String s) {
        String ahoj = s.trim().toLowerCase();
        if (ahoj.equals("") || s.trim().isEmpty() == true) {
            System.out.println("Vyberte jaky predmet chcete odebrat z inventare..");
            return;
        }
        Inventory inventar = hra.getInventar();
        Predmet p = inventar.odeber(ahoj);
        hra.getAktualniMistnost().pridatPredmet(p);

        if (p == null){
            System.out.println("Takovy predmet nemas");
            return;
        }
        System.out.println("Predmet " + s + " byl polozen.");
    }
}
