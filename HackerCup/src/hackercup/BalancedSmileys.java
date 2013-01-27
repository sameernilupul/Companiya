/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hackercup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author sameernilupul
 */
public class BalancedSmileys {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("/Users/sameernilupul/Desktop/hackcup/input.txt"));

        int no = Integer.parseInt(in.readLine());
        boolean balanced = false;
        for (int i = 0; i < no; i++) {
            String s = in.readLine();
            //System.out.println(s);
            //System.out.println(balanced(s));
            //System.out.println("Faces ="+countFaces(s));
            //int faces = countFaces(s);
            if (balanced(s)) {
                System.out.println("Case #"+(i+1)+": YES");
            } else {
                while(hasFaces(s)) {
                    s = removeEyes(s);
                    //System.out.println(" s ="+s);
                    if(balanced(s)){
                        System.out.println("Case #"+(i+1)+": YES.");
                        balanced = true;
                        break;
                    }
                }
                if(!balanced){
                    System.out.println("Case #"+(i+1)+": NO");
                }
            }
            balanced = false;

            //System.out.println("");
        }
        
    }

    static boolean balanced(String s) {
        
        char[] str = s.toCharArray();

        int count = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                count++;
            } else if (str[i] == ')') {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }

        if (count < 0) {
            return false;
        } else if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    static String removeEyes(String s) {
        char[] str = s.toCharArray();

        for (int i = 0; i < str.length; i++) {
            if (str[i] == ':') {
                if (i + 1 < str.length && (str[i + 1] == '(' || str[i + 1] == ')')) {
                    return remove(str, i, 'R');
                }
            }
        }
        return s;


    }

    static String remove(char[] arr, int index, char c) {
        //c == L left
        //c == R right
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            if (c == 'L') {
                if (i == index - 1 || i == index) {
                    continue;
                } else {
                    s += Character.toString(arr[i]);
                }
            } else if (c == 'R') {
                if (i == index + 1 || i == index) {
                    continue;
                } else {
                    s += Character.toString(arr[i]);
                }
            }
        }
        return s;
    }

    static boolean hasFaces(String s) {
        char[] str = s.toCharArray();

        for (int i = 0; i < str.length; i++) {
            if (str[i] == ':') {
                if (i + 1 < str.length && (str[i + 1] == '(' || str[i + 1] == ')')) {
                    return true;
                }
            }
        }

        return false;

    }
}
