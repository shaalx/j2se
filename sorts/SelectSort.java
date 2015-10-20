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

}
