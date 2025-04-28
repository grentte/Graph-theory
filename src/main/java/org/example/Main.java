package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        Scanner console = new Scanner(System.in);

        System.out.println("Выберите вариант выполнения программы:\n1. Из консоли\n2. Из файла");
        int choice = console.nextInt();
        console.nextLine();

        switch (choice) {
            case 1:
                tree.buildFromConsole();
                break;
            case 2:
                System.out.println("Введите название файла: ");
                String filename = console.nextLine();
                tree.buildFromFile(filename);
                break;
            default:
                System.out.println("Некорректный выбор");
                return;
        }

        System.out.println("\nВывод дерева: ");
        tree.printTree(tree.root);

        System.out.println("\nПоиск всех поддеревьев-пирамид: ");
        PyramidFinder.findPyramids(tree.root);

    }
}
