package KonzoleVeci;

public class Ukoly {
    private String nazev;
    private String popis;
    private boolean splneny;

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
