package LinkedList;


public class LinkedList<E> {
	private Node<E> head;
	private Node<E> tail;
	
	public void add(E value){	
		Node<E> node = new Node<E>(value);
		if(head == null) {
			head = node;
			tail = node;
			return;
		}
		tail.next = node;
		tail = node;
	}
	
	public void printLinkedList() {
		Node<E> current = head;
		while(current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	public void prepend(E value) {
		Node<E> newNode = new Node(value);
		newNode.next = head;
		head = newNode;

		if(tail == null) 
			tail = newNode;
		
	}
	
	public boolean contains(E value) {
		int index = this.indexOf(value);
		if(index == -1)
			return false;
		return true;
	}
	
	public int indexOf(E obj) {
		int index = 0;
		
		if(obj == null) {
			for(Node<E> e = head;head != null;e =e.next) {
				if(e == null)
					return index;
				index++;
			}
		}else {
			for(Node<E> e=head;e != null;e = e.next) {
				if(e.data.equals(obj))
					return index;
				index++;
			}

		}

		return -1;
	}
	
	public boolean remove(E obj) {
		if(head == null)
			return false;
		
		Node<E> node = new Node(obj);
		
		if(node.data == head.data) {
			if(tail.data.equals(head)) {
				tail = null;
				head = null;
			}else{
				head  = head.next;
			}
			return true;
		}
		Node<E> e = null;
		for(e = head;e.next != null && !e.next.data.equals(obj);e=e.next) {}
		if(e.next != null) {
			if(e.next == tail)
				tail = e;
			e.next = e.next.next;
			return true;
		}
		
		return false;
	}
	
	
	
	public boolean removeAt(int index) {
		Node<E> e = null;
		int counter = 0;

		if(index == 0) {
			if(tail == head) {
				tail = null;
				head = null;
				return true;
			}
			head = head.next;
			return true;
		}
		
	
		
		for(e = head;e != null && counter+1 != index;counter+=1,e = e.next) {}		
		System.out.println("counter : " + counter);
		if(e == null)
			return false;
		
		if(e.next == null && counter+1 == index) {
			tail = e;
			e = e.next;
			return true;
		}
		if(e.next != null && counter+1 == index) {
			tail = e;
			e.next = e.next.next;
		}
		
		return false;
	}
	
	public boolean removeHead(){
		if(head == null)
			return false;
		if(head == tail) {
			tail = null;
			head = null;
			return true;
		}
			
		head = head.next;
		
		return true;
	}
	public boolean removeTail() {
		if(tail == null)
			return false;
		
		if(tail == head) {
			tail = null;
			head = null;
			return true;
		}
		
		Node<E> temp = head;
		
		while(temp.next != null) {
			
			if(temp.next.next == null)
				break;
			else 
				temp = temp.next;
		}
		
		tail = temp;
		temp.next = null;
		return true;
	}
	
	
	public class Node<E>{
		E data;
		Node<E> next;
		public Node(E obj) {
			data = obj;
			next = null;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (this.data == null) {
				if (other.data != null)
					return false;
			} else if (!this.data.equals(other.data))
				return false;
			return true;
		}
		private LinkedList getEnclosingInstance() {
			return LinkedList.this;
		}

		
		
	
				
	}

}
