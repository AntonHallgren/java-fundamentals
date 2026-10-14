import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Exercises2 {
    //shortcut
    static void main() {
        exerciseSelection();
    }
    public static void exerciseSelection()
    {
        boolean running = true;
        while(running)
        {
            IO.print("\nEnter the number of the exercise you want to run (enter 0 to quit): ");
            int exercise = Integer.parseInt(IO.readln().trim());
            switch (exercise)
            {
                case 0 -> running = false;
                case 1 -> wordReverser();
                case 2 -> emailSlicer();
                case 3 -> stringStats();
                case 4 -> initialsGenerator();
                case 5 -> palindromeChecker();
                case 6 -> wordCounter();
                case 7 -> circleCalculator();
                case 8 -> powerTable();
                case 9 -> rightTriangleChecker();
                case 10 -> numberCruncher();
                case 11 -> diceStatistics();
                case 12 -> passwordGenerator();
                case 13 -> receiptBuilder();
                case 14 -> todaysCalender();
                default -> IO.println("Seems like no exercise of that number has been completed");
            }
        }
    }

    private static void wordReverser()
    {
        StringBuilder word = new StringBuilder(IO.readln("Enter a word: "));
        word.reverse();
        IO.println("Reversed; " + word);
    }

    private static void emailSlicer()
    {
        IO.println("Enter email: ");
        String email = IO.readln();
        int index = email.indexOf('@');
        if(index == -1)
        {
            IO.println("Invalid email");
            return;
        }
        IO.println("Username: " + email.substring(0, index));
        IO.println("Domain: " +  email.substring(index+1));
    }

    private enum CharCategory
    {
        VOWEL, CONSONANT, DIGIT, SPACE, OTHER
    }

    private static void stringStats()
    {

        String s = IO.readln("Enter a sentence: ");
        int vowels =0;
        int consonants = 0;
        int digits = 0;
        int spaces = 0;
        for(int i = 0; i < s.length(); i++)
        {
            switch (categoriseChar(s.charAt(i)))
            {
                case CharCategory.VOWEL -> vowels++;
                case CharCategory.CONSONANT -> consonants++;
                case CharCategory.DIGIT -> digits++;
                case CharCategory.SPACE -> spaces++;
            }
        }
        IO.println(String.format("Vowels    : %d", vowels));
        IO.println(String.format("Consonants: %d", consonants));
        IO.println(String.format("Digits    : %d", digits));
        IO.println(String.format("Spaces    : %d", spaces));

    }

    private static CharCategory categoriseChar(char c)
    {
        if(c == ' ')
        {
            return CharCategory.SPACE;//space
        }
        if(Character.isDigit(c))
        {
            return CharCategory.DIGIT;
        }
        if(!Character.isLetter(c))
        {
            //not any of the categories we are looking at
            return CharCategory.OTHER;
        }
        //from what I could find, there is no inbuilt check for vowels/consonants
        if("aeiouyåäö".indexOf(Character.toLowerCase(c)) != -1)
        {
            return CharCategory.VOWEL;
        }
        return CharCategory.CONSONANT;
    }

    private static void initialsGenerator()
    {
        String fullName = IO.readln("Enter full name: ").trim();
        String[] names = fullName.split(" ");
        StringBuilder initials = new StringBuilder();
        for(String n : names)
        {
            if(n.isEmpty())
            {
                continue;
            }
            initials.append(n.charAt(0)).append('.');
        }
        IO.println("Initials: " +  initials.toString().toUpperCase());
    }

    private static void palindromeChecker()
    {
        String word = IO.readln("Enter a word: ");
        String reverse = (new StringBuilder(word)).reverse().toString();
        if(reverse.equalsIgnoreCase(word))
        {
            IO.println(word + " is a palindrome");
        }
        else
        {
            IO.println(word + " is NOT a palindrome");
        }
    }

    private static void wordCounter()
    {
        String sentence = IO.readln("Enter a sentence: ");
        String wordToFind = IO.readln("Enter word to find: ");
        String[] wordsInSentence = sentence.split(" ");
        int found = 0;
        for(String word : wordsInSentence)
        {
            if(word.equals(wordToFind))
            {
                found++;
            }
        }
        IO.println(String.format("Total words: %d", wordsInSentence.length));
        IO.println(String.format("\"%s\" appears: %d times", wordToFind, found));
    }

    private static void circleCalculator()
    {
        double radius = Double.parseDouble(IO.readln("Enter radius: "));
        double area = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;
        IO.println(String.format("Area          : %.2f", area));
        IO.println(String.format("Circumference : %.2f", circumference));

    }

    private static void powerTable()
    {
        int base = Integer.parseInt(IO.readln("Enter base: "));
        for(int i = 1; i <= 10; i++)
        {
            double result = Math.pow(base, i);
            IO.println(String.format("%d ^ %d = %.1f", base, i, result));
        }
    }

    private static void rightTriangleChecker()
    {
        double a = Double.parseDouble(IO.readln("Enter side a: "));
        double b = Double.parseDouble(IO.readln("Enter side b: "));
        double c = Double.parseDouble(IO.readln("Enter side c: "));
        double longest = Math.max(a, Math.max(b, c));
        IO.println(String.format("Longest side: %.1f", longest));
        /*
        *For small known integer exponents, it is
        * preferable to write out the multiplication
        * rather than using Math.pow()
        *In the formula below, whichever side is longest
        * should cancel out once and leave us with Pythagoras
        *It is generally preferable to not use exact comparison with double
        * */
        if(a*a +  b*b + c*c == 2*longest*longest)
        {
            IO.println("This is a right triangle");
        }
        else
        {
            IO.println("This is NOT a right triangle");
        }
    }

    private static void numberCruncher()
    {
        int first  = Integer.parseInt(IO.readln("Enter first number : "));
        int second = Integer.parseInt(IO.readln("Enter second number: "));
        int third  = Integer.parseInt(IO.readln("Enter third number : "));
        IO.println(String.format("Maximum : %d", findMax(first, second, third)));
        IO.println(String.format("Minimum : %d", findMin(first, second, third)));
        IO.println(String.format("Average : %.2f", average(first, second, third)));
    }

    //considered using this in exercise 9 but realised
    // that this one uses int while e9 seems to want to use double
    private static int findMax(int a, int b, int c)
    {
        return Math.max(a, Math.max(b, c));
    }

    private static int findMin(int a, int b, int c)
    {
        return Math.min(a, Math.min(b, c));
    }

    private static double average(int a, int b, int c)
    {
        return (a + b + c)/3.0;
    }

    private static void diceStatistics()
    {
        int numberOfRolls = Integer.parseInt(IO.readln("How many rolls? "));
        int doubleRolls = 0;
        for(int i = 1; i <= numberOfRolls; i++)
        {
            int roll1 = 1 + (int) (6 * Math.random());
            int roll2 = 1 + (int) (6 * Math.random());
            boolean dr = roll1 == roll2;
            if(dr)
            {
                doubleRolls++;
            }
            IO.println(String.format("Roll %d: %d + %d = %d%s", i, roll1, roll2, roll1 + roll2, dr ? " Double!": ""));
        }
        IO.println(String.format("Doubles rolled: %d out of %d", doubleRolls, numberOfRolls));
    }

    private static void passwordGenerator()
    {
        int length = Integer.parseInt(IO.readln("Enter password length: "));
        final int DIGITS = 10;
        final int LETTERS = 26;
        StringBuilder pass = new StringBuilder();
        for(int i = 0; i < length; i++)
        {
            int r = (int) ((DIGITS + 2 * LETTERS) * Math.random());
            if(r < LETTERS)
            {
                pass.append((char)('a' + r));
            }
            else if(r < 2 * LETTERS)
            {
                pass.append((char)('A' + r - LETTERS));
            }
            else
            {
                pass.append((char)('0' + r - 2 * LETTERS));
            }
        }
        IO.println(String.format("Generated password: %s", pass));
    }

    private static void receiptBuilder()
    {
        String line =     "==========================\n";
        String thinLine = "--------------------------\n";

        StringBuilder receipt = new StringBuilder();
        receipt.append(line);
        receipt.append("\tReceipt\n");
        receipt.append(line);
        boolean done = false;
        double total = 0;
        while(!done)
        {
            String next = IO.readln("Enter item name (or done): ");
            if(next.equalsIgnoreCase("done"))
            {
                done = true;
            }
            else
            {
                double price = Double.parseDouble(IO.readln("Enter price: "));
                total += price;
                receipt.append(next);
                receipt.append(String.format("\t%.2f\n", price));
            }
        }
        receipt.append(thinLine);
        receipt.append(String.format("Grand Total:\t%.2f\n", total));
        receipt.append(line);
        IO.print(receipt);

    }

    private static void todaysCalender()
    {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("eeee, dd MMMM yyyy");
        IO.println("Today is: " + now.format(formatter));
        switch (now.getDayOfWeek())
        {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY ->
                    IO.println("It is a Weekday");
            case SATURDAY, SUNDAY ->
                    IO.println("It is the Weekend.");
        }
    }

}
