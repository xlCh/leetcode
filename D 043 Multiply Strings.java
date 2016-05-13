//https://leetcode.com/problems/multiply-strings/
//大数乘法  找规律
//虽然快但看不太懂。。https://leetcode.com/discuss/87274/3ms-java-solution-beats-100%25
//包含图示：https://leetcode.com/discuss/71593/easiest-java-solution-with-graph-explanation
public String multiply(String num1, String num2) {
        int length1 = num1.length(), length2 = num2.length();
        int[] result = new int[length1 + length2];
        for(int i=length1-1; i>=0; i--) {
            for(int j=length2-1; j>=0; j--) {
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int sum = mul + result[i+j+1];
                result[i+j] += sum / 10;
                result[i+j+1] = sum % 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int num : result) {
            if(!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
