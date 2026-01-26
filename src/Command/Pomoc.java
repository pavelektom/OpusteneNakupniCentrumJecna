package Command;

import KonzoleVeci.Hra;

public class Pomoc implements Command {

    @Override
    public void vykonat(Hra hra, String s) {
        System.out.println("Dostupne prikazy: ");
        System.out.println(hra.toString());
    }
}
