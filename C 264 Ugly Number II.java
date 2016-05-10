//https://leetcode.com/problems/ugly-number-ii/
//寻找第n个ugly number（由2、3、5的乘积组成）
//仅用一个数据结构的解法 https://leetcode.com/discuss/53225/c-one-pass-simple-solution
public int nthUglyNumber(int n) {
        Queue<Long> q2 = new LinkedList<Long>();
        q2.offer(2l);
        Queue<Long> q3 = new LinkedList<Long>();
        q3.offer(3l);
        Queue<Long> q5 = new LinkedList<Long>();
        q5.offer(5l);
        long uglyNum = 1;
        for(int i=1; i<n; i++) {
            uglyNum = getMin(q2.peek(), q3.peek(), q5.peek());
            if(uglyNum == q2.peek()) {
                q2.remove();
                q2.offer(uglyNum * 2);
                q3.offer(uglyNum * 3);
                q5.offer(uglyNum * 5);
            }
            else if(uglyNum == q3.peek()) {
                q3.remove();
                q3.offer(uglyNum * 3);
                q5.offer(uglyNum * 5);
            }
            else {
                q5.remove();
                q5.offer(uglyNum * 5);
            }
        }
        return (int)uglyNum;
    }
    
    public long getMin(long n1, long n2, long n3) {
        if(n1 < n2)
            return n1>n3?n3:n1;
        else
            return n2>n3?n3:n2;
    }
