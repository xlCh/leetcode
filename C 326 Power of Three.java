//https://leetcode.com/problems/power-of-three/
//判断是否为3的幂
//O(1)解法
return n > 0 && 1162261467 % n == 0;

//还可以用log解，但注意有精度的问题（例如e为底）
    if (n <= 0)
        return false;
    double r = Math.log10(n) / Math.log10(3);
    if (r % 1 == 0)
        return true;
    else
        return false;
