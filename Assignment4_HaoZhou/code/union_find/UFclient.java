package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UFclient {
    public static int[] RandomPair(int n) {
        Random r = new Random();
        int a = r.nextInt(n);
        int b = r.nextInt(n);
        return new int[]{a, b};
    }

    public static int Count(int n) {
        int ConnectionCount = 0;
        for (int i = 0; i < 100; i++) {
            UF_HWQUPC uf = new UF_HWQUPC(n, true);
            int count = 0;
            while (uf.components() > 1) {
                int[] random = RandomPair(n);
                if (!uf.connected(random[0], random[1])) uf.union(random[0], random[1]);
                count++;
            }
            ConnectionCount += count;
        }
        return  (ConnectionCount / 100);
    }



    public static void main(String[] args) {
        for (int n = 100, m = 10; m > 0; n *= 2, m--) {
            int result = Count(n);
            System.out.println("when n is "+ n +", count is "+ result );
        }
    }

}
