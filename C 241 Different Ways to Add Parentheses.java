//https://leetcode.com/problems/different-ways-to-add-parentheses/
//对运算加括号 + - *

Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input))
            return map.get(input);
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<input.length(); i++) {
            char op = input.charAt(i);
            if(op=='+' || op=='-' || op=='*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for(int l : left) {
                    for(int r : right) {
                        if(op == '+')
                            result.add(l + r);
                        else if(op == '-')
                            result.add(l - r);
                        else if(op == '*')
                            result.add(l * r);
                    }
                }
            }
        }
        if(result.isEmpty())
            result.add(Integer.parseInt(input));
        map.put(input, result);
        return result;
    }
