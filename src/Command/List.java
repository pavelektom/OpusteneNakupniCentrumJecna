package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Ukoly;

import java.util.ArrayList;

public class List implements Command {

    @Override
    public String vykonat(Hra hra, String s) {
        ArrayList<Ukoly> ukoly = hra.getUkoly();
        String nebaviMeTo = "Tvoje ukoly - ";
        if(ukoly.isEmpty()){
            return "Nemas zadne ukoly";
        }
        for (Ukoly zboznujuProgramovani : ukoly) {
            nebaviMeTo = nebaviMeTo + " - " + zboznujuProgramovani.getNazev();
            nebaviMeTo = nebaviMeTo + " - " + zboznujuProgramovani.getPopis();

            if (zboznujuProgramovani.isSplneny()){
                return "SPLNENY";
            } else{
                return "NESPLNENY";
            }
        }
        return nebaviMeTo;
    }
}
