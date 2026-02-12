package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Mistnost;

import java.util.Scanner;
//tato trida je pouzita pro pohyb mezi mistnostmi
public class Jdi implements Command {

    public Jdi() {
    }

    @Override
    public String vykonat(Hra hra, String s) {
        String cil = s;
        Mistnost aktualni = hra.getAktualniMistnost();

        if (aktualni == null) {
            return "neni nastavena aktualni mistnost";                             // Tady se zkontroluje jestli je nastavena aktualni mistnost, neboli jestli se spravne nacetly soubory.
        }
        if (aktualni.getSousedi() == null || !aktualni.getSousedi().contains(cil)) {
            return "Tam odtud jit nemuzes";                             // Kdyz hrac zada mistnost, ktera neni soused, vypise se mu "Tam odtud jit nemuzes".
        }
        Mistnost cilova = null;
        for (Mistnost m : hra.getNacitani().mistnosti) {
            if (m != null && cil.equals(m.getNazev())) {
                cilova = m;
                break;
            }
        }
        if (hra.getNacitani().najdiMistnost("vychod").isJeZamcena() == false){ //Pokud je vychod odemceny(hrac odemkl system), tak hrac muze odejit z bezpecnostniho centra
            if (s.equalsIgnoreCase("vychod")) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Chces odejit z obchodniho centra?");
                if (sc.next().equalsIgnoreCase("ano")) {
                    hra.setEnd(true); //nastavime konec hry
                    hra.getNacitani().ukoly.get(4).setSplneny(true); //nastavovani ukoly
                    return "VÝHRA! GRATULUJU!!!";
                }else {
                    return "Ok, zustavas v hlavni hale";
                }
            }
        }
        if (hra.getNacitani().najdiMistnost("nouzovy_vychod").isJeZamcena() == false){// Stejne jak vychod, pokud hrac odemkne system, tak muze jit kratsi cestou
            if (s.equalsIgnoreCase("nouzovy_vychod")) {                         // ale kratsi cesta neni jentak za nic, musi vypocitat od stvury matematiku aby mohl jit
                Scanner sc = new Scanner(System.in);
                System.out.println("Chces odejit z obchodniho centra?");
                if (sc.nextLine().equalsIgnoreCase("ano")) {
                    System.out.println("Stvura: Ahoj přišel jsem sem, jentak tě nenechám odejít grrrr");
                    System.out.println("Stvura: Jaké číslo z oboru celých čísel následuje jedničku? ");
                    if (sc.nextInt() == 2) {
                        hra.setEnd(true); // nastavime konec hry
                        hra.getNacitani().ukoly.get(4).setSplneny(true);// Splnime ukoly
                        return "VÝHRA! GRATULUJU!!!";
                    } else {
                        hra.setEnd(true); //nastavime take konec hry, tentokrat prohru :(
                        return "Umíráš, stvůra tě sežrala....";
                    }
                } else {
                    return "Ok, zustavas v bezpecnostni mistnosti";
                }
            }
        }

        if (cilova.isJeZamcena()) {
            return "Mistnost je zamcena";                             // Pokud je mistnost zamcena, tak se mu vypise toto a hrac nemuze vstoupit.
        }
        hra.setAktualniMistnost(cilova);        // Nastavim akutalni mistnost na tu, kterou hrac zadal.
        System.out.println(cilova.getNazev());  // Vypise se nazev mistnosti
        if (cilova.isTemna()) {                 // Pokud je v mistnosti tma, hrac nemuze hledat predmety v mistnosti. proto mu oznamime jestli je tma.
            System.out.println("Je tu tma");
        }
        return cilova.getPopis();
    }
}