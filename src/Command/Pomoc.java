package Command;

import KonzoleVeci.Hra;

public class Pomoc implements Command {
 //Trida pomoc je pouzita pro to, aby se hrac dozvedel jake prikazy muze pouzit.
    @Override
    public String vykonat(Hra hra, String s) {
        System.out.println("Dostupne prikazy: ");
        String a = "";
        for (String em : hra.getPrikazy().keySet()) { //Nastavi a -> a pote vypiseme a
            a = a + " - " + em;
        }
        return a;
    }
}
