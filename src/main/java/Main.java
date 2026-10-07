import java.util.Scanner;

public class Main {
    private static Scanner sc;

    void main()
    {
        sc = new Scanner(System.in);

        exerciseSelection();
        sc.close();

    }

    private void exerciseSelection()
    {
        boolean running = true;
        while(running)
        {
            IO.print("Enter the number of the exercise you want to run (enter 0 to quit): ");
            int exercise = sc.nextInt();
            sc.nextLine();
            switch (exercise)
            {
                case 0 -> running = false;
                case 1 -> Person.personDemo();
                case 2 -> leapYearDemo();
                case 3 -> Item.purchaseItemsDemo();
                case 4 -> averageOfThreeDemo();
                case 5 -> greetingDemo();
                case 6 -> arithmeticDemo();
                case 7 -> convertSecondsDemo();
                case 8 -> guessNumber();
                default -> IO.println("Seems like no exercise of that number has been completed");
            }
        }
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

    private void convertSecondsDemo()
    {
        IO.print("Enter seconds: ");
        int seconds = sc.nextInt();
        sc.nextLine();
        int hours = seconds / 3600;
        seconds = seconds % 3600;
        int minutes = seconds / 60;
        seconds = seconds % 60;
        IO.println(hours + ":" + minutes + ":" + seconds);
    }

    private void guessNumber()
    {
        int randomNumber = (int) (1 + Math.random()*500);
        int numberGuesses = 0;
        boolean gotIt = false;
        IO.println("Guess the number 1 - 500");
        while(!gotIt)
        {
            IO.print("Enter your guess: ");
            int guess = sc.nextInt();
            sc.nextLine();
            numberGuesses++;
            if(guess == randomNumber)
            {
                gotIt = true;
                IO.println("Correct! You got it in " + numberGuesses + " guessess");
            }
            else if(guess < randomNumber)
            {
                IO.println("Too small!");
            }
            else {
                IO.println("Too big!");
            }
        }
    }
}
