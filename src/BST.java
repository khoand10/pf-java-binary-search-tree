public class BST<Object extends Comparable<Object>> extends AbstractTree<Object> {
    protected TreeNode<Object> root;
    protected int size = 0;

    public BST() {
    }

    public BST(Object[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    public boolean insert(Object e) {
        if (root == null)
            root = createNewNode(e); /*create a new root*/
        else {
            /*locate the parent node*/
            TreeNode<Object> parent = null;
            TreeNode<Object> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; /*Duplicate node not inserted*/
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true; /*element inserted successfully*/
    }

    protected TreeNode<Object> createNewNode(Object e) {
        return new TreeNode<>(e);
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<Object> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }

    @Override
    public int getSize() {
        return size;
    }

    public boolean search(Integer element) {
        TreeNode<Object> current = root;
        while (current != null) {
            if (element < (Integer) current.element) {
                current = current.left;
            } else if (element > (Integer) current.element) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }
}

class TreeNode<Object> {
    protected Object element;
    protected TreeNode<Object> left;
    protected TreeNode<Object> right;

    public TreeNode(Object e) {
        element = e;
    }
}