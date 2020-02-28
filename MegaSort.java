/**
 * This program uses countSort to sort one million integers read from the file "1m-ints.txt"
 * @author marcus bradlee
 */

import java.util.*;
import java.io.*;

public class MegaSort {

    /**
     * The main function creates a file instance for "1m-ints.txt" and a scanner to
     * read this file. It creates a dataArray of 1000000 (size is hard coded).
     * It then reads the file and populates the dataArray so that this array contains
     * every integer in the file as an Int. It also creates an int max using the findMax()
     * function in order to create an indexArray of the max existing number in dataArray()
     * +1.
     * @param args
     * @throws FileNotFoundException
     */

    public static void main(String args[]) throws FileNotFoundException {
        File file = new File("1m-ints.txt");
        Scanner s = new Scanner(file);

        int dataArray[] = new int[1000000];
        int num;

        for(int i = 0; i < dataArray.length; i++){
            String numLine = s.nextLine();
            num = Integer.parseInt(numLine);
            dataArray[i] = num;
        }

        int max = findMax(dataArray);
        int indexArray[] = new int[max+1];

        countSort(dataArray, indexArray);
    }

    /**
     * This function first populates indexArray by looping through dataArray and adding 1 to the index
     * of indexArray equivalent to the value of dataArray. Then it loops through indexArray and prints
     * the index for every 1 in that index.
     * @param dataArray
     * @param indexArray
     */

    public static void countSort(int dataArray[], int indexArray[]){
        for(int i = 0; i < dataArray.length; i++){
            indexArray[dataArray[i]] += 1;
        }
        for(int i = 0; i < indexArray.length; i++){
            while(indexArray[i] > 0){
                System.out.println(i + "\n");
                indexArray[i] -= 1;
            }
        }
    }

    /**
     * This function finds and returns the greatest value that exists in a given array.
     * @param a
     * @return max, which is the greatest value that exists in the given array a.
     */

    public static int findMax(int a[]){
        int max = a[0];
        for(int i = 1; i < a.length; i++){
            if(max < a[i]){
                max = a[i];
            }
        }
        return max;
    }

}
