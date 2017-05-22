package leetcode.sort;

import leetcode.sort.quick.MinHeap;

/**
 * Created by joshua.chi on 5/22/17.
 */
public class AllSortAlgorithms {
    /**
     * Simulate algorithm from below:
     *  https://www.youtube.com/watch?v=ywWBy6J5gz8
     */
    public static void quickSort(int[] nums, int startIndex, int endIndex, int[] counter) {

        if (startIndex >= endIndex) {
            return;
        }

        int wallIndex = startIndex;
        int cursor = endIndex;
        while (wallIndex != cursor) {
            int compare = nums[wallIndex];
            int cursorValue = nums[cursor];
            if ( (wallIndex < cursor && compare > cursorValue) ||
                    (wallIndex > cursor && compare < cursorValue)) {
                swap(nums, wallIndex, cursor);

                int tmp = wallIndex;
                wallIndex = cursor;
                cursor = tmp;
            }
            if (wallIndex < cursor) {
                cursor--;
            }
            else {
                cursor++;
            }
            counter[0] += 1;
        }
        quickSort(nums, startIndex, wallIndex, counter);
        quickSort(nums, wallIndex+1, endIndex, counter);
    }

    public static void bubbleSort(int[] nums, int[] counter) {
        for (int i=0; i<nums.length ;i++) {
            for (int j=i+1; j<nums.length; j++) {
                int target = nums[i];
                if (nums[j] < target) {
                    swap(nums, i, j);
                }
                counter[0] += 1;
            }
        }

    }

    public static void mergeSort(int[] nums, int start, int end, int[] counter) {
        if (start >= end) {
            return;
        }
        int mid = start + (end-start)/2;
        //step1: sort;
        mergeSort(nums, start, mid, counter);
        mergeSort(nums, mid+1, end, counter);
        //step2: merge
        merge(nums, start, mid, end, counter);
    }


    public static void heapSort(int[] nums, int[] counter) {
        MinHeap minHeap = new MinHeap(nums.length, counter);

        int[] r = new int[nums.length];
        for (int i=0; i< nums.length;i++) {
            minHeap.add(nums[i]);
        }
        for (int i=0; i< nums.length;i++) {
            r[i] = minHeap.pop();
            counter[0] += 1;
        }
        System.arraycopy(r, 0, nums, 0, nums.length);
    }

    private static void merge(int[] nums, int start, int mid, int end, int[] counter) {
        int len = end - start + 1;
        int[] r = new int[len];
        int i=start;
        int j=mid+1;
        int count = 0;
        while(i < mid+1 && j < end+1) {

            if (nums[i] < nums[j]) {
                r[count] = nums[i];
                i++;
            }
            else {
                r[count] = nums[j];
                j++;
            }
            count++;
            counter[0] += 1;
        }
        while (i < mid+1) {
            r[count] = nums[i];
            i++;
            count++;
            counter[0] += 1;
        }

        while (j < end+1) {
            r[count] = nums[j];
            j++;
            count++;
            counter[0] += 1;
        }

        System.arraycopy(r, 0, nums, start, len);

    }

    /**
     * similar bubble sort
     * @param nums
     * @param wallIndex
     * @param rightEndIndex
     */
    public static void sort(int[] nums, int wallIndex, int rightEndIndex) {
        if (wallIndex >= rightEndIndex) {
            return;
        }

        int count = 0;

        for (int i = wallIndex; i < nums.length; i++) {
            int rightIndex = rightEndIndex;
            while (i < rightIndex) {
                int wall = nums[i];
                int right = nums[rightIndex];

                if (wall > right) {
                    swap(nums, i, rightIndex); // now wallIndex has smallest value in the compared values;
                }

                rightIndex --;
                count++;
            }
        }

        System.out.println(count + " times!");
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{3,0,1,8,7,2,5,4,9,6};
        sort(nums, 0, nums.length-1);
        System.out.println(" ");
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println(" ======== quick sort ========== ");
        nums = new int[]{3,0,1,8,7,2,5,4,9,6};
        int[] counter = new int[]{0};
        quickSort(nums, 0, nums.length-1, counter);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println("  ======== bubble sort ==========  ");
        System.out.println(counter[0]+ " times!");

        nums = new int[]{3,0,1,8,7,2,5,4,9,6};
        counter = new int[]{0};
        bubbleSort(nums, counter);
        System.out.println(" ");
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(" ");
        System.out.println(counter[0]+ " times!");

        System.out.println("  ======== merge sort ==========  ");
        nums = new int[]{3,0,1,8,7,2,5,4,9,6};
        counter = new int[]{0};
        mergeSort(nums, 0, nums.length-1, counter);
        System.out.println(" ");
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(" ");
        System.out.println(counter[0]+ " times!");


        System.out.println("  ======== heap sort ==========  ");
        nums = new int[]{3,0,1,8,7,2,5,4,9,6};
        counter = new int[]{0};
        heapSort(nums, counter);
        System.out.println(" ");
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(" ");
        System.out.println(counter[0]+ " times!");
    }
}
