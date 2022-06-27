package training.problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrintIntoTree {
	public static final String PATH = "src/main/java/training/problems/problem_input/8/";
	static Tree root = new Tree("root");
	static List<Tree> children = new ArrayList<>();

	public static void main(String args[]) throws IOException {
		FileReader fileRead = new FileReader(PATH + "InputFile");
		BufferedReader buffRead = new BufferedReader(fileRead);
		String str;

		List<String> inputString = new ArrayList<>();

		while ((str = buffRead.readLine()) != null) {
			String s[] = str.split("\t");
			String in = "";
			for (int i = 1; i < s.length; i++) {
				in += "\t" + s[i];
			}
			in += " ~ " + s[0];
			inputString.add(in.trim());
		}
		buffRead.close();
		root.setChildrenNodes(children);

		List<Tree> allTrees = new ArrayList<>();

		for (int i = 0; i < inputString.size(); i++) {
			allTrees.add(createTreeForEachLine(inputString.get(i)));
		}

		for (Tree t : allTrees) {
			insertIntoGlobalTree(root.getChildren(), t);
		}

		for (Tree t : root.getChildren()) {
			String tab = "";
			Tree.printTree(t, tab);
			System.out.println();
		}
	}

	static Tree createTreeForEachLine(String parent) {
		String str[] = parent.split("\t");
		Tree rootNode = new Tree(str[0]);
		for (int i = 1; i < str.length; i++) {

			Tree lastChild = Tree.getLastChild(rootNode);
			lastChild.addChild(new Tree(str[i]));
		}
		return rootNode;
	}

	static void insertIntoGlobalTree(List<Tree> children, Tree toAdd) {

		for (Tree child : children) {
			String s;
			if (child.getTitle().contains("~"))
				s = child.getTitle().split("~")[0].trim();
			else
				s = child.getTitle();

			if (s.equals(toAdd.getTitle())) {
				insertIntoGlobalTree(child.getChildren(), toAdd.getChildren().get(0));
				return;
			}
		}
		children.add(toAdd);
	}

}

class Tree {
	private String title;
	// set of string=code
	private List<Tree> children = null;

	public Tree(String parent) {
		this.setTitle(parent);
		this.children = new ArrayList<>();
	}

	public void addChild(Tree child) {
		children.add(child);
	}

	public void setChildrenNodes(List<Tree> childrenNodes) {
		children = childrenNodes;
	}

	public List<Tree> getChildren() {
		return children;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static void printTree(Tree node, String tab) {

		System.out.println(tab + node.getTitle());
		if (node.children.size() != 0) {
			tab += "\t";
			for (Tree n : node.children) {
				printTree(n, tab);
			}
		}
	}

	public static Tree getLastChild(Tree node) {
		if (node.children.size() != 0) {
			node = getLastChild(node.children.get(0));
		}
		return node;
	}

}
