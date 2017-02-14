/* Michael Wilson
 * 
 * Alternative code
 * 
 * This class was made so that I could understand the 
 * coin_change problem a bit more & to code up a fibonacci 
 * function with a RT of O(n) */
import java.util.*;

public class coin_change {
	public static void main(String[] args) {
		coin_challenge();
	}

	private static void coin_challenge() {
		Set<Integer> d = new HashSet<Integer>();
		d.add(1);
		d.add(6);
		d.add(10);
		d.add(14);
		int number = 9;
		coin_swap(d, number);		
	}

	/* This function keeps track of the minimum number of coins values, incremented
	 * by one up until a given number
	 *
	 * RT : O(n * d)
	 *
	 * @param d The set of coins that we use in our currency
	 * @param n The number that we want to find change for */
	private static void coin_swap(Set<Integer> d, int n) {
		int a[] = new int[n + 1];
		for(int i = 0; i <= n; i++) {
			a[i] = i;
			for(int j : d) {
				if(i >= j && i - j >= 0) {
					if(a[i] > a[i - j]) {
						// System.out.println("Current value: " + a[i] + "\nCompared value: " + a[i - j]);
						a[i] = a[i - j] + 1;		
						// System.out.println("Value is now " + a[i] + "\n");									
					}
				}
			}
		}

		int count = 0;
		for(int i = 0; i < a.length; i++) {
			System.out.println("Looking to make " + count +  "¢, requires at least " + a[i] + " coins");
			count++;
		}
	}

	/* Fibonacci calculor
	 * This is from recognizing that the nth fib number is f(n - 1) + f(n - 2)
	 * The recursive solution has a horrendous RT of O(2^n)
	 *
	 * RT: O(n)
	 * @param n the fibonacci number to find  
	 * @return The fibonacci number at the nth place */
	private static int fib(int n) {
		int f[] = new int[n];

		// initializes the first two
		f[0] = 0;
		f[1] = 1;
		for(int i = 2; i < n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n - 1];
	}
}