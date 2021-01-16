public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(100);
        bst.insert(10);
        bst.insert(150);
        bst.insert(20);
        bst.insert(5);
        bst.insert(130);
        bst.insert(120);
        System.out.println(bst);
    }
}
