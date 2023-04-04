public class Main {
    public static void main(String[] args) {

        int [] X = {1,2,3};
        System.out.println("StandardDeviation : " + StandardDeviation.Calculate(X));

        double [] Temp = {14.2,16.2,11.9,15.2,18.5,22.1,19.4,25.1,23.4,18.1,22.6,17.2};
        double [] Sales = {215,325,185,332,406,522,412,614,544,421,445,408};
        System.out.println("Correlation : " + Correlation.Calculate(Temp, Sales));

        double X2[] = {15, 18, 21, 24, 27};
        double Y2[] = {25, 25, 27, 31, 32};
        System.out.println("Correlation : " + Correlation.Calculate(X2, Y2));
    }


}