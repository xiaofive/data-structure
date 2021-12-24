
package com.drf.linkedlist;

import java.util.HashSet;
import java.util.Set;

/*
 * @Description:自定义单向链表
 * @Version: 2.0
 * @Autor: wang Y
 * @Date: 2021-12-23 10:42:59
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
	 *  头插法
	 * @param data 
	 */
	public void addHead(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode; //锟节碉拷锟斤拷锟?
	}
	
	/**
	 *  尾插法
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

	/**
	 * 任意位置插入
	 * @param index 
	 * @param data 
	 */
	public void addByIndex(int index, int data){
		if(index == 0){
			addHead(data);
		}
		if(index == length()-1){
			addLast(data);
		}
		Node before = getByIndex(index - 1);
		if(before == null){
			System.out.println("下标越界");
		}
		Node newNode = new Node(data);
		Node after = getByIndex(index);
		before.next = newNode;
		newNode.next = after;
	}

	/**
	 * 删除单向链表中所有值为 data 的元素
	 * @param data
	 */
	public void deleteAllData(int data){
		if(length()==0){
			return;
		}
		Node before = this.head;
		Node cur = this.head.next;
		while(cur != null){
			//当前节点需要删除
			if(cur.data == data){
				before.next = cur.next;
				cur = cur.next;
			}else{
				//向右侧移动
				before = cur;
				cur = cur.next;
			}
		}
		if(before.data == data){
			before = cur;
		}
	}

	/**
	 * 删除链表中的重复节点
	 * 时间复杂度O(N2)，空间复杂度O(1)
	 */
	public void deRepeat(){
		if(length()==0){
			return;
		}
		Node cur = this.head;
		Node next = this.head.next;
		// 利用hash表只需遍历一遍即可
		Set<Integer> exists = new HashSet<>();
		exists.add(cur.data);
		while(next!=null){
			if(exists.contains(next.data)){
				cur.next = next.next;
			}else{
				exists.add(next.data);
				cur = next;
			}
			next = next.next;
		}
	}

	/**
	 * 删除链表中首次出现data的节点
	 * @param data
	 */
	public void deleteByDataFirst(int data){
		if(length()==0){
			return;
		}
		Node cur = this.head;
		while(cur.next != null){
			if(cur.data == data){
				cur = cur.next; 
				break;
			}
			cur = cur.next;
		}
	}

	/**
	 * 链表清空
	 */
	public void clear(){
		this.head = null;
	}

	/**
	 * 获取链表中间节点(快慢指针)
	 * @return
	 */
	public Node getMidNode(){
		Node cur = this.head;
		Node curSpeed = this.head;
		while(cur.next!=null){
			curSpeed = curSpeed.next.next;
			cur = cur.next;
		}
		return curSpeed;
	}

	/**
	 * 获取链表倒数第k个节点（快慢指针）
	 * @return
	 */
	public Node getKLastNode(int k){
		Node curSpeed = this.head;
		while(k>0){
			curSpeed = curSpeed.next;
			k--;
		}
		Node cur = this.head;
		while(curSpeed.next != null){
			cur = cur.next;
			curSpeed = curSpeed.next;
		}
		return cur;
	}

	/**
	 * 从尾到头输出链表（基于递归）
	 */
	public void printLastToHead(Node cur){
		if(cur ==null){
			return;
		}
		if(cur.next!=null){
			printLastToHead(cur.next);
		}
		System.out.println(cur.data);
	}

	/**
	 * 单向链表反转,返回反转后的头节点
	 */
	public Node revert(){
		if(this.head==null || this.head.next==null){
			return this.head;
		}

		Node cur = this.head;
		Node next = this.head.next;
		//借助一个中间变量记录原始下一个节点指向，以便于向下遍历
		Node tmp = null;
		while(next!=null){
			tmp = next;
			next.next = cur;
			cur = next;
			next = tmp;
		}
		head.next = null;
		this.head = cur;
		return head;
	}

	/**
	 * 判断链表是否有环(快慢指针)
	 * @return
	 */
	public boolean existLoop(){
		Node slow = this.head;
		Node fast = this.head;
		while(slow!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				return true;
			}
		} 
		return false;
	}

	/**
	 * 根据下标获取节点
	 * @param index
	 * @return
	 */
    private Node getByIndex(int index){
		if(index < 0||length() -1 < index){
			System.out.println("下标越界");
			return null;
		}
		int curIndex = 0;
		Node cur = this.head;
		while(cur.next != null){
			if(curIndex == index){
				break;
			}
			cur = cur.next;
			curIndex++;
		}
		return cur;
	}

	/**
	 * 计算链表长度
	 * @return
	 */
	public int length(){
		int len = 0;
		while(this.head.next !=null){
			len++;
			this.head = head.next; 
		}
		return len;
	}
	
	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();
		for(int i = 0;i < 3; i++) {
			linkedList.addHead(i);
		}
		
		linkedList.print();
		
	}
	
}
