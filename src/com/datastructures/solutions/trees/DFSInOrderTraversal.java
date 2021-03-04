package com.datastructures.solutions.trees;

import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class DFSInOrderTraversal {

    //print the tree horizontally given the root node
    public void printTree(TreeNode root, int level){
        //System.out.println("Entered print function"+level);
        if (root == null)
            return;

        printTree(root.right, level+1);
        for(int i= 0; i<level;i++)
        {
            System.out.print("    ");
        }
        System.out.println(root.val);

        printTree(root.left, level+1);

    }

    public void printRecursiveInorder(TreeNode root)
    {
        if(root != null)
        {
            printRecursiveInorder(root.left);
            System.out.print(" "+root.val);
            printRecursiveInorder(root.right);

        }
    }

    public void printIterativeInorder(TreeNode root)
    {
        TreeNode current = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || current != null)
        {
            if(current != null)
            {
                stack.addLast(current);
                current = current.left;
            }
            else{
                current =  stack.pollLast();
                System.out.print(current.val + " ");
                current = current.right;
            }

        }
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode node11 = new TreeNode(11, null, null);
        TreeNode node19 = new TreeNode(19, null, null);
        TreeNode node5 = new TreeNode(5, node1, node9);
        TreeNode node15 = new TreeNode(15, node11, node19);
        TreeNode node10 = new TreeNode(10, node5, node15);

        DFSInOrderTraversal inorder = new DFSInOrderTraversal();
        inorder.printTree(node10, 0);

        System.out.println("Inorder recursive traversal for the tree is ");
        inorder.printRecursiveInorder(node10);

        System.out.println("\nInorder iterative traversal for the tree is ");
        inorder.printIterativeInorder(node10);
    }
}
