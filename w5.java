import java.util.*;
/* This program is designed to reenact Karatsuba's Algorithm
 * 
 * ©Michael Wilson */

public class w5 {
	public static void main(final String[] args) {
		int a = 6;
		int b = 6;
		//alphaTest(a, b);
		System.out.println("calculating " + a + " x " + b);
		System.out.println("Relying on the computer's algorithm: " + (a * b));
		System.out.println("Result from karatsuba is " + karatsuba(a, b));
	}

	/* Karatsuba's algorithm
	 * 
	 * @param m The first number to multiply
	 * @param n The second number to multiply
	 * @return The result of the multiplication */
	private static int karatsuba(int m, int n) {
		if(n == 0 || m == 0) return 0;
		if(n == 1) return m;
		if(m == 1) return n;
		List<Integer> mBinary = convertToBinary(m);
		List<Integer> nBinary = convertToBinary(n);
		List<Integer> mUpper = new ArrayList<Integer>();
		List<Integer> mLower = new ArrayList<Integer>();
		List<Integer> nUpper = new ArrayList<Integer>();
		List<Integer> nLower = new ArrayList<Integer>();
		splitUpperAndLower(mBinary, mUpper, mLower);
		splitUpperAndLower(nBinary, nUpper, nLower);			
		int p, q, r;
		p = karatsuba(convertToInteger(nUpper), convertToInteger(mUpper));
		q = karatsuba(convertToInteger(nLower), convertToInteger(mLower));
		r = karatsuba((convertToInteger(nUpper) + convertToInteger(nLower)), 
			(convertToInteger(mUpper) + convertToInteger(mLower)));
		int val = p * Math.pow(2, 2 * Math.floor(m/2)) + (r - p - q) * Math.pow(2, Math.floor(m/2)) + q;
		return val;
	}

	// method that converts an integer to binary 
	private static List<Integer> convertToBinary(int n) {
		List<Integer> myList = new ArrayList<>();
		convertToBinary(n, myList);
		return myList;
	}

	// converts an integer to its binary representation
	private static void convertToBinary(int n, List<Integer> list) {
		if(n > 0) {
			list.add(0, n % 2);
			convertToBinary(n/2, list);
		}
	}

	// convert to integer 
	private static int convertToInteger(List<Integer> list) {
		if(list.isEmpty()) return -1;
		int number = 0;
		for(int i = list.size() - 1; i >= 0; i--) 
			if(list.get(i) == 1) 
				number += Math.pow(2, list.size() - 1- i);				
		return number;
	}

	// splits an array for the upper and lower parts
	private static void splitUpperAndLower(List<Integer> source, List<Integer> upper, List<Integer> lower) {
		int breakPoint = (int)Math.ceil(source.size()/2);
		
		// System.out.println("Pre Split:\nLooking at the number: " + convertToInteger(source));
		// System.out.print("binary representation: ");
		// printArrayList(source);
		// System.out.println();

		for(int i = 0; i < breakPoint; i++) 
			upper.add(source.remove(0));	
		// System.out.println("Upper Split:\nLooking at the number: " + convertToInteger(upper));
		// System.out.print("binary representation: ");
		// printArrayList(upper);
		// System.out.println();

		while(!source.isEmpty()) 
			lower.add(source.remove(0));
		// System.out.println("Lower Split:\nLooking at the number: " + convertToInteger(lower));
		// System.out.print("binary representation: ");
		// printArrayList(lower);
		// System.out.println();
		
	}

	// method that prints out the contents of the array
	private static void printArrayList(List<Integer> list) {
		for(int a : list)
			System.out.print(a);
		System.out.println();
	}


	/* Performs a basic test on part of karatsuba's algorithm
	 * 
	 * @param a The first number
	 * @param b The second number */
	private static void alphaTest(int a, int b) {
		List<Integer> aBinary = convertToBinary(a);
		List<Integer> upper = new ArrayList<Integer>();
		List<Integer> lower = new ArrayList<Integer>();
		List<Integer> upper2 = new ArrayList<Integer>();
		List<Integer> lower2 = new ArrayList<Integer>();
		List<Integer> bBinary = convertToBinary(b);
		System.out.println(a + " in binary is ");
		printArrayList(aBinary);		
		splitUpperAndLower(aBinary, upper, lower);
		System.out.print("aUpper: ");
		printArrayList(upper);
		System.out.print("aLower: ");
		printArrayList(lower);
		System.out.println(b + " in binary is ");		
		printArrayList(bBinary);
		splitUpperAndLower(bBinary, upper2, lower2);
		System.out.print("bUpper: ");
		printArrayList(upper2);
		System.out.print("bLower: ");
		printArrayList(lower2);
	}	 
}
