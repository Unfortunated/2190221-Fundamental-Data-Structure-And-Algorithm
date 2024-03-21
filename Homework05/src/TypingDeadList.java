
public class TypingDeadList extends CDLinkedList {
	int score = 0;  //not used in this exam
	DListIterator start = null; // the first position of a word to remove
	DListIterator end = null; // last position of a word to remove

	public TypingDeadList() throws Exception {
		this("");
	}

	public TypingDeadList(String s) throws Exception {
		// initialize the list
		// each data comes from each character in s
		int n = s.length();
		DListIterator d = new DListIterator(header);
		for (int i = n - 1; i >= 0; i--) {
			insert(s.charAt(i), d);
		}

	}

	public void removeWord(String w) throws Exception {
		// remove the first occurrence of w
		// if w is not in the list, do nothing
		// reset start and end to null no matter what
		findWord(w);
		if (start == null)
			return;

		int dec = w.length();
		remove(dec);

	}

	public void findWord(String w) throws Exception {
		// update start and end to mark position of the first occurrence of w
		// The word cannot cross header node
		// If w is not in the list, do nothing.
		// w is assumed never to be an empty string.
		//fill code
		DListIterator itr = new DListIterator(header);
		DListIterator s = new DListIterator(header);
		DListIterator e = new DListIterator(header);
		boolean FirstLetter = false;
		int i = 0;
		while (itr.currentNode.nextNode != header) {
			itr.currentNode = itr.currentNode.nextNode;
			// find first letter
			if ((char) itr.currentNode.data == w.charAt(i) && !FirstLetter) {
				s.currentNode = itr.currentNode;
				FirstLetter = true;
				i++;
			// find the rest of letter
			} else if ((char) itr.currentNode.data == w.charAt(i)) {
				i++;
			// reset
			} else {
				i = 0;
				FirstLetter = false;
			}
			// define the ending node
			if (i == w.length()) {
				e.currentNode = itr.currentNode;
				break;
			}	
		}
		// for word not found
		if (i == w.length()) {
			this.start = s;
			this.end = e;
		}	
	}

	public void remove(int dec) throws Exception { // this must be the last method in your code!
		// remove data from start to end, inclusive,
		// if start or end is at header, do nothing.
		// size to remove is one of the known parameter -> reduce the size parameter of
		// the list
		
		//fill code
		if (this.start.currentNode == header || this.end.currentNode == header) {
			return ;
		} else {
			this.start.currentNode.previousNode.nextNode = this.end.currentNode.nextNode;
			this.end.currentNode.nextNode.previousNode = this.start.currentNode.previousNode;
			this.size -= dec;
		}
	}
	
}
