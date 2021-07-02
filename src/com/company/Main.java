package com.company;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double startTime = System.currentTimeMillis();
        {
            // WeirdAlgorithm();
            //int count = MissingNumber();

            int count1 = Repeat("ATTCGGGA");
            System.out.println(count1);
        }

        double time = ( System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Time :" + time);
    }

    public static void WeirdAlgorithm(){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        while (n != 1){

            System.out.print(n + " -> ");

            if (n % 2 == 0)
                n /= 2;
            else
                n = (n * 3) + 1;
        }
    }
    public static int MissingNumber() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];

        for (int i = 1; i < nums.length; i++) {
            System.out.printf("array[%d] = ", i);
            nums[i] = in.nextInt();
        }

        int first = 0;
        int last = nums.length - 1;

        quickSort(nums, first, last);

        for (int i = 1; i < nums.length; i++) {
            if (i != nums[i])
                return i;
        }

        int count = binarySearch(nums, first, last, 2);
        System.out.println(count);

    return -1;
    }
    public static int Repeat(String s){

        char[] str = s.toCharArray();
        int i, j, g = 0;
        int[] arrayMax = new int[10];

        for(i = 0; i < str.length; i++){
            for (j = 0; j < str.length; j++){
                if (str[i] == str[j])
                    arrayMax[i] += g++;
                else
                    g = 0;

            }
        }

       return Arrays.stream(arrayMax).max().orElse(-1);

    }




// Sort Algorithms
    public static void quickSort(int[] array, int low, int high)
        {

            if(array.length == 0)
                return;

            if (low >= high)
                return;

            int middle = low + (high - low) / 2;
            int opora = array[middle];
            int i = low, j = high;

            while (i <= j){
                while (array[i] < middle)
                    i++;
                while (array[j] > middle)
                    j--;

                if (i <= j){

                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;

                    i++;
                    j--;
                }
            }

            if (low < j)
                quickSort(array, low, j);

            if (high > i)
                quickSort(array, i, high);



        }
//Search Algorithms
    public static int binarySearch(int[] array, int low, int high,int  target){

        while (low <= high){
            int middle = (low + high) / 2;
            if (array[middle] == target)
                return middle;

            else if (array[middle] < target)
                low = middle + 1;

            else if (array[middle] > target)
                high = middle - 1;

        }

        return -1;
    }

    }
