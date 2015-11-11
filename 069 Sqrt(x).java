//x的平方根

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
