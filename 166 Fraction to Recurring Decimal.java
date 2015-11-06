//整数÷整数 小数的循环部分用括号括起来
//https://leetcode.com/discuss/31521/short-java-solution 几处可借鉴优化

public String fractionToDecimal(int numerator, int denominator) {
        int isPositive = 1;
        long numerator_, denominator_;
        if(numerator < 0) {
            isPositive *= -1;
            numerator_ = -(long)numerator;
        }
        else
            numerator_ = numerator;
        if(denominator < 0) {
            isPositive *= -1;
            denominator_ = -(long)denominator;
        }
        else
            denominator_ = denominator;
        long intResult = numerator_ / denominator_;
		long remainder = numerator_ % denominator_;
		String result = "" + intResult;
		if(remainder == 0 && intResult == 0)
		    return "0";
		else if(remainder == 0)
			return isPositive>0?result:'-'+result;
		result += '.';
		Map<Long, Integer> mapping = new HashMap<Long, Integer>();
		List<Long> decimalList = new ArrayList<Long>();
		int digit = 0;
		while(remainder != 0) {
			if(mapping.containsKey(remainder)) {
				digit = mapping.get(remainder);
				break;
			}
			else {
				mapping.put(remainder, digit++);
				decimalList.add(remainder * 10 / denominator_);
				remainder = remainder * 10 % denominator_;
			}
		}
		if(digit == decimalList.size()) {
			for(long decimal : decimalList) {
				result += decimal;
			}
		}
		else {
			for(int i=0; i<digit; i++) {
				result += decimalList.get(i);
			}
			result += '(';
			for(int i=digit; i<decimalList.size(); i++) {
				result += decimalList.get(i);
			}
			result += ')';
		}
		return isPositive>0?result:'-'+result;
    }
