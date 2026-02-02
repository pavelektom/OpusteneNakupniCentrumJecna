package KonzoleVeci;

import java.util.Scanner;

public class PousteniPrikazu {
    private Hra hra;
    Scanner sc = new Scanner(System.in);

    private void provadeniPrikazu() {
        System.out.print(">> ");
        String prikaz = sc.nextLine();
        String[] rozdeleni = prikaz.split(" ");
        String nazevPrikazu = rozdeleni[0].toLowerCase();
        String upresneniPrikazu = "";
        if (rozdeleni.length > 1) {
            upresneniPrikazu = rozdeleni[1];
        }
        if (hra.getPrikazy().containsKey(nazevPrikazu)) {
            System.out.println(hra.getPrikazy().get(nazevPrikazu).vykonat(hra,upresneniPrikazu));
        } else {
            System.out.println(">> Tento prikaz neexistuje");
        }
    }

    public void spusteni(){
        hra = new Hra();
        do {
            provadeniPrikazu();
        } while (!hra.isEnd());
    }

}
