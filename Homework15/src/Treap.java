public class Treap{
	TreapNode root;
	int size;
	
	public Treap() {
	}
	
	public Treap(TreapNode root, int size) {
		this.root = root;
		this.size = size;
	}
	
	//v is BST value
	//h is heap value
	public TreapNode insert(int v, int h) {
		//check if the tree contains the current node if not then insert
		if (this.contains(v,root)) {
			return null;
		} else {
			root = insert(v,h,root, null);
			return root;	
		}	
	}
	
	//helper function for contains
	public boolean contains(int v, TreapNode n) {
		//node is null then not contains
		if (n == null) {
			return false;
			//same value then contains
		} else if (n.bstValue == v) {
			return true;
			//v more than current node go right
		} else if (n.bstValue < v) {
			return contains(v,n.right);
			//v less than current node go left
		} else if (n.bstValue > v) {
			return contains(v,n.left);
		}
		return false;
	}
	
	public TreapNode insert(int v, int h, TreapNode n, TreapNode parent) {
		//null then create new node and increase size
		if (n == null) {
			n = new TreapNode(v,h,null,null,parent);
			size++;
			//new node value less than current node value go left
		} else if (v < n.bstValue) {
			n.left = insert(v, h, n.left, n);
			//new node value more than current node value go right
		} else if (v > n.bstValue) {
			n.right = insert(v, h, n.right, n);
		} 
		//rebalance the tree
		n = rebalance(n);
		return n;
	}
	
	public TreapNode rebalance(TreapNode n) {
		//if node is null then simply return it
		if (n == null)
			return n;
		//catch the case where left is null then check the value and rotate
		if (n.left != null) {
			if (n.heapValue > n.left.heapValue) {
				n = rotateLeftChild(n);
			}
		}
		//catch the case where right is null then check the value and rotate
		if (n.right != null) {
			if (n.heapValue > n.right.heapValue) {
				n = rotateRightChild(n);
			}
		}
		return n;
	}
	
	//rotate left child to root to follow heap condition while being BST
	public TreapNode rotateLeftChild(TreapNode n) {
		TreapNode l = n.left;
		TreapNode lr = n.left.right; // can be null
		n.left = lr;
		if (lr != null) {
			lr.parent = n;
		}
		l.right = n;
		l.parent = n.parent;
		n.parent = l;

		return l;
	}
	
	//rotate right child to root to follow heap condition while being BST
	public TreapNode rotateRightChild(TreapNode n) {
		TreapNode r = n.right;
		TreapNode rl = n.right.left; // can be null
		n.right = rl;
		if (rl != null) {
			rl.parent = n;
		}
		r.left = n;
		r.parent = n.parent;
		n.parent = r;

		return r;
	}
	
}
