import java.util.Random;


class Lab1 {
    static boolean findElement(int element, int[] array){
        /* Поиск элемента в массиве */
        for (int j : array) {
            if (element == j) {
                return true;
            }
        }
        return false;
    }


    static void printMatrix(double[][] matrix) {
        /* Функция (метод?) для вывода матрицы */
        for (double[] i : matrix) {
            for (double value : i) {
                System.out.printf("%.5f ", value);
            }
            System.out.println();
        }
    }


    static void elementCalc(double[][] w1, int[] w, double[] x) {
        /* метод для вычисления элемента в массиве */

        // массив с элементами из 3-его пункта
        int[] arrayElements = {6, 7, 9, 11, 16, 17, 18, 19};

        for (int i = 0; i < 16; i++){
            for (int j = 0; j < 15; j++){
                if (w[i] == 14) {
                    w1[i][j] = Math.pow((Math.pow((0.5/x[j]),x[j])/2), ((Math.pow((Math.E), (Math.asin((x[j]-2)/12)/2))-0.25)/0.5));
                    //w1[i][j] = Math.pow((Math.pow((0.5/x[j]), x[j])/2), Math.pow(Math.pow(Math.E, x[j]), (Math.asin((x[j]-2)/12)/2)-0.2) * 5/0.5);
                } else if (findElement(w[i], arrayElements)) {
                    w1[i][j] = Math.pow((0.25*(Math.pow((Math.sin(x[j]) + 0.5), 3)-1)), 2);
                    //w1[i][j] = Math.pow((0.25 * (Math.pow((Math.sin(x[j]) + 0.5), 3)-1)), 2);
                } else {
                    w1[i][j] = Math.pow(Math.E, Math.pow(Math.log(Math.abs(x[j])), Math.sin(Math.pow(Math.E, x[j]))));
                    //w1[i][j] = Math.pow(Math.E, Math.pow(Math.log(Math.abs(x[j])), Math.sin(Math.pow(Math.E, x[j]))));
                }
            }
        }
    }


    public static void main(String[] args){
        int[] w = new int[16];
        int h = 5;
        for (int i=0; i<16; i++){
            w[i] = h;
            h++;
        }

        double[] x = new double[15];
        for (int i=0; i < 15; i++){
            x[i] = -8 + (4 - (-8)) * new Random().nextDouble();
        }

        // двумерный массив
        double[][] w1 = new double[16][15];

        // вычисление массива
        elementCalc(w1, w, x);

        // Вывод
        printMatrix(w1);
    }
}
