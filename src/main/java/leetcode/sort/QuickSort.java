package leetcode.sort;

import java.util.*;

/**
 * Created by Joshua on 5/13/17.
 */
public class QuickSort<Player> implements Comparator<Player> {
    public int compare(Player o1, Player o2) {
        return 0;
    }
//    public QuickSort(Player[] players) {
//
//        quickSort(players, 0, players.length-1, players.length/2);
//    }
//
//    private void quickSort(Player[] players, int left, int right, int pivot) {
//        while (left < right) {
//
//            while(compare(players[pivot], players[left]) > 0) {
//                left++;
//            }
//            while(compare(players[right], players[pivot]) > 0) {
//                right--;
//            }
//            if (compare(players[right], players[left]) > 0) {
//                swap(players, left, right);
//            }
//
//            quickSort(players, 0, pivot-1, (pivot-1)/2);
//            quickSort(players, pivot, players.length, (players.length - pivot)/2);
//
//        }
//
//    }
//
//    private void swap(Player[] players, int left, int right) {
//        Player tmp = players[left];
//        players[left] = players[right];
//        players[right] = tmp;
//    }
//
//    public int compare(Player p1, Player p2){
//        if (p1.score == p2.score ) {
//            return p1.name.compareTo(p2.name);
//        }
//        else {
//            return p2.score - p1.score;
//        }
//    }
//
//    public void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//
//        Player[] player = new Player[n];
//
//        for(int i = 0; i < n; i++){
//            player[i] = new Player(scan.next(), scan.nextInt());
//        }
//        scan.close();
//
//        Arrays.sort(player, checker);
//        for(int i = 0; i < player.length; i++){
//            System.out.printf("%s %s\n", player[i].name, player[i].score);
//        }
//    }
}