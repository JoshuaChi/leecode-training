package leetcode.heap;

/**
 * Created by joshua.chi on 5/19/17.
 */
public class MaxHeap extends Heap {

    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);

            if (hasRightChild(index)
                    && rightChild(index) > leftChild(index)
                    ) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] > items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    public void heapifyUp() {
        int index = size - 1;

        while (hasParent(index)
                && parent(index) < items[index]
                ) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }
}
