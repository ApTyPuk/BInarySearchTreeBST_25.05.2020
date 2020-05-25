package com.Artur;

public class BinaryTree_A {
    Node root;

    public void addNode(int key, String name){
        Node newNode = new Node(key, name);
        if(root == null){       //if no root
            root = newNode;     //setting up the new root
        }else{
            Node focusNode = root;      //since we have a root, setting focus as root
            Node parent;    //future parent for a node.
            while(true){
                parent = focusNode;     //setting parent class as focus node
                if(key < focusNode.key){    //if key is less than focusNode.key
                    focusNode = focusNode.leftChild;    //changing focus on the left branch of a parent
                    if(focusNode == null){      //if focus node have no children, placing new node on a left of it.
                        parent.leftChild = newNode;     //setting up newNode on a left branch
                        return;
                    }
                }else{       //if key is greater than focusNode.key
                    focusNode = focusNode.rightChild;
                    if(focusNode == null){      //if focus node have no children, placing new node on a right of it.
                        parent.rightChild = newNode;     //setting up newNode on a right branch
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverseTree(Node focusNode){
        if(focusNode != null){
            inOrderTraverseTree(focusNode.leftChild);   //first will be left branch with increasing values.
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);   //second will be right branch with increasing values.

        }
    }

    public void preOrderTraverseTree(Node focusNode){
        if(focusNode != null){
            System.out.println(focusNode);
            preOrderTraverseTree(focusNode.leftChild);
            preOrderTraverseTree(focusNode.rightChild);

        }
    }

    public void postOrderTraverseTree(Node focusNode){
        if(focusNode != null){
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);


        }
    }

    public Node findNode(int key){
        Node focusNode = root;
        while(focusNode.key != key){    //searching untill
            if(key< focusNode.key){
                focusNode = focusNode.leftChild;
            }else{
                focusNode = focusNode.rightChild;
            }

            if(focusNode == null){
                return null;
            }
        }
        return focusNode;
    }



    public static void main(String[] args) {
        BinaryTree_A theTree = new BinaryTree_A();
        theTree.addNode(50,"Boss");
        theTree.addNode(25,"Vise Pres");
        theTree.addNode(15,"Office Manager");
        theTree.addNode(30,"Secretary");
        theTree.addNode(75,"Sales Manager");
        theTree.addNode(85,"Salesman 1");

        theTree.inOrderTraverseTree(theTree.root);
        System.out.println("========================================");
        theTree.preOrderTraverseTree(theTree.root);
        System.out.println("========================================");
        theTree.postOrderTraverseTree(theTree.root);
        System.out.println("========================================");

        System.out.println("Search for 30");
        System.out.println(theTree.findNode(30));

    }


}

class Node {
    int key;
    String name;

    Node leftChild;
    Node rightChild;

    public Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " has the key " + key;
    }
}
