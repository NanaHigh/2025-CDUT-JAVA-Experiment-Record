package Ex3;

import Ex3.Depends.*;

public class ex3_1 {
    
    public static void main(String[] args) {
        Complex a = new Complex(1.0f, 2.0f);
        Complex b = new Complex(1.0f, -2.0f);
        Complex c = new Complex();
        Complex num1 = a.Add(1.0f);
        Complex num2 = a.Add(b);
        Complex num3 = b.Sub(1.0f);
        Complex num4 = b.Sub(a);
        Complex num5 = c.Mul(2.0f);
        Complex num6 = a.Mul(b);

        System.out.println("a = " + a.toString());
        System.out.println("b = " + b.toString());
        System.out.println("c = " + c.toString());
        System.out.println("a + 1.0 = " + num1.toString());
        System.out.println("a + b = " + num2.toString());
        System.out.println("b - 1.0 = " + num3.toString());
        System.out.println("b - a = " + num4.toString());
        System.out.println("c * 2.0 = " + num5.toString());
        System.out.println("a * b = " + num6.toString());
    }
}
