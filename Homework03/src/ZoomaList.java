
public class ZoomaList extends CDLinkedList {
	int score = 0;

	public ZoomaList() {
		super();
	}

	public ZoomaList(CDLinkedList l) {
		header = l.header;
		size = l.size;
	}

	public void insert(int value, Iterator p) throws Exception {
		//fill code
		if (p == null || !(p instanceof DListIterator)) {
			return;
		}
		super.insert(value, p);
		DListIterator lIterator = (DListIterator) p;
		lIterator.next();
		DListIterator rIterator = new DListIterator (lIterator.currentNode);
		while (lIterator.currentNode.data == rIterator.currentNode.data) {
			int count = -1;
			if (lIterator.currentNode.data == header.data) {
				lIterator.currentNode = rIterator.currentNode;
			} else {
				rIterator.currentNode = lIterator.currentNode;
			}
			while (lIterator.currentNode.data == value) {
				lIterator.currentNode = lIterator.currentNode.previousNode;
				count += 1;
			}
			while (rIterator.currentNode.data == value) {
				rIterator.currentNode = rIterator.currentNode.nextNode;
				count += 1;
			}
			if (count >= 3) {
				value = lIterator.currentNode.data;
				score += count;
				this.removeBetween(lIterator, rIterator, count);
			} else {
				break;
			}
		}
}

	
	public void removeBetween(DListIterator left, DListIterator right, int inc) {
		//fill code
		DListNode l = ((DListIterator) left).currentNode;
		DListNode r = ((DListIterator) right).currentNode;
		this.size -= inc;
		if (l == r) {
		} else {
			l.nextNode = r;
			r.previousNode = l;
		}
	}
}
