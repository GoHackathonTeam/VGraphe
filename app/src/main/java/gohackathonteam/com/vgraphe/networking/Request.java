package gohackathonteam.com.vgraphe.networking;

import java.util.Collection;

import gohackathonteam.com.vgraphe.model.Person;
import gohackathonteam.com.vgraphe.utils.SimpleCallback;

public class Request implements VKApi {
    @Override
    public void getPerson(String id, SimpleCallback<Person> callback) {

    }

    @Override
    public void getFriends(Person person, SimpleCallback<Collection<Person>> callback) {

    }
}
