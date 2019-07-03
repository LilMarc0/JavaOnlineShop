package Models;

public class userClient extends User{

    public Double getSoldCurent() {
        return soldCurent;
    }

    public void setSoldCurent(Double soldCurent) {
        this.soldCurent = soldCurent;
    }

    private Double soldCurent;

    public userClient(Integer id, String username, String password, Double soldCurent) {
        super(id, username, password);
        this.soldCurent = soldCurent;
    }

    public void cumpara(Produs p){
        if(soldCurent - p.getPret().getPret() > 0.0){
            soldCurent -= p.getPret().getPret();
        }
    }
}
