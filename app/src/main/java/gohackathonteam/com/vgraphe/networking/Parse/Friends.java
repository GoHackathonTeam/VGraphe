package gohackathonteam.com.vgraphe.networking.Parse;

import android.graphics.Bitmap;
import android.util.JsonReader;

import java.io.IOException;
import java.util.ArrayList;

import gohackathonteam.com.vgraphe.model.Person;
import gohackathonteam.com.vgraphe.networking.HTTP;

public class Friends {

    public static ArrayList<Person> personParse(JsonReader json) throws IOException {
        ArrayList<Person> person = new ArrayList<>();
        String id = "";
        String name = null;
        String surname = null;
        Bitmap photo = null;

        json.beginObject();
        json.nextName();
        json.beginObject();
        json.nextName();
        json.skipValue();
        json.nextName();
        json.beginArray();
        while (json.hasNext()){
            json.beginObject();
            while (json.hasNext()) {
                switch (json.nextName()){
                    case "id":
                        id = json.nextString();
                        break;
                    case "first_name":
                        name = json.nextString();
                        break;
                    case "last_name":
                        surname = json.nextString();
                        break;
                    case "photo_50":
                        photo = HTTP.getImageBitmap(json.nextString());
                        break;
                    default:
                        json.skipValue();
                }
            }
            person.add(new Person(id, name, surname, photo));
            json.endObject();
        }
        json.endArray();
        json.endObject();
        json.endObject();

        return person;
    }
}
