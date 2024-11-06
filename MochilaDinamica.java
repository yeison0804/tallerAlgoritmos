public class MochilaDinamica {

    // Método para resolver el problema de la mochila por programación dinámica
    public static int knapsack(int[] pesos, int[] valores, int capacidad) {
        int n = pesos.length;
        int[][] tabla = new int[n + 1][capacidad + 1];

        // Llenamos la tabla usando la relación de recurrencia
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacidad; w++) {
                if (i == 0 || w == 0) {
                    tabla[i][w] = 0; // Caso base: sin objetos o capacidad 0
                } else if (pesos[i - 1] <= w) {
                    // Objeto puede ser incluido
                    tabla[i][w] = Math.max(tabla[i - 1][w], tabla[i - 1][w - pesos[i - 1]] + valores[i - 1]);
                } else {
                    // Objeto no puede ser incluido
                    tabla[i][w] = tabla[i - 1][w];
                }
            }
        }

        // El valor máximo está en tabla[n][capacidad]
        return tabla[n][capacidad];
    }

    public static void main(String[] args) {
        int[] pesos = {2, 3, 4, 5};     // Pesos de los objetos
        int[] valores = {3, 4, 5, 6};   // Valores de los objetos
        int capacidad = 8;              // Capacidad de la mochila

        int valorMaximo = knapsack(pesos, valores, capacidad);
        System.out.println("El valor máximo que se puede obtener es: " + valorMaximo);
    }
}

