package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class LoginController {

    public TextField UsernameLogin;
    public PasswordField PasswordLogin;
    public Label Status;
    public Button Signin;

    static String correctuser;

//    EventsListController ec = new EventsListController(this);

//    LoginController(Manager m)
//    {
//    manager = m;
//    }
//        Manager manager =new Manager();

    public void Signin(ActionEvent actionEvent)throws Exception
    {
        Stage stage1 = (Stage) Signin.getScene().getWindow();
        stage1.close();

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Signin.fxml"));
        stage.setScene(new Scene(root, 450, 500));
        stage.setTitle("Signin");
        stage.show();
    }

    public void Login(ActionEvent actionEvent)
    {
        try {
            boolean Password=false;
           String filepathUsers = "Users.txt";
           Scanner y;

            y = new Scanner(new File(filepathUsers));

        y.useDelimiter("[,\n]");

        String UsernameTemp = "";
        String PasswordTemp = "";


        while (y.hasNext())
        {
            System.out.println("while");
            UsernameTemp = y.next();
            PasswordTemp =y.next();

            if (UsernameLogin.getText().equals(UsernameTemp)&& PasswordLogin.getText().equals(PasswordTemp))
            {
                Status.setText("You Login Succesfully");
                Password=true;
                System.out.println("SET");
                break;
            }//if
        }//while


        if (Password==false)
        {
            Status.setText("Your password or username is incorrect");
        }else {
            Status.setText("Correct");
            System.out.println("Check true");
//            EventsListController date = new EventsListController(this);

//            date.DateCalender.setValue(localdate);
//            date.Date.setText(formattedString);

            correctuser=UsernameLogin.getText();


//            EventsListController eventsListController =new EventsListController();
            Stage stage1 = (Stage) Signin.getScene().getWindow();
            stage1.close();

//            System.out.println("before stage");
            Stage stage = new Stage();
//            System.out.println("after stage");
            Parent root = FXMLLoader.load(getClass().getResource("EventsList.fxml"));
//            System.out.println("after fxml loader");
            stage.setScene(new Scene(root, 704, 603));
            stage.setTitle("EventsList");
//            System.out.println("before show");

            stage.show();

//            System.out.println("++++++++++++++++");
        }//if

        } catch (Exception e) {
            System.out.println("ex");
            e.printStackTrace();
//            Status.setText("Exeption");
        }///catch
    }//login

    public String Correct ()
    {
        return correctuser;
    }
}
