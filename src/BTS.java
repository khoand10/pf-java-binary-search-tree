public class BTS<T extends Comparable<T>> extends AbstractTree<T> {
    protected TreeNode<T> root;
    protected int size = 0;

    public BTS() {

    }

    public BTS(T[] obj) {
        for (int i = 0; i < obj.length; i++)
            insert(obj[i]);
    }

    @Override
    public boolean insert(T t) {
        if (root == null)
            root = createNode(t); /*create a new root*/
        else {
            /*locate the parent node*/
            TreeNode<T> parent = null;
            TreeNode<T> current = root;
            while (current != null) {
                if (t.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (t.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; /*Duplicate node not inserted*/
            }
            if (t.compareTo(parent.element) < 0)
                parent.left = createNode(t);
            else
                parent.right = createNode(t);
        }
        size++;
        return true; /*element inserted successfully*/
    }

    @Override
    public int getSize() {
        return size;
    }

    public TreeNode<T> createNode(T t) {
        return new TreeNode<>(t);
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<T> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }
}
