
public class PriorityQueue {
	MyQueue q;

	public PriorityQueue(MyQueue q) {
		super();
		this.q = q;
	}

	// implement this.
	public void push(int x) throws Exception {
		if (q.isEmpty()) {
			q.insertLast(x);
		} else {
			int counter = q.size();
			while (x > q.front() && counter > 0) {
				q.insertLast(q.removeFirst());
				counter --;
			}
			q.insertLast(x);
			while (counter > 0) {
				q.insertLast(q.removeFirst());
				counter --;
			}
		}
		
	}

	// implement this.
	public void pop() throws Exception {
		q.removeFirst();
	}

	// implement this
	public int top() throws Exception {
		return q.front();
	}

}
