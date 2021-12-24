
package com.drf.linkedlist;

import java.util.HashSet;
import java.util.Set;

/*
 * @Description:�Զ��嵥������
 * @Version: 2.0
 * @Autor: wang Y
 * @Date: 2021-12-23 10:42:59
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
	 *  ͷ�巨
	 * @param data 
	 */
	public void addHead(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode; //�ڵ����?
	}
	
	/**
	 *  β�巨
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
	 * ����λ�ò���
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
			System.out.println("�±�Խ��");
		}
		Node newNode = new Node(data);
		Node after = getByIndex(index);
		before.next = newNode;
		newNode.next = after;
	}

	/**
	 * ɾ����������������ֵΪ data ��Ԫ��
	 * @param data
	 */
	public void deleteAllData(int data){
		if(length()==0){
			return;
		}
		Node before = this.head;
		Node cur = this.head.next;
		while(cur != null){
			//��ǰ�ڵ���Ҫɾ��
			if(cur.data == data){
				before.next = cur.next;
				cur = cur.next;
			}else{
				//���Ҳ��ƶ�
				before = cur;
				cur = cur.next;
			}
		}
		if(before.data == data){
			before = cur;
		}
	}

	/**
	 * ɾ�������е��ظ��ڵ�
	 * ʱ�临�Ӷ�O(N2)���ռ临�Ӷ�O(1)
	 */
	public void deRepeat(){
		if(length()==0){
			return;
		}
		Node cur = this.head;
		Node next = this.head.next;
		// ����hash��ֻ�����һ�鼴��
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
	 * ɾ���������״γ���data�Ľڵ�
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
	 * �������
	 */
	public void clear(){
		this.head = null;
	}

	/**
	 * ��ȡ�����м�ڵ�(����ָ��)
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
	 * ��ȡ��������k���ڵ㣨����ָ�룩
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
	 * ��β��ͷ����������ڵݹ飩
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
	 * ��������ת,���ط�ת���ͷ�ڵ�
	 */
	public Node revert(){
		if(this.head==null || this.head.next==null){
			return this.head;
		}

		Node cur = this.head;
		Node next = this.head.next;
		//����һ���м������¼ԭʼ��һ���ڵ�ָ���Ա������±���
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
	 * �ж������Ƿ��л�(����ָ��)
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
	 * �����±��ȡ�ڵ�
	 * @param index
	 * @return
	 */
    private Node getByIndex(int index){
		if(index < 0||length() -1 < index){
			System.out.println("�±�Խ��");
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
	 * ����������
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
