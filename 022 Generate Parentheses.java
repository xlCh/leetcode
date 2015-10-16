//给定n组左右括号 求组合

public class Solution {
    List<String> result = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        generate("", 0, n, n*2);
        return result;
    }
    
    public void generate(String str, int balanceNum, int avaliableLeftNum, int targetNum) {
        if(targetNum == 0) {
            result.add(str);
            return;
        }
        if(avaliableLeftNum != 0) {
            generate(str+'(', balanceNum+1, avaliableLeftNum-1, targetNum-1);
        }
        if(balanceNum > 0) {
            generate(str+')', balanceNum-1, avaliableLeftNum, targetNum-1);
        }
        
    }
}
