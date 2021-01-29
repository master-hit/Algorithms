/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searching;

/**
 *
 * @author Moises
 */
public class NewtonMethod {
    public static void main(String[] args) {
//        // finding the sqrt(3) using the formula x^2 - 3
//        double y = function(2,4);
//        System.out.println("function = " + y);
           System.out.println("divition" + 3/0);
    }
    
    //iterating formula of Newton's method: x - f(x)/f'(x)
    // using as f(x) = x^2 - 3
    public static double function(double estimate, int times) {
        for (int i = 0; i < times; i++) {
            estimate = estimate - (Math.pow(estimate,2)-3)/(2*estimate);
        }
        return estimate;
    }
}
