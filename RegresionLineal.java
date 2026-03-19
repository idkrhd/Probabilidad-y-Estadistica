public class RegresionLineal {
    public static void main(String[] args) {
        double[] advertising = {23, 26, 30, 34, 43, 48, 52, 57, 58};
        double[] sales =       {651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518};
        int n = advertising.length;
        double sumaX = 0;
        double sumaY = 0;
        double sumaXY = 0;
        double sumaX2 = 0;
        for (int i = 0; i < n; i++) {
            sumaX += advertising[i];
            sumaY += sales[i];
            sumaXY += advertising[i] * sales[i];
            sumaX2 += advertising[i] * advertising[i];
        }
        double B1 = (n * sumaXY - sumaX * sumaY) / (n * sumaX2 - sumaX * sumaX);
        double B0 = (sumaY - B1 * sumaX) / n;
        System.out.println("Ecuacion de regresion:");
        System.out.println("Y = " + B0 + " + " + B1 + "X");
        double[] nuevosX = {20, 35, 50, 60, 70};
        System.out.println("\nPredicciones:");
        for (int i = 0; i < nuevosX.length; i++) {
            double prediccion = B0 + B1 * nuevosX[i];
            System.out.println("Advertising: " + nuevosX[i] + " -> Sales: " + prediccion);
        }
    }
}