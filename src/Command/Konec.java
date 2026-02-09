package Command;

import KonzoleVeci.Hra;

public class Konec implements Command {

// pomoci teto tridy muze hrac napsat do konzole "konec" a ukonci tim hru
    @Override
    public String vykonat(Hra hra, String s) {
        String em = "Hra se vypina.. :(";
        hra.setEnd(true); //Tady nastavime konec pravdivy a hra se vypne
        return em;
    }
}
