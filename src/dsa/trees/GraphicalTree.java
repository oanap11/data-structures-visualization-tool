package dsa.trees;

import java.awt.Graphics;

public class GraphicalTree {
    public TreeNode root;
    
    public int getTreeDepth(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + Math.max(getTreeDepth(node.left), getTreeDepth(node.right));
	}

    public void insertElement(String value) {
        double va = Double.parseDouble(value);
        root = insertRecursive(root, va);
    }
    
    private TreeNode insertRecursive(TreeNode node, double value) {
        if (node == null) {
            return new TreeNode(value); 
        }
        
        if (value < node.value) {
            node.left = insertRecursive(node.left, value);
        } else {
            node.right = insertRecursive(node.right, value);
        }

        return node;
    }

    public boolean deleteElement(String value) {
        double parsedValue = Double.parseDouble(value);
        if (root == null) {
            return false;
        }

        root = deleteNode(root, parsedValue);
        return root != null;
    }

    private TreeNode deleteNode(TreeNode node, double value) {
        if (node == null) {
            return null; 
        }

        if (value < node.value) {
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = deleteNode(node.right, value); 
        } else {
            // Node found, handle the three possible cases for deletion
            if (node.left == null) {
                return node.right; // Case 1: Only right child or no children
            } else if (node.right == null) {
                return node.left; // Case 2: Only left child
            }

            // Case 3: Two children - replace with smallest in right subtree
            TreeNode minNode = findMin(node.right);
            node.value = minNode.value; // Copy min value to current node
            node.right = deleteNode(node.right, minNode.value); // Delete min node
        }

        return node; 
    }
    
    public void draw(TreeNode node, Graphics g, int x, int y, int prevx, int prevy, int lev, int gap) {
        if (node == null) {
            return;
        }
        g.drawOval(x, y, 30, 30);

        if (lev != 1) {
            g.drawLine(prevx + 15, prevy + 30, x + 15, y);
            gap /= 2;
        }

        g.drawString("" + node.value, x + 2, y + 17);
        draw(node.left, g, x - gap, y + 50, x, y, lev, gap);
        draw(node.right, g, x + gap, y + 50, x, y, lev, gap);
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}