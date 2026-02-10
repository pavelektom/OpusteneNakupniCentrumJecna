package Command;

import KonzoleVeci.Hra;
import KonzoleVeci.Inventory;
import KonzoleVeci.Mistnost;
import KonzoleVeci.Predmet;
 //Predmet poloz je hlavne urcen pro inventar, pomoci poloz muze hrac uvolnit misto v inventari
public class Poloz implements Command {

    @Override
    public String vykonat(Hra hra, String s) {

        String ahoj = s.trim().toLowerCase(); // tady si odebereme mezery a dame na mala pismenka
        if (ahoj.equals("") || s.trim().isEmpty() == true) {
            return "Vyberte jaky predmet chcete odebrat z inventare.."; // Pokud hrac nenapise nic, vratime mu toto
        }
        Inventory inventar = hra.getInventar();
        Predmet p = inventar.odeber(ahoj); // Odebereme predmet z inventare
        if (p == null){
            return "Takovy predmet nemas"; // pokud tento predmet nema, vratime mu ze ho nema.
        }
        hra.getAktualniMistnost().pridatPredmet(p);// pridame predmet do mistnosti, kde se hrac prave nachazi

        return "Predmet " + s + " byl polozen."; // vypiseme, ze predmet byl polozen
    }
}
