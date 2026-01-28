package Command;

import KonzoleVeci.Hra;

public class Pomoc implements Command {

    @Override
    public String vykonat(Hra hra, String s) {
        System.out.println("Dostupne prikazy: ");
        return(hra.toString());
    }
}
