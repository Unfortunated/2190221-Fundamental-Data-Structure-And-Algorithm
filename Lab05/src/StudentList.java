
public class StudentList extends CDLinkedList {
    // you can write additional methods.
	public StudentList() {
		super();
	}

	// implement this method
	public void swapNode(DListIterator i1, DListIterator i2) {
//		DListNode p1temp = i1.currentNode.previousNode;
//		DListNode f1temp = i1.currentNode.nextNode;
//		DListNode p2temp = i2.currentNode.previousNode;
//		DListNode f2temp = i2.currentNode.nextNode;
//		i1.currentNode.previousNode = p2temp;
//		p2temp.nextNode = i1.currentNode.previousNode;
//		i1.currentNode.nextNode = f2temp;
//		f2temp.previousNode = i1.currentNode.nextNode;
//		i2.currentNode.previousNode = p1temp;
//		p1temp.nextNode = i2.currentNode.previousNode;
//		i2.currentNode.nextNode = f1temp;
//		f1temp.previousNode = i2.currentNode.nextNode;
//		i1.currentNode.previousNode = i2.currentNode;
//		i2.currentNode = i1.currentNode.previousNode;
//		
//		i1.currentNode.nextNode = i2.currentNode.nextNode;
//		i2.currentNode.nextNode = i1.currentNode.nextNode;
////		previous i1 to i2
//		i1.currentNode.previousNode.nextNode = i2.currentNode;
//		i2.currentNode.previousNode.nextNode = i1.currentNode;
//		
////		previous i2 to i1
//		i1.currentNode.previousNode = i2.currentNode.previousNode;
//		i2.currentNode.previousNode.nextNode = i1.currentNode;
//		
////		next i1 to i2
//		i1.currentNode.nextNode.previousNode = i2.currentNode;
//		i2.currentNode.nextNode = i1.currentNode.nextNode;
//		
////		next i2 to i1
//		i1.currentNode.nextNode = i2.currentNode.nextNode;
//		i2.currentNode.nextNode.previousNode = i1.currentNode;
		
		
		
		// previous node
		i1.currentNode.previousNode.nextNode = i2.currentNode;
		i2.currentNode.previousNode.nextNode = i1.currentNode;
		
		// next node
		i1.currentNode.nextNode.previousNode = i2.currentNode;
		i2.currentNode.nextNode.previousNode = i1.currentNode;
		
		// clean up
		DListNode p1 = i1.currentNode.previousNode;
		i1.currentNode.previousNode = i2.currentNode.previousNode;
		i2.currentNode.previousNode = p1;
		DListNode f1 = i1.currentNode.nextNode;
		i1.currentNode.nextNode = i2.currentNode.nextNode;
		i2.currentNode.nextNode = f1;
	}
	
	// implement this method
	public void insertList(DListIterator i1, CDLinkedList lst) throws Exception {
		if (lst.isEmpty()) {
			return;
		} 
		DListNode nextnode = i1.currentNode.nextNode;
		DListNode finalnode = lst.header.previousNode;
		i1.currentNode.nextNode = lst.header.nextNode;
		lst.header.nextNode.previousNode = i1.currentNode;
		nextnode.previousNode = finalnode;
		lst.header.previousNode.nextNode = nextnode;
	}

	// implement this method
	public void gender(String g) throws Exception {
		DListIterator itr = new DListIterator(header);
		DListIterator marker = new DListIterator(header);
		while (itr.currentNode.nextNode != header) {
			itr.currentNode = itr.currentNode.nextNode;
			if (((Student) itr.currentNode.data).getSex().equals(g)) {
				insert(itr.currentNode.data,marker);
				marker.currentNode = marker.currentNode.nextNode;
				itr.currentNode.previousNode.nextNode = itr.currentNode.nextNode;
				itr.currentNode.nextNode.previousNode = itr.currentNode.previousNode;
			}
		}
	}

}
