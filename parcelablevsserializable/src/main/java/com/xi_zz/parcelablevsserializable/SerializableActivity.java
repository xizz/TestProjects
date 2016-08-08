package com.xi_zz.parcelablevsserializable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class SerializableActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_serializable);

		SerializableList list = (SerializableList) getIntent().getSerializableExtra(MainActivity.SERIALIZABLE_ARRAYLIST);
		SerializableTreeNode tree = (SerializableTreeNode) getIntent().getSerializableExtra(MainActivity.SERIALIZABLE_TREE);
		long time = System.currentTimeMillis() - MainActivity.sTimeStarted;
		MainActivity.sSerializableResult.add(time);
		Log.d("xizz", "Serializable Time: " + time);
		TextView textView = (TextView) findViewById(R.id.serializable_display);
		textView.setText("Serializable Time: " + time);
	}
}
