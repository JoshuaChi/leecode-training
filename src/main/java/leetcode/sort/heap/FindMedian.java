package leetcode.sort.heap;

/**
 * Created by Joshua on 5/20/17.
 */

import java.util.Arrays;
import java.util.Scanner;

public class FindMedian {

    public static abstract class Heap {
        int size = 0;
        int[] nums;
        int capility = 100;
        public Heap() {
            nums = new int[this.capility];
        }

        public void add(int i) {
            if (size >= capility) {
                nums = Arrays.copyOf(nums, nums.length + capility);
            }
            nums[size] = i;
            up(size);
            size++;
        }

        public int peek() {
            return nums[0];
        }

        public int pop() {
            int top = nums[0];
            nums[0] = nums[size-1];
            size--;
            down(0);
            return top;
        }

        public int size() {
            return size;
        }

        public void swap(int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        public boolean isEmpty() {
            return size==0;
        }

        public abstract void up(int i);
        public abstract void down(int i);

    }

    public static class MaxHeap extends Heap {
        public void up(int i) {
            int parent = (i-1)/2;
            if (parent < 0) {
                return;
            }
            if (nums[parent] < nums[i]) {
                swap(parent, i);
                up(parent);
            }
        }

        public void down(int i) {
            int left = 2*i+1;
            int right = 2*(i+1);
            if (left < size) {
                int max = i;
                if (nums[left] > nums[i]) {
                    swap(left, i);
                    max = left;
                }
                if (right<size && nums[right] > nums[i]) {
                    swap(right, i);
                    max = right;
                }
                if (max != i) {
                    down(max);
                }
            }
        }
    }

    public static class MinHeap extends Heap {
        public void up(int i) {
            int parent = (i-1)/2;
            if (parent < 0) {
                return;
            }
            if (nums[parent] > nums[i]) {
                swap(parent, i);
                up(parent);
            }
        }

        public void down(int i) {
            int left = 2*i+1;
            int right = 2*(i+1);
            if (left < size) {
                int min = i;
                if (nums[left] < nums[i]) {
                    swap(left, i);
                    min = left;
                }
                if (right<size && nums[right] < nums[i]) {
                    swap(right, i);
                    min = right;
                }
                if (min != i) {
                    down(min);
                }
            }
        }

    }

    public static void reBalance(int[] a, int a_i, MinHeap min, MaxHeap max) {
        if (min.isEmpty()) {
            min.add(a[a_i]);
        }
        else {
            if (max.isEmpty()) {
                int minTop = min.pop();
                if (minTop < a[a_i]) {
                    min.add(a[a_i]);
                    max.add(minTop);
                }
                else {
                    max.add(a[a_i]);
                    min.add(minTop);
                }

            }
            else {
                if (min.size() > max.size()) {
                    int minTop = min.pop();
                    if (a[a_i] < minTop) {
                        //min: 7,9,10,11 max:5,4,3 v:6
                        min.add(minTop);
                        max.add(a[a_i]);
                    }
                    else {
                        //min: 7,9,10,11 max:5,4,3 v:8
                        min.add(a[a_i]);
                        max.add(minTop);
                    }
                }
                else if(min.size() == max.size()) {
                    int minTop = min.pop();
                    int maxTop = max.pop();
                    if (a[a_i] < minTop) {
                        if (a[a_i] < maxTop) {
                            //min: 7,9,10,11 max:5,4,3,2 v:1
                            min.add(minTop);
                            min.add(maxTop);
                            max.add(a[a_i]);
                        }
                        else {
                            //min: 7,9,10,11 max:5,4,3,2 v:6
                            min.add(minTop);
                            min.add(a[a_i]);
                            max.add(maxTop);
                        }
                    }
                    else {
                        //min: 7,9,10,11 max:5,4,3,2 v:8
                        min.add(a[a_i]);
                        min.add(minTop);
                        max.add(maxTop);
                    }
                }
                else {
                    int maxTop = max.pop();
                    if (a[a_i] < maxTop) {
                        //min: 7,9,10 max:5,4,3,2 v:1
                        min.add(maxTop);
                        max.add(a[a_i]);
                    }
                    else {
                        //min: 7,9,10 max:5,4,3,2 v:6
                        min.add(a[a_i]);
                        max.add(maxTop);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n]; //O(n) space
        MinHeap min = new MinHeap();
        MaxHeap max = new MaxHeap();
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            reBalance(a, a_i, min, max); //n*log(n)
            int sizeMin = min.size();
            int sizeMax = max.size();
            int minTop = min.peek(); // O(n/2) space
            int maxTop = max.peek(); // O(n/2) space
            System.out.println("minTop:"+minTop+"; maxTop:"+maxTop+".");
            if (sizeMin == sizeMax) {
                System.out.println(String.format("%.1f", ((double)minTop + (double)maxTop)/2));
            }
            else {
                System.out.println(String.format("%.1f", (double)minTop));
            }
        }
    }
}

