package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Predmet;

public class Odemkni implements Command {
    @Override
    public String vykonat(Hra hra, String s) {
        Inventar inventar = new Inventar();
        Predmet p = hra.getInventar().najdi("pristupova_karta");
        if (s.equalsIgnoreCase("sklad")){
            if (hra.isMaPristupovoukartu() == true) {
                if (hra.getAktualniMistnost().getNazev().equals("elektronika")){
                    hra.getNacitani().najdiMistnost("sklad").setJeZamcena(false);
                    return "Odemkl jsi sklad. ";
                }
            } else {
                return "Nemas pristupovou kartu";
            }

        }
        return "";
    }
}
