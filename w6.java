import java.util.*;

public class w6 {
	public static void main(String[] args) {
		System.out.println("2 ^ 4 is " + power(2, 4));
		System.out.println("The 10th fib number is " + fib(10));
	}

	static int fib(int n) {
		int f[] = new int[n];
		f[0] = 0;
		f[1] = 1;
		for(int i = 2; i < n; i++)
			f[i] = f[i - 1] + f[i - 2];
		return f[n-1];
	}
	static int power(int base, int powera) {
		if(powera == 0 || powera == 1) return 1;
		else if(powera % 2 == 0) return power(base, powera/2) * power(base, powera/2);
		else return base * power(base, powera/2) * power(base, powera/2);
	}
}
