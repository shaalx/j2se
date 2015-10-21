package sorts;

public class HeapSort implements Sort{

	@Override
	public void Sort(int[] arr) {
		int len = arr.length;
		// 建堆
		int start = (len-1)/2;
		while(start>=0){
			heapAdjust(arr, start,len);
			-- start;
		}
		// 对换，调整
		while(len>1){
			--len;
			int x = arr[len];
			arr[len]=arr[0];
			arr[0]=x;
			heapAdjust(arr, 0, len);
		}
	}
	public void heapAdjust(int[] arr,int s,int len) {
		int x = arr[s];
		int child = 2*s+1;
		while(child<len){
			if (child+1<len && arr[child]<arr[child+1]) {
				++ child;
			}
			if (arr[s]<arr[child]) {
				arr[s] = arr[child];
				s = child;
				child = 2*s+1;
			}else{
				break;
			}
			arr[s]=x;
		}
		for(int v:arr){
			System.out.print(v+"\t");
		}
		System.out.println();
	}

}
