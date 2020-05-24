package LinkedList;

public class Test {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(5);
		linkedList.add(0);
		linkedList.add(1);
		linkedList.add(9);
		linkedList.prepend(1);
		linkedList.prepend(3);
		linkedList.remove(1);
		linkedList.removeAt(99);
		linkedList.removeTail();


		linkedList.printLinkedList();
		System.out.println(linkedList.contains(0));
	}

}
