
class Solution {
    public boolean checkPerfectNumber(int num) {

        int sum = 1;

        if(num == 1)
            return false;

        if(num % 2 == 0)
        {
            for (int i = 2; i * i < num; i++) {
                if (num % i == 0) {
                    sum = sum + i + num / i;
                }
            }
        }
        else {
         for (int i = 3; i * i < num; i += 2) {
            if (num % i == 0) {
                sum = sum + i + num / i;
                }
            }
        }
        return sum == num;
    }
}