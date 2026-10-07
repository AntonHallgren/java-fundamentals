import java.util.Scanner;

public class Main {
    void main()
    {
        //Person.personDemo();
        //leapYearDemo();
        //Item.purchaseItemsDemo();
        AvarageOfThreeDemo();


    }

    private static void leapYearDemo()
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

    private static boolean leapYearCalculation(int year)
    {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    private static void AvarageOfThreeDemo()
    {
        Scanner sc = new Scanner(System.in);
        IO.print("Enter first number: ");
        int first = sc.nextInt();
        IO.print("Enter second number: ");
        int second = sc.nextInt();
        IO.print("Enter third number: ");
        int third = sc.nextInt();
        double average = (first+second+third)/3.0;
        IO.println("Average: " + average);
        sc.close();
    }
}
