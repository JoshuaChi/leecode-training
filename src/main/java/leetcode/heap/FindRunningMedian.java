package leetcode.heap;

import java.util.Scanner;

/**
 * Created by Joshua on 6/11/17.
 */
public class FindRunningMedian {
    public static class MinHeap {
        int[] items;
        int size;
        public MinHeap(int n) {
            items = new int[n];
            size = 0;
        }

        public void add(int item) {
            items[size] = item;
            up(size);
            size++;
        }

        public int pop() {
            int r = items[0];
            items[0] = items[size-1];
            size--;
            down(0);
            return r;
        }
        public int peek() {
            return items[0];
        }

        public void up(int index) {
            while(index >=0) {
                int parent = (index-1)/2;
                if (index == parent) {
                    return;
                }
                if (items[index] < items[parent]) {
                    swap(index, parent);
                    index = parent;
                }
                else {
                    break;
                }
            }
            down(index);


        }

        public void down(int index) {
            while(index < size) {
                int left = 2*index+1;
                int right = 2*(index+1);

                //has both left and right
                if (left < size && right < size) {
                    if (items[right] < items[left]) {
                        if (items[index] > items[right]) {
                            swap(index, right);
                            index = right;
                        }
                        else {
                            break;
                        }
                    }
                    else {
                        if (items[index] >items[left]) {
                            swap(index, left);
                            index = left;
                        }
                        else {
                            break;
                        }
                    }
                }
                else if (left < size) { // has no right
                    if (items[index] > items[left]) {
                        swap(index, left);
                        index = left;
                    }
                    else {
                        break;
                    }
                }
                else if(right < size) {
                    if (items[index] > items[right]) {
                        swap(index, right);
                        index = right;
                    }
                    else {
                        break;
                    }
                }
                else {
                    return;
                }
            }
        }

        public void swap(int i, int j) {
            int t = items[i];
            items[i] = items[j];
            items[j] = t;
        }

        public int[] retrieveSortedArray() {
            int[] r = new int[size];
            int count = 0;
            while(size-1 >= 0) {
                r[count] = pop();
                count++;
            }
            return r;
        }


    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        MinHeap heap = new MinHeap(n);
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            heap.add(a[a_i]);
        }

        int[] r = heap.retrieveSortedArray();
        for (int i=1; i<=n; i++) {
            if (i%2 == 0) {
                System.out.println( ((double)r[i/2] + (double)r[i/2 - 1] )/2 );
            }
            else {
                System.out.println( (double)r[i/2] );
            }
        }
    }
}
