import java.util.Scanner;

public class CajeroGreedy {


     // Definimos las denominaciones y la cantidad disponible en el cajero
    static int[] denominaciones = {100000, 50000, 20000, 10000};
    static int[] cantidades = {50, 100, 200, 300};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario el monto a retirar
        System.out.print("Ingrese la cantidad de dinero que desea retirar: ");
        int monto = scanner.nextInt();

        // Verificar si el monto es divisible por 10000
        if (monto % 10000 != 0) {
            System.out.println("La cantidad debe ser divisible por 10000.");
            return;
        }

        // Llamamos a la función para calcular los billetes
        int[] resultado = calcularBilletes(monto);

        // Si el resultado es nulo, no se puede retirar la cantidad solicitada
        if (resultado == null) {
            System.out.println("No hay suficientes billetes para retirar la cantidad solicitada.");
        } else {
            // Mostrar el número de billetes de cada denominación entregados
            System.out.println("Billetes entregados:");
            for (int i = 0; i < denominaciones.length; i++) {
                System.out.println(denominaciones[i] + " pesos: " + resultado[i] + " billetes");
            }
        }
    }

    // Función para calcular los billetes a entregar utilizando un algoritmo devorador (greedy)
    public static int[] calcularBilletes(int monto) {
        int[] billetesAEntregar = new int[denominaciones.length];

        // Iterar sobre cada denominación, empezando por la más grande
        for (int i = 0; i < denominaciones.length; i++) {
            // Determinar cuántos billetes de esta denominación se pueden entregar
            int billetesNecesarios = monto / denominaciones[i];
            // Verificar si hay suficientes billetes de esta denominación en el cajero
            int billetesAUsar = Math.min(billetesNecesarios, cantidades[i]);

            // Restar el monto correspondiente a los billetes utilizados
            monto -= billetesAUsar * denominaciones[i];
            billetesAEntregar[i] = billetesAUsar;
        }

        // Si no se ha cubierto todo el monto, retornar null (no se puede entregar la cantidad solicitada)
        if (monto > 0) {
            return null;
        }

        return billetesAEntregar;
    }
}
    

