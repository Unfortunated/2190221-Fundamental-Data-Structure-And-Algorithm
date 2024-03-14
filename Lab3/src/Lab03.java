import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class

public class Lab03 {
	private static int[] genData(int n,int min,int max) {
        int[] data = new int[n];
        for(int i=0;i<n;i++) {
            data[i] = (int) (Math.random()*max);
        }
        return data;
    }
    private static int[] bubbleSort(int[] data) {
        for(int i=0;i<data.length-1;i++) {
             int c = 0;
            for(int j=0;j<data.length-1-i;j++) {
                if(data[j] > data[j+1]) {
                    // c++;
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
             if(c == 0)
                break;
        }
        return data;
    }
    public static void main(String[] args) throws IOException {
    	File myObj = new File("C:\\Users\\Thany\\workload\\University\\Year 2\\sem2\\DataStructureandAlgorithm\\Lab\\Lab3\\time2.txt");
    	FileWriter myWriter = new FileWriter("C:\\Users\\Thany\\workload\\University\\Year 2\\sem2\\DataStructureandAlgorithm\\Lab\\Lab3\\time2.txt");
        for(int n=0;n<=500000;n+=10000) {
            int[] data = genData(n,0,n*100);
            long startTime = System.nanoTime();
            bubbleSort(data);
            System.out.println(""+n+","+(System.nanoTime()-startTime));
            myWriter.write(""+n+","+(System.nanoTime()-startTime)+'\n');
        }
        myWriter.close();
    }
}
