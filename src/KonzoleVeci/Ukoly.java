package KonzoleVeci;

public class Ukoly {//Trida pro ukoly, pomoci teto tridy muzeme vypisovat ukoly v prikazu Ukoly, tride List
    private String nazev;
    private String popis;
    private boolean splneny;

    public Ukoly(String nazev, String popis, boolean splneny) {
        this.nazev = nazev;
        this.popis = popis;
        this.splneny = splneny;
    }

    public String getNazev() {
        return nazev;
    }

    public boolean isSplneny() {
        return splneny;
    }

    public void setSplneny(boolean splneny) {
        this.splneny = true;
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
}
