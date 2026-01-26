package Command;

import KonzoleVeci.Hra;

import java.util.Scanner;

public class Napoveda implements Command{
    Scanner sc = new Scanner(System.in);

    @Override
    public void vykonat(Hra hra, String s) {
        System.out.println("S cim potrebujes pomoct?");
        System.out.println("1 - Kam mam jit?");
        System.out.println("2 - ");
        switch (sc.next()) {
            case "1":
                System.out.println(hra.getAktualniMistnost().getSousedi());
            case "2":

        }
    }
}
