import java.util.*;

public class w4 {
   public static void main(final String[] args){
      int a[] = {3, 2, 1, 23, 42, 34, 1, 2, 4, 10};
      System.out.println("Array before sorting:");
      printArray(a);
      insertionSort(a);
      System.out.println("Array after sorting:");
      printArray(a);
      double mean = findAVG(a);
      System.out.println("The element closest to the average of the array is at index: " 
      + findClosest(a,23));
   }
   
   // prints the contents of an array
   private static void printArray(int a[]) {
      for(int i : a)
         System.out.print(i + " "); 
      System.out.println();     
   }
   
   // generic sorting algorithm   
   // this does the selection sort
   private static void sortArray(int a[]) {
      for(int i = 0; i < a.length; i++) {      
         int minLoc = i;
         for(int j = i + 1; j < a.length; j++) {
            if(a[minLoc] > a[j])
               minLoc = j;
         }
         swap(a, i, minLoc);
      }
   }
   
   // private swapping method
   private static void swap(int a[], int firstIndex, int secondIndex) {
      int temp = a[firstIndex];
      a[firstIndex] = a[secondIndex];
      a[secondIndex] = temp;
   }
      
   // implementation of insertion sort
   private static void insertionSort(int a[]) {
      for(int i = 1; i < a.length; i++){ 
         for(int j = i; j >= 1; j--) {
            if(a[j] < a[j - 1])
               swap(a, j, j -1);   
         }
      }
   }
   
   // calculates the nth fibonacci number
   private static int nthFib(int n) {
      if(n == 0)
         return 0;
      if(n == 1)
         return 1;
      return nthFib(n - 1) + nthFib(n - 2);
   }   
   
   // method that finds the average of an array
   private static double findAVG(int a[]) {
      double sum = 0;
      for(int i = 0; i < a.length; i++) {
         sum += a[i];
      }
      return sum / a.length;
   }
   
   // method that finds the element closest to the mean
   private static int findClosest(int a[], int key) {
      int low = 0;
      int high = a.length - 1;
      int mid;
      while(a[high] != a[low] && key >= a[low] && key <= a[high]) {
         mid = low + ((key - a[low]) * (high - low) / (a[high] - a[low]));
         if(a[mid] < key)
            low = mid + 1;
         else if(key < a[mid])
            high = mid - 1;
         else
            return mid;
      }   
      return key == a[low] ? low : -1;
   }
   
}