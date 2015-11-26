//判断汽油是否能保证从各个加油站环形一圈 返回index

public int canCompleteCircuit(int[] gas, int[] cost) {
		int result = 0, total = 0, tempTotal = 0, length = gas.length;
		for(int i=0; i<length; i++) {
			int current = gas[i] - cost[i];
			tempTotal += current;
			if(tempTotal < 0) {
				tempTotal = 0;
				result = i+1;
			}
			total += current;
		}
		return total < 0 ? -1 : result;
	}
