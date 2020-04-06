public class SelectionSort
{
    public static void main(String[] args)
    {
        int[] arr = {64, 25, 12, 22, 11};
        descendingSort(arr);
        for (int i = 0; i < 5; i++)
        System.out.print(arr[i] + " ");
    }
    
    private static void descendingSort(int arr[])
    {
        int max_idx;
        for (int i = 0; i < arr.length - 1; i++)
        {
            max_idx = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] > arr[max_idx])
                    max_idx = j;
            }
            int temp = arr[max_idx];
            arr[max_idx] = arr[i];
            arr[i] = temp;
        }
    }

    private static void ascendingSort(int arr[])
    {
        int max_idx;
        for (int i = 0; i < arr.length - 1; i++)
        {
            max_idx = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] < arr[max_idx])
                    max_idx = j;
            }
            int temp = arr[max_idx];
            arr[max_idx] = arr[i];
            arr[i] = temp;
        }
    }
}