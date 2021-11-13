import org.junit.Test;
import sort.ISort;
import sort.impl.BubbleSort;
import sort.impl.InsertSort;

import java.util.Comparator;

public class TestSort {

    @Test
    public void testBubbleSort()
    {
        Integer[] array = {1, -3, 90, -5, 0, -8, 10};
        ISort<Integer> sort = new BubbleSort<>();
        sort.sortArray(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1)
            {
                return integer - t1;
            }
        });
        int m = array[0];
        for (int a : array)
        {
            assert (a <= m);
            m = a;
        }

    }

    @Test
    public void testInsertSort()
    {
        Integer[] array = {1, -3, 90, -5, 0, -8, 10};
        ISort<Integer> sort = new InsertSort<>();
        sort.sortArray(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1)
            {
                return integer - t1;
            }
        });
        int m = array[0];
        for (int a : array)
        {
            assert (a <= m);
            m = a;
        }
    }
}
