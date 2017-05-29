package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	public static void main(String[] args) {
		QuickSort<Integer> s = new QuickSort<Integer>();
		Integer[] array = { 30, 28, 7, 29, 11};
		System.out.println(array.length-1);
		s.sort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int j;
		if (leftIndex < rightIndex) {
			j = quick(array, leftIndex, rightIndex);
			sort(array, leftIndex, j);
			sort(array, j + 1, rightIndex);
		}
	}

	private int quick(T[] array, int comeco, int fim) {
		int indicePivot = comeco;

		for (int i = comeco + 1; i <= fim; i++) {
			if (array[i].compareTo(array[indicePivot]) == -1) {
				Util.swap(array, indicePivot, i);
				indicePivot = indicePivot + 1;
			}
		}

		return indicePivot;
	}

}
