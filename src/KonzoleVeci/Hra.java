package KonzoleVeci;

import Command.Command;
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
import Command.Odemkni;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import KonzoleVeci.Nacitani;
import Postavy.Postava;

public class Hra {
        private ArrayList<Ukoly> ukoly;
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

    public String uvodDoHry(){ //Tato metoda slouzi k vypsani uvodu do hry, aby hrac vedel co delat.
        String vypis = "Vítej ve hře Opuštěné nákupní centrum Ječná" + "\n";
        vypis += "Probudil/a ses na studené dlažbě na zemi nákupního centra Ječná, je to tu dlouho opuštěné." +"\n";
        vypis += "Musíš se odtuď dostat živý/á, jestli se nedostaneš ven, zůstaneš tu uzavřený/á navždy." + "\n";
        vypis += "Momentalne se nachazis v : " + getAktualniMistnost() + "\n";
        vypis += "Kdybyste nevedel/a co delat, pouzij pomoc pro vypsani prikazu a napoveda pro napovedu" + "\n";

        return vypis;
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
    public String zpracujKod(String kod) { //Tato metoda nam zpracuje kod pro bezpecnostni panel
        if (!pojistkaVPanelu) {
            return "Pojistka není v panelu.";
        }
        if (!kod.equals("3110")) {
            setEnd(true);
            return "Špatný kód. Systém se uzamkl, zůstáváš tu navždy...";
        } else {
            setExtraZapnuti(true);
            getNacitani().najdiMistnost("vychod").setJeZamcena(false);
            getNacitani().najdiMistnost("nouzovy_vychod").setJeZamcena(false);

        }
        return "Systém restartován. Můžeš odejít!!!";
    }

//    public String zapnutiBezpecnostnihoSystemu(){ //Tato metoda je bezpecnostni panel, v "pouzij" si nastavime pojistkavpanelu == true
//        Scanner sc = new Scanner(System.in);
//        if (!pojistkaVPanelu == true){
//            return "Pojistka neni v panelu a nejde zapnout";
//        }
//        if (pojistkaVPanelu ==true){
//            System.out.println("Co je servisni kod?");
//            if (sc.nextLine().equals("3110")){
//                setExtraZapnuti(true); //Zeptame se hrace na servisni kod
//                if (extraZapnuti == true){ //Pokud ma spravny servisni kod musi odpovedet na lehkou rovnici matematiky
//                    String vypis = "Stvura: Ja si te nasel, myslis ze muzes jentak lehce odejit?"+ "\n";
//                    vypis += "Jestli mi odpovis na tento priklad tak te pustim..." + "\n";
//                    vypis += "x = 6 - 2x" + "\n";
//                    vypis += "x = ";
//                    System.out.println(vypis); // Pres vypis += abyste tam nemela systemoutprint :D
//                    if (sc.nextLine().equals("2")) { //Pokud umi matematiku tak muze pokracovat odemknutim centra celeho
//                        getNacitani().najdiMistnost("vychod").setJeZamcena(false); //Nastavujeme odemknuti vychodu a nouzoveho vychodu
//                        getNacitani().najdiMistnost("nouzovy_vychod").setJeZamcena(false);
//                        System.out.println("VYPNUL JSI SYSTEM MUZES ODEJIT!!!");
//                        getNacitani().ukoly.get(3).setSplneny(true);
//                    }else {
//                        String a = "Prohral jsi, neumis matematiku";
//                        System.out.println(a);
//                        setEnd(true); //Pokud neumi matematiku tak prohraje
//                     }
//                }
//            } else {
//                String a = "To je spatny kod. :(";
//                System.out.println(a);
//                setEnd(true);
//            }
//        }
//        return "";
//    }
    private boolean maPristupovoukartu;

    public boolean isMaPristupovoukartu() {
        return maPristupovoukartu;
    }

    public void setMaPristupovoukartu(boolean maPristupovoukartu) {
        this.maPristupovoukartu = maPristupovoukartu;
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
        prikazy.put("jdi", new Jdi()); //Pridavani prikazu do hashmapy, pomoci ktere muze hrac pouzivat prikazy
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
        Nacitani data = Nacitani.loadGameDataFromResources("resources/svet.json"); //Nacitani ze souboru
        this.ukoly = data.ukoly;
//        System.out.println("Predmety: " + data.predmety.size());
//        System.out.println("Postavy: " + data.postavy.size());
//        System.out.println("Mistnosti: " + data.mistnosti.size());
//        System.out.println("Ukoly: " + data.ukoly.size());
        this.nacitani = data;
        this.aktualniMistnost = data.najdiMistnost("hlavni_hala");
        pridaniPrikazu();
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

    public void sousediMistnost(){
        getAktualniMistnost().getSousedi();
    }

}