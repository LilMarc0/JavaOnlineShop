import Services.UserServices;

public class Main {

    // 13. sistem de gestiune a unui magazin (Produs, furnizori, bonuri facturi,
    // furnizori-utilizatori ce pot verifica cat au de incasat etc)

    public static void main(String[] args) {
        UserServices us = UserServices.getInstance();
        System.out.println(us.getByName("Doru"));
    }
}