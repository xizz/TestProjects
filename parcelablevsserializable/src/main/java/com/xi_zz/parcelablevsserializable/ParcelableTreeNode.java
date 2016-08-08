package com.xi_zz.parcelablevsserializable;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class ParcelableTreeNode implements Parcelable {
	public List<ParcelableTreeNode> children;

	public String string0;
	public String string1;
	public String string2;

	public int int0;
	public int int1;
	public int int2;

	public boolean boolean0;
	public boolean boolean1;
	public boolean boolean2;

	public ParcelableTreeNode() {
	}

	protected ParcelableTreeNode(Parcel in) {
		if (in.readByte() == 0x01) {
			children = new ArrayList<>();
			in.readList(children, ParcelableTreeNode.class.getClassLoader());
		} else {
			children = null;
		}
		string0 = in.readString();
		string1 = in.readString();
		string2 = in.readString();
		int0 = in.readInt();
		int1 = in.readInt();
		int2 = in.readInt();
		boolean0 = in.readByte() != 0x00;
		boolean1 = in.readByte() != 0x00;
		boolean2 = in.readByte() != 0x00;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		if (children == null) {
			dest.writeByte((byte) (0x00));
		} else {
			dest.writeByte((byte) (0x01));
			dest.writeList(children);
		}
		dest.writeString(string0);
		dest.writeString(string1);
		dest.writeString(string2);
		dest.writeInt(int0);
		dest.writeInt(int1);
		dest.writeInt(int2);
		dest.writeByte((byte) (boolean0 ? 0x01 : 0x00));
		dest.writeByte((byte) (boolean1 ? 0x01 : 0x00));
		dest.writeByte((byte) (boolean2 ? 0x01 : 0x00));
	}

	public static final Creator<ParcelableTreeNode> CREATOR = new Creator<ParcelableTreeNode>() {
		@Override
		public ParcelableTreeNode createFromParcel(Parcel in) {
			return new ParcelableTreeNode(in);
		}

		@Override
		public ParcelableTreeNode[] newArray(int size) {
			return new ParcelableTreeNode[size];
		}
	};

	public static ParcelableTreeNode createNode(int level) {
		if (level < 4) {
			return createRootNode(level + 1);
		} else {
			return createSimpleNode();
		}
	}

	private static ParcelableTreeNode createRootNode(int level) {
		ParcelableTreeNode root = createSimpleNode();
		root.children = new ArrayList<>(10);
		for (int i = 0; i < 10; i++) {
			root.children.add(createNode(level));
		}
		return root;
	}

	private static ParcelableTreeNode createSimpleNode() {
		ParcelableTreeNode root = new ParcelableTreeNode();
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
