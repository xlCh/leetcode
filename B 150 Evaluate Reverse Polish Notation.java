//https://leetcode.com/problems/evaluate-reverse-polish-notation/
//实现运算（运算符号在两个数字后面）
//注意除法和减法！！
public int evalRPN(String[] tokens) {
        Stack<Integer> tokenStack = new Stack<Integer>();
        int temp;
        for(int i=0; i<tokens.length; i++) {
            switch(tokens[i]) {
                case "+":
                    temp = tokenStack.pop() + tokenStack.pop();
                    tokenStack.push(temp);
                    break;
                case "-":
                    temp = -tokenStack.pop() + tokenStack.pop();
                    tokenStack.push(temp);
                    break;
                case "*":
                    temp = tokenStack.pop() * tokenStack.pop();
                    tokenStack.push(temp);
                    break;
                case "/":
                    int divide = tokenStack.pop();
                    temp = tokenStack.pop() / divide;
                    tokenStack.push(temp);
                    break;
                default:
                    tokenStack.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return tokenStack.peek();
    }
