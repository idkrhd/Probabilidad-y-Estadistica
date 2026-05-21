public class Probabilidad {

    private int[] estudia;
    private int[] aprueba;
    private int total;

    public Probabilidad(int[] estudia, int[] aprueba) {

        this.estudia = estudia;
        this.aprueba = aprueba;
        total = estudia.length;
    }

    public void mostrarDatos() {

        System.out.println("Alumno\tEstudia\tAprueba");
        System.out.println("------------------------------------");

        for (int i = 0; i < total; i++) {

            System.out.println(
                (i + 1) + "\t" +
                estudia[i] + "\t\t" +
                aprueba[i]
            );
        }
    }

    public double probabilidadMarginal() {

        int contador = 0;

        for (int i = 0; i < total; i++) {

            if (estudia[i] == 1) {

                contador++;
            }
        }

        return (double) contador / total;
    }

    public double probabilidadConjunta() {

        int contador = 0;

        for (int i = 0; i < total; i++) {

            if (estudia[i] == 1 &&
                aprueba[i] == 1) {

                contador++;
            }
        }

        return (double) contador / total;
    }

    public double probabilidadCondicional() {

        int estudian = 0;
        int estudianYAprueban = 0;

        for (int i = 0; i < total; i++) {

            if (estudia[i] == 1) {

                estudian++;

                if (aprueba[i] == 1) {

                    estudianYAprueban++;
                }
            }
        }

        return (double) estudianYAprueban / estudian;
    }
}