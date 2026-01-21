package KonzoleVeci;

import Postavy.Postava;

import java.util.ArrayList;
import java.util.HashMap;
public class Mistnost {

    private String nazev;
    private String popis;
    private boolean jeZamcena;
    private boolean temna;

    private ArrayList<String> sousedi;
    private ArrayList<Predmet> predmety;
    private ArrayList<Postava> postavy;


    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public boolean isJeZamcena() {
        return jeZamcena;
    }

    public void setJeZamcena(boolean jeZamcena) {
        this.jeZamcena = jeZamcena;
    }

    public boolean isTemna() {
        return temna;
    }

    public void setTemna(boolean temna) {
        this.temna = temna;
    }
}

