import numpy as np


class Solution:
    def canBeValid(self, s: str, locked: str) -> bool:
        str_formatted = np.array([1 if c == '(' else -1 for c in s])
        locked = np.array([1 if c == '1' else 0 for c in locked])

        n = len(s)

        erroneous_parenthesis = self.valid(str_formatted, n)
        while erroneous_parenthesis != n:
            if self.try_open(str_formatted, locked, erroneous_parenthesis):
                erroneous_parenthesis = self.valid(str_formatted, n)
            else:
                return False

        sum_parenthesis = sum(str_formatted)
        while sum_parenthesis != 0:
            if self.try_close(str_formatted, locked, n - 1):
                sum_parenthesis -= 2
            else:
                return False

        if self.valid(str_formatted, n) != n:
            return False

        return True

    def valid(self, arr, n) -> int:
        count = 0
        for i in range(n):
            count += arr[i]
            if count < 0:
                return i
        return n

    def try_open(self, arr, locked, index) -> bool:
        for i in range(index, -1, -1):
            if arr[i] == -1 and locked[i] == 0:
                arr[i] = 1
                return True
        return False

    def try_close(self, arr, locked, index) -> bool:
        for i in range(index, -1, -1):
            if arr[i] == 1 and locked[i] == 0:
                arr[i] = -1
                return True
        return False
