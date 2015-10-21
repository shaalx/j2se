package sorts;

public class sorts {

	public static void main(String[] args) {
		//Sort iSort = new InsertSort();
		//Sort iSort = new ShellSort();
		//Sort iSort = new QuickSort();
		//Sort iSort = new SelectSort();
		//Sort iSort = new BubbleSort();
		//Sort iSort = new HeapSort();
		Sort iSort = new MergeSort();
		int[] arr = new int[10];		
		for (int i = 0; i < arr.length; i++) {
			arr[i]=10-i;
		}
		for(int t: arr){
			System.out.print(t+"\t");
		}
		System.out.println();
		iSort.Sort(arr);
		for(int t: arr){
			System.out.print(t+"\t");
		}
		System.out.println();
	}

}
