import data.*;
import org.junit.Before;
import org.junit.Test;
import repository.Repository;

import java.util.Date;

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

        repository.addContract(contract1);
        repository.addContract(contract2);
        repository.addContract(contract3);
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
}
