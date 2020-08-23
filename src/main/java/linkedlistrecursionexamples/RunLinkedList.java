package linkedlistrecursionexamples;

//import java.util.Scanner;

public class RunLinkedList {

	public static void main(String... args) {
		//int value;
		//char c;
		//Scanner sc = new Scanner(System.in);
		/*CustomLinkedList list = new CustomLinkedList();
		CustomLinkedList list2=new CustomLinkedList(); */
		//CustomLinkedList list = new CustomLinkedList();
		NewCustomListRecusive list= new NewCustomListRecusive();
		//NewCustomListRecusive list1= new NewCustomListRecusive();
		list.add(70);
		list.add(20);
		list.add(30);
		list.add(60);
		list.add(50);
		list.add(30);
		list.add(30);
		list.add(10);
		list.listDisplay();
		list.rec_deleteAll(30);
		//System.out.println(list.listLength());
		//System.out.println(list.listSum());
		//list.copyRandPointer1(list1);
		list.listDisplay();
		//list1.listDisplay();
		
		
		
		/*list2.head=list.rec_copy(list1.head);
		list2.display();*/
		//list.addArbitrary(3, 43);
		
		//System.out.println(list.count());
		
		
		/*System.out.println("Enter list elements");
		value = sc.nextInt();
		list.add(value);
		while (true) {
			System.out.println("want to add more");
			c = sc.next().charAt(0);

			if (c == 'n' || c == 'N') {
				break;
			}
			System.out.println("Enter list elements");
			value = sc.nextInt();
			list.add(value);

		}*/
       // list.display();
		
	//	list.reverse();
		
	}
}
