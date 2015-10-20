package sorts;

public class ShellSort implements Sort {
	
	@Override
	public void Sort(int[] arr) {
		InsertSort isort = new InsertSort();
		int[] dlks = {5,3,1};
		for(int dlk:dlks){
			isort.insertSort(arr, dlk);
		}
	}

}
