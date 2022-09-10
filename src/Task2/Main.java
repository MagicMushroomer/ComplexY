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

        heapSort(array);

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
     * Сборка массива в пирамиду-кучу.
     * @param array Массив чисел необходимый собрать в пирамиду.
     * @param length Длина массива.
     * @param i Шаг.
     */
    static void heapify(int[] array, int length, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;

        if (leftChild < length && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        if (rightChild < length && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, length, largest);
        }
    }

    /**
     * Сортировка пирамидой.
     * @param array Массив чисел, который необходимо отсортировать.
     */
    public static void heapSort(int[] array) {
        if (array.length == 0) return;

        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--)
            heapify(array, length, i);

        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }
}