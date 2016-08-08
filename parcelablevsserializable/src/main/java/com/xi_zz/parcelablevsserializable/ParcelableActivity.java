package com.xi_zz.parcelablevsserializable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class ParcelableActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parcelable);

		ParcelableList list = getIntent().getParcelableExtra(MainActivity.PARCELABLE_ARRAYLIST);
		ParcelableTreeNode tree = getIntent().getParcelableExtra(MainActivity.PARCELABLE_TREE);
		long time = System.currentTimeMillis() - MainActivity.sTimeStarted;
		MainActivity.sParcelableResult.add(time);
		Log.d("xizz", "Parcelable Time: " + time);
		TextView textView = (TextView) findViewById(R.id.parcelable_display);
		textView.setText("Parcelable Time: " + time);
	}
}
