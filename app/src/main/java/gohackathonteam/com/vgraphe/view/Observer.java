package gohackathonteam.com.vgraphe.view;

public interface Observer<T> {
    void update();
    default void update(T t) {}
}