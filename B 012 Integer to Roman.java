//https://leetcode.com/problems/integer-to-roman/
//Integer to Roman  1~3999
//另一种简单解法：https://leetcode.com/discuss/32626/simple-solution
public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String result = "";
        for(int i=0; i<values.length; i++) {
            while(num >= values[i]) {
                num -= values[i];
                result = result.concat(romans[i]);
            }
            //for循环中还可以这样写
            /*
            int n = num / values[i];
            if(n == 0)
                continue;
            for(int j=0; j<n; j++) {
                result.append(romans[i]);
            }
            num %= values[i];
            */
        }
        return result;
    }
