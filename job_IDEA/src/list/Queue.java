package list;
import java.util.Stack;
/**
 * @auther: Xudong Zhang
 * @date:2020/6/11
 * 用两个辅助栈来实现求栈的最大最小值
 */
public class Queue <T extends Comparable<T>> {
	
	Stack<T> stack = new Stack<T>();
	Stack<T> stackMin = new Stack<T>();
	Stack<T> stackMax = new Stack<T>();
	
	public void push(T e) {
		stack.push(e);
		if(stackMin.isEmpty() || e.compareTo(stackMin.peek())<0) {
			stackMin.push(e);
		}else{
			stackMin.push(stackMin.peek());
		}
		
		if(stackMax.isEmpty() || e.compareTo(stackMin.peek())>0) {
			stackMax.push(e);
		}else{
			stackMax.push(stackMax.peek());
		}	
	}
	
	public T pop() {
		if (stack.isEmpty()) {
			System.out.println("栈空");
			return null;
		}else {
			T e = stack.pop();
			stackMax.pop();
			stackMin.pop();
			return e;
		}
	}
	
	public T getMin() {
		return stackMin.peek();
	}
	public T getMax() {
		return stackMax.peek();
	}
	
}
