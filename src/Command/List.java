package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Ukoly;

import java.util.ArrayList;

public class List implements Command {
//Tato trida ukazuje hraci co musi ve hre udelat.
    @Override
    public String vykonat(Hra hra, String s) {
        ArrayList<Ukoly> ukoly = hra.getUkoly(); //Tady si naklonujeme arraylist ukolu
        String nebaviMeTo = "Tvoje ukoly  " +"\n";
        if(ukoly.isEmpty()){
            return "Nemas zadne ukoly";
        }
        for (Ukoly zboznujuProgramovani : ukoly) {
            nebaviMeTo = nebaviMeTo + " - " + zboznujuProgramovani.getNazev() + "\n"; // a tady to nastavi vsechny ukoly
            nebaviMeTo = nebaviMeTo + "      -> " + zboznujuProgramovani.getPopis() + "\n";

            if (zboznujuProgramovani.isSplneny()){
                nebaviMeTo = nebaviMeTo + "      -> splneny" + "\n";
            } else{
                nebaviMeTo = nebaviMeTo + "      -> nesplneny" + "\n";
            }
        }
        return nebaviMeTo; // vracime ukoly :D
    }
}
