package KonzoleVeci;

import Command.Command;
import Postavy.Hrac;

import java.util.HashMap;
import KonzoleVeci.Nacitani;


public class Hra {
        private Hrac hrac;
        private HashMap<String, Command> prikazy = new HashMap<>();
        private Mistnost aktualniMistnost;

    public Hra() {
        Nacitani data = Nacitani.loadGameDataFromResources("resources/svet.json");
        System.out.println("Predmety: " + data.predmety.size());
        System.out.println("Postavy: " + data.postavy.size());
        System.out.println("Mistnosti: " + data.mistnosti.size());
        System.out.println("Ukoly: " + data.ukoly.size());
    }
    public Hrac getHrac() {
        return hrac;
    }

    public HashMap<String, Command> getPrikazy() {
        return prikazy;
    }

    public Mistnost getAktualniMistnost() {
        return aktualniMistnost;
    }

    public void setHrac(Hrac hrac) {
        this.hrac = hrac;
    }

    public void setPrikazy(HashMap<String, Command> prikazy) {
        this.prikazy = prikazy;
    }

    public void setAktualniMistnost(Mistnost aktualniMistnost) {
        this.aktualniMistnost = aktualniMistnost;
    }



}