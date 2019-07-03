package Services;
import java.sql.*;
import java.util.ArrayList;
import Models.User;
import Models.userAdmin;
import Models.userClient;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class DB {
    private static DB ourInstance = new DB();

    public static DB getInstance() {
        return ourInstance;
    }

    private DB() {
        connect();
    }

    Connection connection;

    public void connect() {
        try {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "password");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addUsers(){
        try {
            FileInputStream fis = new FileInputStream("Useri");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<User> usr = (ArrayList) ois.readObject();
            for (User user : usr) {
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USERS (ID, NUME, PAROLA, TIP) VALUES(?,?,?,?)");
                    preparedStatement.setInt(1, user.getId());
                    preparedStatement.setString(2, user.getUsername());
                    preparedStatement.setString(3,user.getPassword());
                    if(user instanceof userAdmin) preparedStatement.setString(4, "Admin");
                    else preparedStatement.setString(4, "Client");
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ois.close();
                fis.close();
            }
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    public String login(String username, String password){
        String tip = "";
        String sql = "SELECT Tip FROM users WHERE Nume='"+username+"' AND Parola='"+password+"'";
        try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) return resultSet.getString(4);
                else return "";
            } catch (SQLException e) {
                e.printStackTrace();
        }
        return tip;
    }
}