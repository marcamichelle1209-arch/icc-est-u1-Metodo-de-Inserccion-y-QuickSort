import java.util.concurrent.Callable;



import controllers.SortPersonaMethods;
import models.Persona;
import models.Resultado;
import utils.Benchmarking;

public class App {
    public static void main(String[] args) throws Exception {
        SortPersonaMethods metodos = new SortPersonaMethods();

        System.out.println("=== Escenario 1 ===");
        ejecutarEscenarioDesordenado(10000,metodos);
        ejecutarEscenarioDesordenado(50000,metodos);
        ejecutarEscenarioDesordenado(100000,metodos);

        System.out.println("=== Escenario 2  + 1 persona ===");
        ejecutarEscenarioCasiOrdenado(10000,metodos);
        ejecutarEscenarioCasiOrdenado(50000,metodos);
        ejecutarEscenarioCasiOrdenado(100000,metodos);
    }
    public static Persona[] generarPersonas(int cantidad){
            
        Persona[] personas = new Persona[cantidad];
        for (int i =0; i< cantidad; i++){
            String nombre = "Persona" + (i+1);
            int edad = (int) (Math.random()*101);
            personas[i]= new Persona(nombre,edad);
        }
        return personas;

    }
  
    public static void ejecutarEscenarioDesordenado(int size, SortPersonaMethods metodos){
        Persona[] base =generarPersonas(size);
        Persona[] copiaInsercion =base.clone();
        Persona[] copiarQuickSort = base.clone();

        Callable<Void> insertion =() -> {
            metodos.insertionSort(copiaInsercion);
            return null;
        };
        Callable<Void> quick = () -> {
            metodos.quickSort(copiarQuickSort,0,copiarQuickSort.length-1);
            return null;
        };
        Resultado r1 = Benchmarking.medirTiempo(insertion,"Insercion","Desordenamiento",size);
        Resultado r2 = Benchmarking.medirTiempo(quick,"QuickSort","Desordenamiento",size);
        
        imprimirResultado(r1);
        imprimirResultado(r2);

    }
    public static void ejecutarEscenarioCasiOrdenado(int size,SortPersonaMethods metodos){
        Persona[] base = generarPersonas(size);
        metodos.quickSort(base,0, base.length-1);

        Persona[] casiOrdenado = new Persona[size+1];
        System.arraycopy(base, 0, casiOrdenado, 0, size);

        casiOrdenado[size] = new Persona("Persona Nueva", (int) (Math.random()*101));

        Persona[] copiarInsercion = casiOrdenado.clone();
        Persona[] copiarQuickSort = casiOrdenado.clone();

        int nuevoSize = size+1;
        Callable<Void> insertion = ()->{
            metodos.insertionSort(copiarInsercion);
            return null;
        };

        Callable<Void> quick = () ->{
            metodos.quickSort(copiarQuickSort, 0, copiarQuickSort.length-1);
            return null;
        };
        Resultado r1 = Benchmarking.medirTiempo(insertion, "Insercion","casi ordenado + 1 persona", nuevoSize);
        Resultado r2 = Benchmarking.medirTiempo(quick, "QuickSort","casi odenado + 1 persona",  nuevoSize);

        imprimirResultado(r1);
        imprimirResultado(r2);
    }
    public static void imprimirResultado(Resultado r){
        System.out.printf("%s|%s| %d| %.2f ms\n",r.getEscenario(),
        r.getAlgoritmo(),r.getSample(),r.getTiempoMillis());
    }

    
}
