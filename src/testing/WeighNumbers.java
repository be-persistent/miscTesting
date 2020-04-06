package testing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.junit.Test;

public class WeighNumbers {
	
	
	
	@Test
	public void BasicTests() {
		System.out.println("****** Basic Tests ******");
		assertEquals("2000 103 123 4444 99", weighTheNumbers("103 123 4444 99 2000"));
		//assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", weighTheNumbers("2000 10003 1234000 44444444 9999 11 11 22 123"));
	}
	

	public String weighTheNumbers(String weighThis) {
		String[] weighThisArray = weighThis.split(" ");
		
		HashMap<Integer, String> myMap = new HashMap<Integer, String>();
		HashMap<Integer, String> myExtraMap = new HashMap<Integer, String>();
		
		for(String str : weighThisArray) {
			char[] chr = str.toCharArray();
			int count = 0;
			for(char char2 : chr) {
				count += Integer.parseInt(String.valueOf(char2));	
			}
			if(myMap.containsKey(count)) {
				myExtraMap.put(count, str);
			}else {
				myMap.put(count, str);	
			}
		}
		
		Iterator<Integer> myIter = myMap.keySet().iterator();

		ArrayList<Integer> myList = new ArrayList<Integer>();
		
		while(myIter.hasNext()) {
			myList.add(myIter.next());
		}
		
		Collections.sort(myList);
		
		String sortedList = "";
		
		for(int i=0; i<myList.size(); i++) {
			String inStr = myMap.get(myList.get(i));
			sortedList = sortedList.concat(inStr);
			if(i < myList.size()-1) {
				sortedList = sortedList.concat(" ");
			}
		}
		
		return sortedList;
	}

}
