public class SucesionLucas {

    // Método para calcular la sucesión de Lucas usando tabulación
    public static int lucasTabulacion(int n) {
        // Arreglo para almacenar los valores de la sucesión
        int[] lucas = new int[n + 1];

        // Casos base
        lucas[0] = 2;
        if (n > 0) {
            lucas[1] = 1;
        }

        // Llenar el arreglo de forma iterativa
        for (int i = 2; i <= n; i++) {
            lucas[i] = lucas[i - 1] + lucas[i - 2];
        }

        // Retornar el valor para L(n)
        return lucas[n];
    }

    public static void main(String[] args) {
        int n = 10; // Cambiar este valor para probar diferentes entradas

        System.out.println("Lucas por tabulación para n = " + n + ": " + lucasTabulacion(n));
    }
}
