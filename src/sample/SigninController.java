package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;


public class SigninController
{

    public Label Status;
    public TextField UsernameSignin;
    public PasswordField PasswordSignin;
    public PasswordField RePassword;
    public Button Signin;

    public void Signin(ActionEvent actionEvent) throws Exception
    {
        boolean Username=true;
        String filepathUsers = "Users.txt";
        Scanner y;
        y = new Scanner(new File(filepathUsers));
        y.useDelimiter("[,\n]");

        String UsernameTemp = "";
        String PasswordTemp = "";

        while (y.hasNext())
        {
            UsernameTemp = y.next();
            PasswordTemp =y.next();
//            if (PasswordSignin.getText().equals(RePassword.getText()))
//            {
                 if (UsernameSignin.getText().equals(UsernameTemp))
                {
                   Status.setText("Already have this Username Pls change your Username");
                   Username=false;
                }//if
//            }
        }//while
        System.out.println("++++++");
        if (!PasswordSignin.getText().equals(RePassword.getText()))
        {
            Status.setText("Your password DONT match");
            Username=false;
        }

        if (Username==true)
        {

            String filepath = "Users.txt";
            File file = new File(filepath);
            BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true));
            bw.write(UsernameSignin.getText() + "," + PasswordSignin.getText() + "\n");
            bw.close();

            File file1 =new File(UsernameSignin.getText()+".txt");
            file1.createNewFile();

            Stage stage1 = (Stage) Signin.getScene().getWindow();
            stage1.close();

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            stage.setScene(new Scene(root, 450, 500));
            stage.setTitle("Login");
            stage.show();
        }//if

    }//signin

    public void Back(ActionEvent actionEvent) throws IOException
    {
        Stage stage1 = (Stage) Signin.getScene().getWindow();
        stage1.close();

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage.setScene(new Scene(root, 450, 500));
        stage.setTitle("Login");
        stage.show();
    }
}
