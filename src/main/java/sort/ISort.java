package sort;

import collections.List;

import java.util.Comparator;

public interface ISort<T> {
    void sortArray(T[] array, Comparator<T> comparator);
}
