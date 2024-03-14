import java.util.ArrayList;

public class ArrayListStack implements Stack {
	private ArrayList<Integer> a;
	private int currentSize;
	private static final int DEFAULT_SIZE = 0;
	// implement a default constructor and all methods from interface Stack.
	// Additional methods maybe required in order to run tests.
	public ArrayListStack() {
		this(DEFAULT_SIZE); // create empty stack
	}
	
	public ArrayListStack(int size) {
		ArrayList<Integer> a = new ArrayList<Integer>(size);
		this.a = a;
		this.currentSize = 0;
	}
	
	public void setCurrentSize(ArrayList<Integer> a) {
		this.currentSize = this.a.size();
	}

	public ArrayList<Integer> getA() {
		return this.a;
	}

	@Override
	public boolean isEmpty() {
		return currentSize == 0;
	}

	@Override
	public boolean isFull() {
		return currentSize == 100000;
	}

	@Override
	public void makeEmpty(){
		while(!this.isEmpty()) {
			try {
				pop();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public int top() throws Exception {
		if(this.isEmpty()) {
			throw new EmptyStackException();
		}
		return this.a.get(a.size()-1);
	}

	@Override
	public void pop() throws Exception {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		}
		a.remove(a.size()-1);
		setCurrentSize(a);
	}

	@Override
	public void push(int data) throws Exception {
		a.add(data);
		setCurrentSize(a);
	}

}
