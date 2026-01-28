package Command;

import KonzoleVeci.Hra;

public class Konec implements Command {


    @Override
    public String vykonat(Hra hra, String s) {
        String em = "Hra se vypina.. :(";
        hra.setEnd(true);
        return em;
    }
}
