package com.spring.hibernate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Try1 {
    public static void main(String args[]){
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(0);
        arr.add(1);
        arr.add(1);
        arr.add(0);
        List<Integer> result = getMaxArray(arr);
        for(int i=0; i<result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
    }

        public static List<Integer> getMaxArray(List<Integer> arr) {
            List<Integer> result = new ArrayList<Integer>(); // Initialize an empty result list
            int n = arr.size();
            while (n > 0) { // Repeat until the list arr is empty
                int k = 2;
                
                
                
                result.add(getMex(arr.subList(0, k))); // Append the MEX of the first k elements of arr to the result list
                arr.subList(0, k).clear(); // Remove the first k elements of arr
                n -= k;
            }
            return result;
        }

        private static int getMex(List<Integer> arr) { // Helper function to compute the MEX of a list
            Set<Integer> set = new HashSet<Integer>();
            for (int num : arr) {
                set.add(num);
            }
            int mex = 0;
            while (set.contains(mex)) {
                mex++;
            }
            return mex;
        }
}
