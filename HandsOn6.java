public class HandsOn6 {

    public static void main(String[] args) {

        int[] estudia = {
            1, 1, 1, 0, 1,
            0, 1, 1, 0, 0
        };

        int[] aprueba = {
            1, 1, 0, 0, 1,
            0, 1, 1, 0, 1
        };

        Probabilidad probabilidad =
                new Probabilidad(estudia, aprueba);

        System.out.println("====================================");
        System.out.println("        HANDS-ON 6");
        System.out.println("           PROBABILIDAD");
        System.out.println("====================================");

        System.out.println();

        probabilidad.mostrarDatos();

        System.out.println();
        System.out.println("====================================");
        System.out.println("     RESULTADOS DE PROBABILIDAD");
        System.out.println("====================================");

        System.out.printf(
            "\nProbabilidad Marginal\n"
        );

        System.out.printf(
            "P(Estudia) = %.2f\n",
            probabilidad.probabilidadMarginal()
        );

        System.out.printf(
            "\nProbabilidad Conjunta\n"
        );

        System.out.printf(
            "P(Estudia y Aprueba) = %.2f\n",
            probabilidad.probabilidadConjunta()
        );

        System.out.printf(
            "\nProbabilidad Condicional\n"
        );

        System.out.printf(
            "P(Aprueba | Estudia) = %.2f\n",
            probabilidad.probabilidadCondicional()
        );

        System.out.println();
        System.out.println("====================================");
    }
}