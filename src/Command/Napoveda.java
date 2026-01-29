package Command;

import KonzoleVeci.Hra;
import Postavy.Postava;

import java.util.Scanner;

public class Napoveda implements Command{
    Scanner sc = new Scanner(System.in);

    @Override
    public String vykonat(Hra hra, String s) {
        System.out.println("S cim potrebujes pomoct?");
        System.out.println("1 - Kam mam jit?");
        System.out.println("2 - Kdo je v teto mistnosti");
        String emm = ":D";
        switch (sc.next()) {
            case "1":
                System.out.println("Dostupne vychody - ");
                System.out.print(hra.getAktualniMistnost().getSousedi());
            case "2":
                if (hra.getAktualniMistnost().getPostavy().isEmpty()) {
                    return "V mistnosti nikdo neni.";
                }
                String text = "V mistnosti jsou postavy: ";
                for (Postava p : hra.getAktualniMistnost().getPostavy()) {
                    text = text + "\n" + " - " + p.getJmeno();
                }
                return text;
        }
        return emm;
    }
}
