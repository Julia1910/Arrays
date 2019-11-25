package com.kopytko.model.arrays;

public class DuplicateArray {
    public int[] array;

    public DuplicateArray(int[] array) {
        this.array = array;
    }

    public void deleteDuplicate() {
        int size = array.length;
        for (int i = 1; i < size; i++) {
            if (array[i] == array[i-1]) {
                remove(i-1);
                size--;
                i--;
            }
        }
    }

    public void remove(int index) {
        if (index == 0) {
            int[] array2 = new int[array.length - 1];
            System.arraycopy(array, 1, array2, 0, array2.length);
            array = array2;
        } else if (index == array.length - 1) {
            int[] array2 = new int[array.length - 1];
            for (int i = 0; i < array.length - 1; i++) {
                array2[i] = array[i];
            }
            array = array2;
        } else {
            int[] array2 = new int[array.length - 1];
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


}
