package sorting;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertionSort {
	//An In-place Algorithm
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
		sort(arr);
	}
	
	private static void sort(int[] arr) {
		int key;
		for(int i=1; i<arr.length; i++) {
			key = arr[i];
			for(int j=i-1; j>=-1; j--) {
				if(j>=0 && arr[j]>key) {
					arr[j+1] = arr[j];
				}
				else {
					arr[j+1] = key;
					break;
				}
			}
		}
		
		print(arr);
	}
	
	public static void print(int[] arr) {
		System.out.println("Sorted Array:- ");
		int c = 0;
		System.out.println(arr.length);
		for(int i: arr) {
			System.out.print(i);
			c++;
			System.out.print(c < arr.length ? ", " : "");
		}
	}
	
}
