//https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
//验证树的前序遍历形式 例如"9,3,4,#,#,1,#,#,2,#,6,#,#"这种格式
//较慢 改进split可加快
//方法巧妙！计算入度和出度是否平衡 https://leetcode.com/discuss/83824/7-lines-easy-java-solution
//使用栈 https://leetcode.com/discuss/83819/java-intuitive-22ms-solution-with-stack
public boolean isValidSerialization(String preorder) {
       int i = 1;
		String[] elements = preorder.split(",");
		if(elements.length == 0)
			return true;
		Queue<String> queue = new LinkedList<String>();
		if(!elements[0].equals("#"))
		    queue.offer(elements[0]);
		while(!queue.isEmpty()) {
			if(i >= elements.length - 1)
				return false;
			queue.poll();
			if(!elements[i].equals("#"))
				queue.offer(elements[i]);
			i++;
			if(!elements[i].equals("#"))
				queue.offer(elements[i]);
			i++;
		}
		return i==elements.length ? true : false; 
    }
