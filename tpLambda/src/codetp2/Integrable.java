package codetp2;

public interface Integrable {
    public double function(double x);
    default double integr(double a, double b, int n) {
        double interval = (b - a) / n;
        double sum = 0;

        for(int i = 0; i < n; i++) {
            sum += (this.function(a) + this.function(a + interval)) * interval / 2;
            a += interval;
        }
        return sum;
    }

    public static void main(String[] args) {
        class testSQUARE implements Integrable {

            @Override
            public double function(double x) {
                // TODO Auto-generated method stub
                return x * x;
            }

        }

        Integrable sqr = new testSQUARE();
        System.out.println(sqr.integr(0, 10, 5));
        
        class testSIN implements Integrable{

			@Override
			public double function(double x) {
				return Math.sin(x);
			}
        	
        }
        
        Integrable sin = new testSIN();
        System.out.println(sin.integr(0, Math.PI, 5));
    }
}
