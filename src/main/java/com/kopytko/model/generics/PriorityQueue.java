package com.kopytko.model.generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityQueue<T> {
    public List<T> list = new ArrayList<T>();
    Comparator<T> c = Comparator.comparing(obj -> obj.hashCode());
    int count = 0;

    public void add(T element) {
        list.add(element);
    }

    public void poll() {
        list.sort(c);
        list.remove(count);
        count++;

    }

    public T peek (int index) {
        list.sort(c);
        return list.get(index);
    }

    public int length() {
        return list.size();
    }
}
