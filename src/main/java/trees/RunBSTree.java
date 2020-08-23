package trees;

public class RunBSTree {

	public static void main(String... string) {
		VerticalSum v = new VerticalSum();
		BottomView bv = new BottomView();
		BSTree c = new BSTree();
		BSTree b = new BSTree();
		b.insert(50);
		b.insert(30);
		b.insert(60);
		b.insert(65);
		b.insert(55);
		b.insert(40);
		b.insert(10);
		b.insert(90);
		//b.insert(100);
		// b.insert(70);
		// b.insert(96);
		// b.insert(9);
		// b.insert(900);
		// b.insert(190);
		// b.insert(20);
		// b.insert(77);
		// v.print(b.root);
		// System.out.println("----");
		// bv.print(b.root);
		// b.printTest(b.root);
		// System.out.println(b.sumNode(b.root));
		// System.out.println(b.maxNode(b.root));
		// b.displayLeaf(b.root);
		// System.out.println(b.searchBST(b.root, 20));
		// b.displayFinal(b.root);
		// b.traversalpre(b.root);
		// System.out.println();
		// b.traversalpost(b.root);
		// System.out.println();
		// b.traversalin(b.root);
		// System.out.println();
		// b.printLevelByLevel(b.root);
		// b.traversalLevel(b.root);
		// System.out.println();
		// System.out.println(b.haspath(b.root, 110));
		// List i=b.traversalLevel();
		// System.out.println(i);
		// System.out.println(b.sumAllNodes(b.root));
		// System.out.println(b.maxNode(b.root));
		// System.out.println(b.countLeafNodes(b.root));
		// b.search(b.root, 60);
		// b.countLeaf(b.root);
		// b.displaycount();
		// b.traversalpre(b.root);
		// System.out.println("---");
		// b.iterativePreOrder(b.root);
		b.traversalLevelLineByLine(b.root);
		System.out.println("-------");
		b.root=b.delete(b.root, 60);
		System.out.println("after deletion-------");
		b.traversalLevelLineByLine(b.root);
	//	b.traversalin(b.root);
	//	b.printAllAncestor(b.root, 100);
		// b.sumTree(b.root);
		// b.traversalLevelLineByLine(b.root);
		// System.out.println(b.checksumTree(b.root));
		// System.out.println(b.searchBST(b.root, 60));
		// b.countLeafNodesK(b.root, 2);

		// b.traversalLevelLineByLine();
		// b.invertTree(b.root);
		// System.out.println(b.sumTree(b.root));
		// b.traversalLevelLineByLine(b.root);
		// b.treeToDLLLevelorder(b.root);
		// b.printList(b.head);

		// b.traversalLevelReverse(b.root);
		// System.out.println("-------");

		// b.traversalLevelSpiral(b.root);

		// b.mirrorBuiltInplace(b.root);
		// b.traversalLevelLineByLine(b.root);
		// c.root = b.mirrorBuilt(b.root);
		// c.traversalLevelLineByLine(c.root);
		// System.out.println(b.searchBST(b.root, 50));
		// int path[] = new int[16];
		// b.rootToLeafPath(b.root, path, 0);
		// System.out.println("---");
		// b.rootToLeafPathGivenSum(b.root, path, 0, 120);
		// b.rootToLeafPathGivenSumBacktracking(b.root,120);
		// b.countLeafNodesK(b.root, 2);

		// Two way to print Diagonal,bottom,top view either hm local or global
		// 1. Local hash map
		// HashMap<Integer, Integer> hm=new HashMap<>();
		// b.findDiagonalSum(b.root, 0,hm);
		// System.out.println(hm);
		// 2. Global hash map

		// b.findDiagonalSumG(b.root, 0);
		// System.out.println(b.hm);

		// b.rootToLeafPathGivenSumBacktracking(b.root, 90);
		// b.rootToLeafPathBacktracking(b.root);
		// b.printAllAncestor(b.root, 100);
		// b.printNodeAtKDistance(b.root, 2);
		// b.countLeafNodesK(b.root, 2);

		// b.leftViewUtil(b.root, 0);
		// System.out.println("-------");
		// b.rightViewUtil(b.root, 0);
		// b.findVerticalSum(b.root, 0);
		//// Set<Map.Entry<Integer, Integer>> es = b.hm.entrySet();
		// for(Map.Entry<Integer, Integer> e:es){
		// System.out.println(e.getValue());
		// }
		// b.printLevelByLevel(b.root);
		// b.traversalpost(b.root);
		// System.out.println();
		// b.traversalin(b.root);
		// b.sumNode(b.root);
		// System.out.println(b.isBSTRange(b.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
		// b.displayLeafN(b.root);
		// .displayLeaf(b.root);
		// b.search(b.root, 10);
		// b.printLevelByLevel(b.root);
		// System.out.println(b.maxNode(b.root,Integer.MIN_VALUE));
		// System.out.println(b.height(b.root));
		// System.out.println(b.sumNode(b.root));
		// if(b.isBST(b.root))
		// System.out.println("true");
		// else System.out.println("false");
		// System.out.println(b.cummulativeSum(b.root));
		// b.cumulaSumAtEachNode(b.root);
		// b.traversalLevelLineByLine(b.root);
		// b.doubleTree(b.root);
		// b.traversalLevelLineByLine(b.root);

		// b.traversalin(b.root);
		// Node head = null;
		// b.treeToDLLInorder(b.root);
		// System.out.println();
		// b.printList(b.head);

		/*
		 * BSTree tree = new BSTree();
		 * 
		 * // Let us create trees shown in above diagram tree.root = new
		 * Node(1); tree.root.left = new Node(2); tree.root.right = new Node(3);
		 * tree.root.left.left = new Node(4); tree.root.left.right = new
		 * Node(5); tree.root.right.left = new Node(6);
		 * tree.root.left.right.left = new Node(7); tree.root.left.right.right =
		 * new Node(8); BSTree tree2 = new BSTree(); tree2.root = new Node(1);
		 * tree2.root.left = new Node(3); tree2.root.right = new Node(2);
		 * tree2.root.right.left = new Node(4); tree2.root.right.right = new
		 * Node(5); tree2.root.left.right = new Node(6);
		 * tree2.root.right.right.left = new Node(8);
		 * tree2.root.right.right.right = new Node(7);
		 * 
		 * tree.traversalLevelLineByLine(tree.root);
		 * tree2.traversalLevelLineByLine(tree2.root);
		 * 
		 * System.out.println(tree.isIsomorphic(tree.root, tree2.root));
		 * 
		 * 
		 */

		// -----------------In order Predecessor and successor---------
		/*
		 * b.traversalin(b.root); System.out.println(); System.out.println(
		 * "Predecessor " + b.findInOrderPredecessor(b.root,
		 * b.root.right.right.right)); System.out.println("Successor " +
		 * b.findInOrderSuccessor(b.root, b.root.right.right.right));
		 * 
		 * System.out.println("Predecessor " + b.findInOrderPredecessor(b.root,
		 * b.root)); System.out.println("Successor " +
		 * b.findInOrderSuccessor(b.root, b.root));
		 * 
		 * System.out.println("Predecessor " + b.findInOrderPredecessor(b.root,
		 * b.root.left.left)); System.out.println("Successor " +
		 * b.findInOrderSuccessor(b.root, b.root.left.left));
		 * b.diagonalSum(b.root);
		 */

	}

}
