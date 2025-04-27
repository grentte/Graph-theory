package org.example;

import java.io.*;
import java.util.*;


public class BinaryTree {
    public TreeNode root;

    public void buildFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите элементы дерева в порядке уровней (null для отсутствующих узлов): ");
        root = buildTree(scanner.nextLine());
    }

    public void buildFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            root = buildTree(line);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    private TreeNode buildTree(String data) {
        if (data == null || data.isEmpty())
            return null;
        String[] values = data.split("\\s+");
        if (values.length == 0)
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();
            if (current != null) {
                if (!values[i].equalsIgnoreCase("null")) {
                    current.left = new TreeNode(Integer.parseInt(values[i]));
                    queue.add(current.left);
                }
                i++;
                if (i < values.length && !values[i].equalsIgnoreCase("null")) {
                    current.right = new TreeNode(Integer.parseInt(values[i]));
                    queue.add(current.right);
                }
                i++;
            }
        }
        return root;
    }

    public void printTree(TreeNode root) {
        printTree(root, "", true);
    }

    private void printTree(TreeNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.val);
            printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }
}
