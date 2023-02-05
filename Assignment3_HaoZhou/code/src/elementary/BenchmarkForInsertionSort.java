package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.util.Timer;

import java.util.Arrays;

public class BenchmarkForInsertionSort {
    public static void main(String[] args) {
        InsertionSort insert = new InsertionSort();
        for( int n=1000;n<=16000;n*=2) {
            //randomArray
            Comparable[] randA = new Comparable[n];
            for (int i = 0; i < randA.length; i++) {
                randA[i] = ((int) (Math.random() * n));
            }
            //orderedArray
            Comparable[] ordA = new Comparable[n];
            for (int i = 0; i < randA.length; i++) {
                ordA[i] = ((int) (Math.random() * n));
            }
            Arrays.sort(ordA);
            //partiallyArray
            Comparable[] partA = new Comparable[n];
            for (int i = 0; i < ordA.length / 2; i++) {
                partA[i] = ordA[i];
            }
            for (int i = randA.length / 2; i < ordA.length; i++) {
                partA[i] = randA[i];
            }
            //reverseArray
            Comparable[] reverseA = new Comparable[n];
            for (int i = ordA.length - 1; i >= 0; i--) {
                reverseA[ordA.length - i - 1] = ordA[i];
            }

            Timer timer = new Timer();
            final int tem = 20;
            final double ranTime = timer.repeat(100, () -> tem, t -> {
                insert.sort(randA, 0, randA.length - 1);
                return null;
            });
            final double sortTime = timer.repeat(100, () -> tem, t -> {
                insert.sort(ordA, 0, ordA.length - 1);
                return null;
            });
            final double partTime = timer.repeat(100, () -> tem, t -> {
                insert.sort(partA, 0, partA.length - 1);
                return null;
            });
            final double reverseTime = timer.repeat(100, () -> tem, t -> {
                insert.sort(reverseA, 0, reverseA.length - 1);
                return null;
            });
            System.out.println("when N is : "+n);
            System.out.println("The insertion sort time of a random array is " + ranTime);
            System.out.println("The insertion sort time of an ordered array is " + sortTime);
            System.out.println("The insertion sort time of an partially-ordered array is " + partTime);
            System.out.println("The insertion sort time of an reverse-ordered array is " + reverseTime);
        }
    }
}
