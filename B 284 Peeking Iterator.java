//https://leetcode.com/problems/peeking-iterator/
//设计可以预读取一个元素的类
//预读取时首先调用next 真正调用next的时候判断是否已调用peek
//另一种方法，行数少一些：https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private boolean isPeeked;
    private int peekNum;
    private Iterator<Integer> iterator;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	    isPeeked = false;
	    peekNum = 0;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(!isPeeked) {
            peekNum = iterator.next();
            isPeeked = true;
        }
        return peekNum;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(!isPeeked)
	        return iterator.next();
	    isPeeked = false;
	    return peekNum;
	}

	@Override
	public boolean hasNext() {
        return isPeeked || iterator.hasNext();
	}
}
