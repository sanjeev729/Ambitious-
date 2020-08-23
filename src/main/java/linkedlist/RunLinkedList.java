package linkedlist;

//import java.util.Scanner;

public class RunLinkedList {

	public static void main(String... args) {
		// int value;
		// char c;
		// Scanner sc = new Scanner(System.in);
		CustomLinkedList list = new CustomLinkedList();
		CustomLinkedList list3 = new CustomLinkedList();
		CustomLinkedList list2 = new CustomLinkedList();
		// CustomLinkedList list1 = new CustomLinkedList();
		// list.rec_add(10);
		// list.rec_add(20);
		// list.rec_add(30);
		// list.rec_add(40);
		// list.rec_add(50);
		// list.rec_add(70);
		list2.add(10);
		list2.add(80);
		list.add(20);
		list.add(30);
		list.add(60);
		list2.add(90);
		list.add(70);
		list2.add(150);
		list.add(80);

		list.add(100);
		list.display();
		list2.display();
		list3.head = list.SortedMerge(list.head, list2.head);

		list3.display();
		// list2.head=list.rec_copy(list1.head);
		// list2.display();
		// list.addArbitrary(3, 43);

		// System.out.println(list.count());

		/*
		 * System.out.println("Enter list elements"); value = sc.nextInt();
		 * list.add(value); while (true) { System.out.println("want to add more"
		 * ); c = sc.next().charAt(0);
		 * 
		 * if (c == 'n' || c == 'N') { break; } System.out.println(
		 * "Enter list elements"); value = sc.nextInt(); list.add(value);
		 * 
		 * }
		 */
		// list.display();System.out.println("");
		// list.reverse();
		// list.display();
		// System.out.println();
		// list2.head = list.reverse_kth1(4);
		// list2.head = list.formLoop(list.head);
		// list2.display();
		// list2.checkLoop();

		// list3.head = list.deleteGreater(list.head, 50);

		// list3.display();

		// list.rec_display1();
		// list.getMiddle();
		// list.rotate(3);
		// Node t1=new Node();
		// Node t2=list.rec_copy(t1);
		// list.display();

	}
}
