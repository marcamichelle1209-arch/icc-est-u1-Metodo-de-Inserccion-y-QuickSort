import java.util.concurrent.Callable;

import controllers.SortPersonaMethods;
import models.Persona;
import models.Resultado;
import utils.Benchmarking;

public class App {
    public static void main(String[] args) throws Exception {
        SortPersonaMethods metodos = new SortPersonaMethods();
         System.out.println("La salida");
        ejecutarEscenarioDesordenado(10000,metodos);
        ejecutarEscenarioDesordenado(50000,metodos);
        ejecutarEscenarioDesordenado(100000,metodos);
        System.out.println("La salida");
        public static Persona[] generarPersonas(int cantidad){
            System.out.println("Hello, World!");
            Persona[] personas = new Persona[cantidad];
            for (int i =0; i< cantidad; i++){
                String nombre = "Persona" + (i+1);
                int edad = (int) (Math.random()*101);
                personas[i]= new Persona(nombre,edad);
            }
            return personas;

            }
  
    public static void ejecutarEscenarioDesordenado(int size, SortPersonaMethods){
        Persona[] base =generarPersonas(size);
        Persona[] copiaInsercion =base.clone();
        Persona[] copiarQuickSort = base.clone();

        Callable<Void> insertion =(){
            metodos.insertionSort(copiarInsercion);
            return null;
        }
        Callable<Void> quick = () {
            metodos.quickSort(copiarQuickSort,0,copiarQuickSort.length-1);
            return null;
        }
        Resultado r1 = Benchmarking.medirTiempo(insertion,"Insercion","Desordenamiento");
        Resultado r2 = Benchmarking.medirTiempo(quick,"QuickSort","Desordenamiento");
        
        imprimirResultado(r1);
        imprimirResultado(r2);

    }
    
}
