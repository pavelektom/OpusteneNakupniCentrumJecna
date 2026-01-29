package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Mistnost;
import Postavy.Postava;

public class Mluv implements Command {
    @Override
    public String vykonat(Hra hra, String s) {
        if (hra.getAktualniMistnost().getPostavy().isEmpty()){
            return "V teto mistnosti nikdo neni..";
        }
        if (s == null || s.equals("")) {
            return "S kym chces mluvit? ";
        }
        Mistnost m = hra.getAktualniMistnost();

        if (m.getPostavy().size() == 1) {
            if (m.getPostavy().get(0).getJmeno().equalsIgnoreCase(s.trim().toLowerCase())) {
                return m.getPostavy().get(0).getDialog();
        } else{
                return "Tato osoba tu neni, zkus napovedu..";
            }
        } else {
            return "V teto mistnosti nikdo neni";
        }
    }
}
