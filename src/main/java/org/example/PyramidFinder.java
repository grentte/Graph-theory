package org.example;

import java.util.*;

public class PyramidFinder {
    public static void findPyramids(TreeNode root) {
        findPyramidsHelper(root);
    }

    private static PyramidInfo findPyramidsHelper(TreeNode node) {
        if (node == null) {
            return new PyramidInfo(true, true);
        }

        PyramidInfo left = findPyramidsHelper(node.left);
        PyramidInfo right = findPyramidsHelper(node.right);

        boolean isMaxHeap = left.isMaxHeap && right.isMaxHeap;
        boolean isMinHeap = left.isMinHeap && right.isMinHeap;

        if (node.left != null) {
            if (node.val < node.left.val) {
                isMaxHeap = false;
            }
            if (node.val > node.left.val) {
                isMinHeap = false;
            }
        }

        if (node.right != null) {
            if (node.val < node.right.val) {
                isMaxHeap = false;
            }
            if (node.val > node.right.val) {
                isMinHeap = false;
            }
        }

        if (isMaxHeap) {
            System.out.println("Пирамида с корнем в " + node.val + " (макс-куча)");
        } else if (isMinHeap) {
            System.out.println("Пирамида с корнем в " + node.val + " (мин-куча)");
        }

        return new PyramidInfo(isMaxHeap, isMinHeap);
    }

    private static class PyramidInfo {
        boolean isMaxHeap;
        boolean isMinHeap;

        public PyramidInfo(boolean isMaxHeap, boolean isMinHeap) {
            this.isMaxHeap = isMaxHeap;
            this.isMinHeap = isMinHeap;
        }
    }
}
