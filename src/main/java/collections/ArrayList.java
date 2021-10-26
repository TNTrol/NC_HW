package collections;

public class ArrayList<T> implements List<T> {

    private class Node<T> {
        private T value;

        public Node()
        {}

        public Node(T value)
        {
            this.value = value;
        }

        public T getValue()
        {
            return value;
        }

        public void setValue(T value)
        {
            this.value = value;
        }
    }

    private static final int SIZE = 10;

    private Node<T>[] array;
    private int size;

    public ArrayList()
    {
        array = new Node[SIZE];
        size = 0;
    }

    @Override
    public void add(T t)
    {
        if(size >= array.length)
        {
            Node<T>[] temp = new Node[array.length * 2];
            for (int i = 0; i < size; ++i)
            {
                temp[i] = array[i];
            }
            array = temp;
        }
        array[size] = new Node<>(t);
        size++;
    }

    @Override
    public T get(int index)
    {
        if(index >= size)
            throw new IndexOutOfBoundsException();
        return array[index].getValue();
    }

    @Override
    public void remove(int index)
    {
        if(index >= size)
            throw new IndexOutOfBoundsException();
        for (int i = index; i < size - 1; ++i)
        {
            array[i] = array[i + 1];
        }
        if(size > 0)
        {
            array[size - 1] = null;
        }
        size--;
    }

    @Override
    public void clear()
    {
        array = new Node[SIZE];
        size = 0;
    }

    @Override
    public int size()
    {
        return size;
    }
}
