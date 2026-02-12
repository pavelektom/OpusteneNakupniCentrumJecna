package KonzoleVeci;
//Trida predmet je pro vsechny predmety, ktere se nachazi v mistnostech a ve hre
public class Predmet {
    private String nazev;
    private String popis;
    private boolean skryty;
    private boolean hledan;

    public boolean isHledan() {
        return hledan;
    }

    public void setHledan(boolean hledan) {
        this.hledan = hledan;
    }

    public Predmet(String nazev, String popis, boolean skryty) {
        this.nazev = nazev;
        this.popis = popis;
        this.skryty = skryty;
    }

    public void odkryt(){
        this.skryty = false;
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

    public boolean isSkryty() {
        return skryty;
    }
    @Override
    public String toString() {
        return nazev +" - " + popis;
    } //toString jen pro nazev a popis predmetu

    public void setSkryty(boolean skryty) {
        this.skryty = skryty;
    }
}
