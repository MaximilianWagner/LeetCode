class Solution {
    public boolean areOccurrencesEqual(String s) {

        int[] charArray = new int[26];

        for(Character c: s.toCharArray()){
            charArray[c - 'a']++;
        }

        for(int i = 1; i < 26; i++){
            if(charArray[i] != charArray[s.charAt(0) - 'a'] && charArray[i] != 0){
                return false;
            }
        }

        return true;
    }
}