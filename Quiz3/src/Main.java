import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        ArrayQueue queue = new ArrayQueue(5);
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int gamesMade = 0;
        int nextPlayerId = 1;
        int turn = 1;

        System.out.println("Game start");

        while (gamesMade < 10)
        {
            System.out.print("Enter your ID: ");
            int playersJoining = random.nextInt(7) + 1;
            System.out.println(playersJoining + " players joined queue: ");

            for (int i = 0; i < playersJoining; i++)
            {
                int randomLevel = random.nextInt(100) + 1;
                Player newPlayer = new Player(nextPlayerId, "Player" + nextPlayerId, randomLevel);
                queue.add(newPlayer);
                nextPlayerId++;
            }

            System.out.println("\nCurrent queue " + queue.size() + " players:");
            queue.printQueue();

            while (queue.size() >= 5 && gamesMade < 10)
            {
                gamesMade++;
                System.out.println("Games made!" + gamesMade);
                System.out.println("Players in this match:");

                for (int i = 0; i < 5; i++)
                {
                    Player matchedPlayer = queue.remove();
                    System.out.println(" Look at this " + matchedPlayer);
                }
            }

            if (gamesMade < 10)
            {
                System.out.print("Press enter");
                scanner.nextLine();
                turn++;
            }
        }

        System.out.println("Games done");
        scanner.close();
    }
}