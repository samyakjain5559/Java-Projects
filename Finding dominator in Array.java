// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int len = 0;
        int [] index = new int[A.length];
        int t = 0;
        for(int i = 0; i<A.length; i++){
           for(int i2 =0; i2<A.length; i2++){
               if(A[i] == A[i2]){
                   len = len+1;
                   index[t] = i2;
                   t = t +1;
               }
           }
           if(len < A.length/2){
                len = 0;
                for(int i3 =0; i3<index.length ; i3++){
                     index[i3] = 0;
                }
                t = 0;
           }else{
               break;
           }
           
        }
        return index[0];
    }
}