public class Correlation {
    public static double Calculate (double [] X, double [] Y) {

        // Code is based on https://www.mathsisfun.com/data/correlation.html
        //Initialize Variables
        int n_X      = X.length;  //length of first array
        int n_Y      = Y.length;  //length of Second array
        double ave_X = 0.0;       //average of first array
        double ave_Y = 0.0;       //average of Second array
        double [] a = new double[n_X];             //Xi -ave_X
        double [] b = new double[n_Y];             //Yi -ave_Y
        double [] ab = new double[n_X];           //(Xi-ave_X)*(Yi-ave_Y)
        double ab_sum = 0.0;                      //sum ((Xi-ave_X)*(Yi-ave_Y))
        double [] a_squared = new double[n_X];    //(Xi-ave_X)^2
        double a_squared_sum = 0.0;               //sum ((Xi-ave_X)^2)
        double [] b_squared = new double[n_Y];    //(Yi-ave_Y)^2
        double b_squared_sum = 0.0;               //sum ((Xi-ave_X)^2)
        double corr = 0.0;

        //Calculate Average of first and second array
        for (int i = 0; i<n_X; i++){
            ave_X += X[i];
            ave_Y += Y[i];
        }
        ave_X = ave_X/n_X;
        ave_Y = ave_Y/n_Y;


        for (int i = 0; i<n_X; i++){
            a[i] = X[i] - ave_X;
            b[i] = Y[i] - ave_Y;
            ab[i] = a[i] * b[i];
            ab_sum += ab[i];
            a_squared[i] = Math.pow(a[i],2);
            b_squared[i] = Math.pow(b[i],2);
            a_squared_sum += a_squared[i];
            b_squared_sum += b_squared[i];
        }


        corr = ab_sum/Math.sqrt(a_squared_sum * b_squared_sum);

        return corr;
    }
}
