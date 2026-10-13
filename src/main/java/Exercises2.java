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
        StringBuilder initials = new StringBuilder();
        int index = -1;
        boolean done = false;
        while(!done)
        {
            initials.append(fullName.charAt(index + 1)).append(".");
            index = fullName.indexOf(' ', index+1);
            if(index == -1)
            {
                done = true;
            }
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

}
