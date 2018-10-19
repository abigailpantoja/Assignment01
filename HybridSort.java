public class HybridSort implements SortingAlgorithm{


    @Override
    public void sort(int [] a)
    {
        hybridSort(a, 0, a.length-1, 64);
    }

    public void hybridSort(int[] arr, int start, int end, int run_size) {
        if ( end - start < run_size) {
            insertionSort(arr, start, end);
        } else {
            if (start < end) {
                int part = partition(arr, start, end);
                hybridSort(arr, start, part - 1, run_size);
                hybridSort(arr, part + 1, end, run_size);
            }
        }
    }

    public void insertionSort(int[] arr, int start, int end) {
//        
        for (int i = start; i <= end; i++) {
            int tmp = arr[i];
            for (int j = i - 1; j >= 0 && tmp < arr[j] ; j-- ) {
                arr[j+1] = arr[j];
                arr[j] = tmp ;
            }
        }
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = arr[(left+right)/2];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        int tmp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = tmp;

        return i+1;
    }
}
