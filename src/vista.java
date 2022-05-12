/* 
    Hoja de Trabajo #7
    Bryan Carlos Roberto España Machorro - 21550
    Algoritmos y Estructura de Datos - Sección 10
    Catedratico: Moises Alonso
    Auxiliares:  Cristian Laynez y Rudik Rompich
*/

import java.util.Scanner;

public class vista {
    Scanner Scan = new Scanner(System.in);

    /*** 
     * This method is MAPS menu
    */
    public void presentation(){
        System.out.println("-----------Traductor UVG-------------\n"+
                           "----Bienvenido ingrese una palabra---");
    }
    public int menu(){
        System.out.println("");
        int opcion = Scan.nextInt();
        return opcion; 
    }

}
