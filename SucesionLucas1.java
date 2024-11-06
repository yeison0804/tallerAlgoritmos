public class SucesionLucas1 {

    // Arreglo para memorizar los valores ya calculados
    private static int[] memo;

    // Método para calcular la sucesión de Lucas usando memorización
    public static int lucasMemorizacion(int n) {
        // Inicializar el arreglo de memo si es necesario
        if (memo == null) {
            memo = new int[n + 1];
        }

        // Casos base
        if (n == 0) return 2;
        if (n == 1) return 1;

        // Verificar si ya se ha calculado el valor
        if (memo[n] == 0) {
            memo[n] = lucasMemorizacion(n - 1) + lucasMemorizacion(n - 2);
        }

        return memo[n];
    }

    public static void main(String[] args) {
        int n = 10; // Cambiar este valor para probar diferentes entradas
        memo = new int[n + 1]; // Inicializar el arreglo de memo

        System.out.println("Lucas por memorización para n = " + n + ": " + lucasMemorizacion(n));
    }
}
