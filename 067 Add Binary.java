//二进制加法

public String addBinary(String a, String b) {
        int numA = a.length();
        int numB = b.length();
        int i = a.length()-1;
        int j = b.length()-1;
        String result = "";
        int addOne = 0;
        while(i >= 0 && j >= 0) {
            int sum = (a.charAt(i)-48) + (b.charAt(j)-48) + addOne;
            if(sum < 2) {
                addOne = 0;
                result = sum + result;
            }
            else {
                result = (sum-2) + result;
                addOne = 1;
            }
            i--;
            j--;
        }
        while(i >= 0) {
            int sum = (a.charAt(i)-48) + addOne;
            if(sum < 2) {
                addOne = 0;
                result = sum + result;
            }
            else {
                result = (sum-2) + result;
                addOne = 1;
            }
            i--;
        }
        while(j >= 0) {
            int sum = (b.charAt(j)-48) + addOne;
            if(sum < 2) {
                addOne = 0;
                result = sum + result;
            }
            else {
                result = (sum-2) + result;
                addOne = 1;
            }
            j--;
        }
        if(addOne == 1)
            result = "1" + result;
        return result;
    }
