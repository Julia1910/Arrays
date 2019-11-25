package com.kopytko.model.arrays;

public class ClearArray {
    public int[] array;

    public ClearArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void clear() {
        int size = array.length;
        for (int i =0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if (array[i] == array[j]) {
                    for (int k = j; k < size; k++) {
                        if ((k+1) >= size) {
                            remove(k);
                        } else {
                            array[k] = array[k + 1];
                        }
                    }
                    size--;
                    j--;
                }
            }
        }
    }



    public void remove (int index) {
        if (index == 0) {
            int[] array2 = new int[array.length-1];
            System.arraycopy(array, 1, array2, 0, array2.length);
            array = array2;
        }
        else if (index == array.length-1) {
            int[] array2 = new int[array.length-1];
            for (int i = 0; i < array.length-1; i++) {
                array2[i] = array[i];
            }
            array = array2;
        }
        else {
            int[] array2 = new int[array.length-1];
            for (int i = 0; i < array.length; i++) {
                if (i > index) {
                    array2[i-1] = array[i];
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
