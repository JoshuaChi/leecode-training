package leetcode.heap.exercises;

import java.util.Scanner;
import leetcode.heap.*;

/**
 * Created by Joshua.Chi <joshua.chi@akqa.com>
 *
 * @author joshua.chi
 * @date 5/12/17
 */
public class RunningMedianV2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            reOrganize(a[a_i]);
            Double average = (minHeap.size() == maxHeap.size()) ?
                    (Double.valueOf(minHeap.peek()) + Double.valueOf(maxHeap.peek())) / 2 : Double.valueOf(minHeap.peek());
            System.out.println(String.format("%.1f", average));
        }
    }

    private static void reOrganize(int item) {
        if (minHeap.isEmpty()){
            minHeap.add(item);
        }
        else {
            if (maxHeap.isEmpty()) {
                int minRoot = minHeap.poll();
                if (minRoot < item) {
                    maxHeap.add(minRoot);
                    minHeap.add(item);
                }
                else {
                    maxHeap.add(item);
                    minHeap.add(minRoot);
                }
            }
            else {
                int minLen = minHeap.size();
                int maxLen = maxHeap.size();
                int minRoot = minHeap.poll();
                if (minLen == maxLen) {
                    int maxRoot = maxHeap.poll();
                    //minHeap: [7,8,9,10]; maxHeap: [1,2,3,5], item:6
                    if (maxRoot < item) {
                        minHeap.add(minRoot);
                        minHeap.add(item);
                        maxHeap.add(maxRoot);
                    }
                    else {
                        minHeap.add(minRoot);
                        minHeap.add(maxRoot);
                        maxHeap.add(item);
                    }
                }
                else if (minLen > maxLen) {
                    //if new added number is smaller than minheap
                    //minHeap: [7,8,9,10,11]; maxHeap: [1,2,3,4], item:6
                    if (minRoot > item) {
                        minHeap.add(minRoot);
                        maxHeap.add(item);
                    }
                    else {
                        //minHeap: [7,8,9,10,11]; maxHeap: [1,2,3,4], item:12
                        minHeap.add(item);
                        maxHeap.add(minRoot);
                    }
                }
                else {
                    //minHeap: [7,8,9]; maxHeap: [1,2,3,5], item:4
                    int maxRoot = maxHeap.poll();
                    if (maxRoot > item) {
                        minHeap.add(maxRoot);
                        maxHeap.add(item);
                    }
                    else {
                        //minHeap: [7,8,9]; maxHeap: [1,2,3,5], item:6
                        minHeap.add(item);
                        maxHeap.add(maxRoot);
                    }
                }
            }
        }

    }

    //max heap keeps half of the smaller values
    private static MaxHeap maxHeap = new MaxHeap();
    //min heap keeps half of the bigger values
    private static MinHeap minHeap = new MinHeap();

}
