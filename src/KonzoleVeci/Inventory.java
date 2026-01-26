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

    public void vypis() { // V teto metode zjistime co je v inventari, pokud nic, vypiseme, ze je prazdny.
        if (predmety.isEmpty()) {
            System.out.println(">> Inventar je prazdny.");
            return;
        }
        System.out.println(">> kapacita inventare: " + predmety.size() + "/" + kapacita + " ");
        for (Predmet p : predmety) {
            System.out.println(" - " + p.getNazev());
        }
    }

    public Predmet odeber(String nazev) { // Tuto metodu pouzivame na odebrani predmetu z inventare, pouziju ho v commandu Poloz
        if (nazev == null) {
            return null;
        }
        for (int i = 0; i < predmety.size(); i++) {
            Predmet p = predmety.get(i);
            if (p.getNazev().equalsIgnoreCase(nazev)) {
                predmety.remove(i);
                return p;
            }
        }
        return null;
    }


}

