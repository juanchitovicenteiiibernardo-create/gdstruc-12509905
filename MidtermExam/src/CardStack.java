public class CardStack
{
    private CardNode head;
    private int size;

    public void push(Card card)
    {
        CardNode cardNode = new CardNode(card);
        cardNode.setNextCard(head);
        head = cardNode;
        size++;
    }

    public Card pop()
    {
        if (isEmpty())
        {
            return null;
        }
        CardNode removedNode = head;
        head = head.getNextCard();
        removedNode.setNextCard(null);
        size--;
        return removedNode.getCard();
    }

    public Card peek()
    {
        if (isEmpty())
        {
            return null;
        }
        return head.getCard();
    }

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public boolean contains(Card card)
    {
        return indexOf(card) != -1;
    }

    public int indexOf(Card card)
    {
        CardNode current = head;
        int index = 0;
        while (current != null)
        {
            if (current.getCard().equals(card))
            {
                return index;
            }
            current = current.getNextCard();
            index++;
        }
        return -1;
    }

    public void printList()
    {
        CardNode current = head;
        System.out.print("Head ");
        while (current != null)
        {
            System.out.print(current);
            current = current.getNextCard();
        }
        System.out.println("null");
    }
}