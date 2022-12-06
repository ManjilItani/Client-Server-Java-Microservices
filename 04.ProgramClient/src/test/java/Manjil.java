public class Manjil {

    //static method to calculate area of circle
    public static double areaOfCircl(double r){
        double area = Math.PI * (r*r);

        return area;
    }
    // Create a static method that calculates the
    // 2D euclidean distance between two points

    // D = SQRT[(X2-X1)^2 + (Y2-Y1)^2]
    public static double euclidean2D(int X1, int Y1, int X2, int Y2) {

        double D;
        double xDiff = Math.pow(X2 - X1, 2);
        double yDiff = Math.pow(Y2 - Y1, 2);
        D = Math.sqrt(xDiff + yDiff);
        return D;
    }

//    Sum of array
    public static int sumArray(int[] v){

        int S = 0;
        for(int i: v){
            S += i;
        }
        return S;
    }

    public static void main(String[] args) {
        int [] A = {1,2,3};
        System.out.println(sumArray(A));

        System.out.println(areaOfCircl(2));
        System.out.printf("The area is %s", Math.round(areaOfCircl(2)));

    }
}
