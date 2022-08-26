# Source: https://leetcode.com/problems/reordered-power-of-2/
# You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.
# Return true if and only if we can do this so that the resulting number is a power of two.

# Example 1:
# Input: n = 1
# Output: true
# Example 2:
# Input: n = 10
# Output: false
 
# Constraints:
# 1 <= n <= 10^9

class Solution:
    def isPowerOfTwo(self, n: int):
        while(n%2==0):
            n = n/2;
        if n == 1:
            return True
        return False
    def reorderedPowerOf2(self, n: int) -> bool:
        perm = itertools.permutations(str(n))
        for i in list(perm):
            # print(i)
            if(i[0] == '0'):
                continue
            a = (int(''.join(i)))
            # print(a)
            if self.isPowerOfTwo(a):
                return True
        return False

a = Solution()
a.reorderedPowerOf2(1)