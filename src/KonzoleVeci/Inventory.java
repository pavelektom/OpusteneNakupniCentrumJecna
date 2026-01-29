package KonzoleVeci;

import java.util.ArrayList;

public class Inventory {
    private int kapacita;
    private ArrayList<Predmet> predmety;

    public Inventory(int kapacita) {
        this.kapacita = kapacita;
        this.predmety = new ArrayList<>();
    }

    public Predmet najdi(String nazev){
        for(Predmet p : predmety){
            if(p.getNazev().equalsIgnoreCase(nazev)){
                return p;
            }
        }
        return null;
    }

    public boolean pridej(Predmet p) {
        if (p == null){
            return false;                               // Tato metoda pridava predmet do inventare, ale jenom pokud je v inventari dostatek mista
        }
        if (predmety.size() >= kapacita) {              // Take kontroluje jestli hrac vubec zadal nejaky predmet.
            return false;                               // Tady se dozvime jestli hrac ma misto v inventari pro dany predmet, pokud ne, nenechame ho pridat predmet.
        }else {
            predmety.add(p);                            // Pokud ma misto, predmet se prida.
            return true;
        }


    }
    public String vypis() { // V teto metode zjistime co je v inventari, pokud nic, vypiseme, ze je prazdny.
        if (predmety.isEmpty()) {
            return ">> Inventar je prazdny.";
        }
        String vypis = ">> kapacita inventare: " + predmety.size() + "/" + kapacita + " \n";
        for (Predmet p : predmety) {
            vypis = vypis + " - " + p.getNazev() + " ";
        }
        return vypis;
    }

    public Predmet odeber(String nazev) { // Tuto metodu pouzivame na odebrani predmetu z inventare, pouziju ho v commandu Poloz
        if (nazev == null) {
            return null;
        }
        for(int i = 0; i < predmety.size(); i++){
            Predmet predmet = predmety.get(i);
            if (predmet.getNazev().equalsIgnoreCase(nazev)) {
                predmety.remove(i);
                return predmet;
            }
        }
        return null;
    }


}

