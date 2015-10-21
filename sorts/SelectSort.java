package sorts;

public class SelectSort implements Sort{

	@Override
	public void Sort(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len-1; i++) {
			for (int j = i+1; j < len; j++) {
				if (arr[i]>arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	public void AdSort(int[] arr) {
		int len = arr.length;
		int min;
		int flag;
		for (int i = 0; i < len-1; i++) {
			min = arr[i];
			flag = i;
			for (int j = i+1; j < len; j++) {
				if (arr[j]<min) {
					min = arr[j];
					flag = j;
				}
			}
			if (flag!=i) {
				int tmp = arr[i];
				arr[i]=arr[flag];
				arr[flag]=tmp;
			}
		}
	}

}
