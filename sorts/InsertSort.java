package sorts;

public class InsertSort implements Sort {
	public int[] insertSort(int[] arr,int dlk) {
		int len = arr.length;
		for(int i=dlk;i<len;++i){
			int x = arr[i];
			arr[i]=arr[i-dlk];
			int j=i-dlk;
			while(j>=0&&arr[j]>x){
				arr[j+dlk]=arr[j];
				j-=dlk;
			}
			arr[j+dlk]=x;
		}
		return arr;
	}
	public void shellsort(int[] arr) {
		int[] dlks = {5,3,1};
		for(int dlk:dlks){
			insertSort(arr,dlk);
		}
	}
	@Override
	public void Sort(int[] arr) {
		insertSort(arr, 1);
	}
}
