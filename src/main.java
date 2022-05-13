/* 
.______   .______    ____    ____      ___      .__   __.      _______     
|   _  \  |   _  \   \   \  /   /     /   \     |  \ |  |     |   ____|    
|  |_)  | |  |_)  |   \   \/   /     /  ^  \    |   \|  |     |  |__       
|   _  <  |      /     \_    _/     /  /_\  \   |  . `  |     |   __|      
|  |_)  | |  |\  \-.     |  |      /  _____  \  |  |\   |     |  |____  __ 
|______/  | _| `.__|     |__|     /__/     \__\ |__| \__|     |_______|(__)
                                                            
    Hoja de Trabajo #7
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

public class main{
    public static void main(String[] args) {
        arbol English = new arbol();
        arbol French = new arbol();
        boolean translate = false;
        int mode = -1;
        //lee el archivo
        try {
            Scanner scanner = new Scanner(System.in);
            String directory = "palabras.txt";
            BufferedReader reader = new BufferedReader(new FileReader(directory));
            String line;
            //Add Dictionary
            while ((line = reader.readLine()) != null){
                line = line.replace(",", " ");
                String[] parts = line.split("\\s");
                English.colocar(parts[0].strip().toLowerCase(), parts[1].toLowerCase());
                French.colocar(parts[2].strip().toLowerCase(), parts[1].toLowerCase());
            }
            translate = true;
        }catch (Exception e) {
            System.out.println("ERROR: Cerrando programa");
            System.exit(1);
        }
        
        if(translate){
        Scanner op = new Scanner(System.in);
        while (true) {
            System.out.println("-----------Traductor UVG-------------\n"+
            "----Bienvenido ingrese una palabra---\n"+
            "1. Traducir una palabra\n"+
            "2. Traducir archivo: palabras2.txt\n"+
            "3. Editar Translade\n"+
            "4. Borrar una palabra\n"+
            "5. Ver palabras\n"+
            "6. Salir del programa\n");
            try {
                switch(op.nextInt()){
                    case 1 ->{
                        System.out.println("ingrese palabra");
                        Scanner scanner = new Scanner(System.in);
                        String word = scanner.nextLine();
                        if(English.compara(word.toLowerCase())){
                            System.out.println(English.getValue(word.toLowerCase()));
                        }
                        if(French.compara(word.toLowerCase())){
                            System.out.println(French.getValue(word.toLowerCase()));
                        }
                        
                        
                    }
                    case 2 ->{
                        Scanner scanner = new Scanner(System.in);
                        try{
                            String directory = "palabras2.txt";
                            BufferedReader reader = new BufferedReader(new FileReader(directory));
                            String line;
                            ArrayList<String> notfoundTokens = new ArrayList<String>();//ArrayList con las palabras no encontradas en los diccionarios
                            while ((line = reader.readLine()) != null){
                                line = removePunctuations(line);
                                String[] tokens = line.split(" ");
                                ArrayList<String> tokensList = new ArrayList<String>();//ArrayList con los resultados de traduccion
                                for(String word: tokens){
                                    if(English.compara(word.toLowerCase())){
                                        mode = 0;
                                    }
                                    if(French.compara(word.toLowerCase())){
                                        mode = 1;
                                    }
                                }
                                switch(mode){
                                    case 0 -> {
                                        for(String word: tokens){
                                            if(English.compara(word.toLowerCase())){
                                                tokensList.add((String) English.getValue(word.toLowerCase()));
                                            }else{
                                                notfoundTokens.add(word);
                                                tokensList.add("'" + word + "'");
                                            }
                                        }
                                        String transaltion = "";
                                        for(String word : tokensList){
                                            transaltion = transaltion + " " + word;
                                        }
                                        System.out.println(transaltion);
                                    }
                                    case 1 -> {
                                        for(String word: tokens){
                                            if(French.compara(word.toLowerCase())){
                                                tokensList.add((String) French.getValue(word.toLowerCase()));
                                            }else{
                                                notfoundTokens.add(word);
                                                tokensList.add("'" + word + "'");
                                            }
                                        }
                                        String transaltion = "";
                                        for(String word : tokensList){
                                            transaltion = transaltion + " " + word;
                                        }
                                        System.out.println(transaltion);

                                    }
                                    case -1 ->{
                                        System.out.println("no se reconoce el idioma");
                                        break;
                                    }
                                }
                            }
                            for(String newword : notfoundTokens){
                                System.out.println("agregar significado para " + newword);
                                String meaning =  scanner.nextLine();
                                switch(mode){
                                    case 0->{
                                        English.colocar(newword.toLowerCase(), meaning.toLowerCase());
                                    }
                                    case 1->{
                                        French.colocar(newword.toLowerCase(), meaning.toLowerCase());
                                    }
                                }
                            }
                        }
                        catch(FileNotFoundException e){
                            System.out.println("Archivo no encontrado");
                            scanner.next();
                        }
                        catch (Exception e){
                            System.out.println("ERROR: Cerrando programa");
                            scanner.next();
                        }
                        
                    }
                    case 3 ->{
                        System.out.println("seleccione el idioma a editar");
                        System.out.println("1. English");
                        System.out.println("2. Français");
                        try { 
                            Scanner scanner = new Scanner(System.in);
                            System.out.println("ingrese palabra");
                            String word = scanner.nextLine();
                            switch(op.nextInt()){
                                
                                case 1 ->{
                                    
                                    if(English.compara(word.toLowerCase())){
                                        System.out.println("ingrese nuevo significado");
                                        String newmeanings = scanner.nextLine();
                                        English.delete(word.toLowerCase());
                                        English.colocar(word.toLowerCase(), newmeanings.toLowerCase());
                                        
                                    }else{
                                        System.out.println("word not found");
                                    }
                                }
                                case 2 ->{
                                    
                                    if(French.compara(word.toLowerCase())){
                                        System.out.println("ingrese nuevo significado");
                                        String newmeanings = scanner.nextLine();
                                        French.delete(word.toLowerCase());
                                        French.colocar(word.toLowerCase(), newmeanings.toLowerCase());
                                    }else{
                                        System.out.println("word not found");
                                    }
                                }
                            }

                        }catch(InputMismatchException ie){
                            System.out.println("entrada invalida");
                            op.next();
                        }
                    }
                    case 4->{
                        System.out.println("ingrese la palabra a borrar");
                        Scanner scanner = new Scanner(System.in);
                        String word = scanner.nextLine();
                            if(English.compara(word.toLowerCase())){
                                English.delete(word.toLowerCase());
                                System.out.println("deleted");
                            }else if(French.compara(word.toLowerCase())){
                                French.delete(word.toLowerCase());
                                System.out.println("deleted");
                            }else{
                                System.out.println("word not found");
                            }
                    }
                    case 5->{
                        System.out.println("Diccionario en Ingles");
                        English.print();
                        System.out.println("\n Diccionario en Frances");
                        French.print();
                        System.out.println(); 
                    }
                    case 6->{
                        System.exit(0);
                    }
                }
            } catch (InputMismatchException e){
                System.out.println("Error: Vuelve a intentar con otro caracter");
                op.next();
            }
            
            
        }
    } 
}
public static String removePunctuations(String source) {
    return source.replaceAll("\\p{Punct}", "");
}
}
