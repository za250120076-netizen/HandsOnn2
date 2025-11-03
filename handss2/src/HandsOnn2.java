public class HandsOnn2 {

    public static void main(String[] args) {

        // Datos base del modelo (Advertising, Sales)
        double[] advertising = {23, 26, 30, 34, 43, 48, 52, 57, 58};
        double[] sales =       {651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518};

        // Cálculo de medias
        double meanX = mean(advertising);
        double meanY = mean(sales);

        // Calcular coeficientes de la regresión
        double b1 = calcularPendiente(advertising, sales, meanX, meanY);
        double b0 = meanY - b1 * meanX;

        // Imprimir la ecuación
        System.out.printf("Ecuación de Regresión: y = %.4f + %.4f * x%n", b0, b1);

        // --------------------------------------------
        // Predicciones: valores nuevos de Advertising
        // agregar más valores aquí si quieres predecir más casos
        double[] nuevosX = {20, 35, 50, 65, 80,100 };
        // --------------------------------------------

        System.out.println("\nPredicciones de Sales:");
        for (double x : nuevosX) {
            double yPred = b0 + b1 * x;
            System.out.printf("Advertising = %.0f → Predicted Sales = %.2f%n", x, yPred);
        }
    }

    // --------------------------------------------
    // Función: calcular media de un arreglo
    // --------------------------------------------
    public static double mean(double[] data) {
        double sum = 0;
        for (double d : data) sum += d;
        return sum / data.length;
    }

    // --------------------------------------------
    // Función: calcular la pendiente (B1)
    // --------------------------------------------
    public static double calcularPendiente(double[] x, double[] y, double meanX, double meanY) {
        double num = 0, den = 0;
        for (int i = 0; i < x.length; i++) {
            num += (x[i] - meanX) * (y[i] - meanY);
            den += Math.pow(x[i] - meanX, 2);
        }
        return num / den;
    }
}