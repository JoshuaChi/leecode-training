package leetcode.heap;

import java.util.Scanner;

/**
 * Created by joshua.chi on 5/19/17.
 */
public class MinHeap extends Heap {

    public void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);

            if(    hasRightChild(index)
                    && rightChild(index) < leftChild(index)
                    ) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if(items[index] < items[smallerChildIndex]) {
                break;
            }
            else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    public void heapifyUp() {
        int index = size - 1;

        while(    hasParent(index)
                &&   parent(index) > items[index]
                ) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int range = scanner.nextInt();
        scanner.close();

        // Insert random values into heaps:
        Heap minHeap = new MinHeap();
        Heap maxHeap = new MaxHeap();
        System.out.println("Insert Number Sequence:");
        for(int i = 0; i < range; i++) {
            int value = (int) (Math.random() * 100);
            minHeap.add(value);
            maxHeap.add(value);
            System.out.print(+ value + " ");
        }

        // Remove values from heaps:
        System.out.println("\n\nPoll Values:\n------------\nMinHeap MaxHeap");
        for(int i = 0; i < range; i++) {
            System.out.format("  %-12d", minHeap.poll());
            System.out.format("%-6d\n", maxHeap.poll());
        }
        try {
            minHeap.peek();
        }
        catch(IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        try {
            maxHeap.poll();
        }
        catch(IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }
}
