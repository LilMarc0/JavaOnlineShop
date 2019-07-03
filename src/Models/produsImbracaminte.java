package Models;

public class produsImbracaminte extends Produs{

    public produsImbracaminte(Categorie categorie, Pret pret, String nume, String descriere, Integer marime) {
        super(categorie, pret, nume, descriere);
        this.marime = marime;
    }

    public Integer getMarime() {
        return marime;
    }

    public void setMarime(Integer marime) {
        this.marime = marime;
    }

    private Integer marime;

}
