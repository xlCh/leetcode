//猜数字 返回mAnB
//注意可能出现的多种情况

public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        int[] secretList = new int[10];
        for(int i=0; i<10; i++)
            secretList[i] = 0;
        for(int i=0; i<secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bull++;
            }
            else
                secretList[secret.charAt(i)-48]++;
            
        }
        for(int i=0; i<secret.length(); i++) {
            if(secret.charAt(i) != guess.charAt(i) && secretList[guess.charAt(i)-48] >= 1) {
                cow++;
                secretList[guess.charAt(i)-48]--;
            }
        }
        return bull + "A" + cow + "B";
    }
