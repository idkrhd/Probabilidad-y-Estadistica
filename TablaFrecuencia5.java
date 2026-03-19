public class TablaFrecuencia5 {
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
        double[] li = new double[k];
        double[] ls = new double[k];
        double[] xc = new double[k];
        int[] f = new int[k];
        int[] fa = new int[k];
        double[] fr = new double[k];
        double[] fra = new double[k];
        li[0] = min;
        for (int i = 0; i < k; i++) {
            if (i > 0) li[i] = ls[i - 1] + 1;
            ls[i] = li[i] + amplitud - 1;
            xc[i] = (li[i] + ls[i]) / 2;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (datos[i] >= li[j] && datos[i] <= ls[j]) {
                    f[j]++;
                    break;
                }
            }
        }
        int sumaFa = 0;
        double sumaFra = 0;
        for (int i = 0; i < k; i++) {
            sumaFa += f[i];
            fa[i] = sumaFa;
            fr[i] = (double) f[i] / n;
            sumaFra += fr[i];
            fra[i] = sumaFra;
        }
        // MEDIA (agrupada)
        double suma = 0;
        for (int i = 0; i < k; i++) {
            suma += xc[i] * f[i];
        }
        double media = suma / n;
        // MEDIANA (agrupada)
        double mediana = 0;
        int mitad = n / 2;
        for (int i = 0; i < k; i++) {
            if (fa[i] >= mitad) {
                double L = li[i];
                int F_anterior = (i == 0) ? 0 : fa[i - 1];
                int fm = f[i];
                mediana = L + ((mitad - F_anterior) / (double) fm) * amplitud;
                break;
            }
        }
        // MODA (agrupada)
        double moda = 0;
        int indexModa = 0;
        for (int i = 0; i < k; i++) {
            if (f[i] > f[indexModa]) {
                indexModa = i;
            }
        }
        double Lm = li[indexModa];
        int fm = f[indexModa];
        int f1 = (indexModa == 0) ? 0 : f[indexModa - 1];
        int f2 = (indexModa == k - 1) ? 0 : f[indexModa + 1];
        moda = Lm + ((fm - f1) / (double)((fm - f1) + (fm - f2))) * amplitud;
        // TABLA
        System.out.println("Clase\tLimites\tf\tXc\tFa\tfr\tFra\t%");
        for (int i = 0; i < k; i++) {
            System.out.printf("%d\t%.0f-%.0f\t%d\t%.0f\t%d\t%.2f\t%.2f\t%.0f%%\n",
                    (i + 1),
                    li[i],
                    ls[i],
                    f[i],
                    xc[i],
                    fa[i],
                    fr[i],
                    fra[i],
                    fr[i] * 100);
        }
        System.out.println("-----------------------------------");
        System.out.printf("TOTAL\t\t%d\t\t%d\t1.00\t1.00\t100%%\n", n, n);
        // RESULTADOS FINALES 
        System.out.println("\nMedidas de Tendencia Central:");
        System.out.printf("Media: %.2f\n", media);
        System.out.printf("Mediana: %.2f\n", mediana);
        System.out.printf("Moda: %.2f\n", moda);
    }
}