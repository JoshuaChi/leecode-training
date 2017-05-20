package leetcode.dp;

/**
 * Created by Joshua on 5/20/17.
 */
public class MinCoin {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextInt();
        int money = 11;
        int[] coins = new int[]{1,3,5};
        int[] result = new int[money+1];
        for (int i=0; i<=money; i++) {
            result[i] = -1;
        }
        int times = cal(coins, money, result);
        System.out.println(times);
    }

    public static int cal(int[] coins, int money, int[] result) {

        if (money == 0) {
            result[0] = 0;
            return 0;
        }

        int min = -1;
        for (int j=0; j<coins.length; j++) {
            final int leftMoney = money - coins[j];
            if (leftMoney >=0) {
                int times = 0;
                if (result[leftMoney] != -1) {
                    times = result[leftMoney];
                }
                times = cal(coins, leftMoney, result);
                if (min == -1) {
                    min = 1 + times;
                }
                else {
                    min = Math.min(min, 1 + times);
                }
            }
        }
        result[money] = min;
        return min;


    }
}
