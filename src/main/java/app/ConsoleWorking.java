package app;

import data.*;
import repository.Repository;

import java.util.Date;
import java.util.Scanner;

public class ConsoleWorking {
    private int id_human = 0;
    private int id_contract = 0;
    private Repository repository = new Repository();

    public AbstractContract readContract(Scanner scanner)
    {
        AbstractContract contract = null;
        System.out.print("Введите название тарифа: мобильный, интернет, телевизионный\n");
        String token = scanner.next();
        if(token.equals("мобильный"))
        {
            contract = new MobilContract();
            readAbstractContractsFromConsole(contract, scanner);
            readMobilContract((MobilContract) contract, scanner);

        }
        else if(token.equals("интернет"))
        {
            contract = new InternetContract();
            readAbstractContractsFromConsole(contract, scanner);
            readInternetContract((InternetContract) contract, scanner);
        }
        else if(token.equals("телевизионный"))
        {
            contract = new TelevisionContract();
            readAbstractContractsFromConsole(contract, scanner);
            readTelevisionContract((TelevisionContract) contract, scanner);
        }
        else
        {
            System.out.print("Неопределенный тип пакета\n");
        }
        return contract;
    }

    public Date readDate(Scanner scanner)
    {
        System.out.print("Введите числами год , месяц, день\n");
        int year = scanner.nextInt();
        int mouth = scanner.nextInt();
        int day = scanner.nextInt();
        return new Date(year, mouth, day);
    }

    public void readMobilContract(MobilContract contract, Scanner scanner)
    {
        System.out.print("Введите количество минут");
        int minute = scanner.nextInt();
        System.out.print("Введите трафик");
        double traffic = scanner.nextDouble();
        System.out.print("Введите количество смс");
        int sms = scanner.nextInt();
        contract.setCountMinutes(minute);
        contract.setCountSMS(sms);
        contract.setTraffic(traffic);
    }

    public void readInternetContract(InternetContract contract, Scanner scanner)
    {
        System.out.print("Введите скорость интернета");
        int velocity = scanner.nextInt();
        contract.setVelocity(velocity);
    }

    public void readTelevisionContract(TelevisionContract contract, Scanner scanner)
    {
        System.out.print("Введите название пакеты");
        String namePackage = scanner.next();
        contract.setNamePackage(namePackage);
    }

    public void readAbstractContractsFromConsole(AbstractContract contract, Scanner scanner)
    {
        System.out.print("Дата окончания контракта\n");
        Date date = readDate(scanner);
        Human human = readHumanFromConsole(scanner);
        System.out.print("Введите номер телефона");
        int number = scanner.nextInt();
        contract.setOwner(human);
        contract.setId(id_contract++);
        contract.setDateEnd(date);
        contract.setNumber(number);
    }

    public Human readHumanFromConsole(Scanner scanner)
    {
        System.out.print("Введите ФИО\n");
        String fio = scanner.next();
        System.out.print("Дата рождения\n");
        Date date = readDate(scanner);
        System.out.print("Введите серию паспорта\n");
        int number = scanner.nextInt();
        System.out.print("Введите пол: м, ж");
        String gender = scanner.next();
        boolean gender_b = gender.equals("м");
        return new Human(id_human++, fio, date, gender_b, number);
    }

    public void printAll()
    {
        for (AbstractContract contract: repository) {
            System.out.println(contract);
        }
    }

    public void remove(Scanner scanner)
    {
        System.out.print("Введите id контракта");
        int ind = scanner.nextInt();
        repository.removeContract(ind);
    }

    public void add(Scanner scanner)
    {
        AbstractContract contract = readContract(scanner);
        if(contract != null)
        {
            repository.addContract(contract);
        }
    }

    public void printContract(Scanner scanner)
    {
        System.out.print("Введите id контракта");
        int ind = scanner.nextInt();
        AbstractContract contract = repository.getContract(ind);
        if(contract != null)
        {
            System.out.print(contract);
        }
        else
        {
            System.out.print("Нет такого контракта");
        }
    }
}
