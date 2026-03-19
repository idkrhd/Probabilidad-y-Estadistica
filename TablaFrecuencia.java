public class TablaFrecuencia {
    public static void main(String[] args) {
        double[] datos = {
            1.2, 2.5, 3.1, 4.7, 5.0,
            6.3, 7.8, 8.1, 9.4, 2.2,
            3.5, 4.1, 6.7, 7.2, 8.9,
            9.0, 1.8, 2.9, 3.7, 5.5
        };
        int n = datos.length;
        String[] clases = {
            "0 - 2.9",
            "3 - 5.9",
            "6 - 8.9",
            "9 - 11.9"
        };
        int[] frecuencia = new int[clases.length];
        for (int i = 0; i < n; i++) {
            double valor = datos[i];
            if (valor >= 0 && valor <= 2.9) {
                frecuencia[0]++;
            } else if (valor >= 3 && valor <= 5.9) {
                frecuencia[1]++;
            } else if (valor >= 6 && valor <= 8.9) {
                frecuencia[2]++;
            } else if (valor >= 9 && valor <= 11.9) {
                frecuencia[3]++;
            }
        }
        System.out.println("CLASE\t\tf\tfr\t%");
        for (int i = 0; i < clases.length; i++) {
            double fr = (double) frecuencia[i] / n;
            double porcentaje = fr * 100;
            System.out.printf("%s\t%d\t%.2f\t%.0f%%\n",
                    clases[i],
                    frecuencia[i],
                    fr,
                    porcentaje);
        }
        System.out.println("---------------------------------");
        System.out.println("TOTAL\t\t" + n + "\t1.00\t100%");
    }
}