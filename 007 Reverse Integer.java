//将int翻转，溢出返回0
//注意加法和乘法都可能溢出

public int reverse(int x) {
        int times=1, result = 0;
        List<Integer> everyBit = new ArrayList<Integer>();
        while(x != 0) {
            everyBit.add(x % 10);
            x /= 10;
        }
        
        for(int i=everyBit.size()-1; i>=0; i--) {
        	int bit = everyBit.get(i);
        	if((bit != 0 && times * bit / bit != times) || (result > 0 && result+times*bit < 0) || (result < 0 && result+times*bit > 0))
        		return 0;
        	result += times * everyBit.get(i);
        	times *= 10;
        }
        return result;
    }
