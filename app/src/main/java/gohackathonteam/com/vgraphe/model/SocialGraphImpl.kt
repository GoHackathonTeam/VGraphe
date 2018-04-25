package gohackathonteam.com.vgraphe.model

import gohackathonteam.com.vgraphe.networking.VKApi
import gohackathonteam.com.vgraphe.view.Observer
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CopyOnWriteArrayList

class SocialGraphImpl(private val vk: VKApi): SocialGraph {

    private lateinit var thisPerson: Person
    private val observers = CopyOnWriteArrayList<Observer<Person>>()

    private var friends = ConcurrentHashMap<Int, Person>()

    override fun addObserver(observer: Observer<Person>?) {
        if (observer != null)
            observers += observer
    }

    override fun removeObserver(observer: Observer<Person>?) {
        if (observer != null)
            observers -= observer
    }

    override fun rebase(person: Person?) {
        thisPerson = person!!
        friends.clear()
        vk.getFriends(thisPerson) {
            for ((i, value) in it.withIndex()) {
                friends[i] = value
                for (observer in observers) {
                    try {
                        observer.update()
                        observer.update(value)
                    } catch (e: Exception) {
                        e.printStackTrace(System.err)
                    }
                }
            }
        }
    }

    override fun getFriends(): MutableCollection<Person> = friends.values

    override fun getCurrentPerson(): Person = thisPerson
}