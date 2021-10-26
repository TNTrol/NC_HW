import collections.ArrayList;
import collections.List;
import org.junit.*;

public class TestList {

    @Test
    public void testArrayAppend10Elements()
    {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; ++i)
        {
            list.add(i);
        }
        assert (list.size() == 10);
    }

    @Test
    public void testArrayAppend100Elements()
    {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 100; ++i)
        {
            list.add(i);
        }
        assert (list.size() == 100);
    }

    @Test
    public void testArrayRemove10Elements()
    {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; ++i)
        {
            list.add(i);
        }
        for (int i = 9; i >= 0; --i)
        {
            list.remove(i);
        }
    }

    @Test
    public void testArrayElements()
    {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; ++i)
        {
            list.add(i);
        }
        for (int i = 9; i >= 0; --i)
        {
            list.remove(i);
        }
    }

    @Test
    public void testArrayRemoveFirstElements()
    {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; ++i)
        {
            list.add(i);
        }
        for (int i = 0; i < 3; ++i)
        {
            list.remove(i);
        }
    }

    @Test
    public void testArrayClear()
    {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 11; ++i)
        {
            list.add(i);
        }
        list.clear();
        assert (list.size() == 0);
    }

    @Test
    public void testTrueValuesAfterRemoving()
    {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; ++i)
        {
            list.add(i);
        }
        for (int i = 0; i < 3; ++i)
        {
            list.remove(0);
        }
        for (int i = 3; i < 10; ++i)
        {
            assert (list.get(i - 3) == i);
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutIndex()
    {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; ++i)
        {
            list.add(i);
        }
        list.get(100);
    }

}
