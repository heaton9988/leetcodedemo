package cspiration.array;

public interface IArrList {
    int remove(int index);

    void removeElement(int v);

    int get(int index);

    void set(int index, int v);

    boolean contains(int v);

    void add(int v);

    void add(int index, int v);

    int capacity();

    int size();

    boolean isEmpty();
}