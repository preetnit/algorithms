package com.algos.interview.amazon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;


public class PasswordStrength {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String password = bufferedReader.readLine();

        long result = PasswordStrength.findPasswordStrength(password);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    /*
     * Complete the 'findPasswordStrength' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts STRING password as parameter.
     *
     * test
     * t    te  tes tes
     * e    es  est
     * s    st
     * t
     * 4    6   6   3 = 19
     *
     * te
     * t te
     */

    public static long findPasswordStrength(String password) {
        if(password.isEmpty() || null == password)
            return 0;

        if(password.length()==1)
            return 1;

        long result = 0;
        Set set = new HashSet();
        for(int i=0; i<password.length(); i++) {
            for(int j=i; j<password.length(); j++) {
                char ch = password.charAt(j);
                set.add(ch);
                System.out.println("-->"+set);
                result+=set.size();
            }
            set.clear();
        }
        return result;
    }
}
