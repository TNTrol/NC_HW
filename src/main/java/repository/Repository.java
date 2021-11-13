package repository;

import collections.ArrayList;
import collections.List;
import data.AbstractContract;
import sort.ISort;
import sort.impl.InsertSort;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Класс для хранения контрактов
 */
public class Repository implements Iterable<AbstractContract>{
    private List<AbstractContract> contracts;

    public Repository()
    {
        contracts = new ArrayList<>();
    }

    /**
     * Добавить контракт в репозиторий
     * @param contract
     */
    public void addContract(AbstractContract contract)
    {
        contracts.add(contract);
    }

    /**
     * Получение контракта по id контракта
     * @param id
     * @return
     */
    public AbstractContract getContract(Integer id)
    {
        for (int i = 0; i < contracts.size(); ++i)
        {
            if(contracts.get(i).getId().equals(id))
            {
                return contracts.get(i);
            }
        }
        return null;
    }

    /**
     * Удаление контракта по id
     * @param id
     */
    public void removeContract(Integer id)
    {
        for (int i = 0; i < contracts.size(); ++i)
        {
            if(contracts.get(i).getId() == id)
            {
                contracts.remove(i);
            }
        }
    }

    /**
     * Получить итератор
     * @return
     */
    @Override
    public Iterator<AbstractContract> iterator()
    {
        return new Iterator<AbstractContract>() {
            int index = 0;
            @Override
            public boolean hasNext()
            {
                return index < contracts.size();
            }

            @Override
            public AbstractContract next()
            {
                ++index;
                return contracts.get(index - 1);
            }
        };
    }

    /**
     * Получить подрипозиторий, который соответсвует переданному условию
     * @param predicate условие выборки
     * @return репозитоорий
     */
    public Repository getRepositoryBy(Predicate<AbstractContract> predicate)
    {
        Repository repository = new Repository();
        for(int i = 0; i < contracts.size(); ++i)
        {
            if(predicate.test(contracts.get(i)))
            {
                repository.addContract(contracts.get(i));
            }
        }
        return repository;
    }

    /**
     * Сортировка репозитория
     * @param comparator
     */
    public void sortRepository(Comparator<AbstractContract> comparator)
    {
        ISort<AbstractContract> sort = new InsertSort<>();
        AbstractContract[] tempContracts = new AbstractContract[contracts.size()];
        for(int i = 0; i < contracts.size(); ++i)
        {
            tempContracts[i] = contracts.get(i);
        }
        sort.sortArray(tempContracts, comparator);
        for(int i = 0; i < contracts.size(); ++i)
        {
            contracts.set(i, tempContracts[i]);
        }
    }
}
