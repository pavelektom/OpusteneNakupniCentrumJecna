import KonzoleVeci.Nacitani;
import KonzoleVeci.PousteniPrikazu;
import KonzoleVeci.Hra;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        PousteniPrikazu pust = new PousteniPrikazu();
        Hra hra = new Hra();
        System.out.println(hra.uvodDoHry());
        pust.spusteni();
    }
}
