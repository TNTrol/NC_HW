package collections;

public interface List<T> {

    void add(T t);

    T get(int index);

    void remove(int index);

    void clear();

    int size();

}
