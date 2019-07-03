package Models;

public class Categorie{

    public Categorie(String nume, Categorie parinte) {
        this.nume = nume;
        this.parinte = parinte;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public static String getCodCategorie() {
        return codCategorie;
    }

    public static void setCodCategorie(String codCategorie) {
        Categorie.codCategorie = codCategorie;
    }

    public Categorie getParinte() {
        return parinte;
    }

    public void setParinte(Categorie parinte) {
        this.parinte = parinte;
    }

    private String nume;
    static private String codCategorie;
    private Categorie parinte;


}
