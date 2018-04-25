package gohackathonteam.com.vgraphe.model;

import java.util.Collection;

public interface SocialGraph {
    void rebase(Person person);

    Collection<Person> getFriends();
    Person getCurrentPerson();
}
