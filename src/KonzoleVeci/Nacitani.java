package KonzoleVeci;

import Postavy.Postava;

import com.google.gson.Gson;
import com.sun.tools.javac.Main;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class Nacitani {

    public ArrayList<Predmet> predmety;
    public ArrayList<Postava> postavy ;
    public ArrayList<Mistnost> mistnosti;
    public ArrayList<Ukoly> ukoly;

    public static Nacitani loadGameDataFromResources(String path) {
        Gson gson = new Gson();
        try (
                FileInputStream fis = new FileInputStream(path);
                InputStreamReader reader = new InputStreamReader(fis, StandardCharsets.UTF_8)
        ) {
            return gson.fromJson(reader, Nacitani.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Chyba pri nacitani JSON ze souboru: " + path);
        }
    }

    public Mistnost najdiMistnost(String nazev) {
        for (int i = 0; i < mistnosti.size(); i++) {
            if (mistnosti.get(i).getNazev().equalsIgnoreCase(nazev)) {
                return mistnosti.get(i);
            }
        }
        throw new IllegalArgumentException("Neexistuje lokace s nazvem: " + nazev);
    }
    public Predmet najdiPredmet(String nazev) {
        for (int i = 0; i < predmety.size(); i++) {
            if (predmety.get(i).getNazev().equalsIgnoreCase(nazev)) {
                return predmety.get(i);
            }
        }
        throw new IllegalArgumentException("Neexistuje predmet s nazvem: " + nazev);
    }
    public Postava najdiPostavu(String nazev) {
        for (int i = 0; i < postavy.size(); i++) {
            if (postavy.get(i).getJmeno().equalsIgnoreCase(nazev)) {
                return postavy.get(i);
            }
        }
        System.out.println("ups");
        throw new IllegalArgumentException("Neexistuje postava s jmenem: " + nazev);
    }


}




