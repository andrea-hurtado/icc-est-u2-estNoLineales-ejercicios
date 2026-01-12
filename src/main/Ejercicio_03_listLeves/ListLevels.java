
package main.Ejercicio_03_listLeves;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.Materia.Models.Node;

public class ListLevels {
    public List<List<Node>> listLevels(Node root) {
        List<List<Node>> niveles = new ArrayList<>();
        if (root == null) return niveles;

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Node> nivel = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                nivel.add(curr);
                if (curr.getLeft() != null) q.add(curr.getLeft());
                if (curr.getRight() != null) q.add(curr.getRight());
            }
            niveles.add(nivel);
        }

        return niveles;
    }

    public List<String> levelOrderArrows(Node root) {
        List<String> lines = new ArrayList<>();
        List<List<Node>> niveles = listLevels(root);
        for (List<Node> nivel : niveles) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nivel.size(); i++) {
                if (i > 0) sb.append(" -> ");
                sb.append(nivel.get(i).getValue());
            }
            lines.add(sb.toString());
        }
        return lines;
    }
}
