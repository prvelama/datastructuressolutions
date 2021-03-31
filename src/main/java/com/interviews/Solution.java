package main.java.com.interviews;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
        private Map<String,Integer> map;

        public Solution() {
            map = new HashMap<>();
            map.put("foo", 1);
            map.put("bar", 3);
        }




    public static void main(String args[]) throws Exception {
        Solution s = new Solution();
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("foo", 1);
        map.put("bar", 3);
        map.put("hello", 2);

        PriorityQueue<Map.Entry<String, Integer>> pqueue = new PriorityQueue<Map.Entry<String, Integer>>
                                ((a,b)->a.getValue()-b.getValue());
        for(Map.Entry<String, Integer> e:map.entrySet())
        {
            pqueue.add(e);
        }

        System.out.println(pqueue.poll().getValue());
        System.out.println(pqueue.poll());
        System.out.println(pqueue.poll());


        ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(1,3,2,4));
        ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        System.out.println(arr1.removeAll(arr2));
        System.out.println(arr1.size());

        //System.out.println(s.getValue("bar", 2));
        //System.out.println(s.getValue("baz", 0));
        //System.out.println("main");



    }
}
