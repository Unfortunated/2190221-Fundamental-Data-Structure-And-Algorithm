import java.util.ArrayList;

public class BSTList {
	BSTNodeList root;
	int size;
	
	public BSTList() {
		root = null;
		size = 0;
	}
	
	public BSTList(BSTNodeList root, int size) {
		this.root = root;
		this.size = size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public void makeEmpty() {
		root = null;
		size = 0;
	}
	
	public BSTNodeList find(Comparable v) { 
//		v.compareTo(this.root.dataList)
		BSTNodeList itr = this.root;
		//check whether itr is null
		while (itr != null) {
//			Object a = (this.root.dataList).get(0);
			Object a = itr.dataList.get(0);
			switch (v.compareTo(a)) {
				//input first num is less than current node
				case -1:
					itr = itr.left;
					break;
				//input first num is more than current node
				case 1:
					itr = itr.right;
					break;
				//first num is in arrayList
				case 0:
					if (itr.dataList.contains(v)) {
						return itr;
					} else {
						return null;
					}
			}
		}
		return null;
	}
	
	public BSTNodeList insert(Comparable v) {
		if (this.find(v) == null) {
			BSTNodeList itr = this.root;
			BSTNodeList parent = null;
			//check whether itr is null
			while (itr != null) {
//				Object a = (this.root.dataList).get(0);
				Object a = itr.dataList.get(0);
				switch (v.compareTo(a)) {
					//input first num is less than current node
					case -1:
						parent = itr;
						itr = itr.left;
						break;
					//input first num is more than current node
					case 1:
						parent = itr;
						itr = itr.right;
						break;
					//first num is in arrayList
					case 0:
						if (!itr.dataList.contains(v)) {
							itr.dataList.add((Pairdata) v);
							this.size += 1;
							return itr;
						} else {
							return null;
						}
				}
			}
			ArrayList<Pairdata> storage = new ArrayList<Pairdata>();
			BSTNodeList a = new BSTNodeList(storage,null,null,parent);
			switch (v.compareTo(parent.dataList.get(0))) {
				//add to left side of parent
				case -1 :
					storage.add((Pairdata)v);
					parent.left = a;
					this.size += 1;
					break;
				//add to right side of parent
				case 1 :
					storage.add((Pairdata)v);
					parent.right = a;
					this.size += 1;
					break;
				case 0 :
					break;
			}
		} else {
			return this.find(v);
		}
		return this.find(v);
	}
	
	public BSTNodeList findMin(BSTNodeList n) {
		BSTNodeList temp = n;
		if (temp == null)
			return null;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}

	

	
}
