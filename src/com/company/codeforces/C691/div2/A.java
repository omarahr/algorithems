package com.company.codeforces.C691.div2;

import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int tests = Integer.parseInt(br.readLine());

        while (tests-- > 0) {
            int size = Integer.parseInt(br.readLine());
            char[] rCards = br.readLine().toCharArray();
            char[] bCards = br.readLine().toCharArray();

            int counter = 0;
            for (int i = 0; i < size; i++) {
                if (rCards[i] > bCards[i]) {
                    counter++;
                } else if(rCards[i] < bCards[i]) {
                    counter--;
                }
            }

            if (counter > 0) {
                pw.println("RED");
            } else if (counter < 0) {
                pw.println("BLUE");
            } else {
                pw.println("EQUAL");
            }

        }

        br.close();
        pw.close();
    }



}
