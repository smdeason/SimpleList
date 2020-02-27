/*
 * Name: Shawn Deason
 * Class ID: 235
 * Assignment#: 2
 * Description: A class that creates a list that contains 10 elements
 * 				and contains and add, remove, count, search, and toString
 * 				methods. One the list is filled the size of the list
 * 				is dynamically increased by 50% and if more than 25% of the
 * 				list is empty spaces then the size is decreased by 25%.
 */

package cse360assign2;

/**
 * A list of elements that dynamically increases in size by 50% once filled 
 * or decreases by 25% when more than 25% of the list is empty and an element is removed. 
 * Contains add, remove, count, search, and toString methods.
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
	 * Increases the size of the list by 50% if the list is filled.
	 * @param newElement integer to be added to the list
	 */
	public void add(int newElement) {
		if(count == list.length) {
			//increases the size of the list
			int[] tempList = new int[list.length + list.length/2];
			for(int iterator = 0; iterator < list.length; iterator++) {
				tempList[iterator] = list[iterator];
			}
			list = tempList;
			
			//actually adds the element
			add(newElement);
		} else {
			if(count < list.length) {
				//shifts elements to the right and adds to the front element
				for(int iterator = count; iterator > 0 ; iterator--) {
					list[iterator] = list[iterator - 1];
				}
				
				list[0] = newElement;
				count++;
				
			}
		}
	}
	
	/**
	 * Removes the first occurrence of specified value from the list.
	 * Decreases the size of the list if more than 25% of the list is empty spaces.
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

		//Decreases the size of the list after removing an element
		if((double) count / (double) list.length < 0.75 && list.length > 1) {
			int[] tempList = new int[list.length - (int) Math.floor(0.25 * list.length)];
			for(int iterator = 0; iterator < count; iterator++) {
				tempList[iterator] = list[iterator];
			}
			list = tempList;
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