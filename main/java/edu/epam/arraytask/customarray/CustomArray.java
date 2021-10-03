package edu.epam.arraytask.customarray;

public interface CustomArray {
    int getElement(int index);

    void setElement(int index, int element);

    int[] getArray();

    void setArray(int... arrayElements);

    int size();
}
