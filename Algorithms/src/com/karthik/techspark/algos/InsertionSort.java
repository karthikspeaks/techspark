package com.karthik.techspark.algos;

class InsertionSort {

	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 35, 67, 91, 1 };
		int arr2[] = { 12, 11, 13, 5, 6, 35, 67, 91, 1 };

		InsertionSort ob = new InsertionSort();
		ob.sort(arr);
		printArray(arr);

		ob.insertionSort(arr2);
		printArray(arr2);

	}

	void insertionSort(int a[]) {

		int n = a.length;
		for (int j = 1; j < n; j++) {
			int key = a[j];
			int i = j - 1;

			while (i >= 0 && a[i] > key) {
				a[i + 1] = a[i];
				i = i - 1;
			}
			a[i + 1] = key;

		}

	}

	void sort(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

}
