/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hackercup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Chameera {
    public static void main(String args[]) throws IOException {
        java.io.BufferedReader in=new java.io.BufferedReader(new java.io.FileReader("/Users/sameernilupul/Desktop/hackcup/input.txt"));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/sameernilupul/Desktop/hackcup/output.txt")));

        //java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));


        int n = Integer.parseInt(in.readLine());
        
        String s;
        for (int i = 0; i < n; i++) {
             s =in.readLine();
             int ans=0;
            for (int j = 0; j < s.length(); j++) {

                if(s.charAt(j)=='(' && j-1>=0 && s.charAt(j-1)!=':')
                {
                    ans++;
                }
                if(s.charAt(j)==')' && j-1>=0 && s.charAt(j-1)!=':')

                {
                    ans--;
                }
            }
            System.out.print("Case #" + (i + 1) + ": ");
            out.print("Case #" + (i + 1) + ": ");

            if(ans==0)
            {
                System.out.println("YES");
                out.println("YES");
            }
            else
            {
                System.out.println("NO");

                out.println("NO");
            }
        }
        out.close();
    }
    
}