package TP2;
import java.util.*;
import java.util.function.Function;

public interface Integrable {
    double eval(double x);

    default double integr(double a, double b, int n) {
        double delta = (b - a) / n;
        double sum = 0.5 * (eval(a) + eval(b));

        for (int i = 1; i < n; i++) {
            double x = a + i * delta;
            sum += eval(x);
        }

        return sum * delta;
    }
    
    public static void main(String[] args) {
    	Integrable x = new carre();
    	int k = 10;
    	int s = 0;
    	for(int i = 0;i<=k;i++) {
    		s+=i*i;
    		
    	}
    	System.out.println(s);
    	System.out.println(x.integr(0, 10,1));
    	
    	Integrable sin = new sin();
    	System.out.println(sin.integr(0,Math.PI,3));
    }
}

