import java.util.Scanner;

public class Main {
    private static Scanner sc;

    void main()
    {
        sc = new Scanner(System.in);

        Person.personDemo();
        leapYearDemo();
        Item.purchaseItemsDemo();
        averageOfThreeDemo();
        greetingDemo();
        arithmeticDemo();
        sc.close();

    }

    private void leapYearDemo()
    {
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
        sc.nextLine();
    }

    private static boolean leapYearCalculation(int year)
    {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    private void averageOfThreeDemo()
    {
        IO.print("Enter first number: ");
        int first = sc.nextInt();
        IO.print("Enter second number: ");
        int second = sc.nextInt();
        IO.print("Enter third number: ");
        int third = sc.nextInt();
        double average = (first+second+third)/3.0;
        IO.println("Average: " + average);
        sc.nextLine();
    }

    private void greetingDemo()
    {
        IO.print("Enter first name: ");
        String first = sc.nextLine();
        IO.print("Enter last name: ");
        String last = sc.nextLine();
        IO.println("Hello, " + first + " "+ last + "! Welcome aboard.");
    }

    private void arithmeticDemo()
    {
        IO.print("Enter first number: ");
        int first = sc.nextInt();
        IO.print("Enter second number: ");
        int second = sc.nextInt();
        IO.println(first + " + " + second + " = " + (first + second));
        IO.println(first + " - " + second + " = " + (first - second));
        IO.println(first + " * " + second + " = " + (first * second));
        IO.println(first + " / " + second + " = " + (first / second));//cast at least one of the values before dividing to avoid rounding
        sc.nextLine();
    }
}
