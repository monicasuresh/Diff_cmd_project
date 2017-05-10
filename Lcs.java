import java.util.*;
import java.io.*;

public class Lcs {

    //retreiving the max of 2 num
    public static int maxi(int m, int n) {

        if (m > n) {
            return m;
        } else if (m < n) {
            return n;
        } else {
            return m;
        }

    }// maxi

    //processing lcs
    public static void processLcs(String p, String k, int l1, int l2) throws IOException {

        int len = 0;
        char[] m = p.toCharArray();
        char[] n = k.toCharArray();
        int c[][] = new int[100][100];
        for (int j = 0; j <= l2; j++) {
            for (int i = 0; i <= l1; i++) {
                c[j][i] = 0;
            }
        }

        for (int j = 0; j < l1; j++) {
            for (int i = 0; i < l2; i++) {

                if (m[j] != n[i]) {
                    if ((j == 0) && (i == 0)) {
                        c[j][i] = 0;
                    } else if ((j == 0)) {
                        c[j][i] = maxi(c[j][i - 1], 0);
                    } else if ((i == 0)) {
                        c[j][i] = maxi(0, c[j - 1][i]);
                    } else {
                        c[j][i] = maxi(c[j][i - 1], c[j - 1][i]);
                    }

                }// if 
                else {

                    if ((j == 0) && (i == 0)) {
                        c[j][i] = 1;
                    } else {
                        c[j][i] = c[j - 1][i - 1] + 1;
                    }

                }// else if

                len = c[j][i];

            }//for 2

        }//for 1

        //System.out.println("Length of Longest Common subsequence is " + len);
        display(len,l1,l2,p,k);

    }//processLcs
    
    //display whether not same string in same bucket
    public static void display(int len,int l1,int l2,String p,String k){
        
        if ((len == l1) && (len == l2)) {
            //System.out.println("same");
        } else {
            String[] w = p.split(" ", 2);
            String[] w1 = k.split(" ", 2);
            System.out.println("String is not matching from file1 and file2:");
            System.out.println("File 1 : " + w[1] + " in Line Number " + w[0]);
            System.out.println("File 2 : " + w1[1] + " in Line Number " + w1[0]);
        }
    }//display
    
    
}
