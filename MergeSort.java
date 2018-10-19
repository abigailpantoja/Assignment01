public class MergeSort implements SortingAlgorithm {
    @Override
    public void sort(int [] a)
    {
        mergesort(a, 0, a.length-1);
    }
    public void mergesort(int [] a, int top, int bot)
    {
        if (top >= bot) {
            return;
        }
        int mid = (top + bot)/2;
        int n = a.length;

        int[] a1 = new int[(n + 1)/2];
        int[] a2 = new int[n - a1.length];

        mergesort(a1, bot, mid);
        mergesort(a2, mid+1, bot);
        merge(a1, a2, a);
    }
    public void merge(int [] left, int [] right, int[] arr)
    {
        int left_index = 0;
        int right_index = 0;
        int arr_index = 0;

        while (left_index < left.length && right_index < right.length){ 
            if (left[left_index] <= right[right_index])
                arr[arr_index++] =left[left_index++];
            else
                arr[arr_index++] = right[right_index++];
        }
        while (left_index < left.length)
            arr[arr_index++] = left[left_index++];  
        while (right_index <right.length)
            arr[arr_index++] = right[right_index++];     
    }
}
