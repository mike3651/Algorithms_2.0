// Michael Wilson
// CSS 343


#include <iostream>

// allows for the use of an array
#include <array>


using namespace std;


/* Calculates the factorial of a number
 * @param n The number to calculate the factorial of 
 * @return The factorial */
int factorial(int);

/* Calculates a sum running down from the number by 2s
 * @param n The number to find the odd sum of 
 * @preturn The total */
int downSum(int);

int main(void) {
	int n;
	// cout << "please enter a number: ";
	// cin >> n;

	//cout << n << " factorial is " << factorial(n) << endl;
	// cout << "The sum of the numbers in " << n << " going down by 2s is " 
	//      << downSum(n) << endl;
	int a[] = {1, 3, 5, 7};
	int b[] = {2, 4, 6, 8};


	cout << "Merging a[] and b[] gives us " << endl;

}


void printArray(int a[]) {
	int length = sizeof(a)/sizeof(a[0]);
	for(int i = 0; i < length; i++) 
		cout << a[i] << " ";
	cout << endl;
}

int factorial(int n) {
	return n >= 1 ? 1 : n * factorial(n - 1);
}

int downSum(int n) {
	return n <= 1 ? n : n + downSum(n - 2);
}
