//https://leetcode.com/problems/sqrtx/
//x的平方根
//位操作：https://leetcode.com/discuss/8897/share-my-o-log-n-solution-using-bit-manipulation
public int mySqrt(int x) {
        if(x <= 1)
            return x;
        long low = 1, high = x, middle = (low + high) / 2;
        while(low < high - 1) {
            if(middle*middle < x)
                low = middle;
            else if(middle*middle > x)
                high = middle;
            else
                return (int)middle;
            middle = (low + high) / 2;
        }
        return (int)low;
    }
