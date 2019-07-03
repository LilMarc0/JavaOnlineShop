package Services;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Models.User;
import Models.userAdmin;

public class Login {
    private JTextField userText;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JPanel panelMain;
    private UserServices usrService;
    private DB database;

    public Login() {



        //database = DB.getInstance();
        //database.connect();
        usrService = UserServices.getInstance();
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(usrService.getByName(userText.getText()) != null
                        & usrService.getByName(userText.getText()).getPassword().equals(passwordText.getText())) System.out.println("MERGE");
                if(usrService.getByName(userText.getText()) instanceof userAdmin){
                    JFrame adminFrame = new JFrame("Admin");
                    adminFrame.setContentPane(new Admin().panel1);
                    adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    adminFrame.pack();
                    adminFrame.setVisible(true);
                }
//                else System.out.println("NU");
//                if(database.login(userText.getText(), passwordText.getText()).equals("Admin")){
//
//                    JFrame adminFrame = new JFrame("Admin");
//                    adminFrame.setContentPane(new Admin().panel1);
//                    adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                    adminFrame.pack();
//                    adminFrame.setVisible(true);
//                }
//                else if(database.login(userText.getText(), passwordText.getText()).equals("Admin")){
//
//                    JFrame clientFrame = new JFrame("Admin");
//                    clientFrame.setContentPane(new Client().panel1);
//                    clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                    clientFrame.pack();
//                    clientFrame.setVisible(true);
//                }
//                else System.out.println("User sau parola greiste");
            }
        });
    }

    public static void main(String[] args){
        JFrame Loginframe = new JFrame("App");
        Loginframe.setContentPane(new Login().panelMain);
        Loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Loginframe.pack();
        Loginframe.setVisible(true);
    }
}
