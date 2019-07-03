package Services;

import Models.User;
import Models.userAdmin;
import Models.Stoc;
import Models.Produs;
import Models.userClient;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserServices {

    private static ArrayList<User> lista;

    private static UserServices ourInstance = new UserServices();

    private static DB database;
    private static Audit audit;

    public static UserServices getInstance() {
        return ourInstance;
    }



    private UserServices() {
        audit = Audit.getInstance();

        lista = new ArrayList<>();
        lista.add(new userClient(1, "Ioana", "Ioana123", 10000.0));
        lista.add(new userClient(2, "Adelin", "Ad3leen", 12000.0));
        lista.add(new userClient(3, "Marcu", "M4rcu",15000.0));
        lista.add(new userAdmin(4, "Doru", "d0ru", "CEO"));
        lista.add(new userAdmin(5, "Dan", "dan1102", "Vanzari"));

        try
        {
            FileOutputStream fos = new FileOutputStream("Useri");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
       // database = DB.getInstance();
        //database.connect();
       // database.addUsers();
    }

    public User getById(Integer id){
        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        audit.update("getById", dtf.format(timestamp));

        for(User user : lista){
            if(user.getId().equals(id))
                return user;
        }
        return null;
    }

    public User getByName(String name) {
        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        audit.update("getByName", dtf.format(timestamp));
        for (User user : lista) {
            if (user.getUsername().equals(name))
                return user;
        }
        return null;
    }

    public void cumpara(userClient usr, Stoc stoc, Produs prod){
            usr.cumpara(stoc.getItem(prod));
    }

}
