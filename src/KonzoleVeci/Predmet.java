package KonzoleVeci;

public class Predmet {
    private String nazev;
    private String popis;
    private boolean prenosny;
    private boolean skryty;

    public Predmet(String nazev, String popis, boolean prenosny, boolean skryty) {
        this.nazev = nazev;
        this.popis = popis;
        this.prenosny = prenosny;
        this.skryty = skryty;
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

    public boolean isPrenosny() {
        return prenosny;
    }

    public void setPrenosny(boolean prenosny) {
        this.prenosny = prenosny;
    }

    public boolean isSkryty() {
        return skryty;
    }

    public void setSkryty(boolean skryty) {
        this.skryty = skryty;
    }
}
