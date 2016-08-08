package com.xi_zz.parcelablevsserializable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	public static final String SERIALIZABLE_ARRAYLIST = "serializable_list";
	public static final String PARCELABLE_ARRAYLIST = "parcelable_list";
	public static final String SERIALIZABLE_TREE = "serializable_tree";
	public static final String PARCELABLE_TREE = "parcelable_tree";

	public static long sTimeStarted;
	public static List<Long> sSerializableResult = new ArrayList<>();
	public static List<Long> sParcelableResult = new ArrayList<>();

	private TextView resultText;


	private SerializableList serializableObject;
	private ParcelableList parcelableObject;
	private ParcelableTreeNode parcelableTreeNode;
	private SerializableTreeNode serializableTreeNode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		resultText = (TextView) findViewById(R.id.result);

		int size = 9999;
		int level = 2;
		serializableObject = new SerializableList(size);
		parcelableObject = new ParcelableList(size);
		serializableTreeNode = SerializableTreeNode.createNode(level);
		parcelableTreeNode = ParcelableTreeNode.createNode(level);
	}

	public void launchSerializableActivity(View view) {
		sTimeStarted = System.currentTimeMillis();
		Intent intent = new Intent(this, SerializableActivity.class);
		intent.putExtra(SERIALIZABLE_ARRAYLIST, serializableObject);
		intent.putExtra(SERIALIZABLE_TREE, serializableTreeNode);
		startActivity(intent);
	}

	public void launchParcelableActivity(View view) {
		sTimeStarted = System.currentTimeMillis();
		Intent intent = new Intent(this, ParcelableActivity.class);
		intent.putExtra(PARCELABLE_ARRAYLIST, parcelableObject);
		intent.putExtra(PARCELABLE_TREE, parcelableTreeNode);
		startActivity(intent);
	}

	@Override
	protected void onResume() {
		super.onResume();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Serializable Average: ");
		stringBuilder.append(getAverage(sSerializableResult));
		stringBuilder.append("\n");
		stringBuilder.append("Parcelable Average: ");
		stringBuilder.append(getAverage(sParcelableResult));
		stringBuilder.append("\n");
		resultText.setText(stringBuilder);
	}

	private static long getAverage(List<Long> nums) {
		if (nums.size() == 0) return 0;

		long total = 0;
		for (Long n : nums)
			total += n;
		return total / nums.size();
	}
}
