public class TablaFrecuenciaAvanzada {
    public static void main(String[] args) {
        double[] datos = {
            25, 30, 35, 40, 45, 50, 55, 60, 65, 70,
            28, 33, 38, 43, 48, 53, 58, 63, 68, 73,
            27, 32, 37, 42, 47, 52, 57, 62, 67, 72
        };
        int n = datos.length;
        int k = (int) Math.sqrt(n);
        double min = datos[0];
        double max = datos[0];
        for (int i = 0; i < n; i++) {
            if (datos[i] < min) min = datos[i];
            if (datos[i] > max) max = datos[i];
        }
        double rango = max - min;
        double amplitud = Math.ceil(rango / k);
        double[] limiteInferior = new double[k];
        double[] limiteSuperior = new double[k];
        double[] puntoMedio = new double[k];
        int[] frecuencia = new int[k];
        int[] fa = new int[k];
        double[] fr = new double[k];
        double[] fra = new double[k];
        limiteInferior[0] = min;
        for (int i = 0; i < k; i++) {
            if (i > 0) {
                limiteInferior[i] = limiteSuperior[i - 1] + 1;
            }
            limiteSuperior[i] = limiteInferior[i] + amplitud - 1;
            puntoMedio[i] = (limiteInferior[i] + limiteSuperior[i]) / 2;
        }
        for (int i = 0; i < n; i++) {
            double valor = datos[i];
            for (int j = 0; j < k; j++) {
                if (valor >= limiteInferior[j] && valor <= limiteSuperior[j]) {
                    frecuencia[j]++;
                    break;
                }
            }
        }
        int sumaFa = 0;
        double sumaFra = 0;
        for (int i = 0; i < k; i++) {
            sumaFa += frecuencia[i];
            fa[i] = sumaFa;
            fr[i] = (double) frecuencia[i] / n;
            sumaFra += fr[i];
            fra[i] = sumaFra;
        }
        System.out.println("Clase\tLimites\tf\tXc\tFa\tfr\tFra\t%");
        for (int i = 0; i < k; i++) {
            System.out.printf("%d\t%.0f-%.0f\t%d\t%.0f\t%d\t%.2f\t%.2f\t%.0f%%\n",
                    (i + 1),
                    limiteInferior[i],
                    limiteSuperior[i],
                    frecuencia[i],
                    puntoMedio[i],
                    fa[i],
                    fr[i],
                    fra[i],
                    fr[i] * 100);
        }
        System.out.println("---------------------------------------");
        System.out.printf("TOTAL\t\t%d\t\t%d\t1.00\t1.00\t100%%\n", n, n);
    }
}