package com.company.codeforces.C691.div2;

import java.io.*;

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int sum = n % 2 == 0 ? (n/2 +1)*(n/2 +1) : 2*(n/2 +1)*(n/2+2);

        pw.println(sum);

        br.close();
        pw.close();
    }
}
