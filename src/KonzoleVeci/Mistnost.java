package KonzoleVeci;

import Postavy.Postava;

import java.util.ArrayList;
import java.util.HashMap;

public class Mistnost {

    private String nazev;
    private String popis;
    private boolean jeZamcena;
    private boolean temna;

    private ArrayList<Predmet> predmety = new ArrayList<>();
    private ArrayList<Postava> postavy = new ArrayList<>();
    private HashMap<String, Mistnost> sousedi = new HashMap<>();

}
