package com.xi_zz.parcelablevsserializable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SerializableTreeNode implements Serializable {
	public List<SerializableTreeNode> children;

	public String string0;
	public String string1;
	public String string2;

	public int int0;
	public int int1;
	public int int2;

	public boolean boolean0;
	public boolean boolean1;
	public boolean boolean2;

	public static SerializableTreeNode createNode(int level) {
		if (level < 4) {
			return createRootNode(level + 1);
		} else {
			return createSimpleNode();
		}
	}

	private static SerializableTreeNode createRootNode(int level) {
		SerializableTreeNode root = createSimpleNode();
		root.children = new ArrayList<>(10);
		for (int i = 0; i < 10; i++) {
			root.children.add(createNode(level));
		}
		return root;
	}

	private static SerializableTreeNode createSimpleNode() {
		SerializableTreeNode root = new SerializableTreeNode();
		root.string0 = "aaaaaaaaaa";
		root.string1 = "bbbbbbbbbb";
		root.string2 = "cccccccccc";
		root.int0 = 111111111;
		root.int1 = 222222222;
		root.int2 = 333333333;
		root.boolean0 = true;
		root.boolean1 = false;
		root.boolean2 = true;
		return root;
	}
}
