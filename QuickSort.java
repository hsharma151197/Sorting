package sorting;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuickSort {

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
		int q;
		if(p<r) {
			q = partition(arr, p, r);
			sort(arr, p, q-1);
			sort(arr, q+1, r);
		}
		print(arr);
	}
	
	public static int partition(int[] arr, int p, int r) {
		int i = p-1;
		int j = p;
		int key = arr[r];
		int temp;
		while(j<=r-1) {
			if(arr[j] <= key) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			
			j++;
		}
		
		arr[j] = arr[++i];
		arr[i] = key;
		
		return i;
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
