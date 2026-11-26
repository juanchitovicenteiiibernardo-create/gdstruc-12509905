public class CardNode
{
    private Card card;
    private CardNode next;

    public CardNode(Card card)
    {
        this.card = card;
    }

    public Card getCard()
    {
        return card;
    }

    public void setCard(Card card)
    {
        this.card = card;
    }

    public CardNode getNextCard()
    {
        return next;
    }

    public void setNextCard(CardNode nextCard)
    {
        this.next = nextCard;
    }

    @Override
    public String toString()
    {
        return card.toString();
    }
}