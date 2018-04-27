package gohackathonteam.com.vgraphe.model;

import android.graphics.Bitmap;

public class Person {
    private Bitmap photo;
    private String name;
    private String surname;
    private String id;

    public Person(String id, String name, String surname, Bitmap photo){
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

    public String getId() {
        return id;
    }
}
