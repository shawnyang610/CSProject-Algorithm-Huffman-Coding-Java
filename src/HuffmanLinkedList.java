import java.io.PrintWriter;

public class HuffmanLinkedList {
	ListBinaryTreeNode listHead;
	ListBinaryTreeNode oldListHead;
	HuffmanLinkedList(){
		listHead = new ListBinaryTreeNode();
	}
	public void constructHuffmanList (String inChStr, int inProb, PrintWriter outFile) {
		ListBinaryTreeNode nNode = new ListBinaryTreeNode (inChStr, inProb);
		this.listInsert(findSpot (inProb, this.listHead ), nNode);
		this.printList(this.listHead, outFile);
	}
	public static ListBinaryTreeNode findSpot (int inProb, ListBinaryTreeNode inListHead) {
		ListBinaryTreeNode walker = inListHead;
		while (walker.next != null && inProb > walker.next.prob)
			walker = walker.next;
		return walker;
	}
	public void listInsert (ListBinaryTreeNode spot, ListBinaryTreeNode newNode) {
		newNode.next = spot.next;
		spot.next = newNode;
	}
	public void printList (ListBinaryTreeNode inListHead, PrintWriter outFile) {
		outFile.print("ListHead -> ("+inListHead.chStr +", "+ inListHead.prob+", ");
		ListBinaryTreeNode walker = inListHead;
		while (walker.next !=null) {
			walker = walker.next;
			outFile.print(walker.chStr+") --> ("+walker.chStr+", "+walker.prob+", ");
		}
		outFile.println("null)");
	}
}
