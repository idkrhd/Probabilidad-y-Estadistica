public class Probabilidad {

    private int[][] datos;
    private int total;

    public Probabilidad(int[][] datos, int total) {
        this.datos = datos;
        this.total = total;
    }

    public void calcularMarginal() {

        System.out.println("PROBABILIDAD MARGINAL");

        double pA = (double)(datos[0][0] + datos[1][0]) / total;
        double pAprima = (double)(datos[0][1] + datos[1][1]) / total;

        double pB = (double)(datos[0][0] + datos[0][1]) / total;
        double pBprima = (double)(datos[1][0] + datos[1][1]) / total;

        System.out.println("P(A) = " + pA);
        System.out.println("P(A') = " + pAprima);
        System.out.println("P(B) = " + pB);
        System.out.println("P(B') = " + pBprima);
    }

    public void calcularConjunta() {

        System.out.println("\nPROBABILIDAD CONJUNTA");

        double pAyB = (double) datos[0][0] / total;
        double pAprimaYB = (double) datos[0][1] / total;
        double pAyBprima = (double) datos[1][0] / total;
        double pAprimaYBprima = (double) datos[1][1] / total;

        System.out.println("P(A ∩ B) = " + pAyB);
        System.out.println("P(A' ∩ B) = " + pAprimaYB);
        System.out.println("P(A ∩ B') = " + pAyBprima);
        System.out.println("P(A' ∩ B') = " + pAprimaYBprima);
    }

    public void calcularCondicional() {

        System.out.println("\nPROBABILIDAD CONDICIONAL");

        double pBgivenA = (double) datos[0][0] / (datos[0][0] + datos[1][0]);
        double pAgivenB = (double) datos[0][0] / (datos[0][0] + datos[0][1]);

        System.out.println("P(B|A) = " + pBgivenA);
        System.out.println("P(A|B) = " + pAgivenB);
    }
}