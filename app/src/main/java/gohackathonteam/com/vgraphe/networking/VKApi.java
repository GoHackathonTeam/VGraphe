package gohackathonteam.com.vgraphe.networking;

import java.util.Collection;

import gohackathonteam.com.vgraphe.model.Person;
import gohackathonteam.com.vgraphe.utils.SimpleCallback;

public interface VKApi {
    void getPerson(String id, SimpleCallback<Person> callback);
    void getFriends(Person person, SimpleCallback<Collection<Person>> callback);
}
