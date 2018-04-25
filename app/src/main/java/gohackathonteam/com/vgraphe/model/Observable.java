package gohackathonteam.com.vgraphe.model;

import gohackathonteam.com.vgraphe.view.Observer;

public interface Observable<T> {
    void addObserver(Observer<T> observer);
    void removeObserver(Observer<T> observer);
}
