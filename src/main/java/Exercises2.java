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
            IO.print("Enter the number of the exercise you want to run (enter 0 to quit): ");
            int exercise = Integer.parseInt(IO.readln().trim());
            switch (exercise)
            {
                case 0 -> running = false;
                case 1 -> wordReverser();
                case 2 -> emailSlicer();
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
}
