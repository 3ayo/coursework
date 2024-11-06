import java.util.Scanner;
public class VolumeOfASphere{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("please enter your positive r");
        double d=sc.nextDouble();
        double volume = sphere(d);
        System.out.println("The volume of the sphere with diameter " + d + " is: " + volume);
    }
    public static double sphere(double d) {
        double r=d/2;
        return (4/3)*Math.PI*r*r*r;
    }

}