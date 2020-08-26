package com.rafiq.circularLinkedList;

import java.util.Scanner;
public class CircularLinkedListUtility {

	public Scanner myScanner = new Scanner(System.in);
	private Node tail = null;
	int size = 0;

	public void create() {
		Integer choice = 1;
		String input = null;
		while (choice != 0) {
			Node newNode = createNewNode();
			if (tail == null) {
				tail = newNode;
				tail.setNext(newNode);
			} else {
				newNode.setNext(tail.getNext());
				tail.setNext(newNode);
				tail = newNode;
			}
			size++;
			System.out.println("Press any number to add more node or press 0 to stop to adding node:");
			myScanner.nextLine();
			input = myScanner.nextLine();
			while (!isObjectInteger(input)) {
				System.err.println("Please enter an integer value:");
				input = myScanner.nextLine();
			}
			choice = Integer.parseInt(input);
		}
	}

	public void display() {
		if (tail == null) {
			System.out.println("The circular linked list is empty");
		} else {
			System.out.println("The linked list:");
			Node temNode = tail.getNext();
			while (temNode.getNext() != tail.getNext()) {
				System.out.print(temNode.getData());
				System.out.print(temNode.getNext() != null ? "->" : "");
				temNode = temNode.getNext();
			}
			System.out.print(temNode.getData());
			System.out.println();
		}
	}

	public void insertAtbeginning() {

		Node newNode = createNewNode();
		if (tail == null) {
			tail = newNode;
			tail.setNext(newNode);
			tail = newNode;
		} else {
			newNode.setNext(tail.getNext());
			tail.setNext(newNode);
		}
		size++;
	}

	public void insertAtEnd() {
		Node newNode = createNewNode();
		if (tail == null) {
			tail = newNode;
			tail.setNext(newNode);
		} else {
			newNode.setNext(tail.getNext());
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
	}

	public void insertAtGivenPosition() {
		
		int count = 1;
		System.out.println("Please enter the position");
		int position = myScanner.nextInt();
		if (position > size || position <= 0) {
			System.err.println("Invalid position");
		} else {
			if (position == 1) {
				insertAtbeginning();
			} else if (position == size) {
				insertAtEnd();
			} else {
				Node newNode = createNewNode();
				Node tempNode = tail.getNext();
				while (count < position - 1) {
					tempNode = tempNode.getNext();
					count++;
				}
				newNode.setNext(tempNode.getNext());
				tempNode.setNext(newNode);
				size++;
			}
		}
	}

	public void deleteFromTheBeginning() {
		if(size==0) {
			System.err.println("List is empty can not be perform delete operation");
		}else {
			Node tempNode=tail.getNext();
			tail.setNext(tempNode.getNext());
			tempNode=null;
			size--;
		}
	}

	public void deleteFromTheEnd() {
		
		if(size==0) {
			System.err.println("List is empty can not be perform delete operation");
		}else {
			int count=1;
			Node tempNode=tail.getNext();
			while (count<size-1) {
			 tempNode=tempNode.getNext();
			 count++;
			}
			tempNode.setNext(tail.getNext());
			tail=null;
			tail=tempNode;
			size--;
		}
	}

	public void deleteFromGivenPosition() {
		
		System.out.println("Please enter the position:");
		int position = myScanner.nextInt();
		if (size < 1) {
			System.err.println("List is already empty .Can not be perform delete operation");
		} else {
			if (position > size || position <1) {
				System.err.println("Invalid position");
			} else {
				if (position == 1) {
					deleteFromTheBeginning();
				} else if (position == size) {
					deleteFromTheEnd();
				} else {
					int count = 1;
					Node tempNode = tail.getNext();
					while (count < position-1) {
						tempNode = tempNode.getNext();
						count++;
					}
					Node targetNode=tempNode.getNext();
					tempNode.setNext(targetNode.getNext());
					targetNode=null;
					size--;
				}
			}
		}
	}

	public void reverse() {
		if(size==0) {
			System.out.println("List is empty");
		}else if(size==1) {
			display();
		}else {
			Node currentNode=tail.getNext(),previouNode=null,nextNode=currentNode.getNext();
			while (currentNode!=tail) {
				previouNode=currentNode;
				currentNode=nextNode;
				nextNode=currentNode.getNext();
				currentNode.setNext(previouNode);
			}
			nextNode.setNext(tail);
			tail=nextNode;
		}
		
	}

	public int getSize() {
		return 0;
	}

	private Node createNewNode() {
		return new Node(inputData(), null);
	}

	private int inputData() {
		System.out.println("Please enter data:");
		return myScanner.nextInt();
	}

	public boolean isObjectInteger(String number) {
		try {
			Integer.parseInt(number);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
