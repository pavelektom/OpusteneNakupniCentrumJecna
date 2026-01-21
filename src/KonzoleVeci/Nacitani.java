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
    public ArrayList<Mistnost>  mistnosti;
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


}




