package KonzoleVeci;

import Command.Command;
import Postavy.Hrac;
import Command.Jdi;
import Command.Konec;
import Command.Napoveda;
import Command.Inventar;
import Command.Hledat;
import Command.Prozkoumej;
import Command.List;
import Command.Pomoc;
import Command.Vezmi;
import Command.Poloz;
import Command.Pouzij;
import Command.Mluv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import KonzoleVeci.Nacitani;
import Postavy.Postava;

public class Hra {
        private ArrayList<Ukoly> ukoly;
        private Hrac hrac;
        private HashMap<String, Command> prikazy = new HashMap<>();
        private Mistnost aktualniMistnost;
        private boolean End;
        private Nacitani nacitani;
        Scanner sc = new Scanner(System.in);
        private Inventory inventar = new Inventory(4);
        private Predmet predmety;
        private boolean hledany;
        private Postava postavy;

    public boolean isHledany() {
        return hledany;
    }

    public void setHledany(boolean hledany) {
        this.hledany = hledany;
    }

    public Predmet getPredmety() {
        return predmety;
    }

    public Nacitani getNacitani() {
        return nacitani;
    }

    public ArrayList<Ukoly> getUkoly() {
        return ukoly;
    }

    public void setUkoly(ArrayList<Ukoly> ukoly) {
        this.ukoly = ukoly;
    }

    private boolean technickaSkrinOtevrena;

    public boolean isTechnickaSkrinOtevrena() {
        return technickaSkrinOtevrena;
    }

    public void setTechnickaSkrinOtevrena(boolean technickaSkrinOtevrena) {
        this.technickaSkrinOtevrena = technickaSkrinOtevrena;
    }

    public void pridaniPrikazu(){
        prikazy.put("jdi", new Jdi());
        prikazy.put("napoveda", new Napoveda());
        prikazy.put("konec", new Konec());
        prikazy.put("inventar", new Inventar());
        prikazy.put("poloz", new Poloz());
        prikazy.put("pouzij", new Pouzij());
        prikazy.put("vezmi", new Vezmi());
        prikazy.put("ukoly", new List());
        prikazy.put("pomoc", new Pomoc());
        prikazy.put("hledat", new Hledat());
        prikazy.put("prozkoumej", new Prozkoumej());
        prikazy.put("mluv", new Mluv());
    }
    public Hra() {
        Nacitani data = Nacitani.loadGameDataFromResources("resources/svet.json");
        this.ukoly = data.ukoly;
        System.out.println("Predmety: " + data.predmety.size());
        System.out.println("Postavy: " + data.postavy.size());
        System.out.println("Mistnosti: " + data.mistnosti.size());
        System.out.println("Ukoly: " + data.ukoly.size());
        this.nacitani = data;
        this.aktualniMistnost = data.najdiMistnost("hlavni_hala");
        pridaniPrikazu();
    }
    public Hrac getHrac() {
        return hrac;
    }

    public Inventory getInventar() {
        return inventar;
    }

    public void setInventar(Inventory inventar) {
        this.inventar = inventar;
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