package Models;

import java.util.ArrayList;
import java.util.Date;


public class Stoc {
    public ArrayList<Produs> getListaProduse() {
        return listaProduse;
    }

    public void setListaProduse(ArrayList<Produs> listaProduse) {
        this.listaProduse = listaProduse;
    }

    public Stoc(ArrayList<Produs> listaProduse) {
        this.listaProduse = listaProduse;
        Categorie c = new Categorie("nume", null);
        Date date = new Date();
        Pret pr = new Pret(2.0, date, date);
        produsImbracaminte p = new produsImbracaminte(c, pr, "nume", "desc", 30);
        listaProduse.add(p);
    }

    public Produs getItem(Produs prd){
        return listaProduse.get(listaProduse.indexOf(prd));
    }

    private ArrayList<Produs> listaProduse = new ArrayList<Produs>();
}
