/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numericalanalysis;

/**
 *
 * @author Moises
 */
public class NumericalAnalysis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("a"+"\t"+"b"+"\t"+"m");
        bisectionMethod(1.5,1.6,10);
    }
    public static void bisectionMethod(double a,double b,int numberOfIterations) {
        double m,fa,fb,fm; //midpoint, f(a), f(b), f(m)
        for (int i = 0; i < numberOfIterations; i++) {
            //calculate
            m = (a+b)/ 2;
            fa = function(a);
            fb = function(b);
            fm = function(m);
            //show
            System.out.println( a + (fa>0?"+":"-") + "\t" + b + (fb>0?"+":"-") + "\t" + fm + (fm>0?"+":"-") );
            //re-assign
            if (fa*fm<0)
                b=m;
            if (fm*fb<0)
                a=m;
        }
    }
    
    public static double function(double x) {
        return (Math.tan(x));
    }
}
