
public class Main {

    void main()
    {

        exerciseSetSelection();

    }

    private void exerciseSetSelection()
    {
        boolean running = true;
        while(running)
        {
            IO.print("Which set of exercises (enter 0 to quit): ");
            int exercise = Integer.parseInt(IO.readln().trim());
            switch (exercise)
            {
                case 0 -> running = false;
                case 1 -> Exercises1.exerciseSelection();
                case 2 -> Exercises2.exerciseSelection();
                default -> IO.println("Seems like no set of exercises of that number");
            }
        }
    }




}
