import java.io.PrintWriter;

public class ListBinaryTreeNode {
	public String chStr;
	public int prob;
	public ListBinaryTreeNode left, right, next;
	ListBinaryTreeNode(){
		this("dummy", 0);
	}
	ListBinaryTreeNode(String inChStr, int inProb){
		chStr = inChStr;
		prob = inProb;
		left = null;
		right =null;
		next = null;
	}
	public static void printNode(ListBinaryTreeNode inNode, PrintWriter outFile) {
		outFile.print("Node: (chStr:"+inNode.chStr+", prob:"+inNode.prob+",");
		if (inNode.next==null)
			outFile.print(" next:null,");
		else 
			outFile.print(" next:"+inNode.next.chStr+",");
		if (inNode.left==null)
			outFile.print(" left:null,");
		else
			outFile.print(" left:"+inNode.left.chStr+",");
		if (inNode.right==null)
			outFile.println(" right:null,");
		else
			outFile.println(" right:"+inNode.right.chStr+")");
	}
	
	
}
