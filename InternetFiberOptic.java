import java.util.*;

// Clase para representar una arista en el grafo
class Arista implements Comparable<Arista> {
    int origen, destino, costo;

    // Constructor
    public Arista(int origen, int destino, int costo) {
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
    }

    // Método para ordenar aristas por costo (para usar en el algoritmo de Kruskal)
    @Override
    public int compareTo(Arista otra) {
        return this.costo - otra.costo;
    }
}

public class InternetFiberOptic {
    private int numMunicipios;
    private ArrayList<Arista> aristas = new ArrayList<>();

    // Constructor
    public InternetFiberOptic(int numMunicipios) {
        this.numMunicipios = numMunicipios;
    }

    // Método para agregar una arista (conexión entre dos municipios)
    public void agregarArista(int origen, int destino, int costo) {
        aristas.add(new Arista(origen, destino, costo));
    }

    // Método para encontrar el Árbol de Recubrimiento Mínimo usando el algoritmo de Kruskal
    public int kruskal() {
        // Ordenar las aristas por costo
        Collections.sort(aristas);

        // Crear una estructura para representar los subconjuntos (bosque de disjoint sets)
        int[] padre = new int[numMunicipios];
        for (int i = 0; i < numMunicipios; i++) {
            padre[i] = i;
        }

        int costoTotal = 0;
        int aristasSeleccionadas = 0;

        // Iterar sobre las aristas ya ordenadas
        for (Arista arista : aristas) {
            int origenRaiz = encontrarRaiz(padre, arista.origen);
            int destinoRaiz = encontrarRaiz(padre, arista.destino);

            // Verificar que no formen ciclos
            if (origenRaiz != destinoRaiz) {
                // Seleccionar la arista
                costoTotal += arista.costo;
                aristasSeleccionadas++;
                union(padre, origenRaiz, destinoRaiz);
            }

            // Si ya hemos seleccionado N-1 aristas, terminamos
            if (aristasSeleccionadas == numMunicipios - 1) {
                break;
            }
        }

        return costoTotal;
    }

    // Método auxiliar para encontrar la raíz de un nodo (con compresión de caminos)
    private int encontrarRaiz(int[] padre, int nodo) {
        if (padre[nodo] != nodo) {
            padre[nodo] = encontrarRaiz(padre, padre[nodo]);
        }
        return padre[nodo];
    }

    // Método auxiliar para unir dos subconjuntos (union by rank)
    private void union(int[] padre, int origenRaiz, int destinoRaiz) {
        padre[origenRaiz] = destinoRaiz;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ingresar el número de municipios
        System.out.print("Ingrese el número de municipios: ");
        int numMunicipios = scanner.nextInt();

        // Crear el objeto para manejar la red de internet de fibra óptica
        InternetFiberOptic red = new InternetFiberOptic(numMunicipios);

        // Ingresar el número de conexiones posibles
        System.out.print("Ingrese el número de conexiones posibles entre municipios: ");
        int numConexiones = scanner.nextInt();

        // Ingresar las conexiones entre municipios (origen, destino y costo)
        for (int i = 0; i < numConexiones; i++) {
            System.out.print("Ingrese el municipio origen, destino y costo de la conexión " + (i + 1) + ": ");
            int origen = scanner.nextInt();
            int destino = scanner.nextInt();
            int costo = scanner.nextInt();
            red.agregarArista(origen - 1, destino - 1, costo); // Restar 1 para que los índices empiecen en 0
        }

        // Ejecutar el algoritmo de Kruskal y mostrar el costo total mínimo
        int costoTotal = red.kruskal();
        System.out.println("El costo total mínimo para conectar todos los municipios es: " + costoTotal);
    }
}
