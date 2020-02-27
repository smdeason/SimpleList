/*
 * Name: Shawn Deason
 * Class ID: 235
 * Assignment#: 2
 * Description: A class that creates a list that contains 10 elements
 * 				and contains and add, remove, count, search, and toString
 * 				methods. Once all 10 elements in the list are full the oldest
 * 				element falls out of the list.
 */

package cse360assign2;

/**
 * A list of 10 elements that once 10 elements is reached overflows
 * removing the earliest element added. Contains add, remove, count,
 * search, and toString methods.
 * @author Shawn Deason
 */

public class SimpleList{
	
	//integer array to hold elements in the List
	private int[] list;
	//integer to keep track number of elements in List
	private int count;
	
	
	/**
	 * Class Constructor.
	 * Constructs a an empty list of 10 elements with 0 count
	 */
	public SimpleList() {
		list = new int[10];
		count = 0;
	}
	
	/**
	 * Appends the newElement to the front of the list.
	 * Pushes any element over count 10 off the list.
	 * @param newElement integer to be added to the list
	 */
	public void add(int newElement) {
		if(count < 10) {
			//shifts elements to the right and adds to the front element
			for(int iterator = count; iterator > 0 ; iterator--) {
				list[iterator] = list[iterator - 1];
			}
			
			list[0] = newElement;
			count++;
			
		} else {
			//shifts elements to the right and adds to the front element
			//handles case of pushing off elements
			for(int iterator = count-1; iterator > 0 ; iterator--) {
				list[iterator] = list[iterator - 1];
			}
			
			list[0] = newElement;
		}
	}
	
	/**
	 * Removes the first occurrence of specified value from the list.
	 * @param removedElement integer to be removed from the list
	 */
	public void remove(int removedElement) {
		int elementIndex = search(removedElement);
		
		if(elementIndex != -1) {
			
			//shifts elements to the right of the removed element to the left
			for(int iterator = elementIndex; iterator < count - 1 ; iterator++) {
				list[iterator] = list[iterator + 1];
			}
			
			list[count - 1] = 0;
			count--;
		} 
	}
	
	/**
	 * Returns the number of elements in the list.
	 * @return number of elements in the list
	 */
	public int count() {
		return count;
	}
	
	/**
	 * Returns the list as a String with the elements separated by spaces.
	 * @return String containing the elements of a list separated by spaces
	 */
	public String toString() {
		String output = "";
		
		if(count > 0) {
			
			//adds spaces
			for(int iterator = 0; iterator < count-1; iterator++) {
				output += list[iterator] + " ";
			}
			
			//no space after last element
			output += list[count-1]; 
		}
		return output;
	}
	
	/**
	 * Returns the index of first occurrence of the searched element in the list.
	 * If the element is not in the list then -1 is returned.
	 * @param searchedElement the integer to be searched for
	 * @return the index of the first occurrence of the element in the list, or -1 if not in the list
	 */
	public int search(int searchedElement)	{
		int output = -1;
		boolean elementFound = false;
		
		for(int iterator = 0; iterator < count; iterator++) {
			
			if(list[iterator] == searchedElement && elementFound == false) {
				output = iterator;
				elementFound = true;
			}
			//follows principle of structured programming as to not return inside a loop
			
		}
		
		return output;
	}
}