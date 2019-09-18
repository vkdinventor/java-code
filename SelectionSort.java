/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

/**
 * find the minum number and put it at right place.
 *  https://ide.geeksforgeeks.org/n6cjdyTCxN
 **/
class SelectionSort {
	public static void main (String[] args) {
		int[] arr = new int[]{9,8,10,11,2,7,15,6,18};
		System.out.println(Arrays.toString(selectionSort(arr)));
	}
	
	private static int[] selectionSort(int[] arr){
	    for (int i=0; i< arr.length ; i++ ){
	        int min = arr[i];
	        int index=i;
	        
	        for (int j=i; j< arr.length; j++){
	            if(arr[j] < min ){
	                min = arr[j];
	                index = j;
	            }
	        }
	        
	        int temp = arr[i];
	        arr[i]= min;
	        arr[index]= temp;
	    }
	    return arr;
	}
}

