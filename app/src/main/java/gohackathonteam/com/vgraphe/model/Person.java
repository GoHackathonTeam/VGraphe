package gohackathonteam.com.vgraphe.model;

import android.graphics.Bitmap;

public class Person {
    private Bitmap photo;
    private String name;
    private String surname;
    private int id;

    public Person(int id, String name, String surname, Bitmap photo){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.photo = photo;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }
}
