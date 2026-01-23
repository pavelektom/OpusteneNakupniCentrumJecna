package Command;

import KonzoleVeci.Hra;

public class Konec implements Command {


    @Override
    public void vykonat(Hra hra, String s) {
        System.out.println("Hra se vypina :(");
        hra.setEnd(true);
    }
}
