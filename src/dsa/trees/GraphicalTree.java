package dsa.trees;

import java.awt.Graphics;

class NodeTree {
	double value;
	NodeTree leftNode, rightNode;
}

public class GraphicalTree {
    public NodeTree root;

    public GraphicalTree() {
        root = null;
    }
    
    public int getTreeDepth(NodeTree t) {
		if (t == null)
			return 0;
		return 1 + Math.max(getTreeDepth(t.leftNode), getTreeDepth(t.rightNode));
	}

    public void insertElement(String value, Graphics g) {
        double va = Double.parseDouble(value);
        root = insertRecursive(root, va);
    }
    
    private NodeTree insertRecursive(NodeTree node, double value) {
        if (node == null) {
            NodeTree newNode = new NodeTree();
            newNode.value = value;
            return newNode;
        }

        if (value < node.value) {
            node.leftNode = insertRecursive(node.leftNode, value);
        } else {
            node.rightNode = insertRecursive(node.rightNode, value);
        }

        return node;
    }

    public int deleteElement(String v, Graphics g) {
        double va = Double.parseDouble(v);
        if (root == null) {
            return -1;
        }

        return deleteRecursive(root, va) != null ? 1 : -1;
    }

    private NodeTree deleteRecursive(NodeTree node, double value) {
        if (node == null) {
            return node;
        }

        if (value < node.value) {
            node.leftNode = deleteRecursive(node.leftNode, value);
        } else if (value > node.value) {
            node.rightNode = deleteRecursive(node.rightNode, value);
        } else {
            if (node.leftNode == null) {
                return node.rightNode;
            } else if (node.rightNode == null) {
                return node.leftNode;
            }

            NodeTree r = findMin(node.rightNode);
            node.value = r.value;
            node.rightNode = deleteRecursive(node.rightNode, r.value);
        }

        return node;
    }
    
    public void draw(NodeTree t, Graphics g, int x, int y, int prevx, int prevy, int lev, int gap) {
        if (t == null) {
            return;
        }
        g.drawOval(x, y, 30, 30);

        if (lev != 1) {
            g.drawLine(prevx + 15, prevy + 30, x + 15, y);
            gap /= 2;
        }

        g.drawString("" + t.value, x + 2, y + 17);
        draw(t.leftNode, g, x - gap, y + 50, x, y, lev, gap);
        draw(t.rightNode, g, x + gap, y + 50, x, y, lev, gap);
    }

    private NodeTree findMin(NodeTree node) {
        while (node.leftNode != null) {
            node = node.leftNode;
        }
        return node;
    }
}