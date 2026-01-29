package Command;

import KonzoleVeci.Hra;

public class Pomoc implements Command {

    @Override
    public String vykonat(Hra hra, String s) {
        System.out.println("Dostupne prikazy: ");
        String a = "";
        for (String em : hra.getPrikazy().keySet()) {
            a = a + " - " + em;
        }
        return a;
    }
}
