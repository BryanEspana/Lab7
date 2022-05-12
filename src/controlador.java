/* 
    Hoja de Trabajo #7
    Bryan Carlos Roberto España Machorro - 21550
    Algoritmos y Estructura de Datos - Sección 10
    Catedratico: Moises Alonso
    Auxiliares:  Cristian Laynez y Rudik Rompich
*/
import java.util.Scanner;

import javax.swing.JOptionPane;

public class controlador{
    //Variables y Scanner
    int opcion;
    int elemento = 0;
    String Spanish = "";
    boolean opcion1;
    Scanner scan = new Scanner(System.in);

    public void Programa(){
        vista vista = new vista();
        arbol Arbol = new arbol();

        while(opcion1 ==false){
        vista.presentation();
            System.out.println("1. Agregar una palabra\n2. Recorrer los nodos \n3. Salir");
            opcion = scan.nextInt();
            if(opcion ==1){
                System.out.println("Ingresa el Numero del nodo");
                elemento = scan.nextInt();
                System.out.println("Ingresa el nombre del nodo...");
                Spanish = scan.next();
                Arbol.AddNodo(elemento,Spanish);
            }else if(opcion ==2){
                if(!Arbol.vacio()){
                    Arbol.inOrden(Arbol.raiz);
                }else{
                    System.out.println("El arbol binario esta vacio");
                }
            }else if(opcion ==3){
                System.exit(0);
                opcion1 =true;
            }else{
                System.out.println("ERROR: Debes ingresar un numero del 1 al 3");
                }
            }

    }
}