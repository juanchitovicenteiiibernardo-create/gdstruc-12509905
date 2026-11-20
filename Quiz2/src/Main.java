import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Player asuna = (new Player(1, "Asuna", 100));
        Player lethalBacon = (new Player(2, "LethalBacon", 205));
        Player hpDeskJet =  (new Player(3, "HPDeskJet", 34));

        PlayerLinkedList playerLinkedList = new PlayerLinkedList();

        playerLinkedList.addToFront(asuna);
        playerLinkedList.addToFront(lethalBacon);
        playerLinkedList.addToFront(hpDeskJet);

        playerLinkedList.printList();
        System.out.println("Size: "  + playerLinkedList.getSize()); 
    }
}