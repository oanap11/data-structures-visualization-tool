package dsa.trees;

import java.awt.Graphics;

class NodeTree {
	double value;
	NodeTree left, right;
}

public class GraphicalTree {
	public NodeTree root;

	public GraphicalTree() {
		root = null;
	}

	int max(int a, int b) {
		if (a <= b)
			return b;
		return a;
	}

	// adancime nod = numarul de legaturi pe care coboram de la radacina la nodul
	// respectiv
	public int depth(NodeTree t) {
		if (t == null)
			return 0;
		return 1 + max(depth(t.left), depth(t.right));
	}

	// insereaza un nod in arbore
	public void insert(String v, Graphics g) {
		double va = Double.parseDouble(v);
		// daca nu exista elemente in arbore/arborele nu are radacina
		// elementul inserat este radacina
		if (root == null) {
			root = new NodeTree();
			root.left = null;
			root.right = null;
			root.value = va;
			return;
		}

		NodeTree parent = null;
		NodeTree tmp = root;
		// daca elementul adaugat are valoarea mai mica decat radacina, este inserat la
		// stanga
		// altfel este inserat la dreapta
		while (tmp != null) {
			if (va < tmp.value) {
				parent = tmp;
				tmp = tmp.left;
			} else {
				parent = tmp;
				tmp = tmp.right;
			}
		}
		tmp = new NodeTree();
		tmp.left = null;
		tmp.right = null;
		tmp.value = va;

		if (va < parent.value) {
			parent.left = tmp;
		} else {
			parent.right = tmp;
		}
	}

	public void draw(NodeTree t, Graphics g, int x, int y, int prevx, int prevy, int lev, int gap) {
		if (t == null) {
			return;
		}
		g.drawOval(x, y, 30, 30);

		if ((++lev) != 1) {
			g.drawLine(prevx + 15, prevy + 30, x + 15, y);
			gap /= 2;
		}

		g.drawString("" + t.value, x + 2, y + 17);
		draw(t.left, g, x - gap, y + 50, x, y, lev, gap);
		draw(t.right, g, x + gap, y + 50, x, y, lev, gap);
	}

	public int delete(String v, Graphics g) {
		double va = Double.parseDouble(v);
		if (root == null) {
			return -1;
		}

		NodeTree parent = null;
		NodeTree tmp = root;
		// cat timp arborele contine elemente
		// iar elementul pe care ne dorim sa il stergem nu a fost gasit
		while (tmp != null && tmp.value != va) {
			// daca elementul cautat este mai mic decat nodul parinte
			// se continua cautarea elementului in subarborele stang
			if (va < tmp.value) {
				parent = tmp;
				tmp = tmp.left;
			}
			// daca elementul cautat este mai mare decat nodul parinte
			// se continua cautarea elementului in subarborele drept
			else {
				parent = tmp;
				tmp = tmp.right;
			}
		}

		// daca elementul cautat a fost gasit
		if (tmp.value == va) {
			// daca nodul nu are descendenti
			if (tmp.left == null && tmp.right == null) {
				// daca este radacina, aceasta se sterge
				if (tmp == root) {
					root = null;
					return 1;
				}
				// se sterge legatura cu nodul parinte
				if (va < parent.value)
					parent.left = null;
				else
					parent.right = null;

				return 1;
			}

			if (tmp.left == null) {
				if (tmp == root) {
					root = tmp.right;
					return 1;
				}
				if (va < parent.value)
					parent.left = tmp.right;
				else
					parent.right = tmp.right;
				return 1;
			}

			if (tmp.right == null) {

				if (tmp == root) {
					root = tmp.left;
					return 1;
				}
				if (va < parent.value)
					parent.left = tmp.left;
				else
					parent.right = tmp.left;
				return 1;
			}

			NodeTree rparent = null;
			NodeTree r = tmp.right;
			NodeTree rahead = r.left;
			while (rahead != null) {
				rparent = r;
				r = rahead;
				rahead = rahead.left;
			}

			tmp.value = r.value;
			if (tmp.right.left == null)
				tmp.right = r.right;
			else
				rparent.left = r.right;
			return 1;
		} else {
			return -1;
		}

	}

}
