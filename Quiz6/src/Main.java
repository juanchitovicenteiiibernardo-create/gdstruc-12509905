public class Main
{
    public static void main(String[] args)
    {
        Tree tree = new Tree();

        tree.insert(25);
        tree.insert(17);
        tree.insert(29);
        tree.insert(10);
        tree.insert(16);
        tree.insert(-5);
        tree.insert(60);
        tree.insert(55);

        System.out.println(tree.get(25));
        System.out.println("\nDescending Order:");
        tree.descendingTraverseInOrder();

        System.out.println("\nMin Node: " + tree.getMin());
        System.out.println("\nMax Node: " + tree.getMax());
    }
}