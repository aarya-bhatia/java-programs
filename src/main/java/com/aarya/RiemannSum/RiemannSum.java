package com.aarya.RiemannSum;

/** class to find the riemann sum
 * approximation of area under curve
 */
public class RiemannSum {

	private static float sum(Function f, int n, float a, float b, float shift){
		float sum = 0;
		float dx = (b-a)/n;
		for(int i = 0; i < n; i++){
			float x = a + i*dx + shift*dx;
			sum += f.eval(x) * dx;
		}
		return sum;
	}
	
	public static float left(Function f, int n, float a, float b){
		float s = sum(f, n, a, b, 0);
		System.out.println("The left riemann sum for n=" + n + " is " + s);	
		return s;
	}

	public static float right(Function f, int n, float a, float b){
		float s = sum(f, n, a, b, 1);
		System.out.println("The right riemann sum for n=" + n + " is " + s);
		return s;
	}

	public static float middle(Function f, int n, float a, float b){
		float s = sum(f, n, a, b, 0.5f);
		System.out.println("The middle riemann sum for n=" + n + " is " + s);
		return s;
	}
}

