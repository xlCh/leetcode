//给出ip地址的各种可能

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
