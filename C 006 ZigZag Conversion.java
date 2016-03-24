//https://leetcode.com/problems/zigzag-conversion/
//根据Z形状重新输出字符串
//PAYPALISHIRING -> PAHNAPLSIIGYIR
//P   A   H   N
//A P L S I I G
//Y   I   R

public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        int every = 2 * numRows - 2;
        int times = (s.length()-1)/every + 1;
        int k = 0;
        char[] resultChars = new char[s.length()];
        for(int i=0; i<numRows; i++) {
            for(int j=0; j<times; j++) {
                if(i+j*every < s.length())
                    resultChars[k++] = s.charAt(i+j*every);
                if(i != 0 && i != numRows-1 && every-i+j*every<s.length())
                    resultChars[k++] = s.charAt(every-i+j*every);
            }
        }
        return String.valueOf(resultChars);
    }
