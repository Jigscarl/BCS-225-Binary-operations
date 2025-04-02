

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data=data;
        left= null;
        right= null;
    }
}
class BinaryTree{
    Node root;
    public BinaryTree(){
        root=null;
    }
    //insert operation
    public void insert(int data){
        root = insertRut(root,data);
    }
    private Node insertRut(Node root, int data){
        if(root==null){
          root= new Node(data);
          return root;
        }
        if(data< root.data){
            root.left = insertRut(root.left,data);
                    } else if (data> root.data) {
            root.right = insertRut(root.right,data);
        }
        return root;

    }
    // search operation
    public boolean search(int data){
        return searchRut(root,data);
    }
    private boolean searchRut(Node root, int data) {
        if (root == null || root.data == data) {
            return root != null;
        }
        if (data < root.data)
            return searchRut(root.left, data);
        return searchRut(root.right, data);
    }
    //traversal operation
    // in-order traversal(left-root-right)
    public void inOrder(){
        System.out.print("In-order: ");
        inOrderRut(root);
        System.out.println();
            }
    private void inOrderRut(Node root){
        if (root !=null){
            inOrderRut(root.left);
            System.out.print(root.data + " ");
            inOrderRut(root.right);
        }
    }
    //pre-order traversal(root-left-right)
    public  void preOrder(){
        System.out.print("Pre-order : ");
        preOrderRut(root);
        System.out.println();
    }
    private void preOrderRut(Node root){
        if (root != null){
            System.out.print(root.data + " ");
            preOrderRut(root.left);
            preOrderRut(root.right);

        }
    }
    //post-order traversal(left-right-root)
    public void postOrder(){
        System.out.print("Post-order: ");
        postOrderRut(root);
        System.out.println();
    }
    private void postOrderRut(Node root){
        if (root != null){
            postOrderRut(root.left);
            postOrderRut(root.left);
            System.out.print(root.data + "");
        }
    }
    //delete operation
    public void delete(int data){
        root = deleteRut(root,data);
    }
    private Node deleteRut(Node root, int data){
        if (root == null)
            return root;
        if (data< root.data)
            root.left = deleteRut(root.left, data);
        else if (data > root.data) {
            root.right= deleteRut(root.right,data);
        }
        else {
            //Node with only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null) {
                return root.left;
            }
            //Node with two children
            root.data = minValue(root.right);
            root.right = deleteRut(root.right, root.data);
        }
        return root;
    }
    private int minValue(Node root){
        int minV = root.data;
        while (root.left != null){
            minV = root.left.data;
            root = root.left;
        }
        return minV;
    }
}
//Main class to test the binary tree operations
public class Main {
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        //insert some values
        tree.insert(35);
        tree.insert(21);
        tree.insert(87);
        tree.insert(43);
        tree.insert(78);
        tree.insert(12);
        tree.insert(5);
        tree.insert(92);
        //traversal
         tree.inOrder();
         tree.preOrder();
         tree.postOrder();

         //search
        System.out.println("Search 12: " + tree.search(12));
        //deletion
        System.out.println("\nDeleting 43...");
        tree.delete(43);
        tree.inOrder();

    }
}