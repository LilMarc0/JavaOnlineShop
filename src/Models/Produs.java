package Models;

public class Produs{

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Pret getPret() {
        return pret;
    }

    public void setPret(Pret pret) {
        this.pret = pret;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    protected Categorie categorie;
    protected Pret pret;
    private String nume;
    private String descriere;


    public Produs(Categorie categorie, Pret pret, String nume, String descriere) {
        this.categorie = categorie;
        this.nume = nume;
        this.descriere = descriere;
        this.pret = pret;
    }
}
