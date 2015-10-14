//简单计算器 含+ - ( )

public int calculate(String s) {
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Character> chStack = new Stack<Character>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                String num = "";
                while(i < s.length() && s.charAt(i) >= 48 && s.charAt(i) <= 57)
                    num += s.charAt(i++);
                i--;
                numStack.push(Integer.parseInt(num));
                if(!chStack.empty()) {
                    if(chStack.peek() == '+') {
                        numStack.push(numStack.pop() + numStack.pop());
                        chStack.pop();
                    }
                    else if(chStack.peek() == '-') {
                        numStack.push(-numStack.pop() + numStack.pop());
                        chStack.pop();
                    }
                }
            }
            else if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '(')
                chStack.push(s.charAt(i));
            else if(s.charAt(i) == ')') {
                chStack.pop();
                while(!chStack.empty() && (chStack.peek() == '+' || chStack.peek() == '-')) {
                    if(chStack.peek() == '+') {
                        numStack.push(numStack.pop() + numStack.pop());
                        chStack.pop();
                    }
                    else if(chStack.peek() == '-') {
                        numStack.push(-numStack.pop() + numStack.pop());
                        chStack.pop();
                    }
                }
            }
        }
        return numStack.peek();
    }
