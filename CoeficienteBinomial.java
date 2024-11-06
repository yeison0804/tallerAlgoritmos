public class CoeficienteBinomial {

    // Método para calcular el coeficiente binomial usando tabulación
    public static int binomialTabulacion(int n, int k) {
        // Crear una tabla para almacenar los coeficientes binomiales
        int[][] C = new int[n + 1][k + 1];

        // Llenar la tabla de abajo hacia arriba
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                // Casos base: C(n, 0) = C(n, n) = 1
                if (j == 0 || j == i) {
                    C[i][j] = 1;
                } else {
                    // Caso general: C(n, k) = C(n-1, k-1) + C(n-1, k)
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                }
            }
        }

        // Retornar el resultado final: C(n, k)
        return C[n][k];
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;

        System.out.println("Coeficiente Binomial por tabulación C(" + n + ", " + k + ") = " + binomialTabulacion(n, k));
    }
}
