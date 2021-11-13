package sort.impl;

import collections.List;
import sort.ISort;

import java.util.Comparator;

public class BubbleSort<T> implements ISort<T> {
    @Override
    public void sortArray(T[] array, Comparator<T> comparator)
    {
        int elems = array.length;

        for (int out = elems - 1; out >= 1; out--)
        {
            for (int in = 0; in < out; in++)
            {
                if(comparator.compare( array[in],array[in + 1]) < 0)
                {
                    T temp = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = temp;
                }
            }
        }
    }
}
