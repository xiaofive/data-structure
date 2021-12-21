package com.drf.linkedlist;

/**
 * �Զ��嵥������ʵ��
 * @author ����
 *
 */
public class MyLinkedList {

	//����ͷ�ڵ�
	Node head = null;
	
	public void print() {
		while(this.head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	
	/**
	 *     ͷ�巨
	 * @param data 
	 */
	public void addHead(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode; //�ڵ����
	}
	
	/**
	 *     β�巨
	 * @param data
	 */
	public void addLast(int data) {
		Node newNode = new Node(data);
		if(this.head == null) {
			this.head.next = newNode;
			return;
		}
		while(this.head.next != null) {
			head = head.next;
		}
		head.next = newNode;
	}
	
	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();
		for(int i = 0;i < 3; i++) {
			linkedList.addHead(i);
		}
		
		linkedList.print();
	}
	
}
