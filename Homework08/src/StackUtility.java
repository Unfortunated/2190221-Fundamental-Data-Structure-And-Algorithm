
public class StackUtility {
	static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	public static String operate(MyStack s1, MyStack s2) throws Exception {
		MyStack s3 = new StackLinkedList();
		s3.makeEmpty();
		int num1 = 0;
		int num2 = 0;
		int op;
		String ans = "";
		while (!(s1.isEmpty()) && !(s1.size() == 1) && !s2.isEmpty()) {
			//retrieve alphabets
			num1 = s1.top();
			s1.pop();
			num2 = s1.top();
			s1.pop();
			//retrieve operator
			op = s2.top();
			s2.pop();
			//push into new stack
			if (op >= 0) {
				s3.push(num1+num2);
			} else {
				s3.push(num1-num2);
			}	
		}
		while (!s3.isEmpty()) {
			ans += String.valueOf(alphabets.charAt(s3.top()));
			s3.pop();
		}
		return ans;
	}
}
