
public class UseStack {
	
	//implement this method.
	public static Stack sort(Stack s) throws Exception {
		ArrayListStack result = new ArrayListStack();
		//for sorting empty stack
		result.makeEmpty();
		while (!s.isEmpty()) {
			//store temp data
			int temp = s.top();
			s.pop();
			//if result is not empty then check if top is > temp else just shub it back
			while (!result.isEmpty() && temp > result.top()) {
				s.push(result.top());
				result.pop();
			}
			//finally push it to the result
			result.push(temp);
		}
		return result;
	}
}

