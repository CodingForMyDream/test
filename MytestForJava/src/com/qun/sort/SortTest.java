package com.qun.sort;

import java.util.Arrays;

public class SortTest {

	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1 };
		SortTest.printInt(a);
		Arrays.sort(a);
		SortTest.printInt(a);
		//SortTest.printInt(SortTest.insertSort(a));
	}

	/**
	 * 插入排序
	 */
	public static int[] insertSort(int[] args) {
		for (int i = 1; i < args.length; i++) {
			int temp = args[i];
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (args[j] > temp) {
					args[j + 1] = args[j];
				} else {
					break;
				}
			}
			args[j + 1] = temp;
		}
		return args;
	}

	public static void printInt(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
