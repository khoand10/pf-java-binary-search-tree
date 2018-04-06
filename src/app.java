public class app {
    public static void main(String[] args) {
        //create a BST
        BST<Integer> tree = new BST<>();
//        tree.insert("George");
//        tree.insert("Michael");
//        tree.insert("Tom");
//        tree.insert("Adam");
//        tree.insert("Jones");
//        tree.insert("Peter");
//        tree.insert("Daniel");
        tree.insert(6);
        tree.insert(4);
        tree.insert(9);
        System.out.println(tree.search(9));
    }
}
