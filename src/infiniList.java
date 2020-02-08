//Import ArrayList from library
import java.util.ArrayList;

//Create infiniList class that implements the Runnable interface as it's instances will be executed by a threads
public class infiniList implements Runnable {

//Declare an Arraylist "infiniList" of type String
public static ArrayList<String> infiniList = new ArrayList<>();

//Override the Run method
@Override
public void run() {
	//Create an infinite while() loop
    while (true) {
    	//Create null-String "latest" to hold the new added infiniList entry
        String latest = null;
        //Synchronized keyword to eliminate race conditions
        synchronized (infiniList) {
        	//If statement to assess if the inifiniList is empty, and if so make the first entry, "This"
            if(infiniList.isEmpty()) {
                infiniList.add("This");
            	System.out.println(infiniList.get(infiniList.size()-1));}
            //Else clause to give "latest" the value of the latest entry
            else
            {
                latest = infiniList.get(infiniList.size()-1);
                
            //Following if/else if statements to add the appropriate following word, depending on latest entry
            if(latest.equals("This")) {
                infiniList.add("is");
                //Output the latest entries to the console
            	System.out.println(infiniList.get(infiniList.size()-1));}
            else if(latest.equals("is")) {
                infiniList.add("infinite");
            	System.out.println(infiniList.get(infiniList.size()-1));}
            else if(latest.equals("infinite")) {
                infiniList.add("This");
            	System.out.println(infiniList.get(infiniList.size()-1));}
        }
    }}
}

//Main method which invokes start() and starts three concurent threads
public static void main (String args[]) {
    // Call start() method for three threads simultaneously
    new Thread(new infiniList()).start();
    new Thread(new infiniList()).start();
    new Thread(new infiniList()).start();

}
}
