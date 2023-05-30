package pass.Company.Citadel;

public class Triangle {
    public static void main(String[] args){
        double[][] points = new double[][]{{1, 2}, {4,5}, {7, 9}};
        double[] p = new double[]{4,7};
        double total = area(points[0], points[1], points[2]);
        if(total == 0){
            System.out.println("invalid");
            return;
        }
        else{
            double sum = area(p, points[0], points[1]) + area(p, points[0], points[2]) + area(p, points[1], points[2]);
            if(sum == total){
                System.out.println("on or inside");
            }
            else{
                System.out.println("outside");
            }
        }

    }   
    
    public static double area(double[] p1, double[] p2, double[] p3){
        return (p1[0] * (p2[1] - p3[1]) + p2[0] * (p3[1] - p1[1]) + p3[0] * (p1[1] - p2[1]));
    }
}


