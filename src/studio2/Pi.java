package studio2;

public class Pi {
    public static void main(String[] args) {
        double x = 0;
        double y = 0;
        double r = 1;
        double n = 1000000;
        double inside = 0;
        
        for (int i = 0; i < n; i++) {
            x = Math.random();
            y = Math.random();
            if (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2)) {
                inside++;
            }
        }
        
        double pi = 4 * (inside / n);
        System.out.println("Pi: " + pi);
    }
}