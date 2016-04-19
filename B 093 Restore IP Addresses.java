//https://leetcode.com/problems/restore-ip-addresses/
//给出ip地址的各种可能
//哈哈哈哈不错的解法 https://leetcode.com/discuss/88736/who-can-beat-this-code
public class Solution {
    private List<String> result = new ArrayList<String>();
    
    public List<String> restoreIpAddresses(String s) {
        getAddresses("", s, 0);
        return result;
    }
    
    public void getAddresses(String already, String rest, int num) {
        if(num == 4 && rest.equals("")) {
            result.add(already);
            return;
        }
        else if(num == 4)
            return;
        int length = rest.length()>3?3:rest.length();
        for(int i=1; i<=length; i++) {
            int part = Integer.parseInt(rest.substring(0, i));
            String al = new String(already);
            if(0 <= part && part <= 255 && (i == 1 || (i != 1 && rest.charAt(0) != '0'))) {
                al += part;
                if(num != 3)
                    al += '.';
                getAddresses(al, rest.substring(i), num+1);
            }
        }
    }
    
    
}

//略有不同
    List<String> result = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {
        restore(s, "", 0, 4);
        return result;
    }
    
    public void restore(String s, String already, int start, int remain) {
        if(remain == 0 && start >= s.length()) {
            result.add(already.substring(0, already.length()-1));
            return;
        }
        else if(remain == 0 || start >= s.length()) {
            return;
        }
        for(int i=1; i<=3 && start+i <=s.length(); i++) {
            String subNum = s.substring(start, start+i);
            if(Integer.valueOf(subNum) > 255 || (i != 1 && s.charAt(start) == '0'))
                return;
            restore(s, already+subNum + ".", start+i, remain-1);
        }
    }
