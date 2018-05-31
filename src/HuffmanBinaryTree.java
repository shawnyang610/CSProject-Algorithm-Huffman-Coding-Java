import java.io.PrintWriter;

public class HuffmanBinaryTree {
	public ListBinaryTreeNode nNode;
	public ListBinaryTreeNode root;
	public HuffmanLinkedList originalList;
	public ListBinaryTreeNode listHeadPtr;
	HuffmanBinaryTree(HuffmanLinkedList inHuffList) {
		originalList = inHuffList;
		inHuffList.oldListHead = new ListBinaryTreeNode();
		inHuffList.oldListHead.next=inHuffList.listHead.next;
		listHeadPtr = inHuffList.listHead;
	}
	public void constructHuffmanBinTree (PrintWriter outFile) {
		if (listHeadPtr.next==null) {
			System.out.println("empty list");
		}
		while (listHeadPtr.next.next!=null) {
			nNode = new ListBinaryTreeNode();
			nNode.chStr=listHeadPtr.next.chStr+listHeadPtr.next.next.chStr;
			nNode.prob=listHeadPtr.next.prob+listHeadPtr.next.next.prob;
			nNode.left=listHeadPtr.next;
			nNode.right=listHeadPtr.next.next;
			listHeadPtr.next=listHeadPtr.next.next.next;
			//print node
			ListBinaryTreeNode.printNode(nNode, outFile);
			//find spot and insert nNode
			originalList.listInsert(HuffmanLinkedList.findSpot(nNode.prob, listHeadPtr), nNode);
			//print list
			originalList.printList(listHeadPtr, outFile);
		}
		//step3.4
		root = nNode;
	}
	public void constructCharCode (ListBinaryTreeNode inRoot, String inCode, PrintWriter outFile) {
		if (inRoot==null) {
			System.out.println("This is an empty tree!");
			return;
		}
		else if (isLeaf(inRoot)) {
			outFile.println(inRoot.chStr+" "+inCode);
		}
		else {
			constructCharCode(inRoot.left, inCode+"0", outFile);
			constructCharCode(inRoot.right, inCode+"1", outFile);
		}
	}
	public boolean isLeaf(ListBinaryTreeNode inNode) {
		if (inNode.left == null && inNode.right == null) {
			return true;
		}
		else
			return false;
	}
	public static void preOrderTraversal (ListBinaryTreeNode inRoot, PrintWriter outFile) {
		if (inRoot==null) {}
		else {
			ListBinaryTreeNode.printNode(inRoot, outFile);
			preOrderTraversal(inRoot.left, outFile);
			preOrderTraversal(inRoot.right, outFile);
		}
	}
	public static void inOrderTraversal (ListBinaryTreeNode inRoot, PrintWriter outFile) {
		if (inRoot==null) {}
		else {
			inOrderTraversal(inRoot.left, outFile);
			ListBinaryTreeNode.printNode(inRoot, outFile);
			inOrderTraversal(inRoot.right, outFile);
		}	
	}
	public static void postOrderTraversal (ListBinaryTreeNode inRoot, PrintWriter outFile) {
		if (inRoot == null) {}
		else {
			postOrderTraversal(inRoot.left, outFile);
			postOrderTraversal(inRoot.right, outFile);
			ListBinaryTreeNode.printNode(inRoot, outFile);
		}
	}
	
}
