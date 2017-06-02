package leetcode.tree;

import java.util.HashSet;

/**
 * Created by joshua.chi on 6/2/17.
 */
public class DistanceBetween2Nodes {
    public int distance(int[] ary, int startIndex, int target, int distance, HashSet<Integer> visited) {
        if (ary[startIndex] == target) {
            return distance;
        }

        int length = ary.length;
        if (startIndex < 0 || startIndex >= length) {
            return -1;
        }

        if (visited.contains(startIndex)) {
            return -1;
        }

        visited.add(startIndex);

        if (hasLeft(startIndex, length)) {
            int leftDistance = distance(ary, getLeftIndex(startIndex), target, distance + 1, visited);
            if (leftDistance != -1) {
                return leftDistance;
            }
        }

        if ( hasRight(startIndex, length) ) {
            int rightDistance = distance(ary, getRightIndex(startIndex), target, distance + 1, visited);
            if (rightDistance != -1) {
                return rightDistance;
            }
        }

        if (hasParent(startIndex, length)) {
            int parentDistance = distance(ary, getParentIndex(startIndex), target, distance + 1, visited);
            if (parentDistance != -1) {
                return parentDistance;
            }
        }

        return -1;

    }

    private int getLeftIndex(int startIndex) {
        return 2*startIndex+1;
    }
    private int getRightIndex(int startIndex) {
        return 2 * (startIndex+1);
    }
    private int getParentIndex(int startIndex) {
        return (startIndex-1)/2;
    }
    private boolean hasParent(int startIndex, int len) {
        int index = (startIndex-1)/2;
        if (index < 0 || index >= len) {
            return false;
        }
        return true;
    }
    private boolean hasLeft(int startIndex, int len) {
        int index = 2*startIndex+1;
        if (index < 0 || index >= len) {
            return false;
        }
        return true;
    }
    private boolean hasRight(int startIndex, int len) {
        int index = 2 * (startIndex+1);
        if (index < 0 || index >= len) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        DistanceBetween2Nodes distanceBetween2Nodes = new DistanceBetween2Nodes();
        int[] ary = new int[]{1,2,3,4,5,6,7};
        HashSet<Integer> visited = new HashSet<>();
        int d = distanceBetween2Nodes.distance(ary, 3, 6, 0, visited);
        System.out.println(d);
    }
}
