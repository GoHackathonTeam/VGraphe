package gohackathonteam.com.vgraphe.utils;

public interface Callback<A, B, C> {
    void success(A a);
    default void failure(B b) {
    }
    default void update(C c) {
    }
}
