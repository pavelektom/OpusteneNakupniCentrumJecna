package Command;

import KonzoleVeci.Hra;
import Postavy.Postava;

import java.util.Scanner;
//Pomoci napovedy se hrac muze dozvedet kam jit a jestli nekdo je v mistnosti, kde se prave hrac nachazi
public class Napoveda implements Command{
    Scanner sc = new Scanner(System.in);
    @Override
    public String vykonat(Hra hra, String s) {
        System.out.println("S cim potrebujes pomoct?");
        System.out.println("1 - Kam mam jit?");
        System.out.println("2 - Kdo je v teto mistnosti");
        switch (sc.next()) {
            case "1": //Je pouzit switch na to, aby kdyz napise 1, vrati mu to dostupne vychody
                System.out.println("Dostupne vychody - ");
                System.out.print(hra.getAktualniMistnost().getSousedi());
                break;
            case "2": // A kdyz napise 2, vrati mu to osoby v mistnosti.
                if (hra.getAktualniMistnost().getPostavy().isEmpty()) {
                    return "V mistnosti nikdo neni.";
                }
                String text = "V mistnosti jsou postavy: ";
                for (Postava p : hra.getAktualniMistnost().getPostavy()) {
                    text = text + "\n" + " - " + p.getJmeno();
                }
                return text;
        }
        return "";
    }
}
