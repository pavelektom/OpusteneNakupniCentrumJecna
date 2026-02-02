package KonzoleVeci;
import Command.Odemkni;
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
        private boolean maPristupovouKartu;

    public boolean isMaPristupovouKartu() {
        return maPristupovouKartu;
    }

    public void setMaPristupovouKartu(boolean maPristupovouKartu) {
        this.maPristupovouKartu = maPristupovouKartu;
    }

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
    private boolean extraZapnuti;
    private boolean technickaSkrinOtevrena;
    private boolean pojistkaVPanelu;

    public boolean isExtraZapnuti() {
        return extraZapnuti;
    }

    public void setExtraZapnuti(boolean extraZapnuti) {
        this.extraZapnuti = extraZapnuti;
    }

    public String zapnutiBezpecnostnihoSystemu(){
        Scanner sc = new Scanner(System.in);
        if (!pojistkaVPanelu == true){
            return "Pojistka neni v panelu a nejde zapnout";
        }
        if (pojistkaVPanelu ==true){
            System.out.println("Co je servisni kod?");
            if (sc.nextLine().trim().equalsIgnoreCase("3110")){
                setExtraZapnuti(true);
                if (extraZapnuti == true){
                    getNacitani().najdiMistnost("vychod").setJeZamcena(false);
                    getNacitani().najdiMistnost("nouzovy_vychod").setJeZamcena(false);
                    return "VYPNUL JSI SYSTEM MUZES ODEJIT!!!";
                }
            } else {
                return "To je spatny kod. :(";
            }
        }
        return "";

    }

    public boolean isPojistkaVPanelu() {
        return pojistkaVPanelu;
    }

    public void setPojistkaVPanelu(boolean pojistkaVPanelu) {
        this.pojistkaVPanelu = pojistkaVPanelu;
    }

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
        prikazy.put("odemkni", new Odemkni());
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