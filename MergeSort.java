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
		if(p<r) {
			int q = (p+r)/2;
			
			sort(arr, p, q);
			sort(arr, q+1, r);
			
			Merge(arr, p, q, r);
		}
	}
	
	public static void Merge(int[] arr, int p, int q, int r) {
		int n1 = q-p+1;
		int n2 = r-q;
		int[] arr1 = new int[n1];
		int[] arr2 = new int[n2];
		
		for(int i = 0; i<n1; i++) {
			arr1[i] = arr[p+i];
		}
		for(int j = 0; j<n2; j++) {
			arr2[j] = arr[q+1+j];
		}
		
		int i = 0, j = 0;
		int k = p;
		
		while(i < n1 && j < n2) {
			if(arr1[i] <= arr2[j]) {
				arr[k] = arr1[i];
				i++;
			}
			else {
				arr[k] = arr2[j];
				j++;
			}
			k++;
		}
		
		while (i < n1) 
        { 
            arr[k] = arr1[i]; 
            i++; 
            k++; 
        } 
		
		while (j < n2) 
        { 
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
