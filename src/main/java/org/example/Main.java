package org.example;

//TIP Программа для поиска пирамид среди поддеревьев бинарного дерева

public class Main {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.buildFromConsole();
        tree.printTree(tree.root);
    }
}
