package Models;

import Auth.Authenticable;

public class userAdmin extends User {
    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    private String departament;

    public userAdmin(Integer id, String username, String password, String departament) {
        super(id, username, password);
        this.departament = departament;
    }
}
