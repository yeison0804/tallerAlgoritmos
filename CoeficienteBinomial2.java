public class CoeficienteBinomial2 {

    // Arreglo para memorizar los valores calculados
    private static int[][] memo;

    // Método para calcular el coeficiente binomial usando memorización
    public static int binomialMemorizacion(int n, int k) {
        // Inicializar la tabla de memo si es necesario
        if (memo == null) {
            memo = new int[n + 1][k + 1];
        }

        // Casos base: C(n, 0) = C(n, n) = 1
        if (k == 0 || k == n) {
            return 1;
        }

        // Verificar si ya hemos calculado el valor
        if (memo[n][k] == 0) {
            memo[n][k] = binomialMemorizacion(n - 1, k - 1) + binomialMemorizacion(n - 1, k);
        }

        return memo[n][k];
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        memo = new int[n + 1][k + 1]; // Inicializar el arreglo memo

        System.out.println("Coeficiente Binomial por memorización C(" + n + ", " + k + ") = " + binomialMemorizacion(n, k));
    }
}

