public class CDLinkedList {
	DListNode header;
	int size;
	static final int HEADERVALUE = -9999999;

	public CDLinkedList() {
		header = new DListNode(HEADERVALUE);
		makeEmpty();// necessary, otherwise next/previous node will be null
	}

	public boolean isEmpty() {
		return header.nextNode == header;
	}

	public boolean isFull() {
		return false;
	}

	/** make the list empty. */
	public void makeEmpty() {
		header.nextNode = header;
		header.previousNode = header;
		size = 0;
	}

	// put in new data after the position of p.
	public void insert(int value, Iterator p) throws Exception {
		if (p == null || !(p instanceof DListIterator))
			throw new Exception();
		DListIterator p2 = (DListIterator) p;
		if (p2.currentNode == null)
			throw new Exception();

		DListIterator p3 = new DListIterator(p2.currentNode.nextNode);
		DListNode n = new DListNode(value, p3.currentNode, p2.currentNode);
		p2.currentNode.nextNode = n;
		p3.currentNode.previousNode = n;
		size++;
	}

	// return position number of value found in the list.
	// otherwise, return -1.
	public int find(int value) throws Exception {
		DListIterator itr = new DListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			int v = itr.next();
			index++;
			if (itr.currentNode == header)
				return -1;
			if (v == value)
				return index; // return the position of value.
		}
		return -1;
	}

	// return data stored at kth position.
	public int findKth(int kthPosition) throws Exception {
		if (kthPosition < 0 || kthPosition > size - 1)
			throw new Exception();// exit the method if the position is
		// beyond the first/last possible
		// position, throwing exception in the process.
		DListIterator itr = new DListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			int v = itr.next();
			index++;
			if (itr.currentNode == header)
				throw new Exception();
			if (index == kthPosition)
				return v;
		}
		throw new Exception();
	}

	// Return iterator at position before the first position that stores value.
	// If the value is not found, return null.
	public Iterator findPrevious(int value) throws Exception {
		if (isEmpty())
			return null;
		Iterator itr1 = new DListIterator(header);
		Iterator itr2 = new DListIterator(header);
		int currentData = itr2.next();
		while (currentData != value) {
			currentData = itr2.next();
			itr1.next();
			if (((DListIterator) itr2).currentNode == header)
				return null;
		}
		return itr1;
	}

	// remove content at position just after the given iterator. Skip header if
	// found.
	public void remove(Iterator p) {
		if (isEmpty())
			return;
		if (p == null || !(p instanceof DListIterator))
			return;
		DListIterator p2 = (DListIterator) p;
		if (p2.currentNode == null)
			return;
		if (p2.currentNode.nextNode == header)
			p2.currentNode = header;
		if (p2.currentNode.nextNode == null)
			return;
		DListIterator p3 = new DListIterator(p2.currentNode.nextNode.nextNode);
		p2.currentNode.nextNode = p3.currentNode;
		p3.currentNode.previousNode = p2.currentNode;
		size--;
	}

	// remove the first instance of the given data.
	public void remove(int value) throws Exception {
		Iterator p = findPrevious(value);
		if (p == null)
			return;
		remove(p);
	}

	// remove data at position p.
	// if p points to header or the list is empty, do nothing.
	public void removeAt(Iterator p) throws Exception {
		if (isEmpty() || p == null || !(p instanceof DListIterator) || ((DListIterator) p).currentNode == null
				|| ((DListIterator) p).currentNode == header)
			return;

		DListIterator p2 = (DListIterator) (findPrevious(p));
		remove(p2);

	}

	// Print each contact out, one by one.
	// To be completed by students.
	public void printList() throws Exception {
		Iterator itr = new DListIterator(header);
		while (itr.hasNext()) {
			Object data = itr.next();

			System.out.println(data);

		}
	}

	public int size() throws Exception {
		return size;
	}

	// return iterator pointing to location before position.
	public Iterator findPrevious(Iterator position) throws Exception {
		if (position == null)
			return null;
		if (!(position instanceof DListIterator))
			return null;
		if (((DListIterator) position).currentNode == null)
			return null;

		DListIterator p = ((DListIterator) position);
		DListIterator p2 = new DListIterator(p.currentNode.previousNode);
		return p2;

	}





	// write the sort method below
	public void sort() throws Exception { // any sorting will do BUT you must use only 'this' list. No array or any other data structures allowed!!!
//		bubbleSort();
//		selectionSort();
//		insertionSort();
		mergeSort();
//		quickSort();
		}
	
	public void bubbleSort() throws Exception {
		//bubble sort
		//check for boundary conditions
		if (this == null || this.size == 1 || this.isEmpty()) {
			return;
		}
		//set up outer loop
		int counter = this.size-1;
		//outer loop
		while (counter != 0) {
			//setup inner loop
			DListIterator i = new DListIterator(header.nextNode);
			//inner loop
			while (i.currentNode.nextNode != header) {
				//swapping
				if (i.currentNode.data > i.currentNode.nextNode.data) {
					int temp = i.currentNode.data;
					i.currentNode.data = i.currentNode.nextNode.data;
					i.currentNode.nextNode.data = temp;
				}
				i.next();
			}
			counter -= 1;
			}
		//Bubble sort end
		}
	
	public void selectionSort() throws Exception {
		//Selection sort
		//set up outer loop
		DListNode marker = header.previousNode;
		while (marker.previousNode != header) {
			//set up inner loop
			int max = marker.data;
			//i is used to find the maximum in the unsorted portion of array
			DListNode i = marker.previousNode;
			//maxVal track where the maximum value is
			DListNode maxVal = marker;
			//inner loop to find max data in the unsorted portion of array
			while (i != header) {
				if (i.data > max) {
					max = i.data;
					maxVal = i;
				}
				i = i.previousNode;
			}
			//swap value
			int temp = marker.data;
			marker.data = max;
			//place the data into the location of maxValue
			maxVal.data = temp;
			//move marker back
			marker = marker.previousNode;
			}
		//Selection sort end
		}
	
	public void insertionSort() throws Exception {
		//Insertion sort
		//set up outer loop
		//marker is used to track the last element of sorted portion
		DListNode marker = header.nextNode;
		while (marker != header) {
			//set up inner loop
			int temp = marker.data;
			//set i as the rightmost element of sorted portion
			DListNode i = marker;
			//inner loop
			while (i.previousNode != header && i.previousNode.data > temp) {
				//copy previous data to current one until previous data is less than temp
				i.data = i.previousNode.data;
				i = i.previousNode;
			}
			//place the data
			i.data = temp;
			marker = marker.nextNode;
			}
		//Insertion sort end
		}
	
	public void mergeSort() throws Exception {
		//Merge sort
		header = mergeSort(header);
		}
	
	
	public DListNode split(DListNode node) {
		if (node == null || node.nextNode == header || this.size == 1) {
			return node;
		}
		int mid = Math.round(size/2);
		System.out.println(mid);
	    DListNode left = node;
	    DListNode right = node;
	    
	    // Find the middle node
	    for (int i = 0; i < mid; i++) {
	        right = right.nextNode;
	    }
	    
	    left.previousNode = null;
	    right.previousNode.nextNode = null;
	    return right;
	}
	//recursive function for mergeSort
	public DListNode mergeSort(DListNode node) {
		if (node == null || node.nextNode == header || this.size == 1) {
			return node;
		}
//		int middle =  Math.round((this.size-1)/2);
//		DListNode left = mergeSort(node);
//		DListNode right = node;
//		while (middle != 0) {
//			right = right.nextNode;
//			middle -= 1;
//		}
//		DListNode nextToMiddle = right.nextNode;
//		right.nextNode = null;
//		nextToMiddle.previousNode = null;
//		right = nextToMiddle;
//		
//		return merge(left,right);
		
	    
	    // Split the list
	    DListNode left = mergeSort(node);
	    DListNode right = mergeSort(split(node));
	    
	    return merge(left, right);
		}
	
	public DListNode merge(DListNode left, DListNode right) {
		System.out.println("Hello mom");
		if (left == null) {
			return left;
		}
		if (right == null) {
			return right;
		}
		DListNode result = null;
		if (left.data < right.data) {
			result = left;
			result.nextNode.previousNode = result;
			result.nextNode = merge(left.nextNode,right);
			return result;
		} else {
			result = right;
			result.nextNode.previousNode = result;
			result.nextNode = merge(left,right.nextNode);
			return result;
		}
	}
	
	public void quickSort() throws Exception {
		if (this == null || this.size <= 1) {
			return;
		} else if (this.size <= 20) {
//			this.insertionSort();
//			this.mergeSort();
		} else {
			
		}
	}
	}
