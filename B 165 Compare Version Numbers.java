//https://leetcode.com/problems/compare-version-numbers/
//版本比较
//更快的方法 不需要借助java封的方法 https://leetcode.com/discuss/88446/1ms-ac-solution-in-java
//注意split！！！
public int compareVersion(String version1, String version2) {
        String[] version1s = version1.split("\\.");
        String[] version2s = version2.split("\\.");
        int i;
        for(i=0; i<version1s.length && i<version2s.length; i++) {
            int num1 = Integer.parseInt(version1s[i]);
            int num2 = Integer.parseInt(version2s[i]);
            if(num1 < num2)
                return -1;
            else if(num1 > num2)
                return 1;
        }
        while(i<version1s.length) {
            if(Integer.parseInt(version1s[i]) != 0)
                return 1;
            i++;
        }
        while(i<version2s.length) {
            if(Integer.parseInt(version2s[i]) != 0)
                return -1;
            i++;
        }
        return 0;
    }
