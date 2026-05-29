public class DataSet {

    int[][] datos = {
        {7, 3},
        {2, 6}
    };

    public int[][] obtenerDatos() {
        return datos;
    }

    public int getTotal() {
        int total = 0;

        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[i].length; j++) {
                total += datos[i][j];
            }
        }

        return total;
    }
}