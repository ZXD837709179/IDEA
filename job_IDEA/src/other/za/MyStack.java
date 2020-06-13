package other.za;
/**
 *  使用数组实现队列
	自己实现一个栈，要求这个栈具有push()、pop()（返回栈顶元素并出栈）、
	peek() （返回栈顶元素不出栈）、
	isEmpty()、size()这些基本的方法。
 * @author Xudong Zhang
 */
public class MyStack {
	private int[] nums;
	int count;
	int capacity;
	
	public MyStack() {
		this.count = 0;
		this.capacity = 10;
		this.nums = new int[10];
	}
	public MyStack(int capacity) {
		this.count = 0;
		this.capacity = capacity;
		this.nums = new int[capacity];
	}
	
	public void push(int i) {
		ensureCapacity();
		nums[count++] = i;
	}
	
	public int pop() {
		if(count<=0) throw new IllegalArgumentException("the stack is empty");
		
		int tmp = nums[0];
		System.arraycopy(nums, 1, nums, 0, count);
		nums[count--] = 0;
		return tmp;
	}
	public int peek() {
		if(count<=0) throw new IllegalArgumentException("the stack is empty");
		return nums[0];
	}
	
	public boolean isEmpty() {
		if(count<=0) {
			return true;
		}
		return false;
	}
	
	public int size() {
		return count;
	}
	
	public void ensureCapacity() {
		if(capacity-count<=0) {
			capacity = capacity*2;
			int[] newNums = new int[capacity];
			System.arraycopy(nums, 0, newNums, 0, count);
			nums = newNums;
		}
	}
	
	public static void main(String[] args) {
		MyStack myStack = new MyStack(3);
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.push(5);
		myStack.push(6);
		myStack.push(7);
		myStack.push(8);
		System.out.println(myStack.peek());//8
		System.out.println(myStack.size());//8
		for (int i = 0; i < 8; i++) {
		    System.out.println(myStack.pop());
		}
		System.out.println(myStack.isEmpty());//true
		myStack.pop();//报错：java.lang.IllegalArgumentException: Stack is empty.
		
	}
	
	
}
