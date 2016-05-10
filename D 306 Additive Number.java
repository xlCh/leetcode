//https://leetcode.com/problems/additive-number/
//是否能构成一连串加法
//非递归方法 https://leetcode.com/discuss/70119/backtracking-with-pruning-java-solution-and-python-solution
//下标有些晕 https://leetcode.com/discuss/71455/java-very-straightforward-solution-detailed-explanation
//多种方法 https://leetcode.com/discuss/70102/java-recursive-and-iterative-solutions
//参考https://leetcode.com/discuss/70796/simple-java-solution
public boolean isAdditiveNumber(String num) {
        String a, b;
        for(int i=0; i<num.length() / 3; i++) {
            a = num.substring(0, i+1);
            if(a.length() > 1 && a.charAt(0) == '0')
                continue;
            for(int j=i+1; j<num.length(); j++) {
                b = num.substring(i+1, j+1);
                if(b.length() > 1 && b.charAt(0) =='0')
                    continue;
                if(isAdditive(num.substring(j+1), Long.valueOf(a), Long.valueOf(b)))
                    return true;
            }
        }
        return false;
    }
    
    public boolean isAdditive(String num, long a, long b) {
        long c = a + b;
        String value = String.valueOf(c);
        if(!num.startsWith(value)) {
            return false;
        }
        else if(num.length() == value.length())
            return true;
        else {
            return isAdditive(num.substring(value.length()), b, c);
        }
    }
