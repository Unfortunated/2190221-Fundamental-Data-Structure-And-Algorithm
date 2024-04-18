
public class MaxIntHeap extends Heap{
	public void add(Object element) {
		// Add your code here
		if (++size == mData.length) {
			Object[] newHeap = new Object[2 * mData.length];
			System.arraycopy(mData, 0, newHeap, 0, size);
			mData = newHeap;
		}
		mData[size - 1] = element;
		percolateUp();
	}
	@Override
	public void percolateUp() {
		int parent;
		int child = size - 1;
		Comparable temp;
		while (child > 0) {
			parent = (child - 1) / 2;
			//change <= to >
			if (((Comparable) mData[parent]).compareTo(mData[child]) > 0)
				break;
			temp = (Comparable) mData[parent];
			mData[parent] = mData[child];
			mData[child] = temp;
			child = parent;
		}
	}
	@Override
	public void percolateDown(int start) {
		int parent = start;
		int child = 2 * parent + 1;
		Object temp;
		while (child < size) {
			//change > to <=
			if (child < size - 1
					&& ((Comparable) mData[child]).compareTo(mData[child + 1]) <= 0)
				child++;
			//change <= to >
			if (((Comparable) mData[parent]).compareTo(mData[child]) > 0)
				break;
			temp = mData[child];
			mData[child] = mData[parent];
			mData[parent] = temp;
			parent = child;
			child = 2 * parent + 1;
		}
	}
	
	public Object pop() throws Exception {
		// Add your code here
		if (size == 0)
			throw new Exception("Priority queue empty.");
		Object maxElem = mData[0];
		mData[0] = mData[size - 1];
		size--;
		percolateDown(0);
		return maxElem;
		
	}
}
