package com.xi_zz.parcelablevsserializable;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ParcelableList implements Parcelable {

	public ArrayList<Obj> list;

	public ParcelableList(int size) {
		list = new ArrayList<>(size);
		for (int i = 0; i < size; ++i)
			list.add(new Obj("Hello", "World"));
	}

	protected ParcelableList(Parcel in) {
		list = in.createTypedArrayList(Obj.CREATOR);
	}

	public static final Creator<ParcelableList> CREATOR = new Creator<ParcelableList>() {
		@Override
		public ParcelableList createFromParcel(Parcel in) {
			return new ParcelableList(in);
		}

		@Override
		public ParcelableList[] newArray(int size) {
			return new ParcelableList[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(final Parcel parcel, final int i) {parcel.writeTypedList(list);}

	public static class Obj implements Parcelable {
		public String string1;
		public String string2;

		public Obj(final String string1, final String string2) {
			this.string1 = string1;
			this.string2 = string2;
		}

		protected Obj(Parcel in) {
			string1 = in.readString();
			string2 = in.readString();
		}

		public static final Creator<Obj> CREATOR = new Creator<Obj>() {
			@Override
			public Obj createFromParcel(Parcel in) {
				return new Obj(in);
			}

			@Override
			public Obj[] newArray(int size) {
				return new Obj[size];
			}
		};

		@Override
		public int describeContents() {
			return 0;
		}

		@Override
		public void writeToParcel(final Parcel parcel, final int i) {
			parcel.writeString(string1);
			parcel.writeString(string2);
		}
	}
}
