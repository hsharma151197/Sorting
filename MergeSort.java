package sorting;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = -1;
		int[] arr = {};
		boolean flag = true;
		while(flag) {
			try{
				System.out.println("Enter the size of Array you want to sort:-");
				n = sc.nextInt();
				arr = new int[n];
				flag = false;
			}catch(NegativeArraySizeException e) {
				System.out.println("Invalid Entry");
			}
		}
		System.out.println("Enter elements:-");
		for(int i = 0; i<n; i++) {
			try{
				arr[i] = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Invalid Entry");
				sc.next();
				i--;
			}
		}
		sc.close();
		sort(arr, 0, arr.length-1);
	}
	
	public static void sort(int[] arr, int p, int r) {
		int q = 0;
		if(p<r) {
			q = ((int)Math.floor((p+r)/2));
			
			int[] arr1 = new int[q-p+1];
			int[] arr2 = new int[r-q];
			for(int i = 0; i<arr1.length; i++) {
				arr1[i] = arr[i];
			}
			for(int i = 0; i<arr2.length; i++) {
				arr2[i] = arr[q+i+1];
			}
			sort(arr, p, q);
			sort(arr, q+1, r);
			
			Merge(arr ,arr1, arr2);
		}
	}
	
	public static void Merge(int[] arr ,int[] arr1, int[] arr2) {
		int i = 0, j = 0, k = 0;
		if(arr1[i] <= arr2[j]) {
			arr[k] = arr1[i];
			i++;
			k++;
		}
		else {
			arr[k] = arr2[j];
			j++;
			k++;
		}
		print(arr);
	}
	
	public static void print(int[] arr) {
		System.out.println("Sorted Array:- ");
		int c = 0;
		for(int i: arr) {
			System.out.print(i);
			c++;
			System.out.print(c < arr.length ? ", " : "");
		}
	}

}
