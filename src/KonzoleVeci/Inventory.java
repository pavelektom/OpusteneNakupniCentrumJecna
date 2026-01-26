package KonzoleVeci;

import java.util.ArrayList;

public class Inventory {
    private int kapacita;
    private ArrayList<Predmet> predmety;

    public Inventory(int kapacita) {
        this.kapacita = kapacita;
        this.predmety = new ArrayList<>();
    }

    public boolean pridej(Predmet p) {                  // Tato metoda pridava predmet do inventare, ale jenom pokud je v inventari dostatek mista
        if (predmety.size() >= kapacita || p == null) { // Take kontroluje jestli hrac vubec zadal nejaky predmet.
            return false;                               // Tady se dozvime jestli hrac ma misto v inventari pro dany predmet, pokud ne, nenechame ho pridat predmet.
        }else {
            predmety.add(p);                            // Pokud ma misto, predmet se prida.
            return true;
        }

    }
    public ArrayList<Predmet> getPredmety() {
        return predmety;
    }
}

