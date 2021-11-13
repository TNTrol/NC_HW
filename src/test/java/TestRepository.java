import data.*;
import org.junit.Before;
import org.junit.Test;
import repository.Repository;

import java.util.Comparator;
import java.util.Date;
import java.util.function.Predicate;

public class TestRepository {

    private Repository repository;

    @Before
    public void testBefore()
    {
        repository = new Repository();
        Human human = new Human(1, "fio1", new Date(11, 23, 11), true, 1234567);

        TelevisionContract contract1 = new TelevisionContract();
        contract1.setNamePackage("simple");
        contract1.setId(0);
        contract1.setNumber(12324);
        contract1.setOwner(human);
        contract1.setDateEnd(new Date(12, 5, 13));

        MobilContract contract2 = new MobilContract();
        contract2.setDateEnd(new Date(12, 3, 2));
        contract2.setId(2);
        contract2.setCountSMS(12);
        contract2.setCountMinutes(2334);
        contract2.setOwner(human);
        contract2.setTraffic(23.6);
        contract2.setNumber(56789);

        InternetContract contract3 = new InternetContract();
        contract3.setVelocity(1234);
        contract3.setDateEnd(new Date(123, 2, 4));
        contract3.setId(10);
        contract3.setNumber(23456);
        contract3.setOwner(human);

        MobilContract contract4 = new MobilContract();
        contract4.setDateEnd(new Date(1, 3, 2));
        contract4.setId(23);
        contract4.setCountSMS(12);
        contract4.setCountMinutes(500);
        contract4.setOwner(human);
        contract4.setTraffic(100.6);
        contract4.setNumber(1000);

        InternetContract contract5 = new InternetContract();
        contract5.setVelocity(10000);
        contract5.setDateEnd(new Date(23, 2, 4));
        contract5.setId(101);
        contract5.setNumber(2000);
        contract5.setOwner(human);


        repository.addContract(contract1);
        repository.addContract(contract2);
        repository.addContract(contract3);
        repository.addContract(contract4);
        repository.addContract(contract5);

    }

    @Test
    public void testGet0Contract()
    {
        AbstractContract contract = repository.getContract(0);
        assert (contract != null);
        assert (contract.getId() == 0);
        assert  (contract.getOwner().isGender());
    }

    @Test
    public void testGet10Contract()
    {
        AbstractContract contract = repository.getContract(10);
        assert ( contract instanceof InternetContract );
    }

    @Test
    public void testGetRepositoryByPredicate()
    {
        Repository repository = this.repository.getRepositoryBy(new Predicate<AbstractContract>() {
            @Override
            public boolean test(AbstractContract contract)
            {
                return contract instanceof MobilContract;
            }
        });
        for(AbstractContract contract : repository)
        {
            assert (contract instanceof MobilContract);
        }
    }

    @Test
    public void testSortRepository()
    {
        repository.sortRepository(new Comparator<AbstractContract>() {
            @Override
            public int compare(AbstractContract contract1, AbstractContract contract2)
            {
                return  contract1.getId() - contract2.getId();
            }
        });
        int m = -1;
        for(AbstractContract contract : repository)
        {
            if(m < 0)
            {
                m = contract.getId();
                continue;
            }
            assert (contract.getId() < m);
            m = contract.getId();
        }
    }
}
