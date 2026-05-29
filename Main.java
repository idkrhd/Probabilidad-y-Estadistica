public class Main {

    public static void main(String[] args) {

        DataSet data = new DataSet();

        int[][] matriz = data.obtenerDatos();
        int total = data.getTotal();

        Probabilidad prob = new Probabilidad(matriz, total);

        System.out.println("TOTAL: " + total);
        System.out.println();

        prob.calcularMarginal();
        prob.calcularConjunta();
        prob.calcularCondicional();
    }
}