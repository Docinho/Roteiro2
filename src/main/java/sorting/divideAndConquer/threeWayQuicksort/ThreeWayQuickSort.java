package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;
import util.Util;

public class ThreeWayQuickSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot,
	 * particionamos o array colocando os menores a esquerda do pivot 
	 * e os maiores a direita do pivot, e depois aplicamos a mesma estrategia 
	 * recursivamente na particao a esquerda do pivot e na particao a direita do pivot. 
	 * 
	 * Considerando um array com muitos elementos repetidos, a estrategia do quicksort 
	 * pode ser otimizada para lidar de forma mais eficiente com isso. Essa melhoria 
	 * eh conhecida como quicksort tree way e consiste da seguinte ideia:
	 * - selecione o pivot e particione o array de forma que
	 *   * arr[l..i] contem elementos menores que o pivot
	 *   * arr[i+1..j-1] contem elementos iguais ao pivot.
	 *   * arr[j..r] contem elementos maiores do que o pivot. 
	 *   
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh feito
	 * recursivamente. 
	 **/
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int iguais = leftIndex;
			int indicePivot = leftIndex;
			
			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				if (array[i].compareTo(array[indicePivot]) == 0) {
					Util.swap(array, iguais + 1, i);
					iguais = iguais + 1;
				} else if (array[i].compareTo(array[indicePivot]) == -1) {
					if (iguais == indicePivot)
						iguais = indicePivot + 1;
					else
						iguais = iguais + 1;
					Util.swap(array, indicePivot, i);
					indicePivot = indicePivot + 1;

				}
			}
			sort(array, leftIndex, indicePivot - 1);
			sort(array, iguais + 1, rightIndex);
		}
	}

//	private int quick(T[] array, int leftIndex, int rightIndex) {
//
//		int iguais = leftIndex;
//		int indicePivot = leftIndex;
//		
//		for (int i = comeco + 1; i <= fim; i++) {
//			if (array[i] == array[indicePivot]) {
//				swap(array, iguais + 1, i);
//				iguais = iguais + 1;
//			} else if (array[i] < array[indicePivot]) {
//				if (iguais == indicePivot)
//					iguais = indicePivot + 1;
//				else
//					iguais = iguais + 1;
//				swap(array, indicePivot, i);
//				indicePivot = indicePivot + 1;
//
//			}
//		}
//		quickSort(array, comeco, indicePivot - 1);
//		quickSort(array, iguais + 1, fim);
//	}
//	

}
