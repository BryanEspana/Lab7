/*    Hoja de Trabajo #7
    Bryan Carlos Roberto España Machorro - 21550
    Algoritmos y Estructura de Datos - Sección 10
    Catedratico: Moises Alonso
    Auxiliares:  Cristian Laynez y Rudik Rompich
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class nodeArbol{
    int position;
    String Spanish;
    nodeArbol datoIzq;
    nodeArbol datoDer;
    public nodeArbol(int posicion, String Spsh) {
        this.position = posicion;
        this.Spanish = Spsh;
        this.datoIzq = null;
        this.datoDer = null;
    }
    public String toString(){
        return Spanish + "Su dato es " + position;
    }
}
