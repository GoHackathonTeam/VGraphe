package gohackathonteam.com.vgraphe.networking.Parse;

import android.graphics.Bitmap;
import android.util.JsonReader;

import java.io.IOException;
import java.util.Objects;

import gohackathonteam.com.vgraphe.model.Person;
import gohackathonteam.com.vgraphe.networking.HTTP;


public class User {

    public static Person personParse(JsonReader json, String id) throws IOException {
        String name = "";
        String surname = "";
        Bitmap image = null;

        json.beginObject();
        json.nextName();
        json.beginArray();
        while (json.hasNext()) {
            json.beginObject();
            while (json.hasNext()) {
                String next = json.nextName();
                if (Objects.equals(next, "first_name")) {
                    name = json.nextString();
                } else if (Objects.equals(next, "last_name"))
                    surname = json.nextString();
                else if (Objects.equals(next, "photo_50"))
                    image = HTTP.getImageBitmap(json.nextString());
                else
                    json.skipValue();

            }
            json.endObject();
        }
        json.endArray();
        json.endObject();

        return new Person(id, name, surname, image);
    }
}
