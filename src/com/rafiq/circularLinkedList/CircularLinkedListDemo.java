package com.rafiq.circularLinkedList;

import java.util.InputMismatchException;

public class CircularLinkedListDemo {
	static CircularLinkedListUtility circularLinkedListUtility = new CircularLinkedListUtility();

	public static void main(String[] args) {
		linkedListAdapter();
	}
	
	

	private static void linkedListAdapter() {
		System.out.println("Please choice the optin you want to perform the operation on linked list.");
		System.out.println("1:create\n" + "2:Display\n" + "3:Insert at the beginning\n" + "4:Insert at the End\n"
				+ "5:Insert at the given position\n" 
				+ "6:Delete from beginning\n" + "7:Delete from end\n" + "8:Delete from given position\n"
				+ "9:Reverse\n" + "0:Terminate the program\n");
		String input = circularLinkedListUtility.myScanner.nextLine();
		while (!circularLinkedListUtility.isObjectInteger(input)) {
			System.err.println("Please enter an integer value:");
			input=circularLinkedListUtility.myScanner.nextLine();
		}
		
		switch (Integer.parseInt(input)) {
		case 1:
			circularLinkedListUtility.create();
			linkedListAdapter();
			break;
		case 2:
			circularLinkedListUtility.display();
			linkedListAdapter();
			break;
		case 3:
			circularLinkedListUtility.insertAtbeginning();
			linkedListAdapter();
			break;
		case 4:
			circularLinkedListUtility.insertAtEnd();
			linkedListAdapter();
			break;
		case 5:
			circularLinkedListUtility.insertAtGivenPosition();
			linkedListAdapter();
			break;
		case 6:
			circularLinkedListUtility.deleteFromTheBeginning();
			linkedListAdapter();
			break;
		case 7:
			circularLinkedListUtility.deleteFromTheEnd();
			linkedListAdapter();
			break;
		case 8:
			circularLinkedListUtility.deleteFromGivenPosition();
			linkedListAdapter();
			break;
		case 9:
			circularLinkedListUtility.reverse();
			linkedListAdapter();
			break;	
		case 0:
			System.err.println("Your program has been terminated");
			System.exit(0);
			break;
		default:
			System.err.println("Invalid choice please enter a valid input");
			linkedListAdapter();
			break;
		}
	}
}
