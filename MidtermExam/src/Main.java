import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        CardStack playerDeck = new CardStack();
        CardStack discardDeck = new CardStack();
        CardStack playerHand = new CardStack();

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] cardNames = {"Fireball", "Shield", "Heal", "Lightning", "Poison", "Ice"};

        for (int i = 0; i < 30; i++)
        {
            String randomName = cardNames[random.nextInt(cardNames.length)];
            Card newCard = new Card();
            playerDeck.push(newCard);
        }
        int turn = 1;
        System.out.println("Let the game begin!");

        while (!playerDeck.isEmpty())
        {
            System.out.println("Turn " + turn);
            int command = random.nextInt(3);
            int x = random.nextInt(5) + 1;

            if (command == 0)
            {
                System.out.println("Draw " + x + " card");
                for (int i = 0; i < x; i++)
                {
                    if (!playerDeck.isEmpty())
                    {
                        Card card = playerDeck.pop();
                        playerHand.push(card);
                    }
                }
            }

            else if (command == 1)
            {
                System.out.println("Discard " + x + " card");
                for (int i = 0; i < x; i++)
                {
                    if (!playerDeck.isEmpty())
                    {
                        Card discardedCard = playerDeck.pop();
                        discardDeck.push(discardedCard);
                    }
                }
            }

            else
            {
                System.out.println("Get " + x + " card from discarded pile");
                for (int i = 0; i < x; i++)
                {
                    if (!discardDeck.isEmpty())
                    {
                        Card getCard = discardDeck.pop();
                        playerHand.push(getCard);
                    }
                }
            }
            System.out.println("\nCards currently holding " + playerHand.getSize());
            playerHand.printList();
            System.out.println("Remaining cards in player deck: " + playerDeck.getSize());
            System.out.println("Cards in discarded pile: " + discardDeck.getSize());

            if (!playerDeck.isEmpty())
            {
                System.out.print("Press enter");
                scanner.nextLine();
                turn++;
            }
        }

        System.out.println("\nGame done! Player deck is empty");
        scanner.close();
    }
}