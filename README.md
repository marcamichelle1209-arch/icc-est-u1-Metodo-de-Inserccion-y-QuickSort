## Tabla 1. Escenario 1: arreglo completamente desordenado

| Tamaño de muestra | Tiempo Inserción | Tiempo QuickSort | Algoritmo más rápido | Observación |
|---|---|---|---|---|
| 10.000 | 946.99ms | 14.46 ms |  QuickSort| corrio mas rapido |
| 50.000 |  43116.06 ms|49.03 ms  | QuickSort | Insercion fue mas lento |
| 100.000 | 185889.43 ms | 154.45 ms | QuickSort | Sin duda Quick fue mas rapido que insercion esta vez |

## Tabla 2. Escenario 2: arreglo ordenado más una nueva persona

| Tamaño de muestra | Tiempo Inserción | Tiempo QuickSort | Algoritmo más rápido | Observación |
|---|---|---|---|---|
| 10.001 |  1.39 ms| 1295.90 |  Insercion| insercion fue mas rapido que quicksort |
| 50.001 | no hubo |no hubo  |no hay que elejir  | el flujo se detuvo durante la ejecucion |
| 100.001 |no hubo  | no hubo |  no hubo| ya no corrio   se detuvo|

## Análisis requerido

Después de completar las tablas, se debe responder:

- ¿Qué algoritmo fue más rápido en el escenario desordenado?
En el escenario desordenado sin duda fue mas rapido QuickSort

- ¿Qué algoritmo fue más rápido en el escenario casi ordenado?
En este como solo corrio con los 10.001 el mas rapido fue insercion.

- ¿El crecimiento del tamaño de muestra afectó por igual a los dos algoritmos?

Se podria decir que si afecto a los de 50.001 y al de 100.001 por que no se mostraron en la consola.
- ¿Por qué Inserción puede mejorar cuando el arreglo ya está casi ordenado?

Sucede por que Insercion compara y va desplazando los elementos hacia tras siempre y cuando si los elementos  se encuentran fuera de lugar.

- ¿Por qué QuickSort suele ser mejor cuando los datos están muy desordenados?
Por que se puede dividir al conjunto en subarreglos  de tamaños adecuados.


**Nota:** Los resultados, observaciones y análisis deben ser escritos por cada uno con base en su ejecución. No se permite presentar análisis generados por IA.

## Conclusiones

Se debe redactar al menos tres conclusiones propias. Las conclusiones deben estar relacionadas directamente con los tiempos obtenidos.

- Conclusión 1: _El Metodo de insercion mostro que cuando hay condiciones de desorden, insercion se vuelven una complejidad constante, por ende se hace mas lenta en este caso su ejecucion.________________ _______________________________
- Conclusión 2: 
Se pudo observar que en el  2 escenario insercion fue mucho mas rapido, dado al estado inicial de los datos.
_______________________________
- Conclusión 3: _Se pudo observar que al utilizar QuickSort con un pivote fijo, genero una sobrecarga de recursividad, lo que evito completar las otras mediciones.______

**Importante:** Las conclusiones no pueden ser generadas con IA. Deben reflejar su análisis a partir de los resultados reales de la práctica.