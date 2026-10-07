import java.util.Scanner;

public class Main {
    void main()
    {
        //Not using my own details here
        Person p = new Person("Sven Svensson", 42, "Stockholm");
        p.printProfile();



        leapYearProcess();




    }

    private void leapYearProcess()
    {
        Scanner sc = new Scanner(System.in);
        IO.print("Enter a year: ");
        int year = sc.nextInt();
        if(leapYearCalculation(year))
        {
            IO.println(year + " is a leap year.");
        }
        else
        {
            IO.println(year + " is NOT a leap year.");
        }
        sc.close();
    }

    private boolean leapYearCalculation(int year)
    {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
}
