package com.kopytko.model.arrays;

public class ArrayString {
    private String[] array;
    private int size;
    private int count = 0;

    public ArrayString() {
        this.size = 3;
        this.array = new String[size];

    }

    public void add(String element) {
        if (count >= size) {
            size++;
            setNewSize(size);
            array[count] = element;
            count++;
        } else {
            array[count] = element;
            count++;
        }
    }

    public String get(int index) {
        String element = "";
        if (array[index] != null) {
            element = array[index];
        } else {

        }
        return element;
    }

    public void set(int index, String element) {
        array[index] = element;
    }

    public void remove(int index) {
        if (index == 0) {
            String[] array2 = new String[array.length - 1];
            System.arraycopy(array, 1, array2, 0, array2.length);
            array = array2;
        } else if (index == array.length - 1) {
            String[] array2 = new String[array.length - 1];
            for (int i = 0; i < array.length - 1; i++) {
                array2[i] = array[i];
            }
            array = array2;
        } else {
            String[] array2 = new String[array.length - 1];
            for (int i = 0; i < array.length; i++) {
                if (i > index) {
                    array2[i - 1] = array[i];
                }
                if (i == index) {
                    continue;
                }
                if (i < index) {
                    array2[i] = array[i];
                }
            }
            array = array2;
        }

    }

    public int getSize() {
        return array.length;
    }

    public void setNewSize(int size) {
        String[] array1 = new String[size];
        System.arraycopy(array, 0, array1, 0, size-1 );
        array = array1;
    }


}




