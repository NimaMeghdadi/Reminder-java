package sample;

//import sun.security.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Manager {
//    ArrayList<Event> MyEvent= new ArrayList();
    LinkedList<Event> linkedList = new LinkedList<Event>();
//    LinkedList<LinkedList<Event>> ll =new LinkedList<LinkedList<Event>>();

    EventsListController elc = null ;
//    LoginController lc =null;

    Manager(){
        lc = new LoginController();
    }

    Manager(EventsListController el)
    {
        elc = el;
//        lc = new LoginController();
    }
    LoginController lc =new LoginController();

    String sub = "" ;
    String correntuser=null;

    public void AddEvent(String Sub ,String Memo,LocalDate date , String place)//,LocalDate date)
    {
//        System.out.println("Add  "+place);
        linkedList.addLast(new Event(date,Sub,Memo,place));
//        System.out.println("ADD"+linkedList.getFirst().getPlace());
    }
        //////////////////////////////////
/*
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LLLL/yyyy");
//        String formattedString = date.format(formatter);
        int i , k=0;
        for (i=0;i<ll.size();i++)
        {
              if (ll.get(i).getFirst().getDate().equals(date))
             {

                 ll.get(i).addLast(new Event(date,Sub,Memo));
//                 linkedList.addLast(new Event(date,Sub,Memo));
             }
        }//for

        if (i+1>=ll.size())
        {
            k++;
            ll.addLast(linkedList);
            linkedList.addLast(new Event(date,Sub,Memo));
        }
//        linkedList.addLast(new Event("jj","hh","jyf"));
//        linkedList.addLast(new Event(date,Sub,Memo));
//        System.out.println(linkedList.getFirst().getName());
        System.out.println("K = "+k+"ADD Name = "+linkedList.get(i).getName()+"  Date ADD = "+ll.get(i).getFirst().getDate()+"ADD LL SIZE = "+ll.size()+"ADD LINKLISTSIZE = "+linkedList.size());
//        MyEvent.add( new Event( Sub,Memo,date));
//        System.out.println(MyEvent.get(0).getName());
    }*/
    public void Remove (LocalDate date,String memo) throws Exception
    {

        for (int i=0; i<linkedList.size();i++)
        {
            if (linkedList.get(i).getDate().equals(date))
            {
                if (linkedList.get(i).getText().equals(memo))
                {
                    linkedList.remove(i);
                    break;
                }
            }
        }
        Show(elc.DateCalender.getValue());
    }

    public void Attach (LocalDate date , String memo) throws IOException, InterruptedException {
        String place = null,pplace;
//        System.out.println("ATTACH = " + place);
        for (int i=0; i<linkedList.size();i++)
        {
            if (linkedList.get(i).getDate().equals(date))
            {
                if (linkedList.get(i).getText().equals(memo))
                {
                    place=linkedList.get(i).getPlace();
                }
            }
        }

//        BufferedImage bufferedImage =new BufferedImage()
        pplace="cmd /c start "+place;
        System.out.println("ATTACH PPLACE = "+pplace);
//        place.replace("[","").replaceAll("]", "").replaceAll("Sub: ","").replaceAll("Memo: ","");
//        System.out.println("ATTACH = " + place);
//        pplace="E:\\University\\term 2\\gosaste\\Assignments4.pdf";
        Process pro = Runtime.getRuntime().exec(pplace);
//        pro.waitFor();

    }
    public void Show (LocalDate date) throws Exception
    {
        elc.ListViewToday.getItems().clear();
        for (int i=0;i<linkedList.size();i++)
        {
            if (linkedList.get(i).getDate().equals(date))
                elc.setListViewToday(linkedList.get(i).getName(),linkedList.get(i).getText());
        }


 //       System.out.println("LL 2 = "+ll.size());
//        eventsListController.setListViewToday(9);

/*        int i,j=0;
        System.out.println("ll SIZE = "+ll.size());
        for (i=0;i<ll.size();i++)
        {
//            System.out.println("SHOW"+linkedList.get(0).getName()+"  Date SHOW:"+ll.get(0).getFirst().getDate());
            if (ll.get(i).getFirst().getDate().equals(date))
            {
                j=1;
                if(linkedList!=null)
                {
                    System.out.println("SHOW THIS DATE"+date);
                    System.out.println("SHOW NAME"+ll.get(i).get(0).getName());
                    for (int k=0 ; k<linkedList.size();k++)
                      elc.setListViewToday(ll.get(i).get(k).getName(),ll.get(i).get(k).getText());
                }
            }
        }//for

    */}//Show
    public void Initialize ()throws Exception
    {


        elc.Userlbl.setText(lc.Correct());
//        elc.Date.setText();
        String filepathBed =lc.Correct()+".txt" ;
        Scanner y;
        y = new Scanner(new File(filepathBed));
        y.useDelimiter("[,\n]");

        String date  = "";
        String sub  = "";
        String memo  = "";
        String place  = "";

        while (y.hasNext())
        {
            date = y.next();
            sub = y.next();
            memo = y.next();
            place = y.next();

            LocalDate lc =LocalDate.parse(date);
            System.out.println("DATE AND SUB: "+date+sub);
            linkedList.addLast(new Event(lc,sub,memo,place));

        }
        for (int j=0 ; j<linkedList.size();j++)
        {
            if (elc.localdate.isAfter(linkedList.get(j).getDate()))
            {
                Remove(linkedList.get(j).getDate(),linkedList.get(j).getText());
            }
        }
        System.out.println("MANEGER INITIALAZI");
//        Show(elc.DateCalender.getEditor().getText());
        elc.ListViewToday.getItems().clear();
        for (int i=0;i<linkedList.size();i++)
        {
            if (linkedList.get(i).getDate().equals(date))
                elc.setListViewToday(linkedList.get(i).getName(),linkedList.get(i).getText());
        }

    }//method
    public void Exit ()throws Exception
    {

//        String filepath = "Patient.txt";
//        File file = new File(filepath);
//        file.delete();

//        LoginController lc = new LoginController();
//        System.out.println("SIZE BEFOR EXIT"+linkedList.size());
       // String filepath = lc.Correct() +".txt";
        String filepath = lc.Correct()+".txt";
        File file = new File(filepath);
//        file.delete();
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();

//        if (file.delete())
//            System.out.println("FILE CLEAR");
//        else
//            System.out.println("ERROR:: CAN NOT CLEAR  FILE");
        BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true));
        for (int i=0;i<linkedList.size();i++)
        {
            bw.write(linkedList.get(i).getDate()+","+linkedList.get(i).getName()+","+linkedList.get(i).getText()+","+linkedList.get(i).getPlace()+"\n");
        }
        bw.close();
        System.out.println("EXIT");

    }//method
}//class
