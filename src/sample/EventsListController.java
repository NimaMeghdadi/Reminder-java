package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Cursor;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.Scanner;


public class EventsListController implements Initializable{


    @FXML
    public Label Date;
    @FXML
    public TextField Subtitle;
    @FXML
    public TextField Memo;
    @FXML
    public DatePicker DateCalender;
    @FXML
    public ListView ListViewToday;
    public Label DateLbl;
    public Button SaveBtn;
    public Button AttachBtn;

    public Button Switch;
    public Label Userlbl;
    public Button Removeid;
    public Button Editid;
    public Button Showid;
    public Button Add;


    java.util.Date date1 = new Date();
    Instant instant = date1.toInstant();
    LocalDate localdate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
//    LocalDate ld = LocalDate.now();

    Manager manager =new Manager(this);
//    private Object ActionEvent;

    //    LoginController lc = null ;
//    EventsListController(LoginController Lc)
//    {
//        lc = Lc;
//    }
    public void AddBtn(ActionEvent actionEvent) {


        Memo.setPromptText("Enter memo");
        Subtitle.setPromptText(" Enter Subtitle");

//        Date.setText(DateCalender.getEditor().getText());
//        Manager manager =new Manager();
 //       manager.AddEvent(Subtitle.getText(),Memo.getText(),DateCalender.getValue());
        Subtitle.setDisable(false);
        Memo.setDisable(false);
        SaveBtn.setDisable(false);
        AttachBtn.setDisable(false);


    }

    public void RemoveBtn(ActionEvent actionEvent) throws Exception
    {
        String z ,sub ,memo=null;
        Scanner y;
        z = ListViewToday.getSelectionModel().getSelectedItems().toString().replace("[","").replaceAll("]", "").replaceAll("Sub: ","").replaceAll("Memo: ","");
        y = new Scanner(z);
        y.useDelimiter("[\n]");

        while (y.hasNext())
        {

            sub = y.next();
            memo = y.next();
        }
        manager.Remove(DateCalender.getValue(),memo);
//        System.out.println(z);

        Removeid.setDisable(true);
        Editid.setDisable(true);
        Showid.setDisable(true);

    }

    public void EditBtn(ActionEvent actionEvent) throws Exception {
        Subtitle.setDisable(false);
        Memo.setDisable(false);
        SaveBtn.setDisable(false);

        String z ,sub=null ,memo=null;
        Scanner y;
        z = ListViewToday.getSelectionModel().getSelectedItems().toString().replace("[","").replaceAll("]", "").replaceAll("Sub: ","").replaceAll("Memo: ","");
        y = new Scanner(z);
        y.useDelimiter("[\n]");

        while (y.hasNext())
        {

            sub = y.next();
            memo = y.next();
        }

        manager.Remove(DateCalender.getValue(),memo);
        Subtitle.setText(sub);
        Memo.setText(memo);
//        manager.AddEvent(Subtitle.getText(),Memo.getText(),DateCalender.getEditor().getText());

//        System.out.println(x);

        Removeid.setDisable(true);
        Editid.setDisable(true);
        Showid.setDisable(true);

    }
    String x=null;
    public void AttachBtn(ActionEvent actionEvent) {

//        Stage stage =new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File sFile = fileChooser.showOpenDialog(null);
//        sFile.toString();
//        fileChooser.showOpenDialog(null);
        x=sFile.toString();//.replace("\\","\\\\");
////        x= ListViewToday.getSelectionModel().getSelectedItems().toString().replaceAll("\\","7");

//        System.out.println(x);

        //    x.replace("\\","\\\\");
//        System.out.println(sFile);



    }

    public void SaveBtn(ActionEvent actionEvent) throws Exception
    {
//        System.out.println("SAVE BTN");
//       Manager manager =new Manager(this);
//        System.out.println("LL SAVEBTN = "+ manager.ll.size());
        System.out.println("Savebtn  "+x);
       manager.AddEvent(Subtitle.getText(),Memo.getText(),DateCalender.getValue(),x);
//        System.out.println("SAVEBTN"+DateCalender.getEditor().getText());
       manager.Show(DateCalender.getValue());

//        Manager manager =new Manager();
//        manager.AddEvent(Subtitle.getText(),Memo.getText(),DateCalender.getValue());
//        Date.setText(Subtitle.getText());
        Subtitle.setDisable(true);
        Memo.setDisable(true);
        SaveBtn.setDisable(true);
        AttachBtn.setDisable(true);
        Subtitle.setText("");
        Memo.setText("");

    }

    public void CalendarBtn(ActionEvent actionEvent) throws Exception
    {
        System.out.println("calendar SET");
        DateLbl.setText(DateCalender.getEditor().getText());
//        Manager manager =new Manager(this);
 //       System.out.println("ll calendarbtn = "+manager.ll.size());
 //       ListViewToday.getSelectionModel().selectAll();
    //    Manager manager =new Manager();
//        manager.Show(DateCalender.getEditor().getText());
        ListViewToday.getItems().clear();
        System.out.println("CLEAR");
        manager.Show(DateCalender.getValue());
        if (localdate.isAfter(DateCalender.getValue()))
        {
            Add.setDisable(true);
        }else {
            Add.setDisable(false);
        }


//        ListViewToday.getItems().addAll("hi");
//        ListViewToday.getItems().addAll("jjh");

    }
    int flag =1;
    public void Mouse(MouseEvent mouseEvent)
    {
        DateLbl.setText(DateCalender.getEditor().getText());

//        if (flag==1)
//        {
//            DateCalender.setValue(localdate);
//            flag=0;
//        }


    }

    public void MouseCalendar(MouseEvent mouseEvent) {
 //       DateCalender.show();


    }

    public void setListViewToday (String sub,String memo) throws Exception {
//        Manager manager =new Manager();
//        manager.Show(this+"");
//          System.out.println("SET LISTVIEW");
//        ObservableList<String> list = FXCollections.observableArrayList(linkedList);
        ListViewToday.getItems().addAll("Sub: "+sub+"\n"+"Memo: "+memo);

//        ListViewToday.setItems();

    }


    public void Todaybtn(ActionEvent actionEvent)
    {
//        DateLbl.setText(localdate.toString());
        DateCalender.setValue(localdate);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try {
            Removeid.setDisable(true);
            Editid.setDisable(true);
            Showid.setDisable(true);


//            DateCalender.show();
//            DateCalender.setValue()
            Date.setText(localdate.toString());

            DateLbl.setText(DateCalender.getEditor().getText());
//        DateLbl.setText(DateCalender.getEditor().getText());
//        User.setText(lc.Correct());
            manager.Initialize();
            System.out.println("INITIALAZ");
            //manager.Show(DateCalender.getEditor().getText());
            DateCalender.setValue(localdate);
            manager.Show(DateCalender.getValue());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void ShowBtn(ActionEvent actionEvent) throws Exception
    {
        String z ,sub ,memo=null;
        Scanner y;
        z = ListViewToday.getSelectionModel().getSelectedItems().toString().replace("[","").replaceAll("]", "").replaceAll("Sub: ","").replaceAll("Memo: ","");
        y = new Scanner(z);
        y.useDelimiter("[\n]");

        while (y.hasNext())
        {

            sub = y.next();
            memo = y.next();
        }
//        System.out.println("SHOWBTN = ");
        manager.Attach(DateCalender.getValue(),memo);

        Removeid.setDisable(true);
        Editid.setDisable(true);
        Showid.setDisable(true);
    }

    public void Exit(ActionEvent actionEvent) throws Exception {
        manager.Exit();

//        Stage stage1 = (Stage) .getScene().getWindow();
//        stage1.close();
        Stage stage1 = (Stage) SaveBtn.getScene().getWindow();
        stage1.close();

    }
    public void comparison()
    {

    }


    public void SwitchBtn(ActionEvent actionEvent) throws IOException
    {

        Stage stage1 = (Stage) Switch.getScene().getWindow();
        stage1.close();

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage.setScene(new Scene(root, 704, 603));
        stage.setTitle("Login");
        stage.show();


    }


    public void EventListClick(MouseEvent mouseEvent)
    {
        Removeid.setDisable(false);
        Editid.setDisable(false);
        Showid.setDisable(false);


    }

    public void PlusBtn(ActionEvent actionEvent)
    {
        LocalDate dayplus=DateCalender.getValue().plusDays(1);
        DateCalender.setValue(dayplus);
    }

    public void NegativeBtn(ActionEvent actionEvent)
    {
        LocalDate daynegative=DateCalender.getValue().plusDays(-1);
        DateCalender.setValue(daynegative);

    }
}
