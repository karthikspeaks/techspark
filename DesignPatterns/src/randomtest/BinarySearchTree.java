/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package randomtest;

/**
 *
 * @author kamohan2
 */
public class BinarySearchTree {

    private Node root;

    BinarySearchTree(){
        root = null;
    }

    public void insert(int data){

        root = insert(root,data);
        
    }

    public Node insert(Node n, int data){

        if(n == null)
        {
            n = new Node();
            n.setData(data);
        }
        else{

            if(data <= n.getValue() ){
                
                n.setLeft(insert(n.getLeft(),data));
            }
            else{
               n.setRight(insert(n.getRight(),data));
            }

        }
        return n;
    }

    public void inorder(Node n){

        if(n==null) return;
        
        inorder(n.getLeft());
        System.out.println(n.getValue());
        inorder(n.getRight());
    }

    public Node getRoot() {
        return root;
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(13);
        bst.insert(3);
        bst.insert(4);
        bst.insert(12);
        bst.insert(14);
        bst.insert(10);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(2);
        bst.insert(7);
        bst.insert(9);
        bst.insert(11);
        bst.insert(6);
        bst.insert(18);
        
        
        bst.inorder(bst.getRoot());

    }

}

class Node {

         Node left;
    private Node right;
    private int value;

    public void setLeft(Node l){
        left = l;
    }

    public void setRight(Node r){
        right = r;
    }

    public void setData(int data){
        value = data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }


}
