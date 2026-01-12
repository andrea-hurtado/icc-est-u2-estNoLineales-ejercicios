
package main.Ejercicio_02_invert;

import main.Materia.Models.Node;

public class InvertBinaryTree {


    public Node invertTree(Node root) {
        if (root == null) return null;

        Node leftInverted = invertTree(root.getLeft());
        Node rightInverted = invertTree(root.getRight());

        root.setLeft(rightInverted);
        root.setRight(leftInverted);

        return root;
    }

}

