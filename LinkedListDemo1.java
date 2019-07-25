import java.util.Scanner;
class Node
{
	private int data;
	private Node next;
	
	
	public Node()
	{
		data=0;
		next=null;
	}
	
	public Node(int d,Node n) 
	{
		data=d;
		next=n;
	}
	
	public void setData(int d)
	{
		data=d;
	}
	public void setNext(Node n)
	{
		next=n;
	}
	
	public int getData()
	{
		return data;
	}
	
	public Node getNext()
	{
		return next;
	}
}


class LinkedList
{
	private int size;
	private Node start;
	
	public LinkedList()
	{
		size=0;
		start=null;
	}
	
	public boolean isEmpty()
	{
		if(start==null)
				return true;
		else
				return false;
	}
	
	public int getListSize()
	{
		return size;
	}
	
	public void viewList()
	{
		Node t;
		if(isEmpty())
			System.out.println("List is empty");
		else{
			t=start;
			for(int i=1;i<=size;i++)
			{
				System.out.print(" "+t.getData());
				t=t.getNext();
			}
		}
			
	}
	
	public void insertAtFirst(int val)
	{
		Node n;
		n=new Node();
		n.setData(val);
		n.setNext(start);
		start=n;
		size++;
	}
	
	public void insertAtLast(int val)
	{
		Node n,t;
		n=new Node();
		n.setData(val);
		t=start;
		if(t==null)
			start=n;
		else{
			while(t.getNext()!=null)
				t=t.getNext();
			t.setNext(n);
		}
		size++;
	}
	
	public void insertAtPos(int val,int pos)
	{
		if(pos==1)
			insertAtFirst(val);
		else if(pos==size+1)
			insertAtLast(val);
		else if(pos>1 && pos<=size)
		{
			Node n,t;
			n=new Node(val,null);
			t=start;
			for(int i=1;i<pos-1;i++)
				t=t.getNext();
			n.setNext(t.getNext());
			t.setNext(n);
			size++;
			
		}else
			System.out.println("iinsertion is not position "+pos);
	}
	
	//delete function
	public void deleteFirst()
	{
		if(start==null)
			System.out.println("List is Already Empty");
		else{
			start=start.getNext();
			size--;
		}
	}
	
	public void deleteLast()
	{
		if(start==null)
			System.out.println("List is Already Empty");
		else if(size==1)
		{
			start=null;
			size--;
		}else{
			Node t;
			t=start;
			for(int i=1;i<size-1;i++)
				t=t.getNext();
			t.setNext(null);
			size--;
		}
	}
	
	public void deleteAtPos(int pos)
	{
		if(start==null)
			System.out.println("List is already empty");
		else if(pos<1 || pos>size)
				System.out.println("invalid postion");
		else if(pos==1)
				deleteFirst();
		else if(pos==size)
				deleteLast();
		else{
			Node t1,t;
			t=start;
			for(int i=1;i<pos-1;i++)
				t=t.getNext();
			t1=t.getNext();
			t.setNext(t1.getNext());
			size--;
		}
	}
	
}


public class LinkedListDemo1
{
	public static void main(String[] args)
	{
		LinkedList list=new LinkedList();
		boolean flag=true;
		while(flag)
		{	
		Scanner sc=new Scanner(System.in);
		System.out.println("");
		System.out.println("1. Add Item to the list at start");
		System.out.println("2. Add Item to the list at last");
		System.out.println("3. Add Item to the list at postion");
		System.out.println("4. Delete First Item from the list");
		System.out.println("5. Delete Last Item from the list");
		System.out.println("6. Delete Item from the list with given postion");
		System.out.println("7. view List");
		System.out.println("8. exit");
		System.out.println("Enter your choice");
		int choice=sc.nextInt();
		int postion;
		
		switch(choice)
		{
			case 1:
				System.out.println("Enter value of list item");
				int val=sc.nextInt();
				list.insertAtFirst(val);
				break;
			case 2:
				System.out.println("Enter value of list item");
				 val=sc.nextInt();
				list.insertAtLast(val);
				break;
			case 3:
				System.out.println("Enter postion");
				postion=sc.nextInt();
				System.out.println("Enter value of list item");
				val=sc.nextInt();
				list.insertAtPos(val,postion);
				break;
				
			case 4:
				list.deleteFirst();
				break;
			case 5:
				list.deleteLast();
				break;
			case 6:
				System.out.println("Enter postion=");
				postion=sc.nextInt();
				list.deleteAtPos(postion);
				break;
			case 7:
				list.viewList();
				break;
			case 8:
				flag=false;
				break;
			default:
				System.out.println("Invalid choice"); 
		}
		}	
	}
}

