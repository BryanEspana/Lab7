/*    Hoja de Trabajo #7
    Bryan Carlos Roberto España Machorro - 21550
    Algoritmos y Estructura de Datos - Sección 10
    Catedratico: Moises Alonso
    Auxiliares:  Cristian Laynez y Rudik Rompich
*/

public class asignation<V,K>{
    public V llave;
    public K valor;
    public asignation(V key, K value){
        llave = key;
        valor = value;
    }
    //Setters
    public void setLlave(V key){
        this.llave = llave;
    }
    public void setValor(K value){
        this.valor = valor;
    }
    //Getters
    public V getLlave(){
        return llave;
    }
    public K getValor(){
        return valor;
    }

    
}
