package sorts;

public class BubbleSort implements Sort{

	@Override
	public void Sort(int[] arr) {
		int len = arr.length;
		boolean sorted = false;
		int j;
		for(int i=len-1;i>0;--i){
			sorted = false;
			int x = arr[len-1];
			for (j = len-2; j >=0 && arr[j]>x; --j) {
				arr[j+1] = arr[j];
				sorted = true;
			}
			if (!sorted) {
				break;
			}
			arr[j+1] = x;

			for(int v:arr){
				System.out.print(v+"\t");
			}
			System.out.println();
		}
	}

}
