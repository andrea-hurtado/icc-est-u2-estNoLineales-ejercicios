package main;

import utils.StudentValidator;
import main.Ejercicio_01_insert.InsertBST;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_listLeves.ListLevels;
import main.Ejercicio_04_depth.Depth;
import main.Materia.Models.Node;

import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {
        // NO MODIFICAR ESTE CÓDIGO
        var estudiante = StudentValidator.validarDatos();
        System.out.println("👤 Estudiante: " + estudiante.nombre());
        System.out.println("✉️  Correo: " + estudiante.correo());
        // NO MODIFICAR HASTA AQUÍ

        ListLevels ll = new ListLevels();
        //Ejercicio 1
        System.out.println("\n=== Ejercicio 01: Insertar en BST ===");
        InsertBST bst = new InsertBST();
        Node rootBST = null;
        int[] valores = {5, 3, 7, 2, 4, 6, 8};
        for (int v : valores) {
            rootBST = bst.insert(rootBST, v);
        }
        System.out.println("Input: [5, 3, 7, 2, 4, 6, 8]");  
        ListLevels llPrinter = new ListLevels();
        System.out.println("Output: ");
        imprimirNiveles(llPrinter.listLevels(rootBST));

        //Ejercicio 2
        System.out.println("\n=== Ejercicio 02: Invertir un Árbol Binario ===");
        Node rootInv = new Node(4);
        rootInv.setLeft(new Node(2));
        rootInv.setRight(new Node(7));
        rootInv.getLeft().setLeft(new Node(1));
        rootInv.getLeft().setRight(new Node(3));
        rootInv.getRight().setLeft(new Node(6));
        rootInv.getRight().setRight(new Node(9));
        System.out.println("Input:");
        imprimirNiveles(llPrinter.listLevels(rootInv));
        InvertBinaryTree inverter = new InvertBinaryTree();
        Node inverted = inverter.invertTree(rootInv);
        System.out.println("Output:");
        imprimirNiveles(llPrinter.listLevels(inverted));

        // Ejercicio 3
        System.out.println("\n=== Ejercicio 03: Listar Niveles en Listas Enlazadas ===");
        Node rootLevels = new Node(4);
        rootLevels.setLeft(new Node(2));
        rootLevels.setRight(new Node(7));
        rootLevels.getLeft().setLeft(new Node(1));
        rootLevels.getLeft().setRight(new Node(3));
        rootLevels.getRight().setLeft(new Node(6));
        rootLevels.getRight().setRight(new Node(9));

        List<List<Node>> niveles = llPrinter.listLevels(inverted);
        System.out.println("Input:");
        imprimirNiveles(niveles);
        System.out.println("Output:");      
        for (String linea : ll.levelOrderArrows(rootLevels)) {
            System.out.println(linea);
        }


        //Ejercicio 4
        System.out.println("\n=== Ejercicio 04: Calcular profundidad Máxima ===");
        Node rootDepth = new Node(4);
        rootDepth.setLeft(new Node(2));
        rootDepth.setRight(new Node(7));
        rootDepth.getLeft().setLeft(new Node(1));
        rootDepth.getLeft().setRight(new Node(3));
        rootDepth.getLeft().getLeft().setLeft(new Node(8));

        System.out.println("Input: ");
        imprimirNiveles(ll.listLevels(rootDepth));
        Depth depthCalc = new Depth();
        int maxDepth = depthCalc.maxDepth(rootDepth);
        System.out.println("Output: " + maxDepth);

    }

    private static void imprimirNiveles(List<List<Node>> niveles) {
        for (List<Node> nivel : niveles) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nivel.size(); i++) {
                if (i > 0) sb.append(" ");
                sb.append(nivel.get(i).getValue());
            }
            System.out.println(sb.toString());
        }
    }


}
