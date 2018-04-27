package gohackathonteam.com.vgraphe.networking;

import android.util.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import gohackathonteam.com.vgraphe.model.Person;
import gohackathonteam.com.vgraphe.networking.Parse.Friends;
import gohackathonteam.com.vgraphe.networking.Parse.User;
import gohackathonteam.com.vgraphe.utils.SimpleCallback;

public class Request implements VKApi {
    @Override
    public void getPerson(String id, SimpleCallback<Person> callback) {

        String url = "https://api.vk.com/method/users.get?user_id=" + id + "&fields=photo_50&v=5.74";

        try {
            HTTP.lamda(() -> {
                Person person = null;
                JsonReader json = HTTP.get(url);
                try {
                    person = User.personParse(json, id);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                callback.success(person);
            });
        }
        catch (Exception e){
            callback.failure(e);
        }

    }

    @Override
    public void getFriends(Person person, SimpleCallback<Collection<Person>> callback) {
        String url = "https://api.vk.com/method/friends.get?user_id=" + person.getId() + "&order=hints&fields=photo_50&v=5.74";

        try {
            HTTP.lamda(() -> {
                JsonReader json = HTTP.get(url);
                ArrayList<Person> friends = null;
                try {
                    friends = Friends.personParse(json);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                callback.success(friends);
            });
        }
        catch (Exception e){
            callback.failure(e);
        }
    }
}
