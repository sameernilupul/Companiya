/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hackercup;

import java.io.*;
import java.util.Arrays;

public class BeautifulStrings {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("/Users/sameernilupul/Desktop/hackcup/input.txt"));
        
        //BufferedWriter output = new BufferedWriter(new FileWriter("/Users/sameernilupul/Desktop/hackcup/output.txt"));
        int no = Integer.parseInt(in.readLine());
        for(int i=0;i<no;i++){
            System.out.println("Case #"+(i+1)+": "+beauty(in.readLine()));
        }
    }
    
    static int beauty(String s){
        char[] srt = s.toLowerCase().toCharArray();
        
        int beauty=0;
        
        int[] vals = new int[26];
        
        
        for(int i=0;i< srt.length;i++){
            if(!(srt[i]-96 >0 && srt[i]-96 <=26)){
                srt[i] = 255;
            }
        }
        Arrays.sort(srt);
        
       /* for(int k=0;k<srt.length;k++){
            System.out.print(srt[k]);
        }
        System.out.println("");*/
        
        if(srt[0] == 255)
            return 0;
        
        for(int i = 97; i<=122;i++){
            for(int j=0;j<srt.length;j++){
                if(srt[j]==255)
                    break;
                if(srt[j] ==i){
                    vals[i-97]++;
                }
            }
        }
        
        Arrays.sort(vals);
        for(int j=25;j>=0;j--){
            beauty += vals[j]*(j+1);
        }
        //System.out.println("");
        return beauty;
    }
}
