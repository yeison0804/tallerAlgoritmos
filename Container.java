import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Objeto {
    double peso;
    double valor;

    // Constructor
    public Objeto(double peso, double valor) {
        this.peso = peso;
        this.valor = valor;
    }

    // Obtener el valor por unidad de peso
    public double valorPorPeso() {
        return valor / peso;
    }
}

public class Container {
    private double pesoMaximo;
    private ArrayList<Objeto> objetos = new ArrayList<>();
    private ArrayList<Objeto> seleccionados = new ArrayList<>();

    public Container(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    // Método para agregar objetos
    public void agregarObjeto(double peso, double valor) {
        objetos.add(new Objeto(peso, valor));
    }

    // Método para llenar el container usando el algoritmo devorador
    public double llenarContainer() {
        // Ordenar los objetos por valor por peso en orden descendente
        Collections.sort(objetos, new Comparator<Objeto>() {
            @Override
            public int compare(Objeto o1, Objeto o2) {
                return Double.compare(o2.valorPorPeso(), o1.valorPorPeso());
            }
        });

        double pesoActual = 0;
        double valorTotal = 0;

        for (Objeto objeto : objetos) {
            if (pesoActual + objeto.peso <= pesoMaximo) {
                // Si el objeto cabe completamente en el container
                seleccionados.add(objeto);
                pesoActual += objeto.peso;
                valorTotal += objeto.valor;
            } else {
                // Si el objeto no cabe completamente, tomar una fracción
                double pesoRestante = pesoMaximo - pesoActual;
                double fraccion = pesoRestante / objeto.peso;
                seleccionados.add(new Objeto(pesoRestante, objeto.valor * fraccion));
                pesoActual = pesoMaximo;
                valorTotal += objeto.valor * fraccion;
                break; // El container está lleno
            }
        }

        return valorTotal;
    }

    // Mostrar los objetos seleccionados
    public void mostrarObjetosSeleccionados() {
        System.out.println("Objetos seleccionados:");
        for (Objeto obj : seleccionados) {
            System.out.println("Peso: " + obj.peso + ", Valor: " + obj.valor);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir el peso máximo del container
        System.out.print("Ingrese el peso máximo del container: ");
        double pesoMaximo = scanner.nextDouble();

        // Crear el container
        Container container = new Container(pesoMaximo);

        // Pedir la cantidad de objetos a agregar
        System.out.print("Ingrese la cantidad de objetos a agregar: ");
        int cantidadObjetos = scanner.nextInt();

        // Agregar los objetos
        for (int i = 0; i < cantidadObjetos; i++) {
            System.out.print("Ingrese el peso del objeto " + (i + 1) + ": ");
            double peso = scanner.nextDouble();
            System.out.print("Ingrese el valor del objeto " + (i + 1) + ": ");
            double valor = scanner.nextDouble();
            container.agregarObjeto(peso, valor);
        }

        // Llenar el container y mostrar el valor total
        double valorTotal = container.llenarContainer();
        System.out.println("Valor total de la carga: " + valorTotal);

        // Mostrar los objetos seleccionados
        container.mostrarObjetosSeleccionados();
    }
}

