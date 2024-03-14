import java.util.ArrayList;
public class BankQueue { // must work for any implementation of DeQ
	DeQ[] counters;
	DeQ special;

	public BankQueue(DeQ[] counters, DeQ special) {
		super();
		this.counters = counters;
		this.special = special;
	}

	//Write this method
	public void distribute() throws Exception {
		//find needed queue length
		float NQL = 0;
		for (DeQ i : counters) {
			NQL += i.size();
		}
		
		NQL /= counters.length+1; //+1 from special q
		NQL = Math.round(NQL);
		ArrayList<Integer> storage = new ArrayList<Integer>(); // store excess queue
		boolean moved = false; // tracks whether people are moved

		for (DeQ i : counters) {
			// prevent further looping
			if (special.size() == NQL) {
				break;
			} else {
				//remove excess people
				while (i.size() > NQL) {
					storage.add(i.removeLast());
				}
				//pull excess people from excess queue
				while (storage.size() > 0 && special.size() < NQL) {
					special.insertLast(storage.get(storage.size()-1));
					storage.remove(storage.size()-1);
					moved = true;
				}
				//put excess back where they belong
				while (storage.size() > 0) {
					i.insertLast(storage.get(storage.size()-1));
					storage.remove(storage.size()-1);
					moved = true;
				}
			}
		}
		//if never then pull from last counter
		if (!moved) {
			special.insertLast(counters[counters.length-1].removeLast());
		}	
		
	}
}
