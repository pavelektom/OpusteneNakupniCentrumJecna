package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Predmet;

public class Odemkni implements Command {
    @Override //Trida odemkni je pro odekmutni mistnosti.
    public String vykonat(Hra hra, String s) {
        if (s.equalsIgnoreCase("sklad")){// Odemkni je pouzito jen na sklad takze jsem pouzil if
            if (hra.isMaPristupovoukartu() == true) {
                if (hra.getAktualniMistnost().getNazev().equals("elektronika")){ //potvrzeni ze hrac je v elektronice, protoze odjinud nemuze odemknout sklad
                    hra.getNacitani().najdiMistnost("sklad").setJeZamcena(false);// pote se odemkne sklad
                    hra.getNacitani().ukoly.get(1).setSplneny(true);
                    return "Odemkl jsi sklad. ";
                }
            } else { // a vratime mu potvrzeni
                return "Nemas pristupovou kartu";
            } //jinak mu vypiseme, ze nema pristupovou kartu

        }
        return "";
    }
}
