//https://leetcode.com/problems/basic-calculator-ii/
//+ - * / 无括号 计算
//利用栈 https://leetcode.com/discuss/41902/share-my-java-solution
//时间O(n)空间O(1)不需要栈 参考https://leetcode.com/discuss/42903/java-straight-forward-iteration-solution-with-comments-stack
public int calculate(String s) {
        s = s.trim().replaceAll(" +", "");
        int i = 0;
        int prev = 0, result = 0;
        char op = '+';
        while(i < s.length()) {
            int current = 0;
            while(i < s.length() && Character.isDigit(s.charAt(i))) {
                current = 10 * current + (s.charAt(i)-'0');
                i++;
            }
            if(op == '+')  {
                result += prev;
                prev = current;
            }
            else if(op =='-') {
                result += prev;
                prev = -current;
            }
            else if(op == '*')
                prev = prev * current;
            else if(op == '/')
                prev = prev / current;
            if(i == s.length())
                break;
            op = s.charAt(i++);
        }
        return result + prev;
    }
