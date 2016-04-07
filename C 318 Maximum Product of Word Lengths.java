//https://leetcode.com/problems/maximum-product-of-word-lengths/
//判断两个单词长度的最大乘积（两个单词完全没有重复字符）
//位操作 注意把String转换为char[]更快一些
public int maxProduct(String[] words) {
        int[] bit = new int[words.length];
        for(int i=0; i<words.length; i++) {
        	for(int j=words[i].length() - 1; j>=0; j--) {
        		bit[i] |= (1 << words[i].charAt(j));
        	}
        }
        int max = 0;
        for(int i=0; i<words.length; i++) {
        	for(int j=i+1; j<words.length; j++) {
        		if((bit[i] & bit[j]) == 0 && words[i].length() * words[j].length() > max)
        			max = words[i].length() * words[j].length();
        	}
        }
        return max;
    }
