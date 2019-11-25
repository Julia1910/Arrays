package com.kopytko.model.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThirdArray {
    private int[] firstArray;
    private int[] secondArray;
    public List<Integer> thirdArrayBoth;
    public List<Integer> thirdArrayOne;
    public int[] array3;

    public ThirdArray(int[] firstArray, int[] secondArray) {
        this.firstArray = firstArray;
        this.secondArray = secondArray;
    }

    public int[] getFirstArray() {
        return firstArray;
    }

    public void setFirstArray(int[] firstArray) {
        this.firstArray = firstArray;
    }

    public int[] getSecondArray() {
        return secondArray;
    }

    public void setSecondArray(int[] secondArray) {
        this.secondArray = secondArray;
    }

    public void getThirdArrayBoth() {
        thirdArrayBoth = new ArrayList<>();
        thirdArrayOne = new ArrayList<>();
        array3 = firstArray;
        int index = 0;
            for (int j = 0; j < secondArray.length; j++) {
                for (int i = 0; i < firstArray.length; i++) {
                    if (firstArray[i] == secondArray[j]) {
                    thirdArrayBoth.add(firstArray[i]);
                    index = i;
                    if (index >= array3.length) {
                        array3 = remove(array3, (index - 1));
                    } else {
                        array3 = remove(array3, index);
                    }
                }
            }
        }
    }

    public int[] remove(int[] array, int index) {
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
        return array;
    }
}

