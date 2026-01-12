
package main.Ejercicio_01_insert;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import main.Materia.Models.Node;

public class InsertBST {
    public Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.getValue()) {
            root.setLeft(insert(root.getLeft(), value));
        } else if (value > root.getValue()) {
            root.setRight(insert(root.getRight(), value));
        }
        return root;
    }

    public Node buildBST(int[] values) {
        Node root = null;
        if (values == null) return null;
        for (int v : values) {
            root = insert(root, v);
        }
        return root;
    }

    public List<String> levelOrderLines(Node root) {
        List<String> lines = new ArrayList<>();
        if (root == null) return lines;

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            StringBuilder level = new StringBuilder();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (level.length() > 0) level.append(" ");
                level.append(node.getValue());
                if (node.getLeft() != null) q.add(node.getLeft());
                if (node.getRight() != null) q.add(node.getRight());
            }
            lines.add(level.toString());
        }
        return lines;
    }
}
