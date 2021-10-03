package edu.epam.arraytask.customarray.impl;

import edu.epam.arraytask.customarray.CustomArray;

import java.util.Arrays;

public class CustomArrayImpl implements CustomArray {
    private int[] array;

    public CustomArrayImpl(int size) {
        array = new int[size];
    }

    public CustomArrayImpl(int... arrayElements) {
        setArray(arrayElements);
    }

    @Override
    public int getElement(int index) {
        return array[index];
    }

    @Override
    public void setElement(int index, int element) {
        array[index] = element;
    }

    @Override
    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    @Override
    public void setArray(int... arrayElements) {
        this.array = Arrays.copyOf(arrayElements, arrayElements.length);
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        CustomArrayImpl customArray = (CustomArrayImpl) obj;

        return Arrays.equals(array, customArray.getArray());
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
