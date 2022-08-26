package dsa.trees;

import java.awt.Graphics;

import javax.swing.JComponent;

public class TreeComponent extends JComponent {
	String val;
    char flag;
    GraphicalTree tree;

   public synchronized void setValues(GraphicalTree gt, char f, String v) {
      this.tree = gt;
      flag = f;
      val = v;
      repaint();
   }


   @Override
public synchronized void paintComponent(Graphics g) {
       int f = 0,gap = 0;
       switch(flag) {
           case 'i':
                    tree.insert(val,g);
                    gap = tree.depth(tree.root);
                    gap = gap * gap * 10;
                    tree.draw(tree.root, g ,getWidth() / 2, 50,getWidth() / 2, 50,0,gap);
                    f = 1;
                    break;
           case 'd':
                    if(tree.delete(val,g) == 1)
                    {
                        gap = tree.depth(tree.root);
                        gap = gap * gap * 10;
                        tree.draw(tree.root, g ,getWidth() / 2, 50,getWidth() / 2, 50,0,gap);
                    }
                    f = 1;
                    break;

       }
       if(tree != null){
            gap = tree.depth(tree.root);
            gap = gap * gap * 10;
             tree.draw(tree.root, g ,getWidth() / 2, 50,getWidth() / 2, 50,0, gap) ;
       }
       flag = 'k';


   }

}