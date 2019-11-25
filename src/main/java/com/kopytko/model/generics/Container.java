package com.kopytko.model.generics;

import com.kopytko.model.classes.Father;

public class Container<T extends Father> {
    private T element;

    public Container(T element) {
        this.element = element;
    }


    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
