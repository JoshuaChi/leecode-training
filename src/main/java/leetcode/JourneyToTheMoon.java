package leetcode;

/**
 * Created by Joshua on 5/9/17.
 */
import java.io.*;
import java.util.*;

public class JourneyToTheMoon {


    public static class Node {
        int data=-1;
        int parent=-1;
        int rank=0;
        public Node(int d, int parent) {
            this.data = d;
            this.parent = parent;

        }
        public void incr() {
            rank = rank + 1;
        }

        public void setParent(int parent) {
            this.parent = parent;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bfr.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int I = Integer.parseInt(temp[1]);


        HashMap<Integer, Node> numbers = new HashMap<Integer, Node>();



        for(int i = 0; i < I; i++){
            temp = bfr.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            int parentA = findParent(numbers, a);
            int parentB = findParent(numbers, b);
            Node aNode = new Node(a, (parentA==-1?a:parentA));
            Node bNode = new Node(b, (parentB==-1?parentA:parentB));

            numbers.put(aNode.parent, aNode);
            numbers.put(bNode.parent, bNode);


            Node bp = numbers.get(bNode.parent);
            bp.incr();


            if (aNode.parent != bNode.parent) {
                mergeTwoTree(aNode.parent, bNode.parent, numbers);
            }
        }

//        organize();
        long combinations = calculate(numbers);

        // Compute the final answer - the number of combinations

        System.out.println(combinations);

    }

    private static long calculate(HashMap<Integer, Node> numbers) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Iterator<Map.Entry<Integer, Node>> i = numbers.entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry<Integer, Node> next = i.next();
            Integer key = next.getKey();
            Node n = next.getValue();
            int p = n.parent;

            if(map.containsKey(p)) {
                Integer v = map.get(key);
                map.put(key, v+1);
            }else {
                map.put(key, 1);
            }
        }
        int[] ary = new int[map.size()];
        Iterator<Map.Entry<Integer, Integer>> ii = map.entrySet().iterator();
        int c = 0;
        while(ii.hasNext()) {
            Map.Entry<Integer, Integer> next = ii.next();
            int v = next.getValue();
            ary[]
        }


        return cal(map, 0);
    }

    public static int cal(HashMap<Integer, Integer> map, int index) {
        int data = 0;
        if (map.size() < 1 || index > (map.size()-1)) {
            return data;
        }
        int first = map.get(index);
        System.out.println(">>"+first);
        for (int i=index+1; i<map.size(); i++) {
            data += first * map.get(i);
        }
        return data + cal(map, index + 1);
    }


    private static void mergeTwoTree(int parentA, int parentB, HashMap<Integer, Node> numbers) {
        int parent1 = findParent(numbers, parentA);
        int parent2 = findParent(numbers, parentB);

        Node n1 = numbers.get(parent1);
        Node n2 = numbers.get(parent2);
        if (n1.rank >= n2.rank) {
            n2.setParent(n1.data);
            replaceWithNewParent(n2.data, n1.data, numbers);
            n1.incr();
        }
        else {
            n1.setParent(n2.data);
            replaceWithNewParent(n1.data, n2.data, numbers);
            n2.incr();
        }

    }

    private static void replaceWithNewParent(int oldParent, int newParent, HashMap<Integer, Node> numbers) {
        Iterator<Map.Entry<Integer, Node>> i = numbers.entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry<Integer, Node> next = i.next();
            Node n = next.getValue();
            if (n.parent == oldParent) {
                n.setParent(newParent);
            }
        }
    }

    /**
     * parent has its own data as parent;
     *
     * @param numbers
     * @param item
     * @return
     */
    public static int findParent(HashMap<Integer, Node> numbers, int item) {
        Node me = numbers.get(item);
        if (null == me) {
            return -1;
        }
        if (item == me.data) {
            return me.data;
        }
        int parentData = me.parent;
        if (me.parent == -1) {
            return parentData;
        }
        return findParent(numbers, parentData);

    }
}


