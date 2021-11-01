package repository;

import collections.ArrayList;
import collections.List;
import data.AbstractContract;

import java.util.Iterator;

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
            if(contracts.get(i).getId() == id)
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
}
