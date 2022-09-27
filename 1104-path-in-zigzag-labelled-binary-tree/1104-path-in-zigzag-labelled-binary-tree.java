class Solution {
    public List<Integer> pathInZigZagTree(int label) {

        List<Integer> res = new ArrayList<>();

        double x = (Math.log(label) / Math.log(2));
        int depth = (int) x;

        while(depth >= 1){

            res.add(0, label);

            int n = ((1 << (depth + 1)) - label - 1) / 2;

            if(depth % 2 == 0){
                label = (1 << (depth - 1)) + n;
            } else {
                label = (1 << (depth - 1)) + n;
            }
            depth--;

        }

        res.add(0, 1);

        return res;

    }
}