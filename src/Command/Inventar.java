package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Predmet;
import KonzoleVeci.Inventory;

public class Inventar implements Command {

    @Override
    public String vykonat(Hra hra, String s) {
        return hra.getInventar().vypis(); //pouzijeme metodu z Inventory, abychom vypsali co mame v inventari
    }
}
