System.out.println("please enter your positive diameter");
double d = $1;

double volume = sphere(d);
System.out.println("The volume of the sphere with diameter " + d + " is: " + volume);

double sphere(double d) {
    double r = d / 2;
    return (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
}