package leetcode;

/**
 * Created by Joshua.Chi <joshua.chi@akqa.com>
 *
 * @author joshua.chi
 * @date 5/8/17
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a = { 3, 2, 1, 5, 6, 4 };
        System.out.println(findKthLargest(a, 1));
        int[] b = { -1,2,0};
        System.out.println(findKthLargest(b, 3));
        int[] c = { 3,1,5,7,2};
        System.out.println(findKthLargest(c, 2));

    }

    public static void swapTail(int[] nums, int pos1, int pos2) {
        if (pos1 > -1 && pos1 < nums.length && pos2 > -1 && pos2 < nums.length) {
            int tmp = nums[pos1];
            nums[pos1] = nums[pos2];
            nums[pos2] = tmp;
        }
    }
    public static int findKthLargest(int[] nums, int k) {
//        if (find(nums, k)) return -1;
        for(int i=0;i<nums.length;i++) {
            find(nums, i);
        }
//        logAry(nums);
        return nums[nums.length - k];

    }

    private static boolean find(int[] nums, int index) {
//        System.out.println(".");
//        logAry(nums);
        final int length = nums.length;
        //validation
        if (index > length) {
            return true;
        }

        //we only sort none-leaves nodes in b-tree
        final int end = length / 2 - 1 - index;
        for (int i = 0; i < end; i++) {
            sortTreeDesc(nums, i, length-index);
        }
        for (int i = end; i < length-index; i++) {
            sortTreeAsc(nums, i);
        }
        //We assume the tree has been sorted correctly
        //We will sort array by switching root with last leave of the tree;
//        System.out.println("..");
//        logAry(nums);
        sortArray(nums, index);
//        System.out.println("...");
//        logAry(nums);
        return false;
    }

    private static void logAry(int[] nums) {
        System.out.println("---");
        for (int i = 0; i< nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println("\n---");
    }

    private static void sortArray(int[] nums, int index) {
        final int len = nums.length;
        final int last = len - index - 1;
        if (last > 0) {
            swap(nums, 0, last);
        }

    }


    public static void sortTreeDesc(int[] items, int i, int end) {
        int left = 2*i + 1;
        int right = 2*(i+1);
//        System.out.println("left: " + left + "; right: "+ right + "; end: " + end);
        int max = i;
        if (left < end && items[max] < items[left]) {
            swap(items, max, left);
            max = left;
        }

        if (right < end && items[max] < items[right]) {
            swap(items, max, right);
            max = right;
            sortTreeDesc(items, max, end);
        }
    }

    public static void sortTreeAsc(int[] items, int i) {
        int parent = (i - 1) / 2;

        if (i == parent) {
            return;
        }

        int max = i;
        //if current node is bigger than parent, switch
        //otherwise, sort with it's parent
        if (parent >= 0 && items[max] > items[parent]) {
            swap(items, max, parent);
        }
        sortTreeAsc(items, parent);

    }


    public static int findKthLargest2(int[] nums, int k) {
        int[] heap = new int[k];

        heap[0] = nums[0];
        for (int i = 1; i < k; i++) {
            siftUp(nums[i], heap, i);
        }

        for (int i = k; i < nums.length; i++) {
            siftDown(nums, k, heap, i);
        }

        return heap[0];
    }

    private static void siftDown(int[] nums, int k, int[] heap, int i) {
        if (nums[i] > heap[0]) {
            heap[0] = nums[i];
            int p = 0;
            while(p < k) {
                int minChild = 2 * p + 1;
                if(minChild + 1 < k && heap[minChild] > heap[minChild + 1]) minChild ++;
                if(minChild < k && heap[p] > heap[minChild]) {
                    swap(heap, p, minChild);
                    p = minChild;
                } else break;
            }
        }
    }

    private static void siftUp(int num, int[] heap, int i) {
        int p = i;
        heap[i] = num;
        while (p != 0) {
            int parent = (p - 1) / 2;
            if (heap[parent] > heap[p]) {
                swap(heap, p, parent);
            }
            p = parent;
        }
    }

    private static void swap(int[] heap, int p, int parent) {
        int temp = heap[parent];
        heap[parent] = heap[p];
        heap[p] = temp;
    }
}
