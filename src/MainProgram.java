/*
 * CSCI 700: Proj.3 Huffman Coding (Java)
 * Prof. Tsaiyun Phillips
 * Coder: Shawn Yang
 */
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainProgram {

	public static void main(String argv[]) {
		Scanner inFile;
		PrintWriter outFile1, outFile2, outFile3, outFile4, outFile5;
		String inChStr;
		HuffmanLinkedList huffList;
		HuffmanBinaryTree huffTree;
		int inProb;
		if (argv.length<6) {
			System.out.println("Please specify 1 input file and 5 output files.");
		}
		try {
			inFile = new Scanner(new FileReader(argv[0]));
			outFile1 = new PrintWriter(argv[1]);
			outFile2 = new PrintWriter (argv[2]);
			outFile3 = new PrintWriter (argv[3]);
			outFile4 = new PrintWriter (argv[4]);
			outFile5 = new PrintWriter (argv[5]);
		}catch(IOException e) {
			System.out.println(e);
			return;
		}
		System.out.println("Files opened successfully.");
		//read data from file
		huffList = new HuffmanLinkedList();
		while (inFile.hasNext()) {
			inChStr=(inFile.next());
			inProb = Integer.parseInt(inFile.next());
			//construct a HuffmanLinkedList with the data pairs.
			huffList.constructHuffmanList(inChStr, inProb, outFile5);
		}
		inFile.close();
		System.out.println("HuffmanLinkedList Construction finished.");
		//construct HuffmanTree
		huffTree = new HuffmanBinaryTree(huffList);
		huffTree.constructHuffmanBinTree(outFile5);
		System.out.println("HuffmanTree construction finished.");
		//construct CharCode
		huffTree.constructCharCode(huffTree.root, "", outFile1);
		System.out.println("Char Code construction finished.");
		HuffmanBinaryTree.preOrderTraversal(huffTree.root, outFile2);
		HuffmanBinaryTree.inOrderTraversal(huffTree.root, outFile3);
		HuffmanBinaryTree.postOrderTraversal(huffTree.root, outFile4);
		System.out.println("All output finished, program exits.");
		outFile1.close();
		outFile2.close();
		outFile3.close();
		outFile4.close();
		outFile5.close();
	}
	
	
	
}
