package com.xi_zz.parcelablevsserializable;

import java.io.Serializable;
import java.util.ArrayList;

public class SerializableList implements Serializable {

	public ArrayList<Obj> list;

	public SerializableList(int size) {
		list = new ArrayList<>(size);
		for (int i = 0; i < size; ++i)
			list.add(new Obj("Hello", 999));
	}

	public static class Obj implements Serializable {
		public String string;
		public Integer integer;

		public Obj(final String string, final Integer integer) {
			this.string = string;
			this.integer = integer;
		}
	}
}
