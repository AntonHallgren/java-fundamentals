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
                case 9 -> temperatureConverter();
                case 10 -> swapTwo(15, 42);
                case 11 -> fizzBuzz();
                case 12 -> gradeCalculator();
                case 13 -> weekdayChecker();
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

    private void temperatureConverter()
    {
        IO.print("Enter temperature in Celsius: ");
        int inC = sc.nextInt();
        sc.nextLine();
        IO.println("Celsius:    " + (double)inC + " °C");
        IO.println("Fahrenheit: " + (inC*9.0/5 + 32) + " °F");
        IO.println("Kelvin:     " + (inC + 273.15) + "K");
    }

    private static void swapTwo(int a, int b)
    {
        IO.println("Before: a = " + a + ", b = " + b);
        a = a + b;//=a0 + b0
        b = a - b;//=a0
        a = a - b;//=b0
        IO.println("After: a = " + a + ", b = " + b);
    }

    private void fizzBuzz()
    {
        for(int i = 1; i <= 30; i++)
        {
            IO.println(fizzBuzzOne(i));
        }

    }

    private String fizzBuzzOne(int n)
    {
        if(n%3 == 0 && n%5 == 0)//equivalently n%15 == 0
        {
            return "FizzBuzz";
        }
        else if(n%3 == 0)
        {
            return "Fizz";
        }
        else if(n%5 == 0)
        {
            return "Buzz";
        }
        else {
            return "" + n;
        }
    }

    private void gradeCalculator()
    {
        IO.print("Enter score: ");
        int score = sc.nextInt();
        sc.nextLine();
        if(score > 100 || score < 0)
        {
            IO.println("Invalid input, score must be 0 - 100");
        }
        else if(score >= 90)
        {
            IO.println("Grade: A");
        }
        else if(score >= 80)
        {
            IO.println("Grade: B");
        }
        else if(score >= 70)
        {
            IO.println("Grade: C");
        }
        else if(score >= 60)
        {
            IO.println("Grade: D");
        }
        else
        {
            IO.println("Grade: F");
        }
    }

    private void weekdayChecker()
    {
        IO.print("Enter day: ");
        String day = sc.nextLine();
        switch (day)
        {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> IO.println("Weekday");
            case "Saturday", "Sunday" -> IO.println("Weekend");
            default -> IO.println("Unknown day");
        }
    }
}
