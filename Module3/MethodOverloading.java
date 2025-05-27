public class MethodOverloading {
    
    // Method to add two integers
    public static int add(int a, int b) {
        return a + b;
    }

    // Method to add two doubles
    public static double add(double a, double b) {
        return a + b;
    }

    // Method to add three integers
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println("Sum of 2 integers: " + add(5, 10));
        System.out.println("Sum of 2 doubles: " + add(5.5, 4.5));
        System.out.println("Sum of 3 integers: " + add(1, 2, 3));
    }
}
