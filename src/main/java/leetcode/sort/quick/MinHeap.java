package leetcode.sort.quick;

/**
 * Created by joshua.chi on 5/22/17.
 */
public class MinHeap {
    int[] elements;
    int size;
    int capability;
    int[] counter;

    public MinHeap(int c, int[] counter) {
        this.capability = c;
        this.size = 0;
        this.counter = counter;
        elements  = new int[this.capability];
    }

    public void add(int e) {
        elements[this.size] = e;
        counter[0] += 1;
        up(this.size);
//        heapifyUp();
        this.size++;
    }

    private void up(int index) {
        while(index >= 0) {
            boolean hasSwap = false;
            int parent = (index -1 )/2;
            if(index != parent && parent >=0 && elements[parent] > elements[index]) {
                counter[0] += 1;
                swap(parent, index);
                hasSwap = true;
            }
            index = parent;

            if (false == hasSwap) {
                break;
            }
        }
    }

    public boolean isEmpty() {
        return this.size==0;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        counter[0] += 1;
        int top = elements[0];
        elements[0] = elements[size-1];
        elements[size-1] = -1;
        this.size--;
//        down(0);
        heapifyDown();
        return top;
    }

    private void down(int index) {
        while (index < size) {
            int left = 2*index + 1;
            int right = 2*(index + 1);

            boolean hasSwap = false;
            int max = index;

            if (left < size && elements[index] > elements[left]) {
                swap(index, left);
                counter[0] += 1;
                max = left;
                hasSwap = true;
            }

            if (right < size && elements[index] > elements[right]) {
                swap(index, right);
                counter[0] += 1;
                max = right;
                hasSwap = true;
            }

            index = max;
            if (false == hasSwap) {
                break;
            }
        }
    }

    public void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);

            if(    hasRightChild(index)
                    && rightChild(index) < leftChild(index)
                    ) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if(elements[index] < elements[smallerChildIndex]) {
                break;
            }
            else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    private int rightChild(int index) {
        return elements[getRightChildIndex(index)];
    }

    private int leftChild(int index) {

        return elements[getLeftChildIndex(index)];

    }

    private int getRightChildIndex(int index) {
        return 2* (index + 1);
    }

    private int getLeftChildIndex(int index) {
        return 2*index + 1;
    }

    private boolean hasRightChild(int index) {
        int right = 2* (index + 1);
        return right < size;
    }

    private boolean hasLeftChild(int index) {
        int left = 2*index + 1;
        return left < size;
    }

    public void heapifyUp() {
        int index = size - 1;

        while(hasParent(index)
                &&   parent(index) > elements[index]
                ) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private int parent(int index) {
        return elements[getParentIndex(index)];
    }

    private int getParentIndex(int index) {
        return (index -1 )/2;
    }

    private boolean hasParent(int index) {
        int parent = (index -1 )/2;
        return parent >=0;
    }

    private void swap(int parent, int index) {
        int tmp = elements[parent];
        elements[parent] = elements[index];
        elements[index] = tmp;
    }

}
