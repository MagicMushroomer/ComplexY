/*
 * Farit Zakirov
 * farit1998@gmail.com
 * Copyright (c) 2022
 */

package Task2;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[15];

        for (int i=0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
            System.out.print(array[i] + " ");
        }

        System.out.println();

        pairSum(array, 10);

        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    /**
     * Поиск пар элементов массива, по заданной сумме.
     * @param array Массив, у которого необходимо найти сумму.
     * @param requiredSum Сумма, которой должны равнятся пара элементов массива.
     */
    public static void pairSum(int[] array, int requiredSum) {

        if (array == null) {
            throw new NullPointerException("Массив не был передан или он пустой.");
        }
        sort(array);

        int count = 0;
        int start = 0;
        int end = array.length - 1;

        while(start != end) {

            if (array[start] + array[end] < requiredSum) {
                start++;
            } else if(array[start] + array[end] > requiredSum) {
                end--;
            } else {
                System.out.println("[" + array[start] + ", " + array[end] + "]");
                count++;
                start++;
                end--;
            }

            if(count == 2)
                return;
        }

        if(count == 0){
            System.out.println("No such pairs.");
        }
    }


    /**
     * Сортировка массива методом вставки.
     * @param array Массив, который необходимо отсортировать.
     */
    public static void sort(int[] array) {
        if (array == null) {
            throw new NullPointerException("Массив не был передан или он пустой.");
        }
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
    }
}