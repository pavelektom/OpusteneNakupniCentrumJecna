package KonzoleVeci;

import Postavy.Postava;

import java.util.ArrayList;
import java.util.HashMap;
public class Mistnost {

    private String nazev;
    private String popis;
    private boolean jeZamcena;
    private boolean temna;

    private ArrayList<String> sousedi = new ArrayList<>();
    private ArrayList<Predmet> predmety = new ArrayList<>();
    private ArrayList<Postava> postavy = new ArrayList<>();

    public Mistnost(){

    }

    public void pridatPredmet(Predmet p) {
        predmety.add(p);
    }

    public Predmet odeberPredmet(String nazev) {
        for (int i = 0; i < predmety.size(); i++) {
            Predmet p = predmety.get(i);
            if (p.getNazev().equalsIgnoreCase(nazev)) {
                predmety.remove(i);
                return p;
            }
        }
        return null;
    }

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

    public ArrayList<String> getSousedi() {
        return sousedi;
    }

    public void setSousedi(ArrayList<String> sousedi) {
        this.sousedi = sousedi;
    }

    public ArrayList<Predmet> getPredmety() {
        return predmety;
    }

    public void setPredmety(ArrayList<Predmet> predmety) {
        this.predmety = predmety;
    }

    public ArrayList<Postava> getPostavy() {
        return postavy;
    }

    public void setPostavy(ArrayList<Postava> postavy) {
        this.postavy = postavy;
    }
}

