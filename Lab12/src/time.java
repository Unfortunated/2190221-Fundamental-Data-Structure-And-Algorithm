import java.util.Random;
public class time {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test(100);
		test(10000);
		test(1000000);
	}
	
	public static void test(int size) {
		//generate random array of specific size
		int[] array = new int[size];
		Random randomnum = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = randomnum.nextInt();
		}
		Heap heap = new Heap();
		long startadd = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			heap.add(array[i]);
		}
		long add = System.currentTimeMillis()-startadd;
		long startpop = System.currentTimeMillis();
		while (!heap.isEmpty()) {
			try {
				heap.pop();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long pop = System.currentTimeMillis()-startpop;
		System.out.println(size);
		System.out.println("total add time:" + add);
		System.out.println("total pop time:" + pop);
		System.out.println("--------------------------------");
		
	}

}
