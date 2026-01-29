package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Mistnost;
import Postavy.Postava;

public class Mluv implements Command {
    @Override
    public String vykonat(Hra hra, String s) {
        if (s == null || s.equals("")) {
            return "S kym chces mluvit?";
        }
        Postava p = hra.getNacitani().najdiPostavu(s.trim());
        if (s.equalsIgnoreCase(p.getJmeno())) {
            return p.getDialog();
        }

        return "";
    }
}
