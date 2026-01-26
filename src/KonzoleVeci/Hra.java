package KonzoleVeci;

import Command.Command;
import Postavy.Hrac;
import Command.Jdi;
import Command.Konec;
import Command.Napoveda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import KonzoleVeci.Nacitani;

public class Hra {
        private ArrayList<Ukoly> ukoly = new ArrayList<>();
        private Hrac hrac;
        private HashMap<String, Command> prikazy = new HashMap<>();
        private Mistnost aktualniMistnost;
        private boolean End;
        private Nacitani nacitani;
        Scanner sc = new Scanner(System.in);

    public Nacitani getNacitani() {
        return nacitani;
    }

    public void pridaniPrikazu(){
        prikazy.put("jdi", new Jdi());
        prikazy.put("napoveda", new Napoveda());
        prikazy.put("konec", new Konec());
    }
    public Hra() {
        this.nacitani = Nacitani.loadGameDataFromResources("resources/svet.json");
        Nacitani data = Nacitani.loadGameDataFromResources("resources/svet.json");
        System.out.println("Predmety: " + data.predmety.size());
        System.out.println("Postavy: " + data.postavy.size());
        System.out.println("Mistnosti: " + data.mistnosti.size());
        System.out.println("Ukoly: " + data.ukoly.size());
        this.aktualniMistnost = data.najdiMistnost("hlavni_hala");
        pridaniPrikazu();
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


    public boolean isEnd() {
        return End;
    }

    public void setEnd(boolean end) {
        End = end;
    }
}