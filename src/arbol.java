/*    Hoja de Trabajo #7
    Bryan Carlos Roberto España Machorro - 21550
    Algoritmos y Estructura de Datos - Sección 10
    Catedratico: Moises Alonso
    Auxiliares:  Cristian Laynez y Rudik Rompich
*/


public class arbol<V extends Comparable<V>,K>{
    private class Node extends asignation<V,K>{
        Node izq, derch;
        public Node(V value , K transaltion) {
            super(value, transaltion);
        }
    }
    private Node root;
    private int size;
    
    public int getSize() {
        return size;
    }
    public arbol() {
        this.root = null;
        this.size = 0;
    }
    public boolean isEmpty() {
        if (root == null) return true;
        else return false;
    }
    public void colocar(V value , K transaltion) {
        size++;
        if (isEmpty()) root = new Node(value, transaltion);
        else colocar(root, value, transaltion);
    }
    public boolean compara(V value) {
        return compara(root, value);
    }
    public void print() {
        print(root);
    }
    public K getValue(V llave) {
        return getValue(root, llave);

    }
    public void delete(V value) {
        root = deleteRecursive(root,value);
    }
    private Node deleteRecursive(Node node, V value) {
        if (node == null){
            return null; }
        if(value.compareTo(node.llave) == 0){
            //No tendria nada
            if (node.izq == null && node.derch == null) {
                return null;
            }
            //1 hijo ( si es igual a null regresa el nodo)
            if (node.derch == null) {
                return node.izq;
            }
            if (node.izq == null) {
                return node.derch;
            }
            // 2 hijos
            Node smallestValue = findSmallestValue(node.derch);
            node.llave = smallestValue.llave;
            node.valor = smallestValue.valor;
            node.derch = deleteRecursive(node.derch, smallestValue.llave);
            return node;
        }if(value.compareTo(node.llave) < 0){
            node.izq = deleteRecursive(node.izq, value);
            return node;
        }
        node.derch = deleteRecursive(node.derch, value);
        return node;
    }
    private Node findSmallestValue(Node node) {
        return node.izq == null? node : findSmallestValue(node.izq);
    }
    private K getValue(Node node, V llave) {
        if (llave.compareTo(node.llave) == 0) {
            return node.valor;
        } else if (llave.compareTo(node.llave) < 0) {
            if (node.izq == null) return null;
            else return getValue(node.izq, llave);
        } else {
            if (node.derch == null) return null;
            else return getValue(node.derch, llave);
        }
    }
    //Compara los nodos
    private boolean compara(Node node, V value) {
        if (value.compareTo(node.llave) == 0) {
            return true;
        } else if (value.compareTo(node.llave) < 0) {
            if (node.izq == null) return false;
            else return compara(node.izq, value);
        } else {
            if (node.derch == null) return false;
            else return compara(node.derch, value);
        }
    }
    //Imprime los nodos
    private void print(Node node) {
        if (root == null) return;
        if (node.izq != null) print(node.izq);
        System.out.println(node.llave + ": " + node.valor);
        if (node.derch != null) print(node.derch);
    }
    //coloca los nodos
    private void colocar(Node node, V value, K transaltion) {
        if(value.compareTo(node.llave) <= 0) {
            if(node.izq == null) node.izq = new Node(value, transaltion);
            else colocar(node.izq, value, transaltion);
        } else {
            if(node.derch == null) node.derch = new Node(value, transaltion);
            else colocar(node.derch, value , transaltion);
        }
    }
}

