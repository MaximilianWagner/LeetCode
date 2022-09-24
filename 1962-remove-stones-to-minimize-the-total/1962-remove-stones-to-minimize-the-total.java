import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int count = 0;
        
        for (int pile : piles) {
            pq.add(pile);
            count += pile;
        }


        for(int i = 0; i < k; i++) {
            int x = pq.poll();
            int sub = x / 2;
            pq.add(x - sub);
            count -= sub;
        }

        return count;
    }
}