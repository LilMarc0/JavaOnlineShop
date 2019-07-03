package Models;

import java.util.Date;

public class Pret {
    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public Date getIncepandCu() {
        return incepandCu;
    }

    public void setIncepandCu(Date incepandCu) {
        this.incepandCu = incepandCu;
    }

    public Date getPanaLa() {
        return panaLa;
    }

    public void setPanaLa(Date panaLa) {
        this.panaLa = panaLa;
    }

    private Double pret;
    private Date incepandCu;
    private Date panaLa;


    public Pret(Double pret, Date incepandCu, Date panaLa) {
        this.pret = pret;
        this.incepandCu = incepandCu;
        this.panaLa = panaLa;
    }
}
