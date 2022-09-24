import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int pile : piles) {
            pq.add(pile);
        }


        for(int i = 0; i < k; i++) {
            int x = pq.poll();
            pq.add(x - x / 2);
        }

        return pq.stream().reduce(0, Integer::sum);
    }
}