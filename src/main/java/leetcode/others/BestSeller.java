package leetcode.others;

/**
 * Created by Joshua on 5/18/17.
 */
public class BestSeller {
    private int[] top50 = new int[50];

    public int[] getTop50Itesm() {

        return top50;
    }

    public void SellItem(String id, int num) {
        if(top50[stringIdToId(id)] > 0) {

        }

    }

    public int getItemRank(String id) {

        return -1;
    }

    public int stringIdToId(String id) {

        return 0;
    }

    public void sortAsc(int[] items) {

    }

    public static void main(String[] args) {

        int[] items = new int[]{
                1,
                2,
                3
        };
        System.out.println(items[3]);

    }
}
