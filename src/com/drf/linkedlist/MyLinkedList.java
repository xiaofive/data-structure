package com.drf.linkedlist;

/**
 * 自定义单向链表实现
 * @author 汪洋
 *
 */
public class MyLinkedList {

	//定义头节点
	Node head = null;
	
	public void print() {
		while(this.head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	
	/**
	 *     头插法
	 * @param data 
	 */
	public void addHead(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode; //节点后移
	}
	
	/**
	 *     尾插法
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
