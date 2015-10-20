package sorts;

import java.util.Random;

public class QuickSort implements Sort{
	@Override
	public void Sort(int[] arr){
		quickSort(arr,0,arr.length-1);
	}
	
	public void quickSort(int[] arr, int low, int high) {
		if(low<high){
			System.out.printf("low:%d, high:%d\n", low,high);
			int i = section(arr, low, high);
			quickSort(arr, low, i-1);
			quickSort(arr, i+1, high);
		}
		
	}
	
	public int section(int[] arr, int low,int high) {
		if (low>=high) {
			return low;
		}
		int t = new Random().nextInt(high-low)+low;
		int piv = arr[t];
		int i = low,j=high;
		int tmp;
		while(i<j){
			while(i<j&&arr[i]<piv) ++i;
			while(i<j&&arr[j]>piv) --j;
			if (i<j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;	
			}
		}
		return i;
	}
}
