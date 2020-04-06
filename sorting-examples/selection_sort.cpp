// David Kanter Eivin

#include<iostream>

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

void ascendingSort(int arr[], int len)
{
    int max_idx;
    for (int i = 0; i < len - 1; i++)
    {
        max_idx = i;
        for (int j = i + 1; j < len; j++)
        {
            if (arr[j] < arr[max_idx])
                max_idx = j;
        }
        swap(&arr[max_idx], &arr[i]);
    }
}

void descendingSort(int arr[], int len)
{
    int max_idx;
    for (int i = 0; i < len - 1; i++)
    {
        max_idx = i;
        for (int j = i + 1; j < len; j++)
        {
            if (arr[j] > arr[max_idx])
                max_idx = j;
        }
        swap(&arr[max_idx], &arr[i]);
    }
}

int main() {
    int arr[5] = {64,25,12,22,11};
    descendingSort(arr, 5);
    for (int i = 0; i < 5; i++)
        std::cout << arr[i] << " ";
    return 0;
}