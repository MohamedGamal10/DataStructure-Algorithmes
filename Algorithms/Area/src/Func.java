
public class Func {

    //Calculate Circle Area Function
    public static double Circle_Area(double r){
        // A is Area
        // r is Redius of the Circle

        double A = Math.PI * (r*r);
        return (A);
    }

    //Calculate Parallelogram  Area Function
    public static double Parallelogram_Area(double b, double h){
        // A is Area
        // b is base of Parallelogram
        // h is height of Parallelogram

        double A = b * h;
        return (A);
    }


    //Calculate Trapezoid  Area Function
    public static double Trapezoid_Area(double a, double b, double h){
        // A is Area
        // a, b are the bases (parallel sides)
        // h is the height (the perpendicular distance between a and b)
        double A = 0.5 * (a+b) * h;
        return (A);
    }
}
