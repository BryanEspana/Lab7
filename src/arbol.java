public class arbol<V extends Comparable<V>,K>{
    nodeArbol raiz;
    public arbol(){
        raiz = null;
    }
    //Metodo para insertar nodo en el arbol binario
    public void AddNodo(int posicion, String Spsh){
        nodeArbol nuevo = new nodeArbol(posicion, Spsh);
        if(raiz == null){
            raiz = nuevo;
        }else{
            nodeArbol aux= raiz;
            nodeArbol NodoPadre;
            while(true){
                NodoPadre = aux;
                if(posicion<aux.position){
                    aux = aux.datoIzq;
                    if(aux==null){
                        NodoPadre.datoIzq = nuevo.datoIzq;
                        return;
                    }
                }else{
                    aux = aux.datoDer;
                    if(aux==null){
                        NodoPadre.datoDer = nuevo;
                        return;
                    }
                }
            }
        }
    }
    //Saber cuando esta vacio el nodo
    public boolean vacio(){
        return raiz ==null;
    }
    //recorre el arbol inOrden
    public void inOrden(nodeArbol r){
        if(r!= null){
            inOrden(r.datoIzq);
            System.out.println(r.position);
            inOrden(r.datoDer);
        }
    }
}

