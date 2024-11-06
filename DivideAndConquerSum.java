public class DivideAndConquerSum {

    // Función principal que llama a la recursiva
    public static int calcularSuma(int[] numeros) {
        return calcularSumaRecursiva(numeros, 0, numeros.length - 1);
    }

    // Función recursiva para dividir y sumar
    private static int calcularSumaRecursiva(int[] numeros, int inicio, int fin) {
        // Caso base: Si solo hay un elemento, devuelve ese elemento
        if (inicio == fin) {
            return numeros[inicio];
        }

        // Encuentra el punto medio
        int medio = (inicio + fin) / 2;

        // Divide y vence: Suma la parte izquierda y derecha
        int sumaIzquierda = calcularSumaRecursiva(numeros, inicio, medio);
        int sumaDerecha = calcularSumaRecursiva(numeros, medio + 1, fin);

        // Retorna la suma de las dos mitades
        return sumaIzquierda + sumaDerecha;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sumaTotal = calcularSuma(numeros);
        System.out.println("La suma total es: " + sumaTotal);
    }
}

