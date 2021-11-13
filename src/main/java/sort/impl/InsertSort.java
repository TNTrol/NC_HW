package sort.impl;

import sort.ISort;

import java.util.Comparator;

public class InsertSort<T> implements ISort<T> {

    @Override
    public void sortArray(T[] array, Comparator<T> comparator)
    {
        for (int left = 0; left < array.length; left++)
        {
            int minInd = left;
            for (int i = left; i < array.length; i++)
            {
                if (comparator.compare( array[i],array[minInd]) > 0)
                {
                    minInd = i;
                }
            }
            T temp = array[left];
            array[left] = array[minInd];
            array[minInd] = temp;
        }
    }
}
