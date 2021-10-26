package app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ConsoleWorking consoleWorking = new ConsoleWorking();
        String token = "";
        while (!token.equals("-e"))
        {
            System.out.print("Введите комманду: -pa - распечатать все контракты; -p - распечатать один контракт; -a - добавить новый контракт; -r - удалить контракт: -e - выход\n");
            token = scanner.next();
            switch (token)
            {
                case "-pa":
                {
                    consoleWorking.printAll();
                    break;
                }
                case "-a":
                {
                    consoleWorking.add(scanner);
                    break;
                }
                case "-r":
                {
                    consoleWorking.remove(scanner);
                    break;
                }
                case  "-p":
                {
                    consoleWorking.printContract(scanner);
                    break;
                }
            }
        }

    }


}
