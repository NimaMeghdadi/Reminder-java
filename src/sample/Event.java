package sample;

import java.time.LocalDate;
import java.util.*;
public class Event {
    private  Integer id;
    private  String name;
    private  String text;
    private String place;
    private LocalDate date ;
    public LocalDate getDate() {
        return date;
    }



    public void setDate(LocalDate date) {
        this.date = date;
    }



    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }


    User user;


    private ArrayList<String> files;









    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<String> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<String> files) {
        files = files;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    Event( LocalDate date,String name, String text,String place  ){

        this.name=name;
        this.text=text;
        this.date=date;
        this.place=place;
    }

}
