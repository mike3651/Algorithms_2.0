/* Michael Wilson
 * 
 * Some code of algorithms */

import java.util.*;

public class w6 {
	public static void main(String[] args) {
		System.out.println("2 ^ 4 is " + power(2, 4));
		System.out.println("The 10th fib number is " + fib(10));
	}

	/* Finds the nth fibonacci number
	 * 
	 * @param n The nth number to find
	 * @return The nth Fibonacci number */
	static int fib(int n) {
		int f[] = new int[n];
		f[0] = 0;
		f[1] = 1;
		for(int i = 2; i < n; i++)
			f[i] = f[i - 1] + f[i - 2];
		return f[n-1];
	}

	/* Divide and conquer power problem 
	 * 
	 * @param base The base
	 * @param powera The power to raise the base to
	 * @return The base raised to a certain power */
	static int power(int base, int powera) {
		if(powera == 0) return 1;
		if(powera == 1) return base;
		else if(powera % 2 == 0) return power(base, powera/2) * power(base, powera/2);
		else return base * power(base, powera/2) * power(base, powera/2);
	}
}
