package collections;

/**
 *  Мой интерфейс коллекции
 * @param <T> тип хранимых объектов
 */
public interface List<T> {

    /**
     * Добавление объекта в коллекцию
     * @param t
     */
    void add(T t);

    /**
     * Получение объекта из коллекции по индексу
     * @param index индекс нужного объекта
     * @return
     */
    T get(int index);

    /**
     * Изменение значения по индексу
     * @param index индекс элемента
     * @param value значение, которое нужно установить
     */
    void set(int index, T value);

    /**
     * Удаление объекта по индексу
     * @param index
     */
    void remove(int index);

    /**
     * Очистка коллекции
     */
    void clear();

    /**
     * Получить размер
     * @return
     */
    int size();

}
