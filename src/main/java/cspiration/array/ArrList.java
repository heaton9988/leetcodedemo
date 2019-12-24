package cspiration.array;

public class ArrList implements IArrList {
    int[] data;
    int size = 0;

    public ArrList(int capacity) {
        this.data = new int[capacity];
    }

    public ArrList() {
        this(16);
    }

    @Override
    public int remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        int result = data[index];
        for (int i = index; i < size - 1; i++) {
            data[index] = data[index + 1];
        }
        size--;
        return result;
    }

    @Override
    public void removeElement(int v) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i] == v) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            remove(index);
        } else {
            throw new IllegalArgumentException("v not exist");
        }
    }

    @Override
    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        return data[index];
    }

    @Override
    public void set(int index, int v) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        data[index] = v;
    }

    @Override
    public boolean contains(int v) {
        for (int i = 0; i < size; i++) {
            if (data[i] == v) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(int v) {
        add(size, v);
    }

    @Override
    public void add(int index, int v) {
        if (size == capacity()) {
            throw new IllegalArgumentException("array full");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = v;
        size++;
    }

    @Override
    public int capacity() {
        return data.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}