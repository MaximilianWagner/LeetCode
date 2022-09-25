class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(Character c: s.toCharArray()){
            map.computeIfPresent(c, (key, val) -> val + 1);
            map.computeIfAbsent(c, (key) -> 1);
        }

        Set<Integer> values = new HashSet<Integer>(map.values());
        boolean isUnique = values.size() == 1;

        return isUnique;
    }
}