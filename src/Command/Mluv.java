package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Mistnost;
import Postavy.Postava;
// Tato trida je urcena k mluveni s postavami.
public class Mluv implements Command {
    @Override
    public String vykonat(Hra hra, String s) {
        if (hra.getAktualniMistnost().getPostavy().isEmpty()){
            return "V teto mistnosti nikdo neni.."; // kdyz v mistnosti neni zadna postava, vratime, ze v mistnosti nikdo neni
        }
        if (s == null || s.equals("")) {
            return "S kym chces mluvit? "; // jestli nekdo v mistnosti je, ale hrac nenapise nic, vratime, ze si musi nekoho vybrat
        }
        Mistnost m = hra.getAktualniMistnost();

        if (m.getPostavy().size() == 1) {
            if (m.getPostavy().get(0).getJmeno().equalsIgnoreCase(s.trim().toLowerCase())) {
                return m.getPostavy().get(0).getDialog(); // Pokud nekdo v mistnosti je a hrac napise spravne jmeno, vypise se dialog.
        } else{
                return "Tato osoba tu neni, zkus napovedu..";
            } //Pokud hrac napise osobu, ktera tu neni vratime mu toto.
        } else {
            return "V teto mistnosti nikdo neni";
        }
    }
}
