public class StandardDeviation {


   public static double Calculate (int [] X) {

       //Initialize Variables
       double sd =  0;   //StandardDeviation
       double ave = 0;   //Mean
       double a = 0;     //Sum (Xi- ave)^2
       double b = 0;    // a/n
       int n = X.length; // length of array(sample)

       for (int i=0; i<n; i++){
           ave = ave + X[i];
       }

       ave = ave/n;

       for(int i = 0; i<n; i++){
           a = a + Math.pow(X[i] - ave, 2);
       }

       b = a/n;

       sd = Math.sqrt(b);
       return sd;
   }
}
